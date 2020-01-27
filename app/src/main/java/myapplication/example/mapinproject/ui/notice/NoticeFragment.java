package myapplication.example.mapinproject.ui.notice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import myapplication.example.mapinproject.R;

public class NoticeFragment extends Fragment implements View.OnClickListener{

    private Button button2;

    public static NoticeFragment  newInstance(){

    NoticeFragment fragment = new NoticeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notification, null, false);

        button2 = view.findViewById(R.id.button2);
        view.findViewById(R.id.button2).setOnClickListener(this);


        return view;
    }
    public void onClick(View v) {
        if (v == button2) {
            // 通知内容の画面へ(未作成)
        }
    }
}