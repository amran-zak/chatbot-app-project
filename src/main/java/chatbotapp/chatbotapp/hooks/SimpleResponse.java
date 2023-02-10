package chatbotapp.chatbotapp.hooks;

import lombok.Data;

@Data
public class SimpleResponse {
    private String textToSpeech;
    private String ssml;
    private String displayText;
}
