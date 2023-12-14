import javax.swing.*;
import java.awt.*;

public class MainInterface extends JFrame {

    private Image backgroundImage;

    public MainInterface(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();

        setTitle("Ana Sayfa Arayüzü");
        setSize(1077, 768); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        BackgroundPanel backgroundPanel = new BackgroundPanel();

        backgroundPanel.setLayout(null);

        String[] buttonNames = {"Vector Operations", "Projectile Motion", "Momentum", "Newton's Second Law"};
        Color[] buttonColors = {new Color(219, 253, 81), new Color(46, 97, 209), new Color(184, 83, 227), new Color(85, 158, 148)};
        //ImageIcon normal ={"vectorButton.jpg"}

        for (int i = 0; i < buttonNames.length; i++) {
            JButton button = new JButton(buttonNames[i]);
            button.setBounds(800, 250+(i*90), 400, 50); 
            button.setForeground(Color.BLACK);
            button.setFont(new Font("Zen Dots",Font.CENTER_BASELINE,20));
            button.setBackground(buttonColors[i]);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setFocusable(false);
            button.setBorder(BorderFactory.createEtchedBorder());
            button.addActionListener( e -> System.out.println("Clicked:"));
            backgroundPanel.add(button, BorderLayout.CENTER);
        }

        JButton exitButton = new JButton(new ImageIcon("VectorButton.jpg"));
        exitButton.setBounds(1200, 800, 200, 50); 
        exitButton.setForeground(Color.BLACK);
        exitButton.setFont(new Font("Zen Dots",Font.CENTER_BASELINE,20));
        exitButton.setBackground(new Color(236, 56, 42));
        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);
        exitButton.setFocusable(false);
        exitButton.setBorder(BorderFactory.createEtchedBorder());
        exitButton.addActionListener( e -> System.exit(0));
        backgroundPanel.add(exitButton);

        add(backgroundPanel);
    }

    private class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainInterface mainInterface = new MainInterface("Desktop - 1.jpg");
            mainInterface.setVisible(true);
            mainInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainInterface.setExtendedState(JFrame.MAXIMIZED_BOTH);
            mainInterface.setUndecorated(true);
        });
    }
}
