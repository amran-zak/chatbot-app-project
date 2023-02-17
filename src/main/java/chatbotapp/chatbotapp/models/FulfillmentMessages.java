package chatbotapp.chatbotapp.models;

import lombok.Data;

@Data
public class FulfillmentMessages {


    private String platform = "ACTIONS_ON_GOOGLE";

    private Card basicCard;
    private Suggestions suggestions;

    private SimpleResponses simpleResponses;
    private CarouselSelect carouselSelect;
    private TableCard tableCard;



}
