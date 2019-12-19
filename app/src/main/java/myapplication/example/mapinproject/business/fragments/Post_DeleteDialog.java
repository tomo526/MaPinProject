package myapplication.example.mapinproject.business.fragments;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class Post_DeleteDialog extends DialogFragment {

    // ダイアログが生成された時に呼ばれるメソッド ※必須
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // ダイアログ生成  AlertDialogのBuilderクラスを指定してインスタンス化します
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        // タイトル設定
        dialogBuilder.setTitle("削除");
        // 表示する文章設定
        dialogBuilder.setMessage("この場所の削除を提案しますか？");

        // OKボタン作成
        dialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // firebase内の情報を削除（未実装）

                // ダイアログクラスをインスタンス化
                Post_DeleteDialog2 dialog2 = new Post_DeleteDialog2();
                // 表示  getFagmentManager()は固定、sampleは識別タグ
                dialog2.show(getFragmentManager(), "delete");
            }
        });

        // NGボタン作成
        dialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 何もしないで閉じる
            }
        });

        // dialogBulderを返す
        return dialogBuilder.create();
    }

}