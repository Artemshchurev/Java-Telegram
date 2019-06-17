package forms;

import org.javagram.response.object.UserContact;

import javax.swing.*;
import java.awt.*;

public class ContactListItem {
    private JPanel avatarPanel;
    private JLabel userName;
    private JPanel rootPanel;
    private UserContact userContact;

    public ContactListItem() {}

    public ContactListItem(UserContact userContact) {
        this.userContact = userContact;
    }

    public void setUserName(String userName) {
        this.userName.setText(userName);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
