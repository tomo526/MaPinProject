package myapplication.example.mapinproject.data.entities;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Test {
    private String text;
    private String name;

    public Test() {
    }

    public Test(String _text,String _name) {
        this.text = _text;
        this.name = _name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }
}
