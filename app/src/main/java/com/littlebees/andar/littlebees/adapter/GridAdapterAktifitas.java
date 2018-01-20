package com.littlebees.andar.littlebees.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.littlebees.andar.littlebees.EvaluasiSholatActivity;
import com.littlebees.andar.littlebees.DataSholat;
import com.littlebees.andar.littlebees.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andar on 1/2/18.
 */

public class GridAdapterAktifitas extends RecyclerView.Adapter<GridAdapterAktifitas.ViewHolder> {

    List<EndangeredItemAktifitas> mItems1;

    public GridAdapterAktifitas() {
        super();
        mItems1= new ArrayList<EndangeredItemAktifitas>();
        EndangeredItemAktifitas nama1 = new EndangeredItemAktifitas();
        nama1.setName("SHOLAT");
        nama1.setThumbnail(R.drawable.sholat);
        mItems1.add(nama1);

        nama1 = new EndangeredItemAktifitas();
        nama1.setName("Qur'an");
        nama1.setThumbnail(R.drawable.quran);
        mItems1.add(nama1);

        nama1 = new EndangeredItemAktifitas();
        nama1.setName("Doa");
        nama1.setThumbnail(R.drawable.doa);
        mItems1.add(nama1);

        nama1 = new EndangeredItemAktifitas();
        nama1.setName("Sedekah");
        nama1.setThumbnail(R.drawable.sedekah);
        mItems1.add(nama1);

        nama1 = new EndangeredItemAktifitas();
        nama1.setName("Akhlaq");
        nama1.setThumbnail(R.drawable.akhlaq);
        mItems1.add(nama1);

        nama1 = new EndangeredItemAktifitas();
        nama1.setName("Bermain");
        nama1.setThumbnail(R.drawable.bermain);
        mItems1.add(nama1);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup1, int i) {
        View v = LayoutInflater.from(viewGroup1.getContext())
                .inflate(R.layout.card_view_aktifitas, viewGroup1, false);
        ViewHolder viewHolder1 = new ViewHolder(v);
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder1, int i) {
        EndangeredItemAktifitas nature = mItems1.get(i);
        viewHolder1.tvspecies1.setText(nature.getName());
        viewHolder1.imgThumbnail1.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems1.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {


        public ImageView imgThumbnail1;
        public TextView tvspecies1;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail1 = (ImageView)itemView.findViewById(R.id.sholat_box);
            tvspecies1 = (TextView)itemView.findViewById(R.id.judul_topik);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent;
            int Pos = getAdapterPosition();
            switch(Pos){
                case 0:
                    intent = new Intent(v.getContext(), EvaluasiSholatActivity.class);
                    v.getContext().startActivity(intent);
                    break;
            }

        }
    }
}