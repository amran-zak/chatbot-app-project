package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResponseMovieDBPlatform {
    private Map<String, FlarateTmp> results;
}
