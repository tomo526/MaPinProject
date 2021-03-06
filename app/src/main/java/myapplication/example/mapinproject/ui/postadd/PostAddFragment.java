package myapplication.example.mapinproject.ui.postadd;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import myapplication.example.mapinproject.R;
import myapplication.example.mapinproject.business.activities.HomeActivity;
import myapplication.example.mapinproject.data.storage.PostStorage;

public class PostAddFragment extends Fragment  implements View.OnClickListener{

    private static final int RESULT_PICK_IMAGEFILE = 1000;
    private ImageView imageView;

    private FirebaseDatabase database;

    private EditText locationText;
    private EditText contentText;
    private EditText categoryText;
    private RatingBar assessmentNumber;
    private DatabaseReference ref;
    private DatabaseReference testRef;

    public static PostAddFragment newInstance() {
        PostAddFragment fragment = new PostAddFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_original, null, false);

        locationText = view.findViewById(R.id.post_location_text);
        contentText = view.findViewById(R.id.post_content_text);
        categoryText = view.findViewById(R.id.post_category_text);
        assessmentNumber =view.findViewById(R.id.ratingBar);
        RatingBar ratingBar = (RatingBar)view.findViewById(R.id.ratingBar);
        int num =ratingBar.getNumStars();
        view.findViewById(R.id.post_image_button).setOnClickListener(this);
        view.findViewById(R.id.post_send_button).setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
        PostStorage storage = new PostStorage();
        int i = v.getId();
        if (i == R.id.post_image_button) {
            ImageVive(v);
        } else if (i == R.id.post_send_button) {
            storage.newCreate(categoryText.getText().toString(), contentText.getText().toString(), locationText.getText().toString(),assessmentNumber.getRating());

        }
        if (i == R.id.post_send_button) {
            // PostDoneDialog表示
            PostDoneDialog();
        }
    }

    public void ImageVive(View v) {
        v.findViewById(R.id.post_image_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
            }
        });
    }
    public void PostDoneDialog(){
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
    }
}