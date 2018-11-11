package com.huynt75.AppRun.class_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huynt75.AppRun.class_data.Data_bai1;
import com.huynt75.AppRun.MainActivity_bai1_remember_createlayoutbycode_recyclerview;
import com.huynt75.test_1.R;


import java.util.List;

public class Adapter_bai1 extends RecyclerView.Adapter<Adapter_bai1.DanhSachData> implements View.OnClickListener {
    public Adapter_bai1(List<Data_bai1> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    private List<Data_bai1> arrayList;
    Context context;


    @Override
    public int getItemViewType(int position) {
        // loc loai viewtype de truyen vao holder
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public DanhSachData onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
       View view = inflater.inflate(R.layout.bai1_remember_createlayoutbycode_recyclerview_ver1,viewGroup,false);
      // tai day co the getItemViewType(int position) de lua chon view muon add vd R.layout.bai1_remember_createlayoutbycode_recyclerview_ver1
        // thong qua swtich (viewType) va cac case cua no
        return new DanhSachData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DanhSachData danhSachData, final int position) {
          danhSachData.txt_view.setText(arrayList.get(position).getSubjectName());
          danhSachData.img.setImageResource(arrayList.get(position).getPicture());
          danhSachData.txt_view.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
              MainActivity_bai1_remember_createlayoutbycode_recyclerview click = new MainActivity_bai1_remember_createlayoutbycode_recyclerview();
 click.onclick(context,position,arrayList);
             // Toast.makeText(context,"toi click vi tri"+position,Toast.LENGTH_SHORT).show();
                  // tai day co the toat cung ok, nhung lam mau chay ra main de thuc thi lenh
              }
          }) ;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();

    }

    @Override
    public void onClick(View v) {

    }

    public class DanhSachData extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txt_view;
    public DanhSachData(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        txt_view = itemView.findViewById(R.id.txt_view);
    }
}
}
