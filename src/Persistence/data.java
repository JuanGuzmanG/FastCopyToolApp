package Persistence;

import Logic.list_obj;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class data {
    public void saveData(DefaultListModel<list_obj> listModel, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(Collections.list(listModel.elements()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DefaultListModel<list_obj> loadData(String filename) {
        DefaultListModel<list_obj> listModel = new DefaultListModel<>();
        File file = new File(filename);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                List<list_obj> loadedList = (List<list_obj>) ois.readObject();
                for (list_obj obj : loadedList) {
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
