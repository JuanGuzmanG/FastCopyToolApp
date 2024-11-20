package Logic;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class list_obj implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    private String name;
    private List<String> titles;
    private List<String> copies;

    public list_obj(String name) {
        this.name = name;
        this.titles = new ArrayList<>(9);
        this.copies = new ArrayList<>(9);

        for(int i=0; i<9;i++){
            this.titles.add("title");
            this.copies.add("add note");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCopies() {
        return copies;
    }

    public void setCopies(List<String> copies) {
        this.copies = copies;
    }

    public String getCopy(int index){
        return copies.get(index);
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    @Override
    public String toString() {
        return name;
    }
}
