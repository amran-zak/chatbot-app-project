package chatbotapp.chatbotapp.hooks.actions;

import chatbotapp.chatbotapp.hooks.WebhookCommand;
import chatbotapp.chatbotapp.hooks.WebhookInvocator;
import chatbotapp.chatbotapp.hooks.WebhookRequest;
import chatbotapp.chatbotapp.hooks.WebhookResponse;
import chatbotapp.chatbotapp.models.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AskGenreCommand implements WebhookCommand {
    public WebhookResponse execute(WebhookRequest request) {

        WebhookResponse response = new WebhookResponse();

        java.util.List<Suggestion> suggestions;
        suggestions = new ArrayList<Suggestion>();
        suggestions.add(new Suggestion().setTitle("Science fiction"));
        suggestions.add(new Suggestion().setTitle("Comédie"));
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
}
