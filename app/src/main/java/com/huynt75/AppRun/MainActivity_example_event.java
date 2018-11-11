package com.huynt75.AppRun;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.*;

import android.support.v7.app.AppCompatActivity;

import com.huynt75.test_1.R;

public class MainActivity_example_event extends AppCompatActivity implements View.OnClickListener {
    Button btn_send;
    Button btn_save;
    Button btn_xoa;
    TextView txt_disp;
    LinearLayout lt_button;
    int a;
   private Button checkButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_event);

        lt_button = findViewById(R.id.lt_button);

        btn_send = lt_button.findViewById(R.id.btn_send);
        btn_save = lt_button.findViewById(R.id.btn_save);
        btn_xoa = lt_button.findViewById(R.id.btn_xoa);
        txt_disp = findViewById(R.id.txt_disp);
        btn_send.setOnClickListener(this);

//chung ta co the gop nhieu event lai voi nhau de ton vung nho

        btn_send.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        btn_xoa.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send :
                txt_disp.setText("toi da send");
                break;
            case R.id.btn_save:
                txt_disp.setText("toi da save");
                break;
            case R.id.btn_xoa:
                txt_disp.setText("toi da xoa");
                break;
            default:     txt_disp.setText("khong lam gi ca");
        }
    }
// kieens truc cua su kien click

}
