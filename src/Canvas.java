import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    //attributes
    private int size;
    double percent;
    int dotSize;

    //constuctor
    public Canvas(int num) {
        size = num;
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(size, size));
    }

    //methods
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        face(g);
        drawNumbers(g);
        hours(g);
    }

    public void face(Graphics g) {
        g.setColor(Color.white);
        percent = 0.75;
        int sizeO = (int) (size * percent);
        int pos = (int) (size * ((1 - percent) / 2));
        g.fillOval(pos, pos, sizeO, sizeO);

        dotSize = 5;
        int cpPos = (size - dotSize) / 2;
        g.setColor(Color.black);
        g.fillOval(cpPos, cpPos, dotSize, dotSize);
    }

    public void drawNumbers(Graphics g) {


        int radie = (int) (size * ((percent - 0.1) / 2));
        double angle = 2 * Math.PI / 12;
        for (int i = 1; i <= 12; i++) {

            int dx = (int) (radie * Math.sin(angle * i));
            int dy = (int) (radie * Math.cos(angle * i));
            System.out.println("dx " + dx);
            System.out.println("dy " + dy);
            int temp = (size / 2);
            int posx = temp + dx;
            int posy = temp - dy;
            String num = Integer.toString(i);
            g.drawString(num, posx, posy);
            //g.drawOval(posx, posy, dotSize, dotSize);
        }
    }

    //Draws the hour hand
    public void hours(Graphics g) {

    }

    //get & set
}










