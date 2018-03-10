package com.adang.fantasymessenger.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@RestController
public class OAuthController {

    private static final String YAHOO_TOKEN_URL = "https://api.login.yahoo.com/oauth2/get_token";
    @RequestMapping(value = "/oauth", method = RequestMethod.GET)
    String handleOAuthRedirect(@RequestParam("code") String authCode) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", APPLICATION_FORM_URLENCODED_VALUE);
        headers.add("Authorization", "Basic ZGoweUptazlZV3huYVZWU1RtRlRiVzkwSm1ROVdWZHJPVTVHU2xCalJtaDFUbFJKYldOSGJ6bE5RUzB0Sm5NOVkyOXVjM1Z0WlhKelpXTnlaWFFtZUQxbE53LS06ZDUyZDI3OWFjZWZjYWM1ZTM1YmU3YmY5OTY1YjgyZDJhNDA2MGNmZg==");

        // create body
        MultiValueMap<String, String> requestFields = new LinkedMultiValueMap<>();
        requestFields.add("client_id", "dj0yJmk9YWxnaVVSTmFTbW90JmQ9WVdrOU5GSlBjRmh1TlRJbWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmeD1lNw--");
        requestFields.add("client_secret", "d52d279acefcac5e35be7bf9965b82d2a4060cff");
        requestFields.add("code", authCode);
        requestFields.add("grant_type", "authorization_code");
        requestFields.add("redirect_uri", "https://gentle-dusk-83365.herokuapp.com/success");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestFields, headers);

        HttpEntity<String> response = restTemplate.postForEntity(YAHOO_TOKEN_URL, request, String.class);
        return response.getBody();
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    @ResponseBody
    String lol() {
        return "lol";
    }
}
