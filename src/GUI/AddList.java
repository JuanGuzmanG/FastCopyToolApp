package GUI;

import javax.swing.*;
import java.awt.event.*;

public class AddList extends JFrame{
    private JPanel mainpanel_addlist;
    private JTextField tf_newlistname;
    private JButton btn_listnamesave;
    private Main main;
    int cont = 1;

        //class main
    public void setMain(Main main){
        this.main = main;
    }

    public AddList(){
        cerrar();
            //open mainpanel_addlist as main panel
        setContentPane(mainpanel_addlist);

            //select all text for quick editing
        tf_newlistname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_newlistname.selectAll(); // Selecciona todo el texto cuando se obtiene el foco
            }
        });
            //when press "enter" key its saved automatically
        tf_newlistname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btn_listnamesave.doClick(); // Simula un clic en el botón cuando se presiona Enter
                }
            }
        });
            //save list with the entered name
        btn_listnamesave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    //give a name to new list
                if(tf_newlistname.getText().length()>20){
                    Error();
                } else if(!tf_newlistname.getText().isEmpty()) {
                    // Llamar al método en Main para agregar el nombre a la lista
                    main.agregarALista(tf_newlistname.getText());
                    main.setVisible(true);
                    setVisible(false);
                }

            }
        });
    }

        //class to open main when addlist closes
    public void cerrar(){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                main.setVisible(true);
                dispose();
            }
        });
    }

public void Error(){
        JOptionPane.showMessageDialog(this, "el nombre solo puede tener 20 caracteres", "advertencia", JOptionPane.OK_OPTION);
        /*
        int valor = JOptionPane.showConfirmDialog(this, "El nombre no debe tener mas de 20 caracteres","Advertencia", JOptionPane.OK_CANCEL_OPTION);
        cuadro cuando se usa JOptionPane.YES_NO_OPTION
        if(valor==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"gracias","adios",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
*/
    }
}
