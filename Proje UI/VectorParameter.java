
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class VectorParameter extends JPanel implements MouseListener, MouseMotionListener{
    private Image background = new ImageIcon("Desktop - 2.png").getImage();
    private ButtonParent returnButton = new ButtonParent(45, 55, 51, 80, "/return.png", "/returnOver.png", "/returnPressed.png");
    private ParameterButton[] buttons = new ParameterButton[8];
    private ParameterButton[] buttonNames = new ParameterButton[8];
    private String[] buttonN = {"/MagV1X.png","/MagV1Y.png","/StartPV1X.png","/StartPV1Y.png","/MagV2X.png","/MagV2Y.png","/StartPV2X.png","/StartPV2Y.png"};
    private JTextField[] textFields = new JTextField[8];
    private Timer timer;
    
    public VectorParameter(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        setLayout(null);
        for (int i = 0; i < 8; i++) {
            ParameterButton parameterButton = new ParameterButton(490, 200+(90*i), 24, 330, "/Parameter.png");
            ParameterButton parameterButtonName = new ParameterButton(490, 170+(90*i), 24, 330, buttonN[i]);
            buttons[i] = parameterButton;
            buttonNames[i] = parameterButtonName;
            JTextField textField = new JTextField();
            textField.setBounds(buttons[i].getX()+142, buttons[i].getY()+10, buttons[i].getW()-50, buttons[i].getH()-3);
            textField.setBorder(BorderFactory.createLineBorder(Color.BLUE)); 
            textFields[i] = textField;
            add(textField);
        }
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        returnButton.paintButton(g, returnButton.getButtonImage());
        for (ParameterButton button : buttons) {
            g.drawImage(button.getButtonImage(), button.getX(), button.getY(), null);
        }
        for(ParameterButton buttonName : buttonNames){
            g.drawImage(buttonName.getButtonImage(), buttonName.getX(), buttonName.getY(), null);
        }
    }
    public ParameterButton[] getButtons() {
        return buttons;
    }
    public void setButtons(ParameterButton[] buttons) {
        this.buttons = buttons;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        if(returnButton.getButtonSize().contains(e.getX(), e.getY())){
            returnButton.setMouseOver(true);
        } else {
            returnButton.setMouseOver(false);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(returnButton.getButtonSize().contains(e.getX(), e.getY())){
            JFrame currentFrame = (JFrame) SwingUtilities.windowForComponent(this);
            
            if(currentFrame != null){
                currentFrame.dispose();
            }

            VecSimIntf panel = new VecSimIntf();
            JFrame returnFrame = new JFrame();
            returnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            returnFrame.add(panel);
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            gd.setFullScreenWindow(returnFrame);
            returnFrame.setVisible(true);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (returnButton.getButtonSize().contains(e.getX(), e.getY())) {
            returnButton.setPressed(true);
        } else {
            returnButton.setPressed(false);
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        returnButton.setPressed(false);
        returnButton.setMouseOver(false);
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
        VectorParameter vectorParameter = new VectorParameter();
        
        frame.add(vectorParameter);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setVisible(true);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(frame);

    }
}
