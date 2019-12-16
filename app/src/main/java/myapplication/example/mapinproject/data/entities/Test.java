package myapplication.example.mapinproject.data.entities;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Test {
    public String text;

    public Test(){
    }

    public Test(String _text) {
        text = _text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
