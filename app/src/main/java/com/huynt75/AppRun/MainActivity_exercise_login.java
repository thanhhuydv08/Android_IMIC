package com.huynt75.AppRun;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.huynt75.test_1.R;

import java.util.jar.Attributes;

public class MainActivity_exercise_login extends AppCompatActivity {
    private Button btn_login, btn_sigin;
    private EditText userText, passText;
    private String username_put, password_put;
    private CheckBox cbx_remember;
    boolean isRemember = false;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_login);
        FindWigets();// gọi hàm ánh xạ biến vào view tại hàm này
        //isRem = cb.isChecked();// lệnh này không đúng khi đặt trên này --> rất động khi học android
        sharedPreferences = getSharedPreferences("huynt75", MODE_PRIVATE);
        userText.setText(sharedPreferences.getString("username", ""));
        passText.setText(sharedPreferences.getString("password", ""));
// tao deo can biet cu start app la tao fodel huynt75 trong máy tính , gán gia tri vao file username password cua Share cho tao
        // xong rồi set lại cho 2 editText cho tao luôn tất nhiên chạy lần đầu là null
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // khi click thì tiến hành lưu lên foldel huynt75 user, pass mới nhất cho tao...
                username_put = userText.getText().toString();
                password_put = passText.getText().toString();
                //tiến hành luu vao bien tam giúp
                // và luu gia tri 2 biến tam lên huynt75 cái
                isRemember = cbx_remember.isChecked();// bắt buộc phải đặt trong này nhé vì khi click mới đi kiểm tra đã check ko
                ButtonCheckbox(username_put, password_put);
            }
        });

        btn_sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity_exercise_login.this);
//                        alertDialog.setView(R.layout.exercise_login_alertdialog); có 2 cách set view vào dialog = line 33+36
                alertDialog.setCancelable(false);
                final View alertView = getLayoutInflater().inflate(R.layout.exercise_login_alertdialog, null);
                Button btn_yes = alertView.findViewById(R.id.btn_yes);
                Button btn_no = alertView.findViewById(R.id.btn_no);
                alertDialog.setView(alertView);// gắn alertDialog là cái view tôi muốn hiện exercise_login_alertdialog
                final AlertDialog dialog = alertDialog.create();
                // tạo đè nó để kế thừa view trên như 1 alertdialog va khi đó ta sẽ có nhiều thuộc tính hơn
                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();// tôi muốn exit hết view thì làm sao
                    }
                });
                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // test gọi view ngoại như thế nào
                        //alertDialog.setView(R.layout.exercise_login_signup);
                        View alertView1 = getLayoutInflater().inflate(R.layout.exercise_login_signup, null);
                        alertDialog.setView(alertView1);
                        final AlertDialog dialog_2 = alertDialog.create();
                        dialog_2.show();
                        Button btn_exit = alertView1.findViewById(R.id.btn_exit);
                        btn_exit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity_exercise_login.this, "bạn đã thoát thành công", Toast.LENGTH_LONG).show();
                                dialog_2.cancel();
                            }
                        });

                    }
                });
                dialog.show(); // tiến hành show dialog vừa crete trên để hiện thị trên view chính có view con
            }
        });

    }
// add thêm menu theme vào trong view bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share_search, menu);
        return super.onCreateOptionsMenu(menu);
    }
// thao tác bắt sự kiện khi được chọn button trên thanh bar menu vừa tạo
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:
                Toast.makeText(this, "Tôi đã nhấn button setting", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void ButtonCheckbox(String username, String password) {
        if (isRemember) {
            editor = sharedPreferences.edit();
            editor.putString("username", username);// nếu có check ô nhớ thì lưu biến đã login trên foldr huynt75 cái
            editor.putString("password", password);
            editor.commit();
            Toast.makeText(MainActivity_exercise_login.this, "Login thành công", Toast.LENGTH_LONG).show();
        }
    }
    public void FindWigets(){
        userText = findViewById(R.id.edt_username);
        passText = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_login);
        btn_sigin = findViewById(R.id.btn_signup);// giả lập là button thoát hiện ra thông báo yes no
        cbx_remember = findViewById(R.id.chk_1);
    }
}
