package com.huynt75.AppRun;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.huynt75.test_1.R;

import static com.huynt75.test_1.R.color.Blue;
import static com.huynt75.test_1.R.color.background_floating_material_dark;

public class MainActivity_vd_thuoccode_method extends AppCompatActivity {
  //  Context context;
Button btn_addView ;
LinearLayout layout_root, layout_child;
ScrollView scrollView;
    LinearLayout layout_root_one;
    TextView txt;
    TableLayout tableLayout;
    TableRow header,row;
    EditText idTxtView;
    TextView rowTv;
    int cot=0;
    int hang =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vd_thuoccode_method);
    AnhXa();
        btn_addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khi click thi goi toi sinh code view tu dong add vao layout root
                // vi du toi muon tao ra 2 liner nam trong scrool view cua layout root
                // trong 1 liner thi co 5 cot trong 1 cot mang view cua layout vd_thuoccode_method_ver1

//                for (int i=0; i<2;i++){
//                    CreateLayout();
//                   for(int j=0;j<5;j++) {
//                    CallLayout();
//                   }
//                    layout_root.addView(layout_root_one);
//                }

                //////////////thay vi viet nhu tren ta viet table xong add drawble la bai vao tung row

               layout_root.addView(CreateTable());


            }
        });



    }
 public void AnhXa(){
     btn_addView = findViewById(R.id.btn_addView);
     layout_root = findViewById(R.id.layout_root);
     layout_child = findViewById(R.id.layout_child);
     scrollView = findViewById(R.id.scrollView);
 }
public void CreateLayout(){
    layout_root_one = new LinearLayout(MainActivity_vd_thuoccode_method.this);
    layout_root_one.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    layout_root_one.setBackgroundColor(getResources().getColor(R.color.Blue));// bat buoc co getResourcees nhe
    layout_root_one.setOrientation(LinearLayout.HORIZONTAL);
    layout_root_one.setWeightSum(5);
}
public void CallLayout(){
    LayoutInflater inflater = LayoutInflater.from(MainActivity_vd_thuoccode_method.this);
    LinearLayout layout_child_one = (LinearLayout) inflater.inflate(R.layout.vd_thuoccode_method_ver1,null);
    layout_child_one.setWeightSum(1);
    layout_root_one.addView(layout_child_one);

}
    public TableLayout CreateTable(){
        tableLayout = new TableLayout(MainActivity_vd_thuoccode_method.this);
      //  tableLayout.setBackgroundColor(getResources().getColor(R.color.Blue));
        tableLayout.setBaselineAligned(true);
// vi du du lieu truyen vao la 2 row 5 cot
        header = new TableRow(MainActivity_vd_thuoccode_method.this);
        for (int i=0;i<2;i++){
            row = new TableRow(MainActivity_vd_thuoccode_method.this);
            for(int j=0;j<5;j++){
                rowTv = new TextView(MainActivity_vd_thuoccode_method.this);
                rowTv.setId(j);
                rowTv.setWidth(200);
                rowTv.setHeight(300);
                rowTv.setBackgroundResource(R.drawable.border_labai_ungdung);
                row.addView(rowTv);

            }
            tableLayout.addView(row);
        }
        return tableLayout;
    }
}

