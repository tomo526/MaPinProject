package myapplication.example.mapinproject.business.activities;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import myapplication.example.mapinproject.R;
import myapplication.example.mapinproject.business.fragments.PostDoneDialog;
import myapplication.example.mapinproject.data.storage.PostStorage;
import myapplication.example.mapinproject.data.storage.Upload;

//import static myapplication.example.mapinproject.business.activities.PostActivity.PICK_IMAGE_REQUEST;

public class PostActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int RESULT_PICK_IMAGEFILE = 1000;
    private ImageView imageView;

    private FirebaseDatabase database;

    private EditText locationText;
    private EditText contentText;
    private EditText categoryText;
    private RatingBar assessmentNumber;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_original);

        locationText = findViewById(R.id.post_location_text);
        contentText = findViewById(R.id.post_content_text);
        categoryText = findViewById(R.id.post_category_text);
        assessmentNumber =findViewById(R.id.ratingBar);
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        int num =ratingBar.getNumStars();
        findViewById(R.id.post_image_button).setOnClickListener(this);
        findViewById(R.id.post_send_button).setOnClickListener(this);
        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");


        ImageButton imageButton = findViewById(R.id.post_image_button);



    }




    @Override
    public void onClick(View v) {
        PostStorage storage = new PostStorage();
        int i = v.getId();
        if (i == R.id.post_image_button) {

            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            startActivityForResult(intent, RESULT_PICK_IMAGEFILE);


        } else if (i == R.id.post_send_button) {
            storage.newCreate(categoryText.getText().toString(), contentText.getText().toString(), locationText.getText().toString(),assessmentNumber.getRating());

        }
        if (i == R.id.post_send_button) {
            profiledone();
        }


    }



    //画像選択、画像を表示するときの操作
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
//            mImageUri = data.getData();

//            Picasso.with(this).load(mImageUri).into(mImageView);
        }
    }





    public void Pin_infoActivity() {
        Intent intent = new Intent(PostActivity.this, Pin_infoActivity.class);
        startActivity(intent);



    }



//    public void ImageVive() {
//        findViewById(R.id.post_image_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                intent.setType("image/*");
//                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
//                startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
//            }
//        });
//    }
    private void profiledone(){
        // ダイアログクラスをインスタンス化
        PostDoneDialog dialog = new PostDoneDialog();
        // 表示  getFagmentManager()は固定
        dialog.show(getFragmentManager(), "postdone");
    }

//    //画像をアップロードするときの動作ボタン
//    private String getFileExtension(Uri uri) {
//        ContentResolver cR = getContentResolver();
//        MimeTypeMap mime = MimeTypeMap.getSingleton();
//        return mime.getExtensionFromMimeType(cR.getType(uri));
//    }
//
//
//    private void uploadFile() {
//        if (mImageUri != null) {
//            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(mImageUri));
//
//            mUploadTask = fileReference.putFile(mImageUri)
//                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            Handler handler = new Handler();
//                            handler.postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//
//                                }
//                            }, 500);
//
//                            Toast.makeText(PostActivity.this, "アップロード成功", Toast.LENGTH_LONG).show();
//                            Upload upload = new Upload(mEditTextFileName.getText().toString().trim(),
//                                    taskSnapshot.getUploadSessionUri().toString());
//                            String uploadId = mDatabaseRef.push().getKey();
//                            mDatabaseRef.child(uploadId).setValue(upload);
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(PostActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
//        } else {
////            Toast.makeText(this, "ファイルが選択されていません", Toast.LENGTH_SHORT).show();
//        }
//    }
}

//プッシュ確認