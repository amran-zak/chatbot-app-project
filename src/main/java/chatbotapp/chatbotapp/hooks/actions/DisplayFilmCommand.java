package chatbotapp.chatbotapp.hooks.actions;

import chatbotapp.chatbotapp.hooks.WebhookCommand;
import chatbotapp.chatbotapp.hooks.WebhookInvocator;
import chatbotapp.chatbotapp.hooks.WebhookRequest;
import chatbotapp.chatbotapp.hooks.WebhookResponse;
import chatbotapp.chatbotapp.models.*;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class DisplayFilmCommand implements WebhookCommand {

    public WebhookResponse execute(WebhookRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        WebhookResponse response = new WebhookResponse();

        if(request.getQueryResult().getParameters().get("genre").equals("Science fiction")) {
            java.util.List<FulfillmentMessages> fulfillmentMessages;
            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            java.util.List<SimpleResponse> sampleResponses;
            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Tres bien. Voici les meilleurs films de Science fiction"));
            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );

            java.util.List<Item> items;
            items = new ArrayList<Item>();

            String url = "https://api.themoviedb.org/3/search/movie?api_key=4789d4caefcebacc74ede26d39fe8048&query=";
            ResponseEntity<ResponseMovieDB> responseMovieDB;

            // Avatar
            responseMovieDB = restTemplate.getForEntity(
                    url + "Avatar", ResponseMovieDB.class);
            items.add(new Item().setTitle(responseMovieDB.getBody().getResults().get(0).getTitle())
                    .setDescription(responseMovieDB.getBody().getResults().get(0).getOverview())
                    .setInfo(new SelectItemInfo().setKey(responseMovieDB.getBody().getResults().get(0).getId()))
                    .setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"+responseMovieDB.getBody().getResults().get(0).getPoster_path())));
            //Stalker
            responseMovieDB = restTemplate.getForEntity(
                    url + "Stalker", ResponseMovieDB.class);
            items.add(new Item().setTitle(responseMovieDB.getBody().getResults().get(0).getTitle())
                    .setDescription(responseMovieDB.getBody().getResults().get(0).getOverview())
                    .setInfo(new SelectItemInfo().setKey(responseMovieDB.getBody().getResults().get(0).getId()))
                    .setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"+responseMovieDB.getBody().getResults().get(0).getPoster_path())));
            //Blade Runner
            responseMovieDB = restTemplate.getForEntity(
                    url + "Blade Runner", ResponseMovieDB.class);
            items.add(new Item().setTitle(responseMovieDB.getBody().getResults().get(0).getTitle())
                    .setDescription(responseMovieDB.getBody().getResults().get(0).getOverview())
                    .setInfo(new SelectItemInfo().setKey(responseMovieDB.getBody().getResults().get(0).getId()))
                    .setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"+responseMovieDB.getBody().getResults().get(0).getPoster_path())));

            CarouselSelect carouselSelect = new CarouselSelect().setItems(items);
            fulfillmentMessages.add(new FulfillmentMessages().setCarouselSelect(carouselSelect));

            response.setFulfillmentMessages(fulfillmentMessages);
            return  response;
        }
        else if(request.getQueryResult().getParameters().get("genre").equals("Comédie")) {
            java.util.List<FulfillmentMessages> fulfillmentMessages;
            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            java.util.List<SimpleResponse> sampleResponses;
            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Tres bien. Voici les meilleurs films de Comédie"));
            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );

            String url = "https://api.themoviedb.org/3/search/movie?api_key=4789d4caefcebacc74ede26d39fe8048&query=";
            ResponseEntity<ResponseMovieDB> responseMovieDB;

            java.util.List<Item> items;
            items = new ArrayList<Item>();
            // La Cité de la peur
            responseMovieDB = restTemplate.getForEntity(
                    url + "La Cité de la peur", ResponseMovieDB.class);
            items.add(new Item().setTitle(responseMovieDB.getBody().getResults().get(0).getTitle())
                    .setDescription(responseMovieDB.getBody().getResults().get(0).getOverview())
                    .setInfo(new SelectItemInfo().setKey(responseMovieDB.getBody().getResults().get(0).getId()))
                    .setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"+responseMovieDB.getBody().getResults().get(0).getPoster_path())));
            //Astérix & Obélix
            responseMovieDB = restTemplate.getForEntity(
                    url + "Astérix & Obélix", ResponseMovieDB.class);
            items.add(new Item().setTitle(responseMovieDB.getBody().getResults().get(0).getTitle())
                    .setDescription(responseMovieDB.getBody().getResults().get(0).getOverview())
                    .setInfo(new SelectItemInfo().setKey(responseMovieDB.getBody().getResults().get(0).getId()))
                    .setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"+responseMovieDB.getBody().getResults().get(0).getPoster_path())));
            //Monty Python - Sacré Graal !
            responseMovieDB = restTemplate.getForEntity(
                    url + "Monty Python - Sacré Graal !", ResponseMovieDB.class);
            items.add(new Item().setTitle(responseMovieDB.getBody().getResults().get(0).getTitle())
                    .setDescription(responseMovieDB.getBody().getResults().get(0).getOverview())
                    .setInfo(new SelectItemInfo().setKey(responseMovieDB.getBody().getResults().get(0).getId()))
                    .setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"+responseMovieDB.getBody().getResults().get(0).getPoster_path())));

            CarouselSelect carouselSelect = new CarouselSelect().setItems(items);
            fulfillmentMessages.add(new FulfillmentMessages().setCarouselSelect(carouselSelect));

            response.setFulfillmentMessages(fulfillmentMessages);
            return response;
        }
        else if(request.getQueryResult().getParameters().get("genre").equals("Aventure")) {
            java.util.List<FulfillmentMessages> fulfillmentMessages;
            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            java.util.List<SimpleResponse> sampleResponses;
            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Tres bien. Voici les meilleurs films d'aventure"));
            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );

            String url = "https://api.themoviedb.org/3/search/movie?api_key=4789d4caefcebacc74ede26d39fe8048&query=";
            ResponseEntity<ResponseMovieDB> responseMovieDB;

            java.util.List<Item> items;
            items = new ArrayList<Item>();
            // King Kong
            responseMovieDB = restTemplate.getForEntity(
                    url + "King Kong", ResponseMovieDB.class);
            items.add(new Item().setTitle(responseMovieDB.getBody().getResults().get(0).getTitle())
                    .setDescription(responseMovieDB.getBody().getResults().get(0).getOverview())
                    .setInfo(new SelectItemInfo().setKey(responseMovieDB.getBody().getResults().get(0).getId()))
                    .setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"+responseMovieDB.getBody().getResults().get(0).getPoster_path())));
            //Dersou Ouzala
            responseMovieDB = restTemplate.getForEntity(
                    url + "Dersou Ouzala", ResponseMovieDB.class);
            items.add(new Item().setTitle(responseMovieDB.getBody().getResults().get(0).getTitle())
                    .setDescription(responseMovieDB.getBody().getResults().get(0).getOverview())
                    .setInfo(new SelectItemInfo().setKey(responseMovieDB.getBody().getResults().get(0).getId()))
                    .setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"+responseMovieDB.getBody().getResults().get(0).getPoster_path())));
            //Le Salaire de la peur
            responseMovieDB = restTemplate.getForEntity(
                    url + "Le Salaire de la peur", ResponseMovieDB.class);
            items.add(new Item().setTitle(responseMovieDB.getBody().getResults().get(0).getTitle())
                    .setDescription(responseMovieDB.getBody().getResults().get(0).getOverview())
                    .setInfo(new SelectItemInfo().setKey(responseMovieDB.getBody().getResults().get(0).getId()))
                    .setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"+responseMovieDB.getBody().getResults().get(0).getPoster_path())));

            CarouselSelect carouselSelect = new CarouselSelect().setItems(items);
            fulfillmentMessages.add(new FulfillmentMessages().setCarouselSelect(carouselSelect));

            response.setFulfillmentMessages(fulfillmentMessages);
            return response;
        }
        return response;
    }
}
