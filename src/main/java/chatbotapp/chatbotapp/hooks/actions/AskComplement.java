package chatbotapp.chatbotapp.hooks.actions;

import chatbotapp.chatbotapp.hooks.WebhookCommand;
import chatbotapp.chatbotapp.hooks.WebhookRequest;
import chatbotapp.chatbotapp.hooks.WebhookResponse;
import chatbotapp.chatbotapp.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AskComplement implements WebhookCommand  {
    public WebhookResponse execute(WebhookRequest request) {
        WebhookResponse response = new WebhookResponse();

        if(request.getQueryResult().getParameters().get("responseDessert").equals("oui")) {
            java.util.List<FulfillmentMessages> fulfillmentMessages;
            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            java.util.List<SimpleResponse> sampleResponses;
            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Choisis un complément"));
            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );

            java.util.List<Item> items;
            items = new ArrayList<Item>();

            // Tiramisu
            items.add(new Item().setTitle("Tiramisu")
                    .setDescription("" +
                            "5 €")
                    .setInfo(new SelectItemInfo().setKey("Tiramisu"))
                    .setImage(new Image().setImageUri(
                            "https://www.galbani.fr/wp-content/uploads/2017/07/le_veritable_tiramisu_par_il_gusto_italiano_0.png")));

            // Brownie
            items.add(new Item().setTitle("Brownie")
                    .setDescription("4 €")
                    .setInfo(new SelectItemInfo().setKey("Brownie"))
                    .setImage(new Image().setImageUri(
                            "https://www.hervecuisine.com/wp-content/uploads/2015/10/brownies.jpg")));


            CarouselSelect carouselSelect = new CarouselSelect().setItems(items);
            fulfillmentMessages.add(new FulfillmentMessages().setCarouselSelect(carouselSelect));

            response.setFulfillmentMessages(fulfillmentMessages);
            return  response;
        }
        else if(request.getQueryResult().getParameters().get("responseDessert").equals("non")) {
            response.setFulfillmentText("Nous te préparons ta commande, ça te fera 21 €");
        }

        return response;
    }

}
