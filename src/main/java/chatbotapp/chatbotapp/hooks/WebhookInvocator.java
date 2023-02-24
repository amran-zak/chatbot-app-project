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
                            DefaultResponse defaultResponse){
        commands = Map.of(Step.ASK_NAME_PIZZA, askNamePizza,
                Step.DEFAULT_RESPONSE, defaultResponse);
    }


    public  WebhookResponse execute(WebhookRequest request){
        /*if(request.getQueryResult().getAction().equals("voirPlus")){
            return commands.get(Step.DISPLAY_DETAILS).execute(request);
        }*/
        if ((request.getQueryResult().getParameters().get("pizzaName") == null
                || request.getQueryResult().getParameters().get("pizzaName").equals(""))
                && request.getQueryResult().getAction().equals("command_pizza")
        )
        {
            return commands.get(Step.ASK_NAME_PIZZA).execute(request);
        }
        /*else if(!(request.getQueryResult().getParameters().get("genre") == null
                ||request.getQueryResult().getParameters().get("genre").equals(""))
                && request.getQueryResult().getAction().equals("ConseilFilm.ConseilFilm-custom")){
            return commands.get(Step.DISPLAY_FILM).execute(request);
        } else if (!(request.getQueryResult().getParameters().get("film") == null
                ||request.getQueryResult().getParameters().get("film").equals(""))
                && request.getQueryResult().getAction().equals("diffusion")) {
            return commands.get(Step.ASK_PLATFORM).execute(request);
        }*/
        return commands.get(Step.DEFAULT_RESPONSE).execute(request);
    }
}
