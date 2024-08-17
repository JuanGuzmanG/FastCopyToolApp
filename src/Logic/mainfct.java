package Logic;

import GUI.AddList;
import GUI.Main;

import javax.swing.*;

public class mainfct {
    public static void main(String[] args){
        //prueba
        //GUI creation and adjustments
        Main gui = new Main();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setSize(1000,600);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
}

