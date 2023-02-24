package chatbotapp.chatbotapp.hooks.actions;

import chatbotapp.chatbotapp.hooks.WebhookCommand;
import chatbotapp.chatbotapp.hooks.WebhookRequest;
import chatbotapp.chatbotapp.hooks.WebhookResponse;
import org.springframework.stereotype.Service;

@Service
public class DefaultResponse implements WebhookCommand {
    public WebhookResponse execute(WebhookRequest request) {
        return new WebhookResponse().setFulfillmentText("Desole je n'ai pas compris votre demande.");
    }
}
