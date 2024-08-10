package GUI;

import Logic.list_obj;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main extends JFrame{
    public DefaultListModel<list_obj> listModel;
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
    public JList<list_obj> list;
    private JLabel index;
    private JButton deleteSelectionListButton;
    int cont = 0;
    int cont1=0;
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

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Asegúrate de que la selección no esté ajustando
                if (!e.getValueIsAdjusting()) {
                    list_obj seleccionado = list.getSelectedValue();
                    if (seleccionado != null) {
                        List<String> textos = seleccionado.getCopies();
                        // Actualiza las áreas de texto
                        ta_1.setText(textos.size() > 0 ? textos.get(0) : "");
                        ta_2.setText(textos.size() > 1 ? textos.get(1) : "");
                        ta_3.setText(textos.size() > 2 ? textos.get(2) : "");
                    }
                }
            }
        });
    }
    public void agregarALista(String nombre) {
        cont++;
        if(Objects.equals(nombre, "New List")){
            nombre="New List "+cont;
        }
        list_obj newElement = new list_obj(nombre);
        List<String> texts = new ArrayList<>();
        texts.add("Ingresa datos aqui "+cont1);
        cont1++;
        texts.add("Ingresa datos aqui "+cont1);
        cont1++;
        texts.add("Ingresa datos aqui "+cont1);
        cont1++;
        newElement.setCopies(texts);
        listModel.addElement(newElement);
    }


}
