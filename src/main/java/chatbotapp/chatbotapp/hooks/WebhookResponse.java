package chatbotapp.chatbotapp.hooks;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Data
public class WebhookResponse {
    private String fulfillmentText;

    private List<Suggestions_Button> buttons;
}
