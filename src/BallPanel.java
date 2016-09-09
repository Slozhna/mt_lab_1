import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class BallPanel extends JPanel {
    private int count = 0;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int  y= 0;
    private int dx = 2;
    private int dy = 2;

    public BallPanel(){
        x = 25;
        y = 25;
        this.repaint();
    }

    public void draw (Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(x,y,XSIZE,YSIZE));

    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= this.getWidth()) {
            x = this.getWidth()-XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.getHeight()) {
            y = this.getHeight() - YSIZE;
            dy = -dy;
        }

        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        this.draw(g2);
    }

    private void updateCounter() {
        count++;
        System.out.println("Direction changed " + count + " times");
    }
}

