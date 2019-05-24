package com.sundsvall.midalva;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

public class XXRestClient {

    private final String clientId;
    private String url;
    private WebTarget webTarget;

    private Client client;
    private  static final Logger LOG = Logger.getLogger(XXRestClient.class.getName());

    private  final ClientRepository clientRepository;

    public XXRestClient(String url, String clientId, ClientRepository clientRepository) {

        this.url = url;
        this.clientId = clientId;
        this.clientRepository = clientRepository;
        client = ClientBuilder.newClient();

    }

    public String getResponse(String request) {

        OauthClientProperty oauthClientProperty = clientRepository.getOauthClientProperty(clientId);

        Form formData = new Form();

        formData.param(oauthClientProperty.CLIENT_ID, oauthClientProperty.getClientId());
        formData.param(OauthClientProperty.CLIENT_SECRET, oauthClientProperty.getClientSecret());
        formData.param(OauthClientProperty.GRANT_TYPE, oauthClientProperty.getClientGrantType());

        Response post = client
                .target(oauthClientProperty.getTokenURI())
                .request(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .post(Entity.form(formData));

        //Todo handle response depending on the response status ...
        int status = post.getStatus();

        LOG.info(String.format("Got token response from %s with status %d",oauthClientProperty.getTokenURI(), status));

        OauthTokenResponse oauthTokenResponse =  post.readEntity(OauthTokenResponse.class);

        String response2 = client
                .target(url)
                .request(MediaType.APPLICATION_JSON).header("Authorization","Bearer "+oauthTokenResponse.getAccess_token())
                .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                .readEntity(String.class);

        return  response2;
    }

}