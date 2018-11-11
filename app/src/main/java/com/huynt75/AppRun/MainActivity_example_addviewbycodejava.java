package com.huynt75.AppRun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huynt75.test_1.R;
public class MainActivity_example_addviewbycodejava extends AppCompatActivity {
    Button btn;
    LinearLayout layout_root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_addviewbycodejava);
        btn = findViewById(R.id.btn_add);
        layout_root = findViewById(R.id.layout_root);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = new EditText(MainActivity_example_addviewbycodejava.this);// them moi 1 view
                editText.setText("Huynt75");
                Button button = new Button(MainActivity_example_addviewbycodejava.this);// them moi 1 view
                button.setText("huynt75");
                layout_root.addView(editText);// add them cac doi tuong moi tao ra vao view chinh - rooot
                layout_root.addView(button);
                // còn add 1 view.xml vào view root trong file java
                // khác với add view .xml vào view root xml thì dùng <include........
                LayoutInflater inflater = LayoutInflater.from(MainActivity_example_addviewbycodejava.this);
                LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.example_addviewbycode_version1,null);
                layout_root.addView(layout);
                // group code add 1 view xml da thiet ke san bang code  trong file java con add view trong file xml thi chi can include
            }
        });

    }
}
