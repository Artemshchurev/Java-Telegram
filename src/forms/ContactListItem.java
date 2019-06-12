package forms;

import javax.swing.*;
import java.awt.*;

public class ContactListItem {
    private JPanel avatarPanel;
    private JLabel userName;
    private JPanel rootPanel;

    public void setUserName(String userName) {
        this.userName.setText(userName);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
