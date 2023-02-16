package chatbotapp.chatbotapp;

import chatbotapp.chatbotapp.hooks.*;

import chatbotapp.chatbotapp.hooks.Button;
import chatbotapp.chatbotapp.hooks.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;


@Slf4j
@RestController
public class Controllers {

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "Hello world!";
    }

    @PostMapping("/conseilfilm")
    public WebhookResponse conseilfilm(@RequestBody WebhookRequest newWebRequest) {

        WebhookResponse response = new WebhookResponse();

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


        if(newWebRequest.getQueryResult().getParameters().get("genre").equals("Science fiction")) {
            java.util.List<FulfillmentMessages> fulfillmentMessages;

            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            java.util.List<Item> items;

            items = new ArrayList<Item>();
            // Avatar
            items.add(new Item().setTitle("Avatar")
                    .setDescription("Avatar est une franchise cinématographique américaine de science-fiction. La franchise devrait comporter à terme cinq films, le dernier étant prévu pour 2028. Le premier sort en 2009 et connaît un immense succès critique et commercial : il devient le plus gros succès de l'histoire du cinéma.")
                    .setInfo(new SelectItemInfo().setKey("Avatar"))
                    .setImage(new Image().setImageUri("https://static.cnews.fr/sites/default/files/styles/image_750_422/public/raw-taille1200_637388c66f5b7.jpg?itok=GQU6-dn7")));
            // Stranger Things
            items.add(new Item().setTitle("Stranger Things")
                    .setDescription("En 1983, à Hawkins dans l'Indiana, Will Byers disparaît de son domicile. Ses amis se lancent alors dans une recherche semée d'embûches pour le retrouver. Pendant leur quête de réponses, les garçons rencontrent une étrange jeune fille en fuite.")
                    .setInfo(new SelectItemInfo().setKey("Stranger Things"))
                    .setImage(new Image().setImageUri("https://i0.wp.com/www.coliseugeek.com.br/wp-content/uploads/2023/01/bbcee-clickwallpapers-stranger-things-netflix-serie-wallpaper-in-4k-img9-scaled-1.jpg?resize=1024%2C576&ssl=1")));
            // The Twilight Zone
            items.add(new Item().setTitle("The Twilight Zone")
                    .setDescription("Qui pour moderniser cette série fantastique culte, créée en 1959 par Rod Serling, sinon le nouveau maître de l'effroi Jordan Peele (GET OUT - Oscar 2018 du meilleur scénario) et Simon Kinberg (DEADPOOL) ?")
                    .setInfo(new SelectItemInfo().setKey("The Twilight Zone"))
                    .setImage(new Image().setImageUri("https://c4.wallpaperflare.com/wallpaper/572/160/904/tv-show-the-twilight-zone-twilight-zone-wallpaper-preview.jpg")));


            CarouselSelect carouselSelect = new CarouselSelect().setItems(items);

            fulfillmentMessages.add(new FulfillmentMessages().setCarouselSelect(carouselSelect));

            response.setFulfillmentMessages(fulfillmentMessages);
            return  response;
        }
        else if(newWebRequest.getQueryResult().getParameters().get("genre").equals("Comédie")) {
            java.util.List<FulfillmentMessages> fulfillmentMessages;

            fulfillmentMessages = new ArrayList<FulfillmentMessages>();

            java.util.List<Item> items;

            items = new ArrayList<Item>();
            // Palmashow
            items.add(new Item().setTitle("Palmashow")
                    .setDescription("Le Palmashow est un duo d'humoristes composé de Grégoire Ludig et David Marsais. Ils se sont fait connaître sur Internet, puis par Direct 8, D8, C8, puis TMC et TF1. Le Palmashow a depuis créé trois émissions et prépare leur cinquième prime. Sorti prévu pour 2023.")
                    .setInfo(new SelectItemInfo().setKey("Palmashow"))
                    .setImage(new Image().setImageUri("https://kifim.b-cdn.net/series/large/1764004.jpg")));
            // A votre service
            items.add(new Item().setTitle("A votre service")
                    .setDescription("À votre service est une série télévisée courte humoristique française créée et réalisée par Florian Hessique, diffusée depuis le 6 octobre 2015 sur la chaîne MCE TV. Depuis 2018, on retrouve la série sur MyTF1 VoD.")
                    .setInfo(new SelectItemInfo().setKey("A votre service"))
                    .setImage(new Image().setImageUri("data:image/jpeg;base64,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")));
            // Bref
            items.add(new Item().setTitle("Bref")
                    .setDescription("Bref. est une série télévisée française de format shortcom créée par Kyan Khojandi et Bruno Muschio et diffusée au sein du Grand Journal de Canal+ du 29 août 2011 au 12 juillet 2012. La série est composée de trois sessions. La première, composée de 40 épisodes, est celle commandée initialement par Canal+.")
                    .setInfo(new SelectItemInfo().setKey("Bref"))
                    .setImage(new Image().setImageUri("https://fr.web.img6.acsta.net/pictures/19/10/17/07/59/3926800.jpg")));


            CarouselSelect carouselSelect = new CarouselSelect().setItems(items);

            fulfillmentMessages.add(new FulfillmentMessages().setCarouselSelect(carouselSelect));

            response.setFulfillmentMessages(fulfillmentMessages);
            return response;
        }
        response.setFulfillmentText("Je te propose à regarder ....");
        return response;
    }
}
