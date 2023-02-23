package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.List;

@Data
public class Blocks
{
    private String type;

    private Text text;

    private List<Element> elements;
}
