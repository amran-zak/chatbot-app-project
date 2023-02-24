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
public class DisplayPizza implements WebhookCommand {
    public WebhookResponse execute(WebhookRequest request) {
        WebhookResponse response = new WebhookResponse();

        if(request.getQueryResult().getParameters().get("pizzaName").equals("Classiques")) {
            java.util.List<FulfillmentMessages> fulfillmentMessages;
            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            java.util.List<SimpleResponse> sampleResponses;
            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Tres bon choix \uD83D\uDC4D, laquelle choisis-tu \uD83E\uDD14?"));
            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );

            java.util.List<Item> items;
            items = new ArrayList<Item>();

            // Margherita
            items.add(new Item().setTitle("Margherita")
                    .setDescription("10 €")
                    .setInfo(new SelectItemInfo().setKey("Margherita"))
                    .setImage(new Image().setImageUri(
                            "https://img.cuisineaz.com/660x660/2013/12/20/i18445-margherite.jpeg")));

            // Quatre saisons
            items.add(new Item().setTitle("Quatre saisons")
                    .setDescription("15 €")
                    .setInfo(new SelectItemInfo().setKey("Quatre saisons"))
                    .setImage(new Image().setImageUri(
                            "https://assets.afcdn.com/recipe/20190319/89655_w1024h768c1cx3680cy2456.webp")));

            // Prosciutto e funghi
            items.add(new Item().setTitle("Prosciutto e funghi ")
                    .setDescription("12 €")
                    .setInfo(new SelectItemInfo().setKey("Prosciutto e funghi "))
                    .setImage(new Image().setImageUri(
                            "https://www.cuisineactuelle.fr/imgre/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fcac.2F2018.2F09.2F25.2F486382f5-b19f-4707-ae9c-2d9c54ddfd6e.2Ejpeg/750x562/quality/80/crop-from/center/cr/wqkgR2V0dHkgLyBDdWlzaW5lIEFjdHVlbGxl/pizza-a-la-parisienne.jpeg")));

            // La Regina
            items.add(new Item().setTitle("La Regina")
                    .setDescription("Une pizza avec de la sauce tomate, de la mozzarella, du jambon, des champignons frais et des olives noires.")
                    .setInfo(new SelectItemInfo().setKey("La Regina"))
                    .setImage(new Image().setImageUri(
                            "https://www.cuisineactuelle.fr/imgre/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fcac.2F2018.2F09.2F25.2F05b88720-765f-430e-9a61-82a2cb9dc162.2Ejpeg/750x562/quality/80/crop-from/center/cr/wqkgUnltYW4gQ2FiYW5uZXMvU3VjcsOpIHNhbMOpIC8gQ3Vpc2luZSBBY3R1ZWxsZQ%3D%3D/pizza-regina.jpeg")));

            CarouselSelect carouselSelect = new CarouselSelect().setItems(items);
            fulfillmentMessages.add(new FulfillmentMessages().setCarouselSelect(carouselSelect));

            response.setFulfillmentMessages(fulfillmentMessages);
            return  response;
        }
        else if(request.getQueryResult().getParameters().get("pizzaName").equals("Gourmandes")) {
            java.util.List<FulfillmentMessages> fulfillmentMessages;
            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            java.util.List<SimpleResponse> sampleResponses;
            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Tres bon choix \uD83D\uDC4D, laquelle choisis-tu \uD83E\uDD14?"));
            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );

            java.util.List<Item> items;
            items = new ArrayList<Item>();

            // Quattro formaggi
            items.add(new Item().setTitle("Quattro formaggi")
                    .setDescription("13 €")
                    .setInfo(new SelectItemInfo().setKey("Quattro formaggi"))
                    .setImage(new Image().setImageUri(
                            "https://img.cuisineaz.com/660x660/2013/12/20/i18445-margherite.jpeg")));

            // 4 saisons truffes
            items.add(new Item().setTitle("4 saisons truffes")
                    .setDescription("10 €")
                    .setInfo(new SelectItemInfo().setKey("4 saisons truffes"))
                    .setImage(new Image().setImageUri(
                            "https://assets.afcdn.com/recipe/20190319/89655_w1024h768c1cx3680cy2456.webp")));

            // Salmone affumicato
            items.add(new Item().setTitle("Salmone affumicato")
                    .setDescription("16 €")
                    .setInfo(new SelectItemInfo().setKey("Salmone affumicato"))
                    .setImage(new Image().setImageUri(
                            "https://www.cuisineactuelle.fr/imgre/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fcac.2F2018.2F09.2F25.2F486382f5-b19f-4707-ae9c-2d9c54ddfd6e.2Ejpeg/750x562/quality/80/crop-from/center/cr/wqkgR2V0dHkgLyBDdWlzaW5lIEFjdHVlbGxl/pizza-a-la-parisienne.jpeg")));

            // Diavola
            items.add(new Item().setTitle("Diavola")
                    .setDescription("12 €")
                    .setInfo(new SelectItemInfo().setKey("Diavola"))
                    .setImage(new Image().setImageUri(
                            "https://www.cuisineactuelle.fr/imgre/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fcac.2F2018.2F09.2F25.2F05b88720-765f-430e-9a61-82a2cb9dc162.2Ejpeg/750x562/quality/80/crop-from/center/cr/wqkgUnltYW4gQ2FiYW5uZXMvU3VjcsOpIHNhbMOpIC8gQ3Vpc2luZSBBY3R1ZWxsZQ%3D%3D/pizza-regina.jpeg")));

            CarouselSelect carouselSelect = new CarouselSelect().setItems(items);
            fulfillmentMessages.add(new FulfillmentMessages().setCarouselSelect(carouselSelect));

            response.setFulfillmentMessages(fulfillmentMessages);
            return response;
        }
        else if(request.getQueryResult().getParameters().get("pizzaName").equals("Végétariennes")) {
            java.util.List<FulfillmentMessages> fulfillmentMessages;
            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            java.util.List<SimpleResponse> sampleResponses;
            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Tres bon choix \uD83D\uDC4D, laquelle choisis-tu \uD83E\uDD14?"));
            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );

            java.util.List<Item> items;
            items = new ArrayList<Item>();
            // Primavera
            items.add(new Item().setTitle("Primavera")
                    .setDescription("14 €")
                    .setInfo(new SelectItemInfo().setKey("Primavera"))
                    .setImage(new Image().setImageUri(
                            "https://img.cuisineaz.com/660x660/2013/12/20/i18445-margherite.jpeg")));

            // Caprese
            items.add(new Item().setTitle("Caprese")
                    .setDescription("12 €")
                    .setInfo(new SelectItemInfo().setKey("Caprese"))
                    .setImage(new Image().setImageUri(
                            "https://assets.afcdn.com/recipe/20190319/89655_w1024h768c1cx3680cy2456.webp")));

            // Verdure grigliate
            items.add(new Item().setTitle("Verdure grigliate")
                    .setDescription("10 €")
                    .setInfo(new SelectItemInfo().setKey("Verdure grigliate"))
                    .setImage(new Image().setImageUri(
                            "https://www.cuisineactuelle.fr/imgre/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fcac.2F2018.2F09.2F25.2F486382f5-b19f-4707-ae9c-2d9c54ddfd6e.2Ejpeg/750x562/quality/80/crop-from/center/cr/wqkgR2V0dHkgLyBDdWlzaW5lIEFjdHVlbGxl/pizza-a-la-parisienne.jpeg")));

            // Margherita con verdure
            items.add(new Item().setTitle("Margherita con verdure")
                    .setDescription("18 €")
                    .setInfo(new SelectItemInfo().setKey("Margherita con verdure"))
                    .setImage(new Image().setImageUri(
                            "https://www.cuisineactuelle.fr/imgre/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fcac.2F2018.2F09.2F25.2F05b88720-765f-430e-9a61-82a2cb9dc162.2Ejpeg/750x562/quality/80/crop-from/center/cr/wqkgUnltYW4gQ2FiYW5uZXMvU3VjcsOpIHNhbMOpIC8gQ3Vpc2luZSBBY3R1ZWxsZQ%3D%3D/pizza-regina.jpeg")));

            CarouselSelect carouselSelect = new CarouselSelect().setItems(items);
            fulfillmentMessages.add(new FulfillmentMessages().setCarouselSelect(carouselSelect));

            response.setFulfillmentMessages(fulfillmentMessages);
            return response;
        }
        return response;
    }
}
