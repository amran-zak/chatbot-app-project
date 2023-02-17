package chatbotapp.chatbotapp.models;

import lombok.Data;

import java.util.List;

@Data
public class TableCard {
    private String title;
    private Image image;
    private List<ColumnProperties> columnProperties;
    private List<TableCardRow> rows;

}
