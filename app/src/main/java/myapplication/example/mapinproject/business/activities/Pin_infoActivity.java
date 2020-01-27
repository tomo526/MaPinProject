package myapplication.example.mapinproject.business.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import myapplication.example.mapinproject.R;
import myapplication.example.mapinproject.business.fragments.Pin_infoDialog;

public class Pin_infoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pin_info);
        // idがdialogButtonのButtonを取得
        Button dialogBtn = (Button) findViewById(R.id.dialogbutton3);
        // clickイベント追加
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            // クリックしたらダイアログを表示する処理
            public void onClick(View v) {
                // ダイアログクラスをインスタンス化
                Pin_infoDialog dialog = new Pin_infoDialog();
                // 表示  getFagmentManager()は固定、sampleは識別タグ
                dialog.show(getFragmentManager(), "sample");
            }
        });
    }
}