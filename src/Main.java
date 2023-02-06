import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        start();

        System.out.println("Hello world!");
    }

    public static void start() {
        int size = 400;

        //create the frame
        JFrame myFrame = new JFrame(" Hermes");
        myFrame.setSize(new Dimension(size, size));

        //base functionality
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(false);

        // add the clock face
        myFrame.add(new Canvas(size));

        //pack the frame
        myFrame.pack();
        myFrame.setVisible(true);

    }
}