package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.List;

@Data
public class Attachment {
    private List<Blocks> blocks;
}
