package app.helpers;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

    Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setBorder(BorderFactory.createCompoundBorder(getBorder(), padding));
        return this;
    }
}
