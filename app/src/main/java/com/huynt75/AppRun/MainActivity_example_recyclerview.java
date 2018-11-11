package com.huynt75.AppRun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.huynt75.AppRun.class_adapter.example_recyclerview_lession_one_adapter;
import com.huynt75.AppRun.class_data.Data_recyclerview_lession_one;
import com.huynt75.test_1.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_example_recyclerview extends AppCompatActivity {
// type bien;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_recyclerview);

// type noi dung tinh toan
        List<Data_recyclerview_lession_one> lst = new ArrayList();
//        lst.add(new Data_recyclerview_lession_one("Bai 1", "Toi muon hoc android 1"));
//        lst.add(new Data_recyclerview_lession_one("Bai 2", "Toi muon hoc android 2"));
//        lst.add(new Data_recyclerview_lession_one("Bai 3", "Toi muon hoc android 3"));
//        lst.add(new Data_recyclerview_lession_one("Bai 4", "Toi muon hoc android 4"));
//        lst.add(new Data_recyclerview_lession_one("Bai 5", "Toi muon hoc android 4"));
//        lst.add(new Data_recyclerview_lession_one("Bai 6", "Toi muon hoc android 4"));
//        lst.add(new Data_recyclerview_lession_one("Bai 7", "Toi muon hoc android 4"));
//        lst.add(new Data_recyclerview_lession_one("Bai 8", "Toi muon hoc android 4"));
//        lst.add(new Data_recyclerview_lession_one("Bai 9", "Toi muon hoc android 4"));
//        lst.add(new Data_recyclerview_lession_one("Bai 10", "Toi muon hoc android 4"));
//        lst.add(new Data_recyclerview_lession_one("Bai 11", "Toi muon hoc android 4"));
        lst.add(new Data_recyclerview_lession_one("Huy","1"));
        lst.add(new Data_recyclerview_lession_one("Hảo","1"));
        lst.add(new Data_recyclerview_lession_one("Vương","1"));
        lst.add(new Data_recyclerview_lession_one("Khoa","2"));
        lst.add(new Data_recyclerview_lession_one("Đông","2"));
        lst.add(new Data_recyclerview_lession_one("Bửu","2"));
        recyclerView= findViewById(R.id.rcv_1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        // co 2 cach hien thi liner hay grid nhe
      //  GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);// ding nghia them so cot do grid
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new example_recyclerview_lession_one_adapter(lst,getApplicationContext()));
        }

    }

