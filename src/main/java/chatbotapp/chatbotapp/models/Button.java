package chatbotapp.chatbotapp.models;

import lombok.Data;

@Data
public class Button {
    private String title;
    private OpenUriAction openUriAction;
}
