import java.awt.*;
import java.util.Random;

class Ball {
    private final int XSIZE = 20;                    // Size of the ball
    private final int YSIZE = 20;
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Color color;

    Ball(int x, int y) {
        this.x = x;
        this.y = y;
        Random random = new Random();
        this.dx = random.nextInt(2);
        this.dy = random.nextInt(2);
        this.color = new Color(random.nextInt() * 0x1000000);
    }

    Color getColor() {
        return this.color;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    int getXsize() {
        return this.XSIZE;
    }

    int getYsize() {
        return this.YSIZE;
    }

    void updatePosition() {
        this.x += this.dx;
        this.y += this.dy;
    }

    void reverseDx() {
        this.dx = -this.dx;
    }

    void reverseDy() {
        this.dy = -this.dy;
    }

    void resetX() {
        this.x = 0;
    }

    void resetY() {
        this.y = 0;
    }
}
