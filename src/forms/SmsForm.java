package forms;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SmsForm {
    private JPasswordField passwordField;
    private JButton continueButton;
    private JPanel rootPanel;
    private JLabel smsLabel;
    private BufferedImage background;
    private BufferedImage logo;

    public JPanel getRootPanel() {
        return this.rootPanel;
    }

    public JLabel getSmsLabel() {
        return smsLabel;
    }

    public SmsForm() {
        try {
            background = ImageIO.read(new File("res/img/background.png"));
            logo = ImageIO.read(new File("res/img/logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.passwordField.getDocument().addDocumentListener(new DocumentListener() {
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

    private void setContinueButtonEnabled() {
        char[] smsCode = this.passwordField.getPassword();
        if (smsCode.length == 4) {
            this.continueButton.setEnabled(true);
            this.continueButton.requestFocus();
        }
    }

    public JButton getContinueButton() {
        return this.continueButton;
    }

    public String getPassword() {
        return String.valueOf(this.passwordField.getPassword());
    }

    private void createUIComponents() {
        rootPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, null);
            }
        };

        continueButton = new JButton();
        continueButton.setBackground(new Color(78, 178, 225));
        continueButton.setForeground(Color.WHITE);
        continueButton.setOpaque(true);
        continueButton.setBorderPainted(false);
        continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
