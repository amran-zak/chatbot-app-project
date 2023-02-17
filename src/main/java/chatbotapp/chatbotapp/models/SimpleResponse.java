package chatbotapp.chatbotapp.models;

import lombok.Data;

@Data
public class SimpleResponse {
    private String textToSpeech;
    private String ssml;
    private String displayText;
}
