import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.List;

public class MomSimIntf extends JPanel implements MouseListener, MouseMotionListener{
    private Image background = new ImageIcon("Desktop - 6.png").getImage();
    private ButtonParent returnButton = new ButtonParent(45, 55, 51, 80, "/return.png", "/returnOver.png", "/returnPressed.png");
    private ButtonParent option1 = new ButtonParent(420, 497, 30, 240, "/option1.png", "/option1Over.png", "/option1Pressed.png");
    private ButtonParent option2 = new ButtonParent(920, 497, 30, 240, "/option2.png", "/option2Over.png", "/option2Pressed.png");
    private List<ButtonParent> buttons;
    private Timer timer;

    public MomSimIntf() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        buttons = Arrays.asList(option1,option2,returnButton);
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
        option1.paintButton(g, option1.getButtonImage());
        option2.paintButton(g, option2.getButtonImage());
        returnButton.paintButton(g, returnButton.getButtonImage());
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        for (ButtonParent button : buttons) {
            if (button.getButtonSize().contains(e.getX(), e.getY())) {
                button.setMouseOver(true);
            } else {
                button.setMouseOver(false);
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (option1.getButtonSize().contains(e.getX(), e.getY())) {
            System.out.println("Vector Button Clicked");
        }
        if(returnButton.getButtonSize().contains(e.getX(), e.getY())){
            JFrame currentFrame = (JFrame) SwingUtilities.windowForComponent(this);
            
            if(currentFrame != null){
                currentFrame.dispose();
            }

            ImagePanel panel = new ImagePanel();
            JFrame returnFrame = new JFrame("Image Background Example");
            returnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            returnFrame.add(panel);
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            gd.setFullScreenWindow(returnFrame);
            returnFrame.setVisible(true);

        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        for (ButtonParent button : buttons) {
            if (button.getButtonSize().contains(e.getX(), e.getY())) {
                button.setPressed(true);
            } else {
                button.setPressed(false);
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        for (ButtonParent button : buttons) {
            button.setPressed(false);
            button.setMouseOver(false);
        }
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        repaint();
    }
    @Override
    public void mouseExited(MouseEvent e) {
        repaint();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Background Example");
        ProjSimIntf panel = new ProjSimIntf();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(frame);
        frame.setVisible(true);
    }
    
    
}
