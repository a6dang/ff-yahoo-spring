package com.adang.fantasymessenger.auth;

import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@RestController
public class OAuthController {

    private static final String YAHOO_TOKEN_URL = "https://api.login.yahoo.com/oauth2/get_token";
    // prod
    private static final String CLIENT_ID = "dj0yJmk9YWxnaVVSTmFTbW90JmQ9WVdrOU5GSlBjRmh1TlRJbWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmeD1lNw--";
    private static final String CLIENT_SECRET = "d52d279acefcac5e35be7bf9965b82d2a4060cff";
    private static final String AUTHORIZATION_HEADER = "Basic ZGoweUptazlZV3huYVZWU1RtRlRiVzkwSm1ROVdWZHJPVTVHU2xCalJtaDFUbFJKYldOSGJ6bE5RUzB0Sm5NOVkyOXVjM1Z0WlhKelpXTnlaWFFtZUQxbE53LS06ZDUyZDI3OWFjZWZjYWM1ZTM1YmU3YmY5OTY1YjgyZDJhNDA2MGNmZg==";
    private static final String REDIRECT_URI = "gentle-dusk-83365.herokuapp.com";
    // local
//    private static final String CLIENT_ID = "dj0yJmk9VEI0ZUxBZkhKeTcyJmQ9WVdrOVkyODVZelpSTnpnbWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmeD04NQ--";
//    private static final String CLIENT_SECRET = "9ce094a5c54372cfba4024a6237457d150b803f4";
//    private static final String AUTHORIZATION_HEADER = "Basic ZGoweUptazlWRUkwWlV4QlpraEtlVGN5Sm1ROVdWZHJPVmt5T0RWWmVscFNUbnBuYldOSGJ6bE5RUzB0Sm5NOVkyOXVjM1Z0WlhKelpXTnlaWFFtZUQwNE5RLS06OWNlMDk0YTVjNTQzNzJjZmJhNDAyNGE2MjM3NDU3ZDE1MGI4MDNmNA==";
//    private static final String REDIRECT_URI = "https://locahost:8080/success";

//    private static final String CLIENT_ID = "dj0yJmk9NFRtSUVzdXpIVWxoJmQ9WVdrOU9WSlVVbTlUTlRJbWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmeD02OQ--";
//    private static final String CLIENT_SECRET = "1b8579a5bc055f9eb6849cdf850793eb125b9c27";
//    private static final String AUTHORIZATION_HEADER = "Basic ZGoweUptazlORlJ0U1VWemRYcElWV3hvSm1ROVdWZHJPVTlXU2xWVmJUbFVUbFJKYldOSGJ6bE5RUzB0Sm5NOVkyOXVjM1Z0WlhKelpXTnlaWFFtZUQwMk9RLS06MWI4NTc5YTViYzA1NWY5ZWI2ODQ5Y2RmODUwNzkzZWIxMjViOWMyNw==";
//    private static final String REDIRECT_URI = "https://localfantasybot.com:8080/success";

    @RequestMapping(value = "/oauth", method = RequestMethod.GET)
    String handleOAuthRedirect(@RequestParam("code") String authCode) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", APPLICATION_FORM_URLENCODED_VALUE);
        headers.add("Authorization", AUTHORIZATION_HEADER);

        // create body
        MultiValueMap<String, String> requestFields = new LinkedMultiValueMap<>();
        requestFields.add("client_id", CLIENT_ID);
        requestFields.add("client_secret", CLIENT_SECRET);
        requestFields.add("code", authCode);
        requestFields.add("grant_type", "authorization_code");
        requestFields.add("redirect_uri", "oob");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestFields, headers);

        try {
            HttpEntity<String> response = restTemplate.postForEntity(YAHOO_TOKEN_URL, request, String.class);
            return response.getBody();
        } catch (HttpClientErrorException exception) {
            return exception.getResponseBodyAsString();
        }
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    @ResponseBody
    String lol() {
        return "lol";
    }
}
