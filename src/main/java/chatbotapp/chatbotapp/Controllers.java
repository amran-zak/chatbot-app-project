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

            java.util.List<Suggestion> suggestions;

            suggestions = new ArrayList<Suggestion>();
            suggestions.add(new Suggestion().setTitle("Science-fiction"));
            suggestions.add(new Suggestion().setTitle("Comedie"));
            suggestions.add(new Suggestion().setTitle("Aventure"));
            suggestions.add(new Suggestion().setTitle("Action"));


            java.util.List<SimpleResponse> sampleResponses;

            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Tres bien. Quel genre de films veux-tu voir ?"));


            java.util.List<FulfillmentMessages> fulfillmentMessages;

            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );

            fulfillmentMessages.add(new FulfillmentMessages().
                    setSuggestions(new Suggestions().
                            setSuggestions(suggestions)
                    )
            );

            response.setFulfillmentMessages(fulfillmentMessages);


            response.setFulfillmentText("Tres bien. Quel genre de films veux-tu voir - A?");

            return response;
        }
        return response.setFulfillmentText("Avatar");
    }
}
