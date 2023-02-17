package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class QueryResult {


    private String action;
    private String queryText;

    private Map<String, Object> parameters;

    private List<OutputContext> outputContexts;
}
