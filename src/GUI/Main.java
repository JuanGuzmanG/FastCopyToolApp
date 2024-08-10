package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Main extends JFrame{
    public DefaultListModel<String> listModel;
    private JButton btn_next;
    private JButton btn_back;
    private JButton btn_addlist;
    private JButton btn_copy3;
    private JButton btn_clear3;
    private JButton btn_copy2;
    private JButton btn_clear2;
    private JButton btn_copy1;
    private JButton btn_clear1;
    private JTextArea ta_1;
    private JTextArea ta_2;
    private JTextArea ta_3;
    private JPanel mainPanel;
    public JList<String> list;
    private JLabel index;
    private JButton deleteSelectionListButton;
    int cont = 0;

    public Main() {
    setContentPane(mainPanel);

        listModel = new DefaultListModel<>();
        list.setModel(listModel);
    btn_addlist.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddList addList = new AddList();
            addList.setMain(Main.this);
            addList.pack();
            addList.setLocationRelativeTo(null);
            addList.setVisible(true);
            setVisible(false);
        }
    });
        deleteSelectionListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.remove(list.getSelectedIndex());
            }
        });
        ActionListener clear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btn_clear1)) {
                    ta_1.setText("");
                } else if (e.getSource().equals(btn_clear2)) {
                    ta_2.setText("");
                } else if (e.getSource().equals(btn_clear3)) {
                    ta_3.setText("");
                }
            }
        };
        btn_clear1.addActionListener(clear);
        btn_clear2.addActionListener(clear);
        btn_clear3.addActionListener(clear);
    }
    public void agregarALista(String nombre) {
        cont++;
        if(Objects.equals(nombre, "New List")){
            listModel.addElement(nombre+" "+cont);
        }else{
            listModel.addElement(nombre);
        }
    }
}
