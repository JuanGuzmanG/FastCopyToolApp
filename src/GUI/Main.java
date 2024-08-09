package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    private JButton btn_next;
    private JButton btn_back;
    private JButton btn_addlist;
    private JButton btn_copy3;
    private JButton btn_clr3;
    private JButton btn_copy2;
    private JButton btn_clear2;
    private JButton btn_copy1;
    private JButton btn_clear1;
    private JTextArea ta_1;
    private JTextArea ta_2;
    private JTextArea tx_3;
    private JPanel mainPanel;
    private JList<String> list;
    private JLabel index;

    public Main() {

    setContentPane(mainPanel);
    DefaultListModel<String> listModel = new DefaultListModel<>();
    //agregar a lista
    listModel.addElement("lista 1");
    listModel.addElement("lista 2");
    listModel.addElement("lista 3");
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
}

}
