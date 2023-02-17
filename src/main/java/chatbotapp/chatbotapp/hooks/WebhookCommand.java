package chatbotapp.chatbotapp.hooks;

public interface WebhookCommand {

    WebhookResponse execute(WebhookRequest request);
}
