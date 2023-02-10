package chatbotapp.chatbotapp.hooks;

import lombok.Data;

import java.util.List;

@Data
public class Card {
    private String title;
    private String subtitle;

    private String imageUri;
    private List<Button> buttons;
}
