package Logic;

import GUI.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class mainfct {
    public static void main(String[] args){
        //GUI creation and adjustments
        Main gui = new Main();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1000,600);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
    public static void  copy(String text){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(text),null);
    }
    public static void ErrorLenght(JFrame a,int cantidad){
        JOptionPane.showMessageDialog(a, "Solo puede contener "+cantidad+" caracteres", "advertencia", JOptionPane.OK_OPTION);
    }

    /*
    ooooooooooooooooooooooooooooooooooooooo
    ooo oooooooooooooooooooooooo ooo     oo
    oo ooooooo   ooo          ooo o  oo   o
    o oooooooo   ooo   ooooooooooo oo   ooo
    o oooooooo   ooo   ooooooooooo o      o
    o oooooooo   ooo   ooo    oooo oooooooo
    o oooooooo   ooo   ooooo  oooo oooooooo
    oo ooo       ooo          ooo ooooooooo
    ooo oooooooooooooooooooooooo oooooooooo
    ooooooooooooooooooooooooooooooooooooooo
    */

}

