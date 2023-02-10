package chatbotapp.chatbotapp;

import chatbotapp.chatbotapp.hooks.*;

import chatbotapp.chatbotapp.hooks.Button;
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

        WebhookResponse response = new WebhookResponse();

        if (newWebRequest.getQueryResult().getParameters().get("genre") == null || newWebRequest.getQueryResult().getParameters().get("genre").equals("")) {

            java.util.List<Button> buttons;

            buttons = new ArrayList<Button>();
            buttons.add(new Button().setText("Science-fiction"));
            buttons.add(new Button().setText("Comedie"));

            java.util.List<FulfillmentMessages> fulfillmentMessages;

            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            fulfillmentMessages.add(new FulfillmentMessages().setCard(new Card().setButtons(buttons)));

            response.setFulfillmentMessages(fulfillmentMessages);


            response.setFulfillmentText("Tres bien. Quel genre de films veux-tu voir ?");

            return response;
        }
        return new WebhookResponse().setFulfillmentText("Avatar");
    }
}
