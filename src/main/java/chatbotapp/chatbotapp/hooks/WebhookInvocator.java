package chatbotapp.chatbotapp.hooks;

import chatbotapp.chatbotapp.hooks.actions.*;
import chatbotapp.chatbotapp.models.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WebhookInvocator {


    private Map<Step, WebhookCommand> commands;

    public WebhookInvocator(AskNamePizza askNamePizza,
                            DefaultResponse defaultResponse,
                            DisplayPizza displayPizza,
                            AskDessert askDessert,
                            AskComplement askComplement){
        commands = Map.of(Step.ASK_NAME_PIZZA, askNamePizza,
                Step.DEFAULT_RESPONSE, defaultResponse,
                Step.DISPLAY_PIZZA, displayPizza,
                Step.ASK_DESSERT, askDessert,
                Step.ASK_COMPLEMENT, askComplement);
    }


    public  WebhookResponse execute(WebhookRequest request){
        if(request.getQueryResult().getAction().equals("askDessert")){
            return commands.get(Step.ASK_DESSERT).execute(request);
        }
        if ((request.getQueryResult().getParameters().get("pizzaName") == null
                || request.getQueryResult().getParameters().get("pizzaName").equals(""))
                && request.getQueryResult().getAction().equals("command_pizza")
        )
        {
            return commands.get(Step.ASK_NAME_PIZZA).execute(request);
        }
       else if(!(request.getQueryResult().getParameters().get("pizzaName") == null
                || request.getQueryResult().getParameters().get("pizzaName").equals(""))
                && (request.getQueryResult().getAction().equals("command_pizza")
                || request.getQueryResult().getAction().equals("displayPizza")) ){
            return commands.get(Step.DISPLAY_PIZZA).execute(request);
        } else if (!(request.getQueryResult().getParameters().get("responseDessert") == null
                || request.getQueryResult().getParameters().get("responseDessert").equals(""))
                && request.getQueryResult().getAction().equals("askComplement")) {
            return commands.get(Step.ASK_COMPLEMENT).execute(request);
        }
        return commands.get(Step.DEFAULT_RESPONSE).execute(request);
    }
}
