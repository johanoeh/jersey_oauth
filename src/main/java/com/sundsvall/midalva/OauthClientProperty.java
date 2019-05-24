package com.sundsvall.midalva;

public class OauthClientProperty {

    public static final  String CLIENT_ID = "client_id";
    public static  final String CLIENT_SECRET ="client_secret";
    public static final  String GRANT_TYPE = "grant_type";

    private String tokenURI;

    private String clientSecret;
    private String clientId;
    private String clientRegistrationId;
    private String clientGrantType;

    public OauthClientProperty() {
    }

    public String getTokenURI() {
        return tokenURI;
    }

    public void setTokenURI(String tokenURI) {
        this.tokenURI = tokenURI;
    }

    public String getClientGrantType() {
        return clientGrantType;
    }

    public void setClientGrantType(String clientGrantType) {
        this.clientGrantType = clientGrantType;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientRegistrationId() {
        return clientRegistrationId;
    }

    public void setClientRegistrationId(String clientRegistrationId) {
        this.clientRegistrationId = clientRegistrationId;
    }
}
