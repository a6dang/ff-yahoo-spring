package com.adang.fantasymessenger.auth;

import org.springframework.web.bind.annotation.*;

@RestController
public class OAuthController {

    @RequestMapping(value = "/oauth", method = RequestMethod.GET)
    @ResponseBody
    String handleOAuthRedirect(@RequestParam("code") String authCode) {
        return "authCode";
    }
}
