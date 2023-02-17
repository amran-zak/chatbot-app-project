package chatbotapp.chatbotapp.hooks;

import lombok.Data;

@Data
public class FulfillmentMessages {


    private String platform = "ACTIONS_ON_GOOGLE";

    private Card basicCard;
    private Suggestions suggestions;

    private SimpleResponses simpleResponses;
    private CarouselSelect carouselSelect;



}
