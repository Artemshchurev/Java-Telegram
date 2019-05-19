package forms;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Decoration {
    private JPanel rootPanel;
    private JButton closeButton;
    private JPanel contentPanel;
    private JPanel motionPanel;
    private JButton hideButton;
    private BufferedImage closeIcon;
    private BufferedImage hideIcon;

    private int draggingPosX;
    private int draggingPosY;

    public Decoration(JFrame frame) {
        try {
            closeIcon = ImageIO.read(new File("res/img/icon-close.png"));
            hideIcon = ImageIO.read(new File("res/img/icon-hide.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                System.exit(0);
            }
        });

        hideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });

        motionPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - draggingPosX, e.getYOnScreen() - draggingPosY);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        motionPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                draggingPosX = e.getX();
                draggingPosY = e.getY();
            }
        });
    }

    public JPanel getRootPanel()
    {
        return rootPanel;
    }

    public void setContent(Component component) {
        contentPanel.removeAll();
        contentPanel.add(component);

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void createUIComponents() {
        closeButton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(closeIcon, 0, 0, null);
            }
        };

        hideButton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(hideIcon, 0, 0, null);
            }
        };
    }
}
