package chatbotapp.chatbotapp.hooks;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Data
public class WebhookResponse {
    private String fulfillmentText;

    private List<FulfillmentMessages> fulfillmentMessages;
}
