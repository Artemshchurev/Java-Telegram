package forms;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChatForm {
    private JList chatContactsList;
    private JPanel rootPanel;
    private JPanel inlineLogoPanel;
    private JPanel leftSidePanel;
    private JPanel searchPanel;
    private JTextField searchInput;
    private JPanel searchLogoPanel;
    private JPanel headerPanel;
    private BufferedImage inlineLogo;
    private BufferedImage searchLogo;

    public ChatForm() {
        try {
            inlineLogo = ImageIO.read(new File("res/img/logo-micro.png"));
            searchLogo = ImageIO.read(new File("res/img/icon-search.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        searchInput.setBorder(BorderFactory.createEmptyBorder());
        chatContactsList.setCellRenderer(new ListCellRendererContact());
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JList getChatContactsList() {
        return chatContactsList;
    }

    private void createUIComponents() {
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
