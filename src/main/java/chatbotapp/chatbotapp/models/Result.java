package chatbotapp.chatbotapp.models;

import lombok.Data;

@Data
public class Result {
    private String id;
    private String title;
    private String overview;
    private String poster_path;

    private String release_date;
}
