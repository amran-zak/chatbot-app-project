package chatbotapp.chatbotapp.hooks;

import lombok.Data;

import java.util.Map;

@Data
public class OutputContext {
    private String name;

    //private Param parameters;

    private Map<String, Object> parameters;
}
