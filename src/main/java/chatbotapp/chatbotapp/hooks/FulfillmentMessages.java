package chatbotapp.chatbotapp.hooks;

import lombok.Data;

@Data
public class FulfillmentMessages {
    // private Card card;

    private String platform = "ACTIONS_ON_GOOGLE";
    private Suggestions suggestions;



    private SimpleResponses simpleResponses;
}
