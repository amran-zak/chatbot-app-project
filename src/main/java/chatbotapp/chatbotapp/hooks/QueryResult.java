package chatbotapp.chatbotapp.hooks;

import lombok.Data;

import java.util.Map;

@Data
public class QueryResult {


    private String action;
    private String queryText;

    private Map<String, Object> parameters;
}
