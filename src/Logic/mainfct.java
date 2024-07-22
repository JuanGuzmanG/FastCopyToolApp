package Logic;

import javax.swing.JFrame;
import GUI.ScreenFCT;

public class mainfct {
    public static void main(String[] args){
        JFrame frame = new JFrame("ScreenFCT");
        
        frame.setContentPane(new ScreenFCT());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

