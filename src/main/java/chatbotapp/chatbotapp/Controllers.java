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


            //response.setFulfillmentText("Tres bien. Quel genre de films veux-tu voir - A?");

            return response;
        }


        if(newWebRequest.getQueryResult().getParameters().get("genre") == "Science-fiction") {
            java.util.List<FulfillmentMessages> fulfillmentMessages;

            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            fulfillmentMessages.add(new FulfillmentMessages().setCard(
                    new Card().setTitle("Avatar").
                            setSubtitle("Films de Science Fiction disponible dans ma filmothèque et à voir absolument bien sûr elle n'est pas exhaustive !").
                            setImageUri("data:image/jpeg;base64,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")
            ));
            response.setFulfillmentMessages(fulfillmentMessages);
        }

        return response;
    }
}
