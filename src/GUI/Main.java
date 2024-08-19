package GUI;

import Logic.list_obj;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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

        //Remove selected list;
        deleteSelectionListButton.addActionListener(e -> deleteSelectedList());

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

        //save changes when textareas are updated
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

    //save changes when update textfields
    private void addDocumentlisteners(){
        addDocumentListener(ta_1,0);
        addDocumentListener(ta_2,1);
        addDocumentListener(ta_3,2);
    }

    //class save changes in textfields
    private void savechanges(int textAreaIndex){
        list_obj selected = list.getSelectedValue();
        if(selected != null){
            List<String> texts = selected.getCopies();
            int baseIndex = Integer.parseInt(index.getText())*3;

            if(baseIndex+textAreaIndex<texts.size()){
                texts.set(baseIndex+textAreaIndex, getTextAreaContent(textAreaIndex));
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

    public void deleteSelectedList(){
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1){
            int valor = JOptionPane.showConfirmDialog(mainPanel,"Are you sure to delete the list: "+list.getSelectedValue().getName() + "?", "Warning",JOptionPane.YES_NO_OPTION);
            if (valor == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,"Removed Successfully", "Delete",JOptionPane.INFORMATION_MESSAGE);
                listModel.remove(selectedIndex);
            }
            list.setSelectedIndex(list.getLastVisibleIndex());
        } else {
            JOptionPane.showMessageDialog(mainPanel,"there're no lists to delete");
        }
    }

    private void addDocumentListener(JTextArea textArea, int textAreaIndex){
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                savechanges(textAreaIndex);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                savechanges(textAreaIndex);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                savechanges(textAreaIndex);
            }
        });
    }
    private String getTextAreaContent(int textAreaIndex){
        return switch (textAreaIndex){
            case 0 -> ta_1.getText();
            case 1 -> ta_2.getText();
            case 2 -> ta_3.getText();
            default -> "";
        };
    }
}
