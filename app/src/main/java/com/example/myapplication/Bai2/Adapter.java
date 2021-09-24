package com.example.myapplication.Bai2;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Bai1.DetailHoa1;
import com.example.myapplication.Bai1.ListFlower;
import com.example.myapplication.R;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.MusicViewHolder> {
    List<Music> musicList;
   Context context;

    public Adapter(List<Music> musicList, Context context) {
        this.musicList = musicList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_item, parent, false);

        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {

        Music music = musicList.get(position);
            holder.imgMusic.setImageResource(music.getImgSing());
            holder.tvSingName.setText(music.getSingName());
            holder.tvSingerName.setText(music.getSingerName());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(context, MainActivity.class);

                Pair[] pair = new Pair[3];
                pair[0] = new Pair<View, String>( holder.imgMusic,"img_sing");
                pair[1] = new Pair<View, String>( holder.tvSingerName,"singer_name");
                pair[2] = new Pair<View, String>( holder.tvSingName,"sing_name");
                Bundle bundle=  new Bundle();


                bundle.putSerializable("obj", music);

                shareIntent.putExtras(bundle);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context, pair);
                context.startActivity(shareIntent, options.toBundle());

            }
        });

    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imgMusic;
        private LinearLayout layout;
        private TextView tvSingName, tvSingerName;
        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            imgMusic = itemView.findViewById(R.id.img_music);
            tvSingerName = itemView.findViewById(R.id.singer_name);
            tvSingName = itemView.findViewById(R.id.sing_name);
        }
    }
}
