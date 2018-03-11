package com.adang.fantasymessenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {

    private static final String LINK = "https://api.login.yahoo.com/oauth2/request_auth?client_id=dj0yJmk9YWxnaVVSTmFTbW90JmQ9WVdrOU5GSlBjRmh1TlRJbWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmeD1lNw--&redirect_uri=https://gentle-dusk-83365.herokuapp.com/oauth&response_type=code&language=en-us";
//    private static final String LINK = "https://api.login.yahoo.com/oauth2/request_auth?client_id=dj0yJmk9am44aTRiemZnc3VnJmQ9WVdrOWNWcFdVV1ZLTldrbWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmeD1hNA--&redirect_uri=https://localhost:8080/oauth&response_type=code&language=en-us";

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return LINK;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
