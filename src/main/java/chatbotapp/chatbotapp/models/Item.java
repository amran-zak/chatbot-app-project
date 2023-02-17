package chatbotapp.chatbotapp.models;

import lombok.Data;

@Data
public class Item {
    private SelectItemInfo info;
    private String title;

    private String description;

    private Image image;


}
