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
    private JButton btn_next, btn_back;
    private JButton btn_addlist,deleteSelectionListButton;
    private JButton btn_copy1,btn_copy2,btn_copy3;
    private JButton btn_clear1,btn_clear2,btn_clear3;
    private JTextArea ta_1,ta_2,ta_3;
    private JPanel mainPanel;

    public JList<list_obj> list;
    private JLabel index;
    int cont = 0,cont1=0;

    public Main() {
        //Set the main panel
        setContentPane(mainPanel);

        //Create Model to add elements in list
        listModel = new DefaultListModel<>();
        list.setModel(listModel);

        //Open AddList window
        btn_addlist.addActionListener(e ->{
            AddList addList = new AddList();
            addList.setMain(Main.this);
            addList.pack();
            addList.setLocationRelativeTo(null);
            addList.setVisible(true);
            setVisible(false);
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
                    JOptionPane.showMessageDialog(mainPanel, "No hay mas listas para borrar", "advertencia", JOptionPane.OK_OPTION);
                }
            }
        });

        //clear textArea
        ActionListener clear = e -> {
            if (e.getSource().equals(btn_clear1)) {
                ta_1.setText("");
            } else if (e.getSource().equals(btn_clear2)) {
                ta_2.setText("");
            } else if (e.getSource().equals(btn_clear3)) {
                ta_3.setText("");
            }
        };
        btn_clear1.addActionListener(clear);
        btn_clear2.addActionListener(clear);
        btn_clear3.addActionListener(clear);

        //Update content when select a list
        list.addListSelectionListener(e -> {
                if(!e.getValueIsAdjusting()){
                    updateTx();
                    try {
                        index.setText("0");
                        list_obj seleccionado = list.getSelectedValue();
                        List<String> textos = seleccionado.getCopies();
                        setTextAreas(textos,0);
                    }catch (NullPointerException exception){
                        clearTextAreas();
                    }
                }
        });

        //Index NextBtn
        btn_next.addActionListener( e -> {updateIndex_TextAreas(1);});

        //Index BackBtn
        btn_back.addActionListener(e -> {updateIndex_TextAreas(-1);});

        //copy text
        btn_copy1.addActionListener(e -> copy(ta_1.getText()));
        btn_copy2.addActionListener(e -> copy(ta_2.getText()));
        btn_copy3.addActionListener(e -> copy(ta_3.getText()));

        //save changes
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
        for (int i=0;i<9;i++,cont1++){
            texts.add("Ingresa datos aqui "+cont1);
        }
        newElement.setCopies(texts);
        listModel.addElement(newElement);

        //when add list, select last list
        list.setSelectedIndex(list.getLastVisibleIndex());
    }
    //show values to copy based on their index
    private void updateTx(){
        list_obj selected = list.getSelectedValue();
        if(selected!=null){
            List<String> texts = selected.getCopies();
            int baseIndex = Integer.parseInt(index.getText())*3;

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

    //save changes when update textfields
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

    //class save changes in textfields
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

    //nuevas clases

    public void setTextAreas(List<String> texts, int baseIndex){
        if (baseIndex + 2 < texts.size()) {
            ta_1.setText(texts.get(baseIndex));
            ta_2.setText(texts.get(baseIndex + 1));
            ta_3.setText(texts.get(baseIndex + 2));
        } else {
            clearTextAreas();
        }
    }

    public void clearTextAreas(){
        ta_1.setText("Ingrese texto a copiar");
        ta_2.setText("Ingrese texto a copiar");
        ta_3.setText("Ingrese texto a copiar");
    }

    public void updateIndex_TextAreas(int direction){
        list_obj selected = list.getSelectedValue();
        if(selected!=null){
            int currentIndex = Integer.parseInt(index.getText());
            int newIndex = Math.max(0,Math.min(currentIndex+direction,2));
            index.setText(String.valueOf(newIndex));
            setTextAreas(selected.getCopies(),newIndex*3);
        }
    }

    public void copy(String text){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(text),null);
    }
}
