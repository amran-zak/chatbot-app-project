package chatbotapp.chatbotapp.models;

import lombok.Data;

@Data
public class FulfillmentMessages {


    private String platform = "SLACK";

    private Card basicCard;
    private Suggestions suggestions;

    private SimpleResponses simpleResponses;
    private CarouselSelect carouselSelect;
    private TableCard tableCard;

    private  Payload payload;



}


