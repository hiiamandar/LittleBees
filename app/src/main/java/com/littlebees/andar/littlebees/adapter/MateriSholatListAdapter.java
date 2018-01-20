package com.littlebees.andar.littlebees.adapter;

/**
 * Created by andar on 1/15/18.
 */
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.littlebees.andar.littlebees.R;

public class MateriSholatListAdapter extends RecyclerView.Adapter<MateriSholatListAdapter.ViewHolder> {

    private String[] titles =
            {"Berdiri",
            "Takbiratul Ihram",
            "Iftitah",
            "Alfatihah & Surah Lain",
            "Rukuk",
            "I'tidal",
            "Sujud", "Duduk Antara dua Sujud", "Tahiyat Awal", "Tahiyat Akhir", "Salam"};

    private String[] details =
            {"Tegak lurus, menghadap kiblat",
            "Mengangkat kedua tangan sejajar bahu atau dada", "Membaca salah satu doa iftitah",
            "Diawali dengan Ta'awudz & basmalah", "Punggung lurus, tangan menggenggam lutut",
            "Mengangkat tangan sebagaimana pada takbiratul ihram", "7 anggota badan menempel pada tempat sujud",
            "Duduk di atas kaki kiri yang terlipat", "Jari telunjuk menunjuk kedepan", "Duduk pada lantai",
            "Mengucapkan salam setiap menoleh ke kiri dan ke kanan"};

    private int[] images = {
            R.drawable.berdiri,
            R.drawable.takbir,
            R.drawable.iftitah,
            R.drawable.alfatihahsurat,
            R.drawable.rukuk,
            R.drawable.itidal,
            R.drawable.sujud,
            R.drawable.antara2sujud,
            R.drawable.tahiyatawal,
            R.drawable.tahiyatakhir,
            R.drawable.salam};

    class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        public ImageView iconsholat;
        public TextView detailSholat;
        public TextView subDetaiSholat;

        public ViewHolder(View itemView) {
            super(itemView);
            iconsholat = (ImageView) itemView.findViewById(R.id.thumbnail_sholat);
            detailSholat = (TextView) itemView.findViewById(R.id.detail_sholat);
            subDetaiSholat = (TextView) itemView.findViewById(R.id.sub_deetail_sholat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.materi_sholat_list_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.detailSholat.setText(titles[i]);
        viewHolder.subDetaiSholat.setText(details[i]);
        viewHolder.iconsholat.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


}