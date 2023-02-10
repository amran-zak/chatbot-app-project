package chatbotapp.chatbotapp.hooks;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class WebhookResponse {
    private String fulfillmentText;
}
