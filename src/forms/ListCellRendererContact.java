package forms;

import org.javagram.response.object.UserContact;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListCellRendererContact extends ContactListItem implements ListCellRenderer<ContactListItem> {
    private ArrayList<UserContact> contacts;

    @Override
    public Component getListCellRendererComponent(JList<? extends ContactListItem> list,
                                                  ContactListItem value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        setUserName(contacts.get(index).getFirstName() + contacts.get(index).getLastName());

        return this.getRootPanel();
    }

    void setContacts(ArrayList<UserContact> contacts) {
        this.contacts = contacts;
    }
}
