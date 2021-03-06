package forms;

import org.javagram.response.object.UserContact;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ChatForm {
    private JList<ContactListItem> chatContactsList;
    private JPanel rootPanel;
    private JPanel inlineLogoPanel;
    private JPanel leftSidePanel;
    private JPanel searchPanel;
    private JTextField searchInput;
    private JPanel searchLogoPanel;
    private JPanel headerPanel;
    private BufferedImage inlineLogo;
    private BufferedImage searchLogo;
    private ArrayList<UserContact> contacts;

    public ChatForm(ArrayList<UserContact> contacts) {
        this.contacts = contacts;

        try {
            inlineLogo = ImageIO.read(new File("res/img/logo-micro.png"));
            searchLogo = ImageIO.read(new File("res/img/icon-search.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        searchInput.setBorder(BorderFactory.createEmptyBorder());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {

        ListCellRendererContact contactRenderer = new ListCellRendererContact();

        /* Заполнение списка фейковыми контактами */
        DefaultListModel<ContactListItem> modelContacts = new DefaultListModel<>();
        for (int i = 0; i < contacts.size(); i++) {
            modelContacts.addElement(new ContactListItem(contacts.get(i)));
        }

        chatContactsList = new JList<>(modelContacts);
        chatContactsList.setCellRenderer(contactRenderer);
        chatContactsList.setBorder(null);

        ((ListCellRendererContact) chatContactsList.getCellRenderer()).setContacts(contacts);

        inlineLogoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(inlineLogo, 0, 0, null);
            }
        };

        searchLogoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(searchLogo, 0, 0, null);
            }
        };
    }
}
