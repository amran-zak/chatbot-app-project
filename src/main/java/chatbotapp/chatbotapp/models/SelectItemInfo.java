package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.List;

@Data
public class SelectItemInfo {

    private String key;
    private List<String> synonyms;

}
