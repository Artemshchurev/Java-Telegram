import fake.FakeTelegramBridge;
import forms.ChatForm;
import forms.Decoration;
import forms.PhoneForm;
import forms.SmsForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class FormManager extends JFrame {
    private FakeTelegramBridge bridge;
    private PhoneForm phoneForm;
    private SmsForm smsForm;
    private ChatForm chatForm;
    private Decoration decoration;

    FormManager() {
        setUndecorated(true);
        decoration = new Decoration(this);
        setContentPane(decoration.getRootPanel());
        phoneForm = new PhoneForm();
        decoration.setContent(phoneForm.getRootPanel());

        bridge = new FakeTelegramBridge();
        setTitle("Telegram");
        setSize(905, 630);
        setMaximumSize(new Dimension(905, 630));
        setLocationRelativeTo(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                phoneForm.getPhoneField().requestFocus();
            }
        });

        smsForm = new SmsForm();

        phoneForm.getContinueButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bridge.authCheckPhone(phoneForm.getPhoneNumber());
                    bridge.authSendCode(phoneForm.getPhoneNumber());
                    smsForm.getSmsLabel().setText(phoneForm.getPhoneField().getText());
                    decoration.setContent(smsForm.getRootPanel());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        smsForm.getContinueButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bridge.authSignIn(smsForm.getPassword());
                    chatForm = new ChatForm(bridge.contactsGetContacts());
                    decoration.setContent(chatForm.getRootPanel());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
