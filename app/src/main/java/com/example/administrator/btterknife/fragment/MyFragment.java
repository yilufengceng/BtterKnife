package com.example.administrator.btterknife.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.btterknife.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 16-2-25.
 */
public class MyFragment extends Fragment {
    @Bind(R.id.btn1)
    public Button button1;
    @Bind(R.id.btn2)
    public Button button2;
   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment, container, false);
       ButterKnife.bind(this,view);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button2.setText("2222");
            }
        });
       return  view;
   }


}
