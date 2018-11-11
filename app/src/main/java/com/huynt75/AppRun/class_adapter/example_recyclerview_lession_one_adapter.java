package com.huynt75.AppRun.class_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huynt75.AppRun.class_data.Data_recyclerview_lession_one;
import com.huynt75.test_1.R;

import java.util.List;

public class example_recyclerview_lession_one_adapter extends RecyclerView.Adapter<example_recyclerview_lession_one_adapter.Danhsachbaihocviewholder>{
    private List<Data_recyclerview_lession_one> lst;// list nay lay kieu theo Data_recyclerview_lession_one.java va mang du lieu duoc truyen vao
    // tu contractor duoi;
    private Context mcontext;

    public example_recyclerview_lession_one_adapter(List<Data_recyclerview_lession_one> lst, Context mcontext) {
        this.lst = lst;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public Danhsachbaihocviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(mcontext).inflate(R.layout.example_recyclerview_ver1, viewGroup,false);
        return new Danhsachbaihocviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Danhsachbaihocviewholder danhsachbaihocviewholder, int position) {
      danhsachbaihocviewholder.txt_title.setText(lst.get(position).getTitle());
      danhsachbaihocviewholder.edt_mieuTa.setText(lst.get(position).getMieuTa());

    }

    @Override
    public int getItemCount() {
        return lst.size();
    }


//    @NonNull
//    @Override
//    // ham tao viewholder de luu tru
//    // chu y doi ten RecyclerView.ViewHolder thanh Danhsachbaihocviewholder
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewtype) {//viewType la kieu hien thi cua tung loaij\ view muon hien thi
//        // thang viewgroup la thang ben trong recyclerview no tu dong phat sinh khi new recy
//        View view =LayoutInflater.from(mcontext).inflate(R.layout.example_recyclerview_ver1, viewGroup,false);
//        //viewGroup.addView(view); cach add them
//        // nhu vay thu vi null tai root thi bo lenh addview tren ta thay null = viewGroup
//        // lay ra id cua view vua add tu ham public class Danhsachbaihocviewholder extends RecyclerView.ViewHolder nhes
//
//        return new Danhsachbaihocviewholder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
//// cai nay de dien data
//        Data_recyclerview_lession_one Data_recyclerview_lession_one =lst.get(position);
//        //lst la list data
//        viewHolder.
//
//
//    }
//
//    @Override
//    // tra ve
//    public int getItemCount() {
//
//        return lst.size();
//    }

    //tao 1 view holder de quan ly
    public class Danhsachbaihocviewholder extends RecyclerView.ViewHolder {
        private TextView txt_title, edt_mieuTa;
        public Danhsachbaihocviewholder(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            edt_mieuTa = itemView.findViewById(R.id.edt_mieuta);
        }
    }


}
