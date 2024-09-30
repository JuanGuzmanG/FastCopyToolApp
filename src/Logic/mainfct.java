package Logic;

import GUI.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class mainfct {
    public static void main(String[] args){
        //GUI creation andg adjustments
        Main gui = new Main();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1000,600);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }
    public static void copy(String text){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(text),null);
    }
    public static void ErrorLenght(JFrame a,int cantidad){
        JOptionPane.showMessageDialog(a, "Can only have  "+cantidad+" characters", "Warning", JOptionPane.OK_OPTION);
    }
}
    /*
    ooooooooooooooooooooooooooooooooooooooo
    ooo oooooooooooooooooooooooo ooo     oo
    oo ocotoso   ooo          ooo o  oo   o
    o oooooooo   ooo   ooooooooooo oo   ooo
    o oooooooo   ooo   ooooooooooo o      o
    o oooooooo   ooo   ooo    oooo oooooooo
    o oooooooo   ooo   ooooo  oooo oooooooo
    oo ooo       ooo          ooo ooooooooo
    ooo oooooooooooooooooooooooo oooooooooo
    ooooooooooooooooooooooooooooooooooooooo
    */


