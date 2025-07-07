package Persistence;

import Logic.ListObj;

import javax.swing.*;
import java.io.*;
import java.util.Collections;
import java.util.List;

public class data {
    public void saveData(DefaultListModel<ListObj> listModel, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(Collections.list(listModel.elements()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DefaultListModel<ListObj> loadData(String filename) {
        DefaultListModel<ListObj> listModel = new DefaultListModel<>();
        File file = new File(filename);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                List<ListObj> loadedList = (List<ListObj>) ois.readObject();
                for (ListObj obj : loadedList) {
                    listModel.addElement(obj);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found: " + filename + ". A new file will be created upon saving.");
        }
        return listModel;
    }
}
