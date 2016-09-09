import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

class BallPanel extends JPanel {
    private int count = 0;
    private ArrayList <Ball> balls_array;

    BallPanel(){
        this.balls_array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++)
            balls_array.add(new Ball(random.nextInt(100), random.nextInt(100)));

        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        this.draw(g2);
    }

    private void draw(Graphics2D g2) {
        for (Ball aBalls_array : balls_array) {
            move(aBalls_array);
            g2.setColor(aBalls_array.getColor());
            g2.fill(new Ellipse2D.Double(
                    aBalls_array.getX(),
                    aBalls_array.getY(),
                    aBalls_array.getXsize(),
                    aBalls_array.getYsize()));
        }
    }

    private void updateCounter() {
        count++;
        System.out.println("Direction changed " + count + " times");
    }

    private void move(Ball ball) {
        ball.updatePosition();

        if (ball.getX() < 0) {
            ball.resetX();
            ball.reverseDx();
            updateCounter();
        }
        if (ball.getX() + ball.getXsize() >= this.getWidth()) {
            //x = this.getWidth() - ball.getXsize();
            ball.reverseDx();
            updateCounter();
        }
        if (ball.getY() < 0) {
            ball.resetY();
            ball.reverseDy();
            updateCounter();
        }
        if (ball.getY() + ball.getYsize() >= this.getHeight()) {
            //y = -ball.getYsize();
            ball.reverseDy();
            updateCounter();
        }
    }
}

