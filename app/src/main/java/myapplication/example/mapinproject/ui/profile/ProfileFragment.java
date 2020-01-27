package myapplication.example.mapinproject.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import myapplication.example.mapinproject.R;
import myapplication.example.mapinproject.business.activities.LoginActivity;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private Button pbutton7;
    private Button pbutton8;
    private Button pbutton9;
    private Button pbutton;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, null, false);

        pbutton7 = view.findViewById(R.id.pbutton7);
        pbutton8 = view.findViewById(R.id.pbutton8);
        pbutton9 = view.findViewById(R.id.pbutton9);
        pbutton = view.findViewById(R.id.pbutton);
        view.findViewById(R.id.pbutton7).setOnClickListener(this);
        view.findViewById(R.id.pbutton8).setOnClickListener(this);
        view.findViewById(R.id.pbutton9).setOnClickListener(this);
        view.findViewById(R.id.pbutton).setOnClickListener(this);

        return view;
    }
    public void onClick(View v) {
        if (v == pbutton7) {
            // プロフィール編集画面へ(未作成)
            Profile(v);
        }else if(v == pbutton8){
            // 自分の投稿を表示
        }else if(v == pbutton9){
            // お気に入りを表示
        }else if(v == pbutton){
            // さらに表示
        }
    }

    private void Profile(View v) {
        // プロフィール編集画面が未作成のため仮にログインへ
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}