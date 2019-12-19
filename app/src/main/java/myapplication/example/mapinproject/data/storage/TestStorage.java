package myapplication.example.mapinproject.data.storage;

import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import myapplication.example.mapinproject.R;
import myapplication.example.mapinproject.business.activities.TestActivity;
import myapplication.example.mapinproject.data.entities.Test;

public class TestStorage extends FragmentActivity {
    private FirebaseDatabase database;
    private String res;
    TestActivity testActivity = new TestActivity();

//    public void search(String fstr) {
//        TestActivity testActivity = new TestActivity();
//        database = FirebaseDatabase.getInstance();
//        DatabaseReference testRef = database.getReference("test");
//        Query findRef = testRef.orderByChild("name").startAt(fstr).endAt(fstr + "\uf8ff");
//
//        ValueEventListener listener = new  ValueEventListener(){
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                GenericTypeIndicator<HashMap<String, Test>> gt_indicator = new GenericTypeIndicator<HashMap<String, Test>>() {
//                };
//                HashMap<String, Test> values = snapshot.getValue(gt_indicator);
//                res = "";
//                if (values != null) {
//                    for (Object p : values.values()) {
//                        res += p + "\n";
//                    }
//                }else {
//                    res = "no data.";
//                }
//                testActivity.view(res);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) { }
//        };
//        findRef.addListenerForSingleValueEvent(listener);
//    }

    public void newCreate(String text, String name) {
        Test test = new Test(text, name);
        database = FirebaseDatabase.getInstance();
        DatabaseReference testRef = database.getReference("test").push();
        testRef.setValue(test);
    }
}
