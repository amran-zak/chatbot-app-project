package chatbotapp.chatbotapp.hooks.actions;

import chatbotapp.chatbotapp.hooks.WebhookCommand;
import chatbotapp.chatbotapp.hooks.WebhookRequest;
import chatbotapp.chatbotapp.hooks.WebhookResponse;
import chatbotapp.chatbotapp.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClotureCommand implements WebhookCommand {
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
                setDisplayText("").setTextToSpeech("Trés bon choix " + key + ". Nous te préparons ta commande, ça te fera 21 €"));
        fulfillmentMessages.add(new FulfillmentMessages().
                setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
        );


        response.setFulfillmentMessages(fulfillmentMessages);
        return response;
    }

}
