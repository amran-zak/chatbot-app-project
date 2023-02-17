package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.Map;

@Data
public class OutputContext {
    private String name;

    //private Param parameters;

    private Map<String, Object> parameters;
}
