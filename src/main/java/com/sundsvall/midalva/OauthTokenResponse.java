package com.sundsvall.midalva;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class OauthTokenResponse implements Serializable {

    String access_token;
    String expires_in;
    String token_type;
    String scope;

    public OauthTokenResponse(String access_token, String expires_in, String token_type, String scope) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.token_type = token_type;
        this.scope = scope;
    }

    public OauthTokenResponse() {
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonProperty("access_token")
    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @JsonProperty("expires_in")
    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
    @JsonProperty("token_type")
    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    @Override
    public String toString() {
        return "OauthTokenResponse{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", token_type='" + token_type + '\'' +
                '}';
    }
}