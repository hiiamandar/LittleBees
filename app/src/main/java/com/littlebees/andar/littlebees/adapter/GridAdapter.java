package com.littlebees.andar.littlebees.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.littlebees.andar.littlebees.MateriSholatActivity;
import com.littlebees.andar.littlebees.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andar on 1/2/18.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    List<EndangeredItem> mItems;

    public GridAdapter() {
        super();
        mItems = new ArrayList<EndangeredItem>();
        EndangeredItem nama = new EndangeredItem();
        nama.setName("Sholat Bersama Anak");
        nama.setThumbnail(R.drawable.sholatbg);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Membina Rumah Qur'ani");
        nama.setThumbnail(R.drawable.quranbg);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Bermain Bersama Anak");
        nama.setThumbnail(R.drawable.bermainbg);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Yasin Ayat 1-100");
        nama.setThumbnail(R.drawable.sholatbg);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Gemar Bersedekah");
        nama.setThumbnail(R.drawable.quranbg);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Membacakan Sejarah dan Kisah");
        nama.setThumbnail(R.drawable.bermainbg);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Yasin Ayat 1-100");
        nama.setThumbnail(R.drawable.sholatbg);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Maidah Ayat 1-10");
        nama.setThumbnail(R.drawable.bermainbg);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("Surat Al-Baqoroh Ayat 1-10");
        nama.setThumbnail(R.drawable.quranbg);
        mItems.add(nama);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_beranda, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EndangeredItem nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {


        public ImageView imgThumbnail;
        public TextView tvspecies;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.image_home);
            tvspecies = (TextView)itemView.findViewById(R.id.judul);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent;
            int Pos = getAdapterPosition();
            switch(Pos){
                case 0:
                    intent = new Intent(v.getContext(), MateriSholatActivity.class);
                    v.getContext().startActivity(intent);
                    break;
            }

        }
    }
}