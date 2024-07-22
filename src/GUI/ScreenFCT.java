package GUI;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

public class ScreenFCT extends JPanel {

    public ScreenFCT() {
    	setLayout(null);
    	
    	JList LISTA = new JList();
    	LISTA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	LISTA.setBounds(10, 52, 189, 363);
    	add(LISTA);
    	
    	JLabel LABELTITLE = new JLabel("FAST COPY TOOL");
    	LABELTITLE.setFont(new Font("Tahoma", Font.PLAIN, 34));
    	LABELTITLE.setHorizontalAlignment(SwingConstants.CENTER);
    	LABELTITLE.setBounds(10, 11, 834, 34);
    	add(LABELTITLE);
    	
    	JEditorPane NOTE1 = new JEditorPane();
    	NOTE1.setBounds(222, 52, 211, 316);
    	add(NOTE1);
    	
    	JEditorPane NOTE2 = new JEditorPane();
    	NOTE2.setBounds(446, 52, 211, 316);
    	add(NOTE2);
    	
    	JEditorPane NOTE3 = new JEditorPane();
    	NOTE3.setBounds(667, 52, 211, 316);
    	add(NOTE3);
    	
    	JButton btncopy = new JButton("Copy");
    	btncopy.setBounds(304, 379, 129, 36);
    	add(btncopy);
    	
    	JButton btnclear = new JButton("Clear");
    	btnclear.setBounds(222, 379, 72, 36);
    	add(btnclear);
    	
    	JButton btnclear_1 = new JButton("Clear");
    	btnclear_1.setBounds(446, 379, 72, 36);
    	add(btnclear_1);
    	
    	JButton btncopy_1 = new JButton("Copy");
    	btncopy_1.setBounds(528, 379, 129, 36);
    	add(btncopy_1);
    	
    	JButton btnclear_1_1 = new JButton("Clear");
    	btnclear_1_1.setBounds(667, 379, 72, 36);
    	add(btnclear_1_1);
    	
    	JButton btncopy_1_1 = new JButton("Copy");
    	btncopy_1_1.setBounds(749, 379, 129, 36);
    	add(btncopy_1_1);
    	
    	JButton btnaddlist = new JButton("Add List");
    	btnaddlist.setBounds(10, 426, 189, 41);
    	add(btnaddlist);
    	
    	JButton btnAddElement = new JButton("Add Copy");
    	btnAddElement.setBounds(298, 435, 441, 32);
    	add(btnAddElement);

    }
}

