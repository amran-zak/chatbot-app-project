package chatbotapp.chatbotapp;

import chatbotapp.chatbotapp.hooks.*;

import chatbotapp.chatbotapp.hooks.Button;
import chatbotapp.chatbotapp.hooks.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
public class Controllers {

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "Hello world!";
    }
    private RestTemplate restTemplate = new RestTemplate();


    @PostMapping("/conseilfilm")
    public WebhookResponse conseilfilm(@RequestBody WebhookRequest newWebRequest) {
    
        WebhookResponse response = new WebhookResponse();
        if(newWebRequest.getQueryResult().getAction().equals("voirPlus")){
            String key = "";
            for(OutputContext i : newWebRequest.getQueryResult().getOutputContexts()) {
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


        if(newWebRequest.getQueryResult().getParameters().get("genre").equals("Science fiction")) {

            java.util.List<SimpleResponse> sampleResponses;

            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Tres bien. Voici les meilleurs films de Science fiction"));

            java.util.List<FulfillmentMessages> fulfillmentMessages;

            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );

            java.util.List<Item> items;


            items = new ArrayList<Item>();

            String url = "https://api.themoviedb.org/3/search/movie?api_key=4789d4caefcebacc74ede26d39fe8048&query=";
            ResponseEntity<ResponseMovieDB> responseMovieDB;


            // log.info("{}", responseMovieDB.getBody().getResults().get(0));

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
        else if(newWebRequest.getQueryResult().getParameters().get("genre").equals("Comédie")) {
            java.util.List<SimpleResponse> sampleResponses;

            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Tres bien. Voici les meilleurs films de Comédie"));

            java.util.List<FulfillmentMessages> fulfillmentMessages;

            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );

            java.util.List<Item> items;

            items = new ArrayList<Item>();

            String url = "https://api.themoviedb.org/3/search/movie?api_key=4789d4caefcebacc74ede26d39fe8048&query=";
            ResponseEntity<ResponseMovieDB> responseMovieDB;


            // log.info("{}", responseMovieDB.getBody().getResults().get(0));

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
        else if(newWebRequest.getQueryResult().getParameters().get("genre").equals("Aventure")) {
            java.util.List<FulfillmentMessages> fulfillmentMessages;
            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            java.util.List<SimpleResponse> sampleResponses;
            sampleResponses = new ArrayList<SimpleResponse>();
            sampleResponses.add(new SimpleResponse().setSsml("").
                    setDisplayText("").setTextToSpeech("Tres bien. Voici les meilleurs films d'aventure"));
            fulfillmentMessages.add(new FulfillmentMessages().
                    setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
            );






            java.util.List<Item> items;

            items = new ArrayList<Item>();
            String url = "https://api.themoviedb.org/3/search/movie?api_key=4789d4caefcebacc74ede26d39fe8048&query=";
            ResponseEntity<ResponseMovieDB> responseMovieDB;


           // log.info("{}", responseMovieDB.getBody().getResults().get(0));

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



        if (newWebRequest.getQueryResult().getParameters().get("genre") == null || newWebRequest.getQueryResult().getParameters().get("genre").equals("")) {
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


        return response;
    }
}
