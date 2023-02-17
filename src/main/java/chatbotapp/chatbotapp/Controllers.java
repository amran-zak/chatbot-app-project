package chatbotapp.chatbotapp;

import chatbotapp.chatbotapp.hooks.*;

import chatbotapp.chatbotapp.models.*;
import chatbotapp.chatbotapp.models.Button;
import chatbotapp.chatbotapp.models.Image;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@Slf4j
@RestController
@AllArgsConstructor
public class Controllers {

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "Hello world!";
    }

    private WebhookInvocator webhookInvocator;

    @PostMapping("/conseilfilm")
    public WebhookResponse conseilfilm(@RequestBody WebhookRequest newWebRequest) {
        return webhookInvocator.execute(newWebRequest);
    }
}
