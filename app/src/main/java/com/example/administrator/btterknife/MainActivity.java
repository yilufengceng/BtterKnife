package com.example.administrator.btterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.btterknife.fragment.MyFragment;


import java.util.List;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "print";
    @Bind(R.id.tv)
    public TextView tv;
    @BindString(R.string.abc)
    public  String str;
    @Bind({R.id.tv,R.id.tv2,R.id.tv3})
    public List<TextView> viewList;
    @Bind(R.id.et)
    public EditText et;
    @Nullable
    @Bind(R.id.btn1)
    public Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 注册ButterKnife
         */
        ButterKnife.bind(this);
        tv.setText(str);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl,new MyFragment())
                .commit();
        /**
          * 批量设置属性
         */
        ButterKnife.Action<View> DISABLE=new ButterKnife.Action<View>(){

            @Override
            public void apply(View view, int index) {
                view.setEnabled(false);
                if(view instanceof TextView){
                    TextView tv= (TextView) view;
                    tv.setText("统一的名字");
                }
            }
        };
        ButterKnife.apply(viewList, DISABLE);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    @OnTextChanged(value = R.id.et,callback = OnTextChanged.Callback.TEXT_CHANGED)
    public void etmenth(){
        Log.d(TAG, "etmenth: 正在输入");
    }
    @OnTextChanged(value = R.id.et,callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    public void etmenth2(){
        Log.d(TAG, "etmenth: 开始输入");
    }
    @OnTextChanged(value = R.id.et,callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void etmenth3(){
        Log.d(TAG, "etmenth: 结束输入");
    }

    @OnClick({R.id.button,R.id.button2})
    public  void abc(Button btn){
        switch (btn.getId()){
            case R.id.button:
                Toast.makeText(MainActivity.this,"点击了1",Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                Toast.makeText(MainActivity.this,"点击了2",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
