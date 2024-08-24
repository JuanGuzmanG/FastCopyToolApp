package Logic;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class list_obj implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    private String name;
    private List<String> copies;

    public list_obj(String name) {
        this.name = name;
        this.copies = new ArrayList<>(9);
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

    @Override
    public String toString() {
        return name;
    }
}
