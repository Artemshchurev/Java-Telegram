package forms;

import javax.swing.*;
import java.awt.*;

public class ListCellRendererContact extends ContactListItem implements ListCellRenderer<ContactListItem> {
    @Override
    public Component getListCellRendererComponent(JList<? extends ContactListItem> list,
                                                  ContactListItem value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        return this;
    }
}
