package myapplication.example.mapinproject.data.storage;

import androidx.fragment.app.FragmentActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import myapplication.example.mapinproject.data.entities.Post;

public class PostStorage extends FragmentActivity {
    private FirebaseDatabase database;

    public void newCreate(String category,String content,String postname,Number assessment) {
        Post post = new Post(category,content,postname,assessment);
        database = FirebaseDatabase.getInstance();
        DatabaseReference testRef = database.getReference("post").push();
        testRef.setValue(post);
    }
}
