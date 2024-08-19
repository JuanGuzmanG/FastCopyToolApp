package Logic;

import GUI.Main;

import javax.swing.*;

public class mainfct {
    public static void main(String[] args){
        //GUI creation and adjustments
        Main gui = new Main();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1000,600);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }

    public static void Error(JFrame a,int cantidad){
        JOptionPane.showMessageDialog(a, "Solo puede contener "+cantidad+" caracteres", "advertencia", JOptionPane.OK_OPTION);
    }

    //
    //         ooooooooooooooooooooooooooooooooooooooo
    //         ooo oooooooooooooooooooooooo ooo    ooo
    //         oo ooooooo   ooo          ooo o  oo   o
    //         o oooooooo   ooo   ooooooooooo oo   ooo
    //         o oooooooo   ooo   ooooooooooo o      o
    //         o oooooooo   ooo   ooo    oooo oooooooo
    //         o oooooooo   ooo   ooooo  oooo oooooooo
    //         oo ooo       ooo          ooo ooooooooo
    //         ooo oooooooooooooooooooooooo oooooooooo
    //         ooooooooooooooooooooooooooooooooooooooo
    //

}

