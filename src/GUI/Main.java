package GUI;

import Logic.list_obj;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
    int cont = 0,cont1=0;

    public Main() {
        //Set the main panel
    setContentPane(mainPanel);

        //Create Model to add elements in list
    listModel = new DefaultListModel<>();
    list.setModel(listModel);

        //Open AddList window
    btn_addlist.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
            AddList addList = new AddList();
            //Send Main to Addlist class
            addList.setMain(Main.this);
            //adjusts the size of the windows to the size of it's components
            addList.pack();
            addList.setLocationRelativeTo(null);
            addList.setVisible(true);
            setVisible(false);
        }
    });

            //Delete selected list;
        deleteSelectionListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(list.getSelectedIndex()!=-1){
                    int valor = JOptionPane.showConfirmDialog(mainPanel, "esta seguro de elimnar la lista "+list.getSelectedValue().getName(),"Advertencia", JOptionPane.YES_NO_OPTION);

                    if(valor==JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null,"Eliminado Correctamente","Eliminacion",JOptionPane.INFORMATION_MESSAGE);
                        listModel.remove(list.getSelectedIndex());
                    }

                    list.setSelectedIndex(list.getLastVisibleIndex());
                }else {
                    JOptionPane.showMessageDialog(mainPanel, "no hay mas listas para borrar", "advertencia", JOptionPane.OK_OPTION);
                }
            }
        });

            //clear textArea
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
                if(!e.getValueIsAdjusting()){
                    updateTx();
                    try {
                        index.setText("0");
                        list_obj seleccionado = list.getSelectedValue();
                        List<String> textos = seleccionado.getCopies();
                        ta_1.setText(textos.get(0));
                        ta_2.setText(textos.get(1));
                        ta_3.setText(textos.get(2));
                    }catch (NullPointerException exception){
                        ta_1.setText("");
                        ta_2.setText("");
                        ta_3.setText("");
                    }
                }
            }
        });



            //Index NextBtn
        btn_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(list.getSelectedValue()==null)){
                    list_obj seleccionado = list.getSelectedValue();
                    List<String> textos = seleccionado.getCopies();

                    int intIndice=0;
                    String indice = index.getText();
                    intIndice = Integer.parseInt(indice);

                    if(intIndice<2){
                        intIndice++;
                        indice = String.valueOf(intIndice);
                        index.setText(indice);
                        switch (intIndice) {
                            case 0 -> {
                                ta_1.setText(textos.get(0));
                                ta_2.setText(textos.get(1));
                                ta_3.setText(textos.get(2));
                            }
                            case 1 -> {
                                ta_1.setText(textos.get(3));
                                ta_2.setText(textos.get(4));
                                ta_3.setText(textos.get(5));
                            }
                            case 2 -> {
                                ta_1.setText(textos.get(6));
                                ta_2.setText(textos.get(7));
                                ta_3.setText(textos.get(8));
                            }
                        }
                    }
                }
            }
        });

            //Index BackBtn
        btn_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(list.getSelectedValue()==null)){
                    list_obj seleccionado = list.getSelectedValue();
                    List<String> textos = seleccionado.getCopies();

                    int intIndice=0;
                    String indice = index.getText();
                    intIndice = Integer.parseInt(indice);

                    if(intIndice>0){
                        intIndice--;
                        indice = String.valueOf(intIndice);
                        index.setText(indice);
                    }
                    switch (intIndice) {
                        case 0 -> {
                            ta_1.setText(textos.get(0));
                            ta_2.setText(textos.get(1));
                            ta_3.setText(textos.get(2));
                        }
                        case 1 -> {
                            ta_1.setText(textos.get(3));
                            ta_2.setText(textos.get(4));
                            ta_3.setText(textos.get(5));
                        }
                    }
                }
            }
        });

            //copy text
        ActionListener copy = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String copytext="";
                if(e.getSource().equals(btn_copy1)){
                    copytext = ta_1.getText();
                } else if (e.getSource().equals(btn_copy2)){
                    copytext = ta_2.getText();
                } else if (e.getSource().equals(btn_copy3)) {
                    copytext = ta_3.getText();
                }

                Toolkit tk = Toolkit.getDefaultToolkit();
                Clipboard cb = tk.getSystemClipboard();
                cb.setContents(new StringSelection(copytext),null);
            }
        };
        btn_copy1.addActionListener(copy);
        btn_copy2.addActionListener(copy);
        btn_copy3.addActionListener(copy);

        addDocumentlisteners();
    }

        //AddList class
    public void agregarALista(String nombre) {
        cont++;
        if(Objects.equals(nombre, "New List")){
            nombre="New List "+cont;
        }
        list_obj newElement = new list_obj(nombre);
        List<String> texts = new ArrayList<>();
        for (int i=0;i<9;i++){
            texts.add("Ingresa datos aqui "+cont1);
            cont1++;
        }
        newElement.setCopies(texts);
        listModel.addElement(newElement);

        list.setSelectedIndex(list.getLastVisibleIndex());
    }

    private void updateTx(){
        list_obj selected = list.getSelectedValue();
        if(selected!=null){
            List<String> texts = selected.getCopies();
            int intIndice = Integer.parseInt(index.getText());
            int baseIndex = intIndice*3;

            if(baseIndex + 2< texts.size()){
                ta_1.setText(texts.get(baseIndex));
                ta_2.setText(texts.get(baseIndex+1));
                ta_3.setText(texts.get(baseIndex+2));
            }else{
                ta_1.setText("Ingrese texto a copiar");
                ta_2.setText("Ingrese texto a copiar");
                ta_3.setText("Ingrese texto a copiar");
            }
        }
    }

    private void addDocumentlisteners(){
        ta_1.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                savechanges(0);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                savechanges(0);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                savechanges(0);
            }
        });
        ta_2.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                savechanges(1);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                savechanges(1);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                savechanges(1);
            }
        });
        ta_3.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                savechanges(2);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                savechanges(2);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                savechanges(2);
            }
        });
    }

    private void savechanges(int textAreaIndex){
        list_obj selected = list.getSelectedValue();
        if(selected != null){
            List<String> texts = selected.getCopies();
            int intIndice = Integer.parseInt(index.getText());
            int baseIndex = intIndice*3;

            if(baseIndex+textAreaIndex<texts.size()){
                switch (textAreaIndex){
                    case 0 ->texts.set(baseIndex, ta_1.getText());
                    case 1 ->texts.set(baseIndex+1, ta_2.getText());
                    case 2 ->texts.set(baseIndex+2, ta_3.getText());
                }
            }
        }
    }



    //JJGG
}
