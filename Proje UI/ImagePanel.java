import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.List;


public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener{
    private Image backgroundImage = new ImageIcon("Desktop - 1.jpg").getImage();
    private List<ButtonParent> buttons;
    private ButtonParent vectorButton = new ButtonParent(635, 210, 79, 659, "/Vector.png", "/VectorOver.png", "/VectorPressed.png");
    private ButtonParent projectileButton = new ButtonParent(635, 330, 79, 659, "/ProjectileB.png", "/ProjectileOver.png", "/ProjectilePressed.png");
    private ButtonParent momentumButton =  new ButtonParent(635, 450, 79, 659, "/MomentumB.png", "/MomentumOver.png", "/MomentumPressed.png");
    private ButtonParent newtonButton =  new ButtonParent(635, 570, 79, 659, "/Newton.png", "/NewtonOver.png", "/NewtonP.png");
    private ButtonParent exitButton =  new ButtonParent(1111, 800, 53, 273, "/ExitB.png", "/ExitOver.png", "/ExitP.png");
    private Timer timer;

    public ImagePanel() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        buttons = Arrays.asList(vectorButton, projectileButton, momentumButton, newtonButton, exitButton); 
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        vectorButton.paintButton(g, vectorButton.getButtonImage());
        momentumButton.paintButton(g, momentumButton.getButtonImage());
        projectileButton.paintButton(g, projectileButton.getButtonImage());
        newtonButton.paintButton(g, newtonButton.getButtonImage());
        exitButton.paintButton(g, exitButton.getButtonImage());

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (vectorButton.getButtonSize().contains(e.getX(), e.getY())) {
            JFrame currentFrame = (JFrame) SwingUtilities.windowForComponent(this);
            VecSimIntf panel = new VecSimIntf();
            if(currentFrame != null){
                currentFrame.dispose();
            }
            JFrame vectorFrame = new JFrame();
            vectorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vectorFrame.add(panel);
            vectorFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            gd.setFullScreenWindow(vectorFrame);
            vectorFrame.setVisible(true);

        }
        else if (projectileButton.getButtonSize().contains(e.getX(), e.getY())) {
            JFrame currentFrame = (JFrame) SwingUtilities.windowForComponent(this);
            ProjSimIntf panel = new ProjSimIntf();
            if(currentFrame != null){
                currentFrame.dispose();
            }
            JFrame projectileFrame = new JFrame();
            projectileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            projectileFrame.add(panel);
            projectileFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            gd.setFullScreenWindow(projectileFrame);
            projectileFrame.setVisible(true);

        }
        else if (newtonButton.getButtonSize().contains(e.getX(), e.getY())) {
            JFrame currentFrame = (JFrame) SwingUtilities.windowForComponent(this);
            NewSimIntf panel = new NewSimIntf();
            if(currentFrame != null){
                currentFrame.dispose();
            }
            JFrame newtonFrame = new JFrame();
            newtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newtonFrame.add(panel);
            newtonFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            gd.setFullScreenWindow(newtonFrame);
            newtonFrame.setVisible(true);

        }
        else if (momentumButton.getButtonSize().contains(e.getX(), e.getY())) {
            JFrame currentFrame = (JFrame) SwingUtilities.windowForComponent(this);
            MomSimIntf panel = new MomSimIntf();
            if(currentFrame != null){
                currentFrame.dispose();
            }
            JFrame momentumFrame= new JFrame();
            momentumFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            momentumFrame.add(panel);
            momentumFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            gd.setFullScreenWindow(momentumFrame);
            momentumFrame.setVisible(true);

        }
        else if(exitButton.getButtonSize().contains(e.getX(), e.getY())){
            System.exit(0);
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
    public void mouseReleased(MouseEvent e) {
        for (ButtonParent button : buttons) {
            button.setPressed(false);
            button.setMouseOver(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {repaint();}
    @Override
    public void mouseExited(MouseEvent e) {repaint();}
    @Override
    public void mouseDragged(MouseEvent e) {repaint();}
        public static void main(String[] args) {
        JFrame frame = new JFrame();
        ImagePanel panel = new ImagePanel();
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setUndecorated(true);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(frame);
        frame.setVisible(true);

    }
}
