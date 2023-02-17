package chatbotapp.chatbotapp.hooks;


import chatbotapp.chatbotapp.models.QueryResult;
import lombok.Data;

@Data
public class WebhookRequest {

     private QueryResult queryResult;

}
