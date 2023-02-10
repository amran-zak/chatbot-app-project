package chatbotapp.chatbotapp;

import chatbotapp.chatbotapp.hooks.WebhookRequest;

import chatbotapp.chatbotapp.hooks.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "Hello world!";
    }

    @PostMapping("/conseilfilm")
    public WebhookResponse conseilfilm(@RequestBody WebhookRequest newWebRequest) {
        if(newWebRequest.getParameters() == null) {
            return new WebhookResponse().setFulfillmentText("SVP ! saisez le genre de films 😁");
        }
        return new WebhookResponse().setFulfillmentText("Avatar");
    }
}
