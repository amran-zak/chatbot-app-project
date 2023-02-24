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
                    .setDescription("une pizza classique avec de la sauce tomate, de la mozzarella, de l'huile d'olive et du basilic frais.")
                    .setInfo(new SelectItemInfo().setKey("Margherita"))
                    .setImage(new Image().setImageUri(
                            "https://img.cuisineaz.com/660x660/2013/12/20/i18445-margherite.jpeg")));

            // Pepperoni
            items.add(new Item().setTitle("Pepperoni")
                    .setDescription("Une pizza classique avec de la sauce tomate, de la mozzarella, de l'huile d'olive et du basilic frais.")
                    .setInfo(new SelectItemInfo().setKey("Pepperoni"))
                    .setImage(new Image().setImageUri(
                            "https://assets.afcdn.com/recipe/20190319/89655_w1024h768c1cx3680cy2456.webp")));

            // Parisienne
            items.add(new Item().setTitle("Parisienne")
                    .setDescription("Une pizza avec de la crème fraîche, des champignons, du jambon, des oignons et de la mozzarella.")
                    .setInfo(new SelectItemInfo().setKey("Parisienne"))
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
            // Margherita
            items.add(new Item().setTitle("Margherita")
                    .setDescription("une pizza classique avec de la sauce tomate, de la mozzarella, de l'huile d'olive et du basilic frais.")
                    .setInfo(new SelectItemInfo().setKey("Margherita"))
                    .setImage(new Image().setImageUri(
                            "https://img.cuisineaz.com/660x660/2013/12/20/i18445-margherite.jpeg")));

            // Pepperoni
            items.add(new Item().setTitle("Pepperoni")
                    .setDescription("Une pizza classique avec de la sauce tomate, de la mozzarella, de l'huile d'olive et du basilic frais.")
                    .setInfo(new SelectItemInfo().setKey("Pepperoni"))
                    .setImage(new Image().setImageUri(
                            "https://assets.afcdn.com/recipe/20190319/89655_w1024h768c1cx3680cy2456.webp")));

            // Parisienne
            items.add(new Item().setTitle("Parisienne")
                    .setDescription("Une pizza avec de la crème fraîche, des champignons, du jambon, des oignons et de la mozzarella.")
                    .setInfo(new SelectItemInfo().setKey("Parisienne"))
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
            // Margherita
            items.add(new Item().setTitle("Margherita")
                    .setDescription("une pizza classique avec de la sauce tomate, de la mozzarella, de l'huile d'olive et du basilic frais.")
                    .setInfo(new SelectItemInfo().setKey("Margherita"))
                    .setImage(new Image().setImageUri(
                            "https://img.cuisineaz.com/660x660/2013/12/20/i18445-margherite.jpeg")));

            // Pepperoni
            items.add(new Item().setTitle("Pepperoni")
                    .setDescription("Une pizza classique avec de la sauce tomate, de la mozzarella, de l'huile d'olive et du basilic frais.")
                    .setInfo(new SelectItemInfo().setKey("Pepperoni"))
                    .setImage(new Image().setImageUri(
                            "https://assets.afcdn.com/recipe/20190319/89655_w1024h768c1cx3680cy2456.webp")));

            // Parisienne
            items.add(new Item().setTitle("Parisienne")
                    .setDescription("Une pizza avec de la crème fraîche, des champignons, du jambon, des oignons et de la mozzarella.")
                    .setInfo(new SelectItemInfo().setKey("Parisienne"))
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
            return response;
        }
        return response;
    }
}
