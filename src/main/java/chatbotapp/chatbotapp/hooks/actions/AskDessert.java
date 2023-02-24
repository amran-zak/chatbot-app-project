package chatbotapp.chatbotapp.hooks.actions;

import chatbotapp.chatbotapp.hooks.WebhookCommand;
import chatbotapp.chatbotapp.hooks.WebhookRequest;
import chatbotapp.chatbotapp.hooks.WebhookResponse;
import chatbotapp.chatbotapp.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class AskDessert implements WebhookCommand {
    public WebhookResponse execute(WebhookRequest request) {
        WebhookResponse response = new WebhookResponse();

        String key = "";
        for(OutputContext i : request.getQueryResult().getOutputContexts()) {
            if(i.getName().endsWith("actions_intent_option")) {
                key = (String) i.getParameters().get("OPTION");
                break;
            }
        }
        java.util.List<FulfillmentMessages> fulfillmentMessages;
        fulfillmentMessages = new ArrayList<FulfillmentMessages>();

        java.util.List<SimpleResponse> sampleResponses;
        sampleResponses = new ArrayList<SimpleResponse>();
        sampleResponses.add(new SimpleResponse().setSsml("").
                setDisplayText("").setTextToSpeech("Et " + key + " ! Souhaites tu autre chose"));
        fulfillmentMessages.add(new FulfillmentMessages().
                setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
        );

        java.util.List<Suggestion> suggestions;
        suggestions = new ArrayList<Suggestion>();
        suggestions.add(new Suggestion().setTitle("Oui"));
        suggestions.add(new Suggestion().setTitle("Non"));
        fulfillmentMessages.add(new FulfillmentMessages().
                setSuggestions(new Suggestions().
                        setSuggestions(suggestions)
                )
        );

        response.setFulfillmentMessages(fulfillmentMessages);
        return response;
    }

}
