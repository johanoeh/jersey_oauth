package com.sundsvall.midalva;

import java.util.HashMap;
import java.util.Map;

public class ClientRepository {

    private final Map<String, OauthClientProperty> clientProperties = new HashMap<>();

    public OauthClientProperty getOauthClientProperty(String clientRegistrationId) {
        return clientProperties.get(clientRegistrationId);
    }

    public void addProperty(OauthClientProperty oauthClientProperty){
        clientProperties.put(oauthClientProperty.getClientRegistrationId(),oauthClientProperty);
    }
}
