package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.List;

@Data
public class Element {
    private String type;
    private Text text;
    private String value;
}
