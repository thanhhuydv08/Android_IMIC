package com.huynt75.AppRun.class_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huynt75.AppRun.class_data.Data_bai2;
import com.huynt75.test_1.R;

import java.util.List;

public class Adapter_bai2 extends RecyclerView.Adapter<Adapter_bai2.DanhSachBai2> {

    List<Data_bai2> arraList;
    Context context;

    public Adapter_bai2() {
    }

    public Adapter_bai2(List<Data_bai2> arraList, Context context) {
        this.arraList = arraList;
        this.context = context;
    }

    @Override// muốn over chi cần click phải + generat_override method--> chon method can override nhe
    public int getItemViewType(int position) {
        if((position+2)%2==0){
            return 0;
        }else return 1;

    }

    @NonNull

    @Override
    public DanhSachBai2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        if(viewType ==0){
            view =inflater.inflate(R.layout.bai2_recyclerview_viewtype_one,viewGroup,false);
        }else {view=inflater.inflate(R.layout.bai2_recyclerview_viewtype_two,viewGroup,false);}

        return new DanhSachBai2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachBai2 danhSachBai2, int position) {
        danhSachBai2.imageView.setImageResource(arraList.get(position).getPicture());
        danhSachBai2.textView.setText(arraList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return arraList.size();
    }

    public class DanhSachBai2 extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public DanhSachBai2(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.img_bai2);
            textView = itemView.findViewById(R.id.txtv_bai2_desc);

        }
    }

}
