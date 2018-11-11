package com.huynt75.AppRun;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.huynt75.AppRun.class_data.Data_bai2;
import com.huynt75.AppRun.class_adapter.Adapter_bai2;
import com.huynt75.AppRun.class_frontend.SpaceItemDecoration;
import com.huynt75.test_1.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_bai2_recyclerview_viewtype extends AppCompatActivity {
    // type bien;
    RecyclerView recyclerView_bai2;
    List<Data_bai2> arrayList;
    Adapter_bai2 adapter_bai2;
    AlertDialog.Builder builder;
    AlertDialog dialog_2;
    EditText editTextDesr, editTextIndex;
    ImageView imageView;
    Button add;
    String description;
    int image, index;
    View viewAlertDialog;
    Button convert_Activity;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2_recyclerview_viewtype);
        convert_Activity = findViewById(R.id.btn_convert_Activity);
        convert_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_bai2_recyclerview_viewtype.this,MainActivity_exercise_login.class);
               startActivity(intent);
            }
        });
        AnhXa();
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com");
        ObjectData();
        AddRecyclerView();

// type noi dung tinh toan


    }

    public  void AddRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity_bai2_recyclerview_viewtype.this,LinearLayoutManager.VERTICAL,false);
        recyclerView_bai2.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration =new DividerItemDecoration(recyclerView_bai2.getContext(),linearLayoutManager.getOrientation());
        recyclerView_bai2.addItemDecoration(dividerItemDecoration);
        recyclerView_bai2.addItemDecoration(new SpaceItemDecoration(20));// toi goi toi class outbound cua package classfrontend ....
        adapter_bai2 = new Adapter_bai2(arrayList,getApplicationContext());
        recyclerView_bai2.setAdapter(adapter_bai2);

    }
// thay vi dung ham trong class nay ta tao 1 class library cua minh va goi toi no
//    public class  SpaceItemDecoration extends ItemDecoration {
//        private int space;
//
//        public SpaceItemDecoration(int space) {
//            this.space = space;
//
//        }
//        @Override
//        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//            super.getItemOffsets(outRect, view, parent, state);
//            outRect.left =space;
//            outRect.bottom=space;
//            outRect.right=space;
//            outRect.top=space;
//        }
//    }

    public void AnhXa(){
        webView = findViewById(R.id.webv_1);
        recyclerView_bai2 = findViewById(R.id.recyclerview_bai2);
    }
    public List ObjectData(){
        arrayList = new ArrayList<>();
        arrayList.add(new Data_bai2("- Bóng đá 11/3 hôm nay ....",R.mipmap.iphone));
        arrayList.add(new Data_bai2("- Thế giới công nghê ....",R.mipmap.huawei));
        arrayList.add(new Data_bai2("- Chuyện làng film holly ....",R.mipmap.samsung));
        arrayList.add(new Data_bai2("- Truyện tranh Kim Dung....",R.mipmap.sony));
        arrayList.add(new Data_bai2("- Công nghệ 4.0 ....",R.mipmap.blackberry));

        return arrayList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bai2_menu_add_update_remove,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //khi flat tren thi bien trong file xml menu tai day se thay duoc
        switch (item.getItemId()){
            case R.id.menu_add:{
                // muc dich toi khi click vao se goi den file xml dien thong tin cua arraylist nhu anh va description
                AddAlertDialog();
// khi goi ham tren de su dung view khac nhap du lieu vao thi cac lenh ben duoi phai tro ve view do moi su dung dc bien
                AnhXaLayoutAlertDialog();
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PullDataAlertDialog();
                        arrayList.add(index,new Data_bai2(description,image));
                        adapter_bai2.notifyItemInserted(index);
                        dialog_2.cancel();// sau khi Alertdialog show va thao tac bam nut add xong thi canlel chi de laij view chinh
                       // Log.i("info", "Hoan thanh them"); kieemr tra code di toi dau
                    }
                });
                break;
            }
            case R.id.menu_Remove:{
                AddAlertDialog();
                AnhXaLayoutAlertDialog();
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PullDataAlertDialog();
                        arrayList.remove(index);
                        adapter_bai2.notifyItemRemoved(index);
                        dialog_2.cancel();
                    }
                });

                break;
            }
            case R.id.menu_Updates:{
                AddAlertDialog();
                AnhXaLayoutAlertDialog();
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PullDataAlertDialog();
                        arrayList.set(index,new Data_bai2(description,image));
                        adapter_bai2.notifyItemChanged(index);
                        dialog_2.cancel();
                    }
                });

                break;
            }
            case R.id.menu_setting:{

                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
    public void AddAlertDialog() {
        // tai day toi se goi set view dien thong tin vao
        builder = new AlertDialog.Builder(MainActivity_bai2_recyclerview_viewtype.this);
        LayoutInflater inflater = LayoutInflater.from(MainActivity_bai2_recyclerview_viewtype.this);
        viewAlertDialog = inflater.inflate(R.layout.bai2_recyclerview_viewtype_three, null);
        builder.setView(viewAlertDialog);
        dialog_2 = builder.create();
        dialog_2.show();
    }
    public void AnhXaLayoutAlertDialog(){
        // bat buoc bien phhai khai bao truoc
        imageView = viewAlertDialog.findViewById(R.id.img_bai2_three);
        editTextIndex=viewAlertDialog.findViewById(R.id.edt_bai2_three_3);
        add =viewAlertDialog.findViewById(R.id.btn_bai2_three_1);
        editTextDesr = viewAlertDialog.findViewById(R.id.edt_bai2_three_2);
    }
    public void PullDataAlertDialog(){
        description = editTextDesr.getText().toString();
        index = Integer.parseInt(editTextIndex.getText().toString());
        image = R.mipmap.blackberry;

    }
}

