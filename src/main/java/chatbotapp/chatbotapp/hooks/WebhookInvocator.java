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

    public WebhookInvocator(AskGenreCommand askGenreCommand,
                            DefaultCommand defaultCommand,
                            DisplayFilmCommand displayFilmCommand,
                            DisplayDetailsCommand displayDetailsCommand,
                            AskPlatformCommand askPlatformCommand){
        commands = Map.of(Step.ASK_GENRE, askGenreCommand,
                Step.DEFAULT_GENRE, defaultCommand,
                Step.DISPLAY_FILM, displayFilmCommand,
                Step.DISPLAY_DETAILS, displayDetailsCommand,
                Step.ASK_PLATFORM, askPlatformCommand);
    }


    public  WebhookResponse execute(WebhookRequest request){
        if(request.getQueryResult().getAction().equals("voirPlus")){
            return commands.get(Step.DISPLAY_DETAILS).execute(request);
        }
        if ((request.getQueryResult().getParameters().get("genre") == null
                || request.getQueryResult().getParameters().get("genre").equals(""))
                && request.getQueryResult().getAction().equals("ConseilFilm")
        )
        {
            return commands.get(Step.ASK_GENRE).execute(request);
        } else if(!(request.getQueryResult().getParameters().get("genre") == null
                ||request.getQueryResult().getParameters().get("genre").equals(""))
                && request.getQueryResult().getAction().equals("ConseilFilm.ConseilFilm-custom")){
            return commands.get(Step.DISPLAY_FILM).execute(request);
        } else if (!(request.getQueryResult().getParameters().get("film") == null
                ||request.getQueryResult().getParameters().get("film").equals(""))
                && request.getQueryResult().getAction().equals("diffusion")) {
            return commands.get(Step.ASK_PLATFORM).execute(request);
        }
        return commands.get(Step.DEFAULT_GENRE).execute(request);
    }
}
