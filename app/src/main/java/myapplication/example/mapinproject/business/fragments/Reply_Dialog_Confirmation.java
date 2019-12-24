package myapplication.example.mapinproject.business.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class Reply_Dialog_Confirmation extends DialogFragment {

    // ダイアログが生成された時に呼ばれるメソッド ※必須
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // ダイアログ生成  AlertDialogのBuilderクラスを指定してインスタンス化します
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        // タイトル設定
        dialogBuilder.setTitle("確認");
        // 表示する文章設定
        dialogBuilder.setMessage("この内容で送信しますか？");

        // OKボタン作成
        dialogBuilder.setPositiveButton("送信", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // firebase内の情報を変更（未実装）

                // ダイアログクラスをインスタンス化
                Post_Dialog_Completely dialog2 = new Post_Dialog_Completely();
                // 表示  getFagmentManager()は固定、sampleは識別タグ
                dialog2.show(getFragmentManager(), "change");
            }
        });

        // NGボタン作成
        dialogBuilder.setNegativeButton("戻る", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 何もしないで閉じる
            }
        });

        // dialogBulderを返す
        return dialogBuilder.create();
    }

}