import javax.swing.*;

class BounceFrame extends JFrame {

    private BallPanel ball_panel;
    private static final int WIDTH = 450;
    private static final int HEIGHT = 350;

    BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Ball simple program");

        this.ball_panel = new BallPanel();
        this.add(ball_panel);
    }

    void simulate(){
        int steps = 0;
        while(true){
            ball_panel.repaint();
            try {
                Thread.sleep(steps / 5);
                if (steps > 1000) break;
            } catch (InterruptedException ignored) { }
            System.out.println("i= " + (steps++));
        }
        System.out.println("Ball successfully stoped!");
    }
}