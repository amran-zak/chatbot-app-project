package chatbotapp.chatbotapp.hooks.actions;

import chatbotapp.chatbotapp.hooks.WebhookCommand;
import chatbotapp.chatbotapp.hooks.WebhookRequest;
import chatbotapp.chatbotapp.hooks.WebhookResponse;
import chatbotapp.chatbotapp.models.*;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class DisplayDetailsCommand implements WebhookCommand {
    public WebhookResponse execute(WebhookRequest request) {
        RestTemplate restTemplate = new RestTemplate();
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

        String url = "https://api.themoviedb.org/3/movie/";
        ResponseEntity<Result> result;
        result = restTemplate.getForEntity(
                url + key +"?api_key=4789d4caefcebacc74ede26d39fe8048", Result.class);

        java.util.List<SimpleResponse> sampleResponses;
        sampleResponses = new ArrayList<SimpleResponse>();
        sampleResponses.add(new SimpleResponse().setSsml("").
                setDisplayText("").setTextToSpeech("Voici les details supplémentaires du films " + result.getBody().getTitle()));
        fulfillmentMessages.add(new FulfillmentMessages().
                setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
        );

        java.util.List<Button> butons;
        butons = new ArrayList<Button>();
        butons.add(new Button().setTitle("Voir sur the Movie DB")
                .setOpenUriAction(new OpenUriAction().setUri("https://github.com/amran-zak")));

        Card basiccard = new Card().setTitle(result.getBody().getTitle())
                .setSubtitle(result.getBody().getRelease_date())
                .setFormattedText(result.getBody().getOverview())
                .setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"+result.getBody().getPoster_path()))
                .setButtons(butons);
        fulfillmentMessages.add(new FulfillmentMessages().setBasicCard(basiccard));

        response.setFulfillmentMessages(fulfillmentMessages);
        return response;
    }
}
