package Logic;

import GUI.Main;

import javax.swing.*;
import java.awt.*;

public class MainFCT {
    public static void main(String[] args){
        //GUI creation
        Main gui = new Main();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1000,680);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setTitle("FAST COPY TOOL");
        gui.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/resource/logo.png")));
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


