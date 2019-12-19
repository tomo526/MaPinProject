package myapplication.example.mapinproject.business.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import myapplication.example.mapinproject.business.fragments.Post_DeleteDialog;
import myapplication.example.mapinproject.R;

public class Post_DeleteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_delete);

        // idがdialogButtonのButtonを取得
        Button dialogBtn = (Button) findViewById(R.id.dialogbutton1);
        Button button =(Button)findViewById(R.id.button1);
        // clickイベント追加
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            // クリックしたらダイアログを表示する処理
            public void onClick(View v) {
                // ダイアログクラスをインスタンス化
                Post_DeleteDialog dialog = new Post_DeleteDialog();
                // 表示  getFagmentManager()は固定、sampleは識別タグ
                dialog.show(getFragmentManager(), "delete");

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),Pin_infoActivity.class );
                startActivity(intent);
            }
        });

    }
}