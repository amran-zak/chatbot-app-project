package chatbotapp.chatbotapp.hooks.actions;

import chatbotapp.chatbotapp.hooks.WebhookCommand;
import chatbotapp.chatbotapp.hooks.WebhookRequest;
import chatbotapp.chatbotapp.hooks.WebhookResponse;
import chatbotapp.chatbotapp.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AskNamePizza implements WebhookCommand  {
    public WebhookResponse execute(WebhookRequest request) {

        WebhookResponse response = new WebhookResponse();

        java.util.List<FulfillmentMessages> fulfillmentMessages;

        fulfillmentMessages = new ArrayList<FulfillmentMessages>();



        java.util.List<SimpleResponse> sampleResponses;
        sampleResponses = new ArrayList<SimpleResponse>();
        sampleResponses.add(new SimpleResponse().setSsml("").
                setDisplayText("").setTextToSpeech("Tres bien, quelle base ?"));
        fulfillmentMessages.add(new FulfillmentMessages().
                setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
        );

        java.util.List<Suggestion> suggestions;
        suggestions = new ArrayList<Suggestion>();
        suggestions.add(new Suggestion().setTitle("Base Tomate"));
        suggestions.add(new Suggestion().setTitle("Base Créme"));
        suggestions.add(new Suggestion().setTitle("Base sucrée"));
        fulfillmentMessages.add(new FulfillmentMessages().
                setSuggestions(new Suggestions().
                        setSuggestions(suggestions)
                )
        );



        response.setFulfillmentMessages(fulfillmentMessages);

        return response;
    }

}
