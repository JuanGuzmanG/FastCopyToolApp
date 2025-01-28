package GUI;

import Logic.Utils;
import javax.swing.*;
import java.awt.event.*;

public class AddList extends JFrame{
    private JPanel mainpanel_addlist;
    private JTextField tf_newlistname;
    private JButton btn_listnamesave;
    private Main main;

    public AddList(){
            //open mainpanel_addlist as main panel
        setContentPane(mainpanel_addlist);

            //Close Option
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                main.setVisible(true);
                dispose();
            }
        });

            //select all text for quick editing
        tf_newlistname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_newlistname.selectAll();
            }
        });

            //when press "enter" key its saved automatically
        tf_newlistname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btn_listnamesave.doClick();
                }
            }
        });

            //save list with the entered name
        btn_listnamesave.addActionListener(e -> {
                String nameList = tf_newlistname.getText();
                    //give a name to new list
                if(nameList.isEmpty()){
                    JOptionPane.showMessageDialog(mainpanel_addlist,"The name can't be null","No null", JOptionPane.OK_OPTION);
                } else if(nameList.length()>20) {
                    // Call the error method
                    Utils.errorLength(AddList.this,20);
                } else{
                    main.addList(tf_newlistname.getText());
                    main.setVisible(true);
                    setVisible(false);
                }
        });
    }

    //windows
    public void setMain(Main main){this.main = main;}
}