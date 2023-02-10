package chatbotapp.chatbotapp;

import chatbotapp.chatbotapp.hooks.Suggestions_Button;
import chatbotapp.chatbotapp.hooks.WebhookRequest;

import chatbotapp.chatbotapp.hooks.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;


@Slf4j
@RestController
public class Controllers {

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "Hello world!";
    }

    @PostMapping("/conseilfilm")
    public WebhookResponse conseilfilm(@RequestBody WebhookRequest newWebRequest) {
        if (newWebRequest.getQueryResult().getParameters().get("genre") == null || newWebRequest.getQueryResult().getParameters().get("genre").equals("")) {
            java.util.List<Suggestions_Button> buttons;
            buttons = new ArrayList<Suggestions_Button>();

            Suggestions_Button button = new Suggestions_Button();
            button.setDescription("Science-fiction");
            button.setTitle("Science-fiction");
            button.setUrl("https://example.com/science-fiction");
            buttons.add(button);

            Suggestions_Button button1 = new Suggestions_Button();
            button1.setDescription("Comédie");
            button1.setTitle("Comédie");
            button1.setUrl("https://example.com/Comedie");
            buttons.add(button1);

            return new WebhookResponse().setFulfillmentText("Tres bien. Quel genre de films veux-tu voir ?").setButtons(buttons);
        }
        return new WebhookResponse().setFulfillmentText("Avatar");
    }
}
