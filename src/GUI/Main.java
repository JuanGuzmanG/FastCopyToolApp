package GUI;

import Logic.ListObj;
import Logic.Utils;
import Persistence.data;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main extends JFrame{
    public DefaultListModel<ListObj> listModel;
    private JButton btn_next, btn_back;
    private JButton btn_addlist,deleteSelectionListButton;
    private JButton btn_copy1,btn_copy2,btn_copy3;
    private JButton btn_clear1,btn_clear2,btn_clear3;
    private JTextArea ta_1,ta_2,ta_3;
    private JPanel mainPanel;

    public JList<ListObj> list;
    private JLabel index;
    private JTextField tf_title1;
    private JTextField tf_title2;
    private JTextField tf_title3;
    private JButton btn_deleteAll;
    private JButton btn_DeleteTexts;
    private JButton btn_help;
    int countlists=0;

    ImageIcon icon = new ImageIcon(Main.class.getResource("/resource/logo.png"));

    public Main() {

        setContentPane(mainPanel);

        // Now that the panel and all its components are loaded,
        // you can safely add listeners and modify them.
        list.setModel(new DefaultListModel<>());

        // when click on a title or note it selects all texts
        FocusAdapter selectAllListener = new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                ((JTextField) e.getSource()).selectAll();
            }
        };
        tf_title1.addFocusListener(selectAllListener);
        tf_title2.addFocusListener(selectAllListener);
        tf_title3.addFocusListener(selectAllListener);
        FocusAdapter select = new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                ((JTextArea) e.getSource()).selectAll();
            }
        };
        ta_1.addFocusListener(select);
        ta_2.addFocusListener(select);
        ta_3.addFocusListener(select);

        //remove border from textfields
        tf_title1.setBorder(null);
        tf_title2.setBorder(null);
        tf_title3.setBorder(null);

        //load data .bin
        data persistence = new data();
        listModel = persistence.loadData("lists.bin");
        list.setModel(listModel);

        //Open AddList window
        btn_addlist.addActionListener(e ->{
            AddList addList = new AddList();
            addList.setMain(Main.this);
            addList.pack();
            addList.setLocationRelativeTo(mainPanel);
            addList.setTitle("ADD LIST");
            addList.setIconImage(icon.getImage());
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
                        ListObj selected = list.getSelectedValue();
                        List<String> texts = selected.getCopies();
                        List<String> titles = selected.getTitles();

                        setTextAreas(texts,titles,0);
                    }catch (NullPointerException exception){
                        clearTextAreas();
                    }
                }
        });

        //Index NextBtn
        btn_next.addActionListener( e -> {
            updateIndexTextAreas(1);});

        //Index BackBtn
        btn_back.addActionListener(e -> {
            updateIndexTextAreas(-1);});

        //copy text
        btn_copy1.addActionListener(e -> Utils.copy(ta_1.getText()));
        btn_copy2.addActionListener(e -> Utils.copy(ta_2.getText()));
        btn_copy3.addActionListener(e -> Utils.copy(ta_3.getText()));

        //save changes when textareas are updated
        addDocumentListeners();

        //save data when Close program
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                data persistence = new data();
                persistence.saveData(listModel, "lists.bin");
                System.exit(0);
            }
        });

        //delete texts
        btn_DeleteTexts.addActionListener(e -> {
                if (list.getSelectedValue() != null) {
                    int valor = JOptionPane.showConfirmDialog(mainPanel,"Are you sure to delete the texts from: "+list.getSelectedValue().getName() + "?", "Warning",JOptionPane.YES_NO_OPTION);

                    if(valor == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(mainPanel,"Removed Successfully", "Delete",JOptionPane.INFORMATION_MESSAGE,icon);
                        List<String> texts = new ArrayList<String>();
                        List<String> titles = new ArrayList<String>();
                        list.getSelectedValue().setTitles(titles);
                        list.getSelectedValue().setCopies(texts);
                        setTextAreas(texts,titles,0);
                    }else{
                        JOptionPane.showMessageDialog(mainPanel,"Canceled", "Warning",JOptionPane.INFORMATION_MESSAGE,icon);
                    }
                }else{
                    JOptionPane.showMessageDialog(mainPanel,"Nothing to delete", "Error",JOptionPane.ERROR_MESSAGE);
                }
        });

        //delete all lists
        btn_deleteAll.addActionListener(e ->{
            if (listModel.getSize() > 0) {
                int option = JOptionPane.showConfirmDialog(mainPanel,"DELETE ALL LISTS, Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
                if(option==JOptionPane.YES_OPTION){
                    listModel.clear();
                    list.setModel(listModel);
                    JOptionPane.showMessageDialog(mainPanel,"Deleted Successfully", "Delete",JOptionPane.INFORMATION_MESSAGE, icon);
                }else{
                    JOptionPane.showMessageDialog(mainPanel,"Canceled", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(mainPanel,"No list to delete", "Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        //Help Button
        btn_help.addActionListener(e ->{
            JOptionPane.showMessageDialog(mainPanel, """
                            1. create a list with the green add list button.\s
                            2. enter the texts you want to save in the right boxes.\s
                            3. You can add a title to each text if you wish.\s
                            
                            Note: each list has nine possible texts,
                             the index at the bottom informs the position from 0 to 2.""",
                    "Help",JOptionPane.INFORMATION_MESSAGE);
        });
    }

    //AddList class
    public void addList(String name) {
        countlists++;
        if(Objects.equals(name, "New List")){
            name="New List "+ countlists;
        }
        ListObj newElement = new ListObj(name);
        List<String> texts = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (int i=0;i<9;i++){
            texts.add("add the text");
            titles.add("title");
        }
        newElement.setCopies(texts);
        newElement.setTitles(titles);
        listModel.addElement(newElement);

        //when add list, select last list
        list.setSelectedIndex(list.getLastVisibleIndex());
    }

    //save changes when update textfields
    private void addDocumentListeners(){
        addDocumentListener(tf_title1,ta_1,0);
        addDocumentListener(tf_title2,ta_2,1);
        addDocumentListener(tf_title3,ta_3,2);
    }

    //class save changes in textfields
    private void saveChanges(int textAreaIndex){
        ListObj selected = list.getSelectedValue();
        if(selected != null){
            List<String> texts = selected.getCopies();
            List<String> titles = selected.getTitles();
            int baseIndex = Integer.parseInt(index.getText())*3;

            //as long as "base" is less than 9
            if(baseIndex+textAreaIndex<texts.size()){
                texts.set(baseIndex + textAreaIndex,
                        getTextAreaContent(textAreaIndex));
            }
            if(baseIndex + textAreaIndex < titles.size()){
                titles.set(baseIndex + textAreaIndex,
                        getTitlesContent(textAreaIndex));
            }
        }
    }

    //update the content of the textarea
    public void setTextAreas(List<String> texts,List<String> titles, int baseIndex){
        List<String> listcopy = new ArrayList<>(titles);
        if (baseIndex + 2 < texts.size()) {
            ta_1.setText(texts.get(baseIndex));
            ta_2.setText(texts.get(baseIndex + 1));
            ta_3.setText(texts.get(baseIndex + 2));

            tf_title1.setText(listcopy.get(baseIndex));
            tf_title2.setText(listcopy.get(baseIndex + 1));
            tf_title3.setText(listcopy.get(baseIndex + 2));
        } else {
            clearTextAreas();
        }
    }

    //if textareas and titles are empty, fill with:
    public void clearTextAreas(){
        ta_2.setText("Create list or Insert text");
        ta_1.setText("Create list or Insert text");
        ta_3.setText("Create list or Insert text");
        tf_title1.setText("title");
        tf_title2.setText("title");
        tf_title3.setText("title");
    }

    //index control
    public void updateIndexTextAreas(int direction){
        ListObj selected = list.getSelectedValue();
        if(selected!=null){
            int currentIndex = Integer.parseInt(index.getText());
            int newIndex = Math.max(0,Math.min(currentIndex+direction,2));
            index.setText(String.valueOf(newIndex));
            setTextAreas(selected.getCopies(),selected.getTitles(),newIndex*3);
        }
    }

    //delete selected list
    public void deleteSelectedList(){
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1){
            int valor = JOptionPane.showConfirmDialog(mainPanel,"Are you sure to delete the list: "+list.getSelectedValue().getName() + "?", "Warning",JOptionPane.YES_NO_OPTION);
            if (valor == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(mainPanel,"Removed Successfully", "Delete",JOptionPane.INFORMATION_MESSAGE,icon);
                listModel.remove(selectedIndex);
            }
            list.setSelectedIndex(list.getLastVisibleIndex());
        } else {
            JOptionPane.showMessageDialog(mainPanel,"there're no lists to delete","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    //detects when insert, remove, change JTEXTFIELD and JTEXTAREA
    private void addDocumentListener(JTextField tx_title, JTextArea textArea, int textAreaIndex){
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                saveChanges(textAreaIndex);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                saveChanges(textAreaIndex);
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                saveChanges(textAreaIndex);
            }
        });
        tx_title.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                saveChanges(textAreaIndex);}
            @Override
            public void removeUpdate(DocumentEvent e) {
                saveChanges(textAreaIndex);}
            @Override
            public void changedUpdate(DocumentEvent e) {
                saveChanges(textAreaIndex);}
        });
        //insertUpdate when text is inserted
        //removeUpdate when text is delete, backspace key or clear button
        //changedUpdate when applying a different format
    }

    //add the texts and titles from the list to textareas
    private String getTextAreaContent(int textAreaIndex){
        return switch (textAreaIndex){
            case 0 -> ta_1.getText();
            case 1 -> ta_2.getText();
            case 2 -> ta_3.getText();
            default -> "";
        };
    }
    private String getTitlesContent(int texttitleIndex){
        return switch (texttitleIndex){
            case 0 -> tf_title1.getText();
            case 1 -> tf_title2.getText();
            case 2 -> tf_title3.getText();
            default -> "";
        };
    }
}
