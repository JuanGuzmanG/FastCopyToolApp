package GUI;

import Logic.list_obj;
import Logic.mainfct;
import Persistence.data;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
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
    public JList<list_obj> titles_texts;
    private JLabel index;
    private JTextField tf_title1;
    private JTextField tf_title2;
    private JTextField tf_title3;
    int countlists =0;

    public Main() {
        //Set the main panel
        setContentPane(mainPanel);

        //Create Model to add elements in list
        listModel = new DefaultListModel<>();
        list.setModel(listModel);

        data persistence = new data();
        listModel = persistence.loadData("lists.bin");
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
                tf_title1.setText("");
            } else if (e.getSource().equals(btn_clear2)) {
                ta_2.setText("");
                tf_title2.setText("");
            } else if (e.getSource().equals(btn_clear3)) {
                ta_3.setText("");
                tf_title3.setText("");
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
                        list_obj selected = list.getSelectedValue();
                        List<String> texts = selected.getCopies();
                        setTextAreas(texts,0);
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
        btn_copy1.addActionListener(e -> mainfct.copy(ta_1.getText()));
        btn_copy2.addActionListener(e -> mainfct.copy(ta_2.getText()));
        btn_copy3.addActionListener(e -> mainfct.copy(ta_3.getText()));

        //save changes when textareas are updated
        addDocumentlisteners();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                data persistence = new data();
                persistence.saveData(listModel, "lists.bin");
                System.exit(0);
            }
        });
    }

    //AddList class
    public void addList(String name) {
        countlists++;
        if(Objects.equals(name, "New List")){
            name="New List "+ countlists;
        }
        list_obj newElement = new list_obj(name);
        List<String> texts = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i=0;i<9;i++){
            texts.add("add note");
            titles.add("title note");
        }
        newElement.setCopies(texts);
        listModel.addElement(newElement);

        //when add list, select last list
        list.setSelectedIndex(list.getLastVisibleIndex());
    }

    //save changes when update textfields
    private void addDocumentlisteners(){
        addDocumentListener(tf_title1,ta_1,0);
        addDocumentListener(tf_title2,ta_2,1);
        addDocumentListener(tf_title3,ta_3,2);
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
        ta_1.setText("Create a list and Insert text to copy");
        ta_2.setText("Create a list and Insert text to copy");
        ta_3.setText("Create a list and Insert text to copy");
        tf_title1.setText("title 1");
        tf_title2.setText("title 2");
        tf_title3.setText("title 3");
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

    private void addDocumentListener(JTextField tx_title, JTextArea textArea, int textAreaIndex){
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
        tx_title.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {savechanges(textAreaIndex);}
            @Override
            public void removeUpdate(DocumentEvent e) {savechanges(textAreaIndex);}
            @Override
            public void changedUpdate(DocumentEvent e) {savechanges(textAreaIndex);}
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
