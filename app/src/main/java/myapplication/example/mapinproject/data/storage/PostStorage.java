package myapplication.example.mapinproject.data.storage;

import androidx.fragment.app.FragmentActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import myapplication.example.mapinproject.data.entities.Post;
import myapplication.example.mapinproject.data.entities.Test;

public class PostStorage extends FragmentActivity {
    private FirebaseDatabase database;

    public void newCreate(String category,String content,String postname) {
        Post post = new Post(category,content,postname);
        database = FirebaseDatabase.getInstance();
        DatabaseReference testRef = database.getReference("post").push();
        testRef.setValue(post);
    }
}
