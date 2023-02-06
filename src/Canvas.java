import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class Canvas extends JPanel {
    //attributes
    private int size;
    private double percent;
    private int dotSize;
    private double angle = 2 * Math.PI / 12;

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
        minutes(g);
        seconds(g);

        repaint();
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

        for (int i = 1; i <= 12; i++) {

            int dx = (int) (radie * Math.sin(angle * i));
            int dy = (int) (radie * -Math.cos(angle * i));
            int temp = (size / 2);
            int posx = temp + dx;
            int posy = temp + dy;
            String num = Integer.toString(i);
            g.drawString(num, posx, posy);
            //g.drawOval(posx, posy, dotSize, dotSize);
        }
    }

    //Draws the hour hand
    public void hours(Graphics g) {
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        drawHand(g, 0.1, hour, angle);
    }

    //Draws the hour hand
    public void minutes(Graphics g) {
        LocalTime time = LocalTime.now();
        int minute = time.getMinute();
        drawHand(g, 0.2, minute, (Math.PI * 2 / 60));
    }

    public void seconds(Graphics g) {
        LocalTime time = LocalTime.now();
        int second = time.getSecond();
        g.setColor(Color.red);
        drawHand(g, 0.3, second, (Math.PI * 2 / 60));
    }

    public void drawHand(Graphics g, double len, int time, double v) {
        int cp = size / 2;
        int dx = (int) (size * len * Math.sin(v * time));
        int dy = (int) (size * len * -Math.cos(v * time));
        int posx = cp + dx;
        int posy = cp + dy;
        g.drawLine(cp, cp, posx, posy);

    }

    //get & set
}










