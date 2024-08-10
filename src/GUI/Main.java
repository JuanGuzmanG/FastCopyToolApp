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
                listModel.remove(list.getSelectedIndex());
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

        //add and save texts in TextsFields
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
        ta_1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTexto(0, ta_1.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTexto(0, ta_1.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTexto(0, ta_1.getText());
            }
        });
        ta_2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTexto(1, ta_2.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTexto(1, ta_2.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTexto(1, ta_2.getText());
            }
        });

        // DocumentListener para ta_3
        ta_3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTexto(2, ta_3.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTexto(2, ta_3.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTexto(2, ta_3.getText());
            }
        });
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

    }
    private void actualizarTexto(int index, String nuevoTexto) {
        list_obj seleccionado = list.getSelectedValue();
        if (seleccionado != null) {
            List<String> textos = seleccionado.getCopies();
            // Asegúrate de que la lista tenga suficientes elementos
            while (textos.size() <= index) {
                textos.add("");
            }
            // Actualiza el texto en el índice correspondiente
            textos.set(index, nuevoTexto);
        }
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
