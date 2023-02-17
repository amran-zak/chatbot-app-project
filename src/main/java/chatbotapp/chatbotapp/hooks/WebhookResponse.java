package chatbotapp.chatbotapp.hooks;

import chatbotapp.chatbotapp.models.FulfillmentMessages;
import lombok.Data;

import java.util.List;


@Data
public class WebhookResponse {
    private String fulfillmentText;

    private List<FulfillmentMessages> fulfillmentMessages;
}
