package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.List;

@Data
public class ResponseMovieDB {

    private List<Result> results;

}
