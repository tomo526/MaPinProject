package myapplication.example.mapinproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class Pin_infoDialog extends DialogFragment {

    // ダイアログが生成された時に呼ばれるメソッド ※必須
    public Dialog onCreateDialog(Bundle savedInstanceState){

        // リスト項目生成
        final String[] items = new String[2];
        items[0]="この場所の情報を変更";
        items[1]="この場所を削除";

        // ダイアログ生成  AlertDialogのBuilderクラスを指定してインスタンス化します
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        // タイトル設定
        dialogBuilder.setTitle("情報の修正を提案");
        // 表示する文章設定
        dialogBuilder.setItems(items, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // whichには選択したリスト項目の順番が入っているので、それを使用して値を取得
                String selectedVal = items[which];
                if(selectedVal == items[0]){
                    // post_changeに遷移
                    Activity parent = getActivity();
                    Intent intent = new Intent(parent,Post_ChangeActivity.class );
                    startActivity(intent);
                }else if(selectedVal == items[1]){
                    // post_deleteに遷移
                    Activity parent = getActivity();
                    Intent intent = new Intent(parent,Post_DeleteActivity.class );
                    startActivity(intent);
                }

            }
        });


        // dialogBulderを返す
        return dialogBuilder.create();
    }
}