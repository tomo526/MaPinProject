package myapplication.example.mapinproject.business.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import myapplication.example.mapinproject.R;
import myapplication.example.mapinproject.business.fragments.Post_Dialog_Confirmation;
import myapplication.example.mapinproject.business.fragments.Reply_Dialog_Confirmation;

public class ReplyActivity extends AppCompatActivity {
    public static final int RESULT_PICK_IMAGEFILE = 1000;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reply);
        final Button dialogBtn = (Button) findViewById(R.id.reply_send_button);

        findViewById(R.id.reply_image_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
            }
        });

        findViewById(R.id.reply_send_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText text = (EditText)findViewById(R.id.reply_content_text);
                if(text.getText().toString().isEmpty()) {
                    text.setError("文字を入力してください");
                }

                else {
                    dialogBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // ダイアログクラスをインスタンス化
                            Reply_Dialog_Confirmation dialog = new Reply_Dialog_Confirmation ();
                            // 表示  getFagmentManager()は固定、sampleは識別タグ
                            dialog.show(getFragmentManager(), "sample");
                        }
                    });


                }




            }
        });

    }
}


