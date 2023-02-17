package chatbotapp.chatbotapp.hooks;

import chatbotapp.chatbotapp.hooks.actions.AskGenreCommand;
import chatbotapp.chatbotapp.hooks.actions.DefaultCommand;
import chatbotapp.chatbotapp.hooks.actions.DisplayDetailsCommand;
import chatbotapp.chatbotapp.hooks.actions.DisplayFilmCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class WebhookInvocator {

    private AskGenreCommand askGenreCommand;
    private DefaultCommand defaultCommand;
    private DisplayDetailsCommand displayDetailsCommand;
    private DisplayFilmCommand displayFilmCommand;



    public  WebhookResponse execute(WebhookRequest request){
        if(request.getQueryResult().getAction().equals("voirPlus")){
            return displayDetailsCommand.execute(request);
        }
        if (request.getQueryResult().getParameters().get("genre") == null
                || request.getQueryResult().getParameters().get("genre").equals(""))
        {
            return askGenreCommand.execute(request);
        } else if(!request.getQueryResult().getParameters().get("genre").equals("")){
            return displayFilmCommand.execute(request);
        }
        return defaultCommand.execute(request);
    }
}
