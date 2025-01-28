package Logic;

import GUI.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Utils {
    public static void copy(String text){
        if(text== null || text.isEmpty()){
            JOptionPane.showConfirmDialog(null,"Text cannot be null or empty","Error",JOptionPane.WARNING_MESSAGE);
        }
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(text),null);
    }
    public static void errorLength(JFrame a, int cantidad){
        JOptionPane.showMessageDialog(a, "Can only have  "+cantidad+" characters", "Warning", JOptionPane.OK_OPTION);
    }
}
