package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.List;

@Data
public class TableCardRow {
    private List<TableCardCell> cells;
    private Boolean dividerAfter;
}
