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
        btn_listnamesave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    //give a name to new list
                String nombreLista = tf_newlistname.getText();
                if (!nombreLista.isEmpty()) {
                    // Llamar al método en Main para agregar el nombre a la lista
                    main.agregarALista(nombreLista);
                }
                main.setVisible(true);
                setVisible(false);
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
/* Cuadros de dialogo
public void salida(){
        int valor = JOptionPane.showConfirmDialog(this, "quiere salir","Advertencia", JOptionPane.YES_NO_OPTION);
        if(valor==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"gracias","adios",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }*/
}
