package forms;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class PhoneForm {
    private JFormattedTextField phoneField;
    private JButton continueButton;
    private JPanel rootPanel;
    private JPanel logoPanel;
    private JLabel enterCodeMessage;
    private JPanel phoneFieldPanel;
    private JPanel iconPhonePanel;
    private BufferedImage background;
    private BufferedImage logo;
    private BufferedImage phoneLogo;

    public PhoneForm() {
        try {
            background = ImageIO.read(new File("res/img/background.png"));
            logo = ImageIO.read(new File("res/img/logo.png"));
            phoneLogo = ImageIO.read(new File("res/img/icon-phone.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        phoneField.setOpaque(false);

        phoneField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setContinueButtonEnabled();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setContinueButtonEnabled();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setContinueButtonEnabled();
            }
        });
    }

    public JFormattedTextField getPhoneField() {
        return this.phoneField;
    }

    public JPanel getRootPanel() {
        return this.rootPanel;
    }

    private void setContinueButtonEnabled() {
        String phoneNumber = phoneField.getText().replaceAll("\\D", "");
        if (phoneNumber.length() == 11 && !continueButton.isEnabled()) {
            continueButton.setEnabled(true);
            continueButton.requestFocus();
        }
    }

    public String getPhoneNumber() {
        return phoneField.getText().replaceAll("\\D", "");
    }

    private void createUIComponents() {
        rootPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };
        logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logo, 0, 0, null);
            }
        };

        iconPhonePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(phoneLogo, 0, 0, null);
            }
        };

        phoneFieldPanel = new JPanel();
        phoneFieldPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

        continueButton = new JButton();
        continueButton.setBackground(new Color(78, 178, 225));
        continueButton.setForeground(Color.WHITE);
        continueButton.setOpaque(true);
        continueButton.setBorderPainted(false);
        continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        try {
            phoneField = new JFormattedTextField(new MaskFormatter("+7 ### ### ## ##"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public JButton getContinueButton() {
        return this.continueButton;
    }
}
