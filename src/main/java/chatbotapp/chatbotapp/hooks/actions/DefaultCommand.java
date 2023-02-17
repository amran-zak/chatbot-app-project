package chatbotapp.chatbotapp.hooks.actions;

import chatbotapp.chatbotapp.hooks.WebhookCommand;
import chatbotapp.chatbotapp.hooks.WebhookRequest;
import chatbotapp.chatbotapp.hooks.WebhookResponse;
import chatbotapp.chatbotapp.models.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DefaultCommand implements WebhookCommand {
    public WebhookResponse execute(WebhookRequest request) {
        return new WebhookResponse().setFulfillmentText("Desole je n'ai pas compris votre demande.");
    }
}
