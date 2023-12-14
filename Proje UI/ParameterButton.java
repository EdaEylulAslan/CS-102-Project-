
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ParameterButton{
    private BufferedImage image;
    private int x;
    private int y;
    private int h;
    private int w;
    private Rectangle buttonSize;

    public ParameterButton(int x, int y, int h, int w, String image){
        playImageLoad(image);
        this.w = w;
        this.h = h;
        this.y = y;
        this.x = x;

    }
    public void playImageLoad(String name1){
        if (name1 == (null) || name1.equals("")){
            return;
        }
        InputStream inputStream = getClass().getResourceAsStream(name1);
        try {
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void paintButton(Graphics g, BufferedImage button){
        g.drawImage(this.getButtonImage(), x, y, null);
    }
    public int getH() {
        return h;
    }
    public int getW() {
        return w;
    }  
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Rectangle getButtonSize() {
        return buttonSize;
    }
    public BufferedImage getButtonImage(){
        return image;
    }



}
