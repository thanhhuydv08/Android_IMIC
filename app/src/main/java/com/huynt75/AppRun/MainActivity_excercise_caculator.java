package com.huynt75.AppRun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.huynt75.test_1.R;

public class MainActivity_excercise_caculator extends AppCompatActivity {
    final static String NHAN="NHÂN";
    final static String CONG="CỘNG";
    final static String TRU="TRỪ";
    final static String CHIA="CHIA";

Button btn;
EditText edt_phepTinh;
EditText edt_numberA;
EditText edt_numberB;
TextView txt_view;
private String check="aaaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_caculator);
        btn = findViewById(R.id.btn_tinh);
        edt_phepTinh = findViewById(R.id.edt_phepTinh);
        edt_numberA = findViewById(R.id.edt_numberA);
        edt_numberB = findViewById(R.id.edt_numberB);
        txt_view = findViewById(R.id.txt_view);
        //check= edt_phepTinh.getText().toString();// moi chay thi edt_edt_phepTinh = roong  ma do do ko nen dat o day nhe

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        check= edt_phepTinh.getText().toString().toUpperCase();//tu dong chuyen sang hoa

           switch (check){
               case CONG: { txt_view.setText(phepCong()); break;}
               case TRU: {txt_view.setText(phepTru()); break;}
               case NHAN: {txt_view.setText(phepNhan()); break;}
               case CHIA: {txt_view.setText(phepChia()); break;}
               default:txt_view.setText("Ban nhap vao sai cu phap toan hoc");
           }
    }
});

    }

    public String phepCong(){
        String s = String.valueOf(Integer.parseInt(edt_numberA.getText().toString())+Integer.parseInt(edt_numberB.getText().toString()));
        return s;
    }
    public String phepTru(){
        String s = String.valueOf(Integer.parseInt(edt_numberA.getText().toString())-Integer.parseInt(edt_numberB.getText().toString()));
        return s;
    }
    public String phepNhan(){
        String s = String.valueOf(Integer.parseInt(edt_numberA.getText().toString())*Integer.parseInt(edt_numberB.getText().toString()));
        return s;
    }
    public String phepChia(){
        String s = String.valueOf(Integer.parseInt(edt_numberA.getText().toString())/Integer.parseInt(edt_numberB.getText().toString()));
        return s;
    }

}
