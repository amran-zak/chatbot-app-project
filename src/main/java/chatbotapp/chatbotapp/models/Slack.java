package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.List;

@Data
public class Slack {
    private String text;

    private List<Attachment> attachments;
}
