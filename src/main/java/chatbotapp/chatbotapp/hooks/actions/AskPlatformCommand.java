package chatbotapp.chatbotapp.hooks.actions;

import chatbotapp.chatbotapp.hooks.WebhookCommand;
import chatbotapp.chatbotapp.hooks.WebhookRequest;
import chatbotapp.chatbotapp.hooks.WebhookResponse;
import chatbotapp.chatbotapp.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
@Slf4j
public class AskPlatformCommand implements WebhookCommand {
    @Override
    public WebhookResponse execute(WebhookRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        WebhookResponse response = new WebhookResponse();

        java.util.List<FulfillmentMessages> fulfillmentMessages;
        fulfillmentMessages = new ArrayList<FulfillmentMessages>();

        java.util.List<SimpleResponse> sampleResponses;
        sampleResponses = new ArrayList<SimpleResponse>();
        sampleResponses.add(new SimpleResponse().setSsml("").
                setDisplayText("").setTextToSpeech("Le film est disponible sur ces plateformes"));
        fulfillmentMessages.add(new FulfillmentMessages().
                setSimpleResponses(new SimpleResponses().setSimpleResponses(sampleResponses))
        );

        String url = "https://api.themoviedb.org/3/search/movie?api_key=4789d4caefcebacc74ede26d39fe8048&query=";
        ResponseEntity<ResponseMovieDB> responseMovieDB;

        responseMovieDB = restTemplate.getForEntity(
                url + request.getQueryResult().getParameters().get("film"), ResponseMovieDB.class);


        String url1 = "https://api.themoviedb.org/3/movie/";
        ResponseEntity<ResponseMovieDBPlatform> responseMovieDB1;

        responseMovieDB1 = restTemplate.getForEntity(
                url1 + responseMovieDB.getBody().getResults().get(0).getId() + "/watch/providers?api_key=4789d4caefcebacc74ede26d39fe8048",
                ResponseMovieDBPlatform.class);

        TableCard tableCard = new TableCard();
        //title
        tableCard.setTitle(responseMovieDB.getBody().getResults().get(0).getTitle());
        //image
        tableCard.setImage(new Image().setImageUri("https://image.tmdb.org/t/p/w500"
                +responseMovieDB.getBody().getResults().get(0).getPoster_path()));

        // cols
        java.util.List<ColumnProperties> cols;
        cols = new ArrayList<ColumnProperties>();
        cols.add(new ColumnProperties().setHeader("Pays"));
        cols.add(new ColumnProperties().setHeader("Plateforme"));
        tableCard.setColumnProperties(cols);

        // rows
        java.util.List<TableCardRow> rows;
        rows = new ArrayList<TableCardRow>();

        //cels
        java.util.List<TableCardCell> cells;


        //US
        cells = new ArrayList<TableCardCell>();
        cells.add(new TableCardCell().setText("Etats-Unis"));
        //log.info("{}", responseMovieDB1.getBody().getResults().get("US").getFlatrate());
        if(responseMovieDB1.getBody().getResults().get("US").getFlatrate() == null){
            cells.add(new TableCardCell().setText("Non disponnible"));

        }else{
            cells.add(new TableCardCell().setText(responseMovieDB1.getBody().getResults().get("US").getFlatrate().get(0).getProvider_name()));
        }
        rows.add(new TableCardRow().setCells(cells));

        //JP
        cells = new ArrayList<TableCardCell>();
        cells.add(new TableCardCell().setText("Japon"));
        if(responseMovieDB1.getBody().getResults().get("JP").getFlatrate() == null){
            cells.add(new TableCardCell().setText("Non disponnible"));

        }else{
            cells.add(new TableCardCell().setText(responseMovieDB1.getBody().getResults().get("JP").getFlatrate().get(0).getProvider_name()));
        }rows.add(new TableCardRow().setCells(cells));

        //GB
        cells = new ArrayList<TableCardCell>();
        cells.add(new TableCardCell().setText("Royaume-Uni"));
        if(responseMovieDB1.getBody().getResults().get("GB").getFlatrate() == null){
            cells.add(new TableCardCell().setText("Non disponnible"));

        }else{
            cells.add(new TableCardCell().setText(responseMovieDB1.getBody().getResults().get("GB").getFlatrate().get(0).getProvider_name()));
        }
        rows.add(new TableCardRow().setCells(cells));

        //BE
        cells = new ArrayList<TableCardCell>();
        cells.add(new TableCardCell().setText("Belgique"));
        if(responseMovieDB1.getBody().getResults().get("BE").getFlatrate() == null){
            cells.add(new TableCardCell().setText("Non disponnible"));

        }else{
            cells.add(new TableCardCell().setText(responseMovieDB1.getBody().getResults().get("BE").getFlatrate().get(0).getProvider_name()));
        }
        rows.add(new TableCardRow().setCells(cells));

        //FR
        cells = new ArrayList<TableCardCell>();
        cells.add(new TableCardCell().setText("France"));
        if(responseMovieDB1.getBody().getResults().get("FR").getFlatrate() == null){
            cells.add(new TableCardCell().setText("Non disponnible"));

        }else{
            cells.add(new TableCardCell().setText(responseMovieDB1.getBody().getResults().get("FR").getFlatrate().get(0).getProvider_name()));
        }
        rows.add(new TableCardRow().setCells(cells));

        //add rows
        tableCard.setRows(rows);

        fulfillmentMessages.add(new FulfillmentMessages().setTableCard(tableCard));

        response.setFulfillmentMessages(fulfillmentMessages);
        return response;
    }
}
