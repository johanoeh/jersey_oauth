import com.sundsvall.midalva.ClientRepository;
import com.sundsvall.midalva.OauthClientProperty;
import com.sundsvall.midalva.XXRestClient;

import java.io.UnsupportedEncodingException;

public class Application {

    public static void main(String[] args)  {

        String request = "{}";

        OauthClientProperty oauthClientProperty = new OauthClientProperty();
        oauthClientProperty.setClientRegistrationId("some_integration");
        oauthClientProperty.setClientId("client_id");
        oauthClientProperty.setClientSecret("client_secret");
        oauthClientProperty.setTokenURI("Https://someservice:5050/token");
        oauthClientProperty.setClientGrantType("client_credentials");

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.addProperty(oauthClientProperty);

        XXRestClient xRestClient = new XXRestClient("https://requestedresource/resource","some_integration",clientRepository);

    }
}
