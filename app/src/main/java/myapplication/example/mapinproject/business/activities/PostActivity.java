package myapplication.example.mapinproject.business.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import myapplication.example.mapinproject.R;
import myapplication.example.mapinproject.business.fragments.PostDoneDialog;
import myapplication.example.mapinproject.data.storage.PostStorage;

import myapplication.example.mapinproject.business.fragments.Post_Dialog_Confirmation;
import static myapplication.example.mapinproject.business.activities.ReplyActivity.RESULT_PICK_IMAGEFILE;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int RESULT_PICK_IMAGEFILE = 1000;
    private ImageView imageView;

    private FirebaseDatabase database;

    private EditText locationText;
    private EditText contentText;
    private EditText categoryText;
    private RatingBar assessmentNumber;
    private DatabaseReference ref;
    private DatabaseReference testRef;

public class PostActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        final Button dialogBtn = (Button) findViewById(R.id.post_send_button);
        final TextView textView = (TextView) findViewById(R.id.post_send_button);


        locationText = findViewById(R.id.post_location_text);
        contentText = findViewById(R.id.post_content_text);
        categoryText = findViewById(R.id.post_category_text);
        assessmentNumber =findViewById(R.id.ratingBar);
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        int num =ratingBar.getNumStars();
        findViewById(R.id.post_back_button).setOnClickListener(this);
        findViewById(R.id.post_image_button).setOnClickListener(this);
        findViewById(R.id.post_send_button).setOnClickListener(this);

        ImageButton imageButton = findViewById(R.id.post_image_button);

    }

    @Override
    public void onClick(View v) {
        PostStorage storage = new PostStorage();
        int i = v.getId();
        if (i == R.id.post_back_button) {
            Pin_infoActivity();
        } else if (i == R.id.post_image_button) {
            ImageVive();
        } else if (i == R.id.post_send_button) {
            storage.newCreate(categoryText.getText().toString(), contentText.getText().toString(), locationText.getText().toString(),assessmentNumber.getRating());

        }
        if (i == R.id.post_send_button) {
            // ダイアログクラスをインスタンス化
            PostDoneDialog dialog = new PostDoneDialog();
            // 表示  getFagmentManager()は固定、sampleは識別タグ
            dialog.show(getFragmentManager(), "postdone");
        }
    }

    public void Pin_infoActivity() {
        Intent intent = new Intent(PostActivity.this, Pin_infoActivity.class);
        startActivity(intent);
    }

    public void ImageVive() {
        findViewById(R.id.post_image_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
            }
        });

        //送信時に行う
        findViewById(R.id.post_send_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text = (EditText)findViewById(R.id.post_content_text);
                if(text.getText().toString().isEmpty()) {
                    text.setError("文字を入力してください");
                } else {
                    dialogBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                    public void onClick(View v) {
                        // ダイアログクラスをインスタンス化
                        Post_Dialog_Confirmation dialog = new Post_Dialog_Confirmation();
                        // 表示  getFagmentManager()は固定、sampleは識別タグ
                        dialog.show(getFragmentManager(), "sample");
                    }
                });
                }
            }
        });
    }
