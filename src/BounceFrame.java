import javax.swing.*;
import java.awt.*;

public class BounceFrame extends JFrame {

    private BallPanel ball_panel;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Ball simple program");

        this.ball_panel = new BallPanel();
        this.add(ball_panel);
    }

    public void simulate(){
        int steps = 0;
        while(true){
            ball_panel.move();
            try {
                Thread.sleep(steps / 5);
                if (steps > 1000) break;
            } catch (InterruptedException ex) { }
            System.out.println("i= " + (steps++));
        }
        System.out.println("Ball successfully stoped!");
    }

}