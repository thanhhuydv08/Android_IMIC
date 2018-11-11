package com.huynt75.AppRun;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.huynt75.AppRun.class_data.Data_bai1;
import com.huynt75.AppRun.class_adapter.Adapter_bai1;
import com.huynt75.test_1.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_bai1_remember_createlayoutbycode_recyclerview extends AppCompatActivity {
    // type bien;
    private LinearLayout layout_root;
    private EditText edt_user, edt_pass;
    private Button btn_login;
    private CheckBox checkbox;
    private SharedPreferences sharedPreferences;// thu vien tao folde va file de luu du lieu
    private SharedPreferences.Editor editor;// put du lieu len 2 file tao o tren
    private String tempUsername, tempPassword;
    Boolean beChecked;
    private List<Data_bai1> arrayList = new ArrayList<>();
    RecyclerView recyclerView;

    public MainActivity_bai1_remember_createlayoutbycode_recyclerview() {
    }

    public  void onclick(Context context, int position,List<Data_bai1> arrayList) {
        // context truyen vao thi arr cua bien truyen vao vi neu khong truyen vao arrl se bao loi vi conetxt nay arrl se = null
      Toast.makeText(context, "Toi da click "+arrayList.get(position).getSubjectName(), Toast.LENGTH_SHORT).show();
   }
   public void testedit(){
        Toast.makeText(MainActivity_bai1_remember_createlayoutbycode_recyclerview.this,"toi muon lay ra "+arrayList.get(1).getSubjectName(),Toast.LENGTH_SHORT).show();
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1_remember_createlayoutbycode_recyclerview);
// type noi dung tinh toan
        AnhXa();
// set du lieu sharedPreferences lên edt
        sharedPreferences = getSharedPreferences("huynt75_bai1", MODE_PRIVATE);
        edt_user.setText(sharedPreferences.getString("username",""));
        edt_pass.setText(sharedPreferences.getString("password",""));
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beChecked=checkbox.isChecked();
                editor=sharedPreferences.edit();
                tempUsername = edt_user.getText().toString();
                tempPassword = edt_pass.getText().toString();
                KiemTraCheckBox(editor);
                //display recycler view
                // add thong tin vao mang
                DataObject();
                AddRecyclerView();



            }
        });
    }

    public void AnhXa(){
        layout_root = findViewById(R.id.layout_root);
        edt_user = findViewById(R.id.edt_user);
        edt_pass = findViewById(R.id.edt_pass);
        btn_login = findViewById(R.id.btn_login);
        checkbox = findViewById(R.id.checkbox);
        recyclerView = findViewById(R.id.recyclerview);

    }
    public void KiemTraCheckBox(SharedPreferences.Editor editor){
        if(beChecked){
            editor.putString("username",tempUsername);
            editor.putString("password",tempPassword);
            editor.commit();
        }else {
            editor.putString("username","");
            editor.putString("password","");
            editor.commit();
        }
    }
    public List DataObject(){
        arrayList.add(new Data_bai1(R.mipmap.blackberry,"Blackberry"));
        arrayList.add(new Data_bai1(R.mipmap.sony,"Sony"));
        arrayList.add(new Data_bai1(R.mipmap.samsung,"Samsung"));
        arrayList.add(new Data_bai1(R.mipmap.huawei,"Huawei"));
        arrayList.add(new Data_bai1(R.mipmap.iphone,"Iphone"));
       return arrayList;
    }
    public void AddRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity_bai1_remember_createlayoutbycode_recyclerview.this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Adapter_bai1(arrayList,MainActivity_bai1_remember_createlayoutbycode_recyclerview.this));
    }

}
