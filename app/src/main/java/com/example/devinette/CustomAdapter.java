package com.example.devinette;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList  devinette_title,score,player_id;

    CustomAdapter(Context context, ArrayList player_id, ArrayList devinette_title, ArrayList score ){
       // this.activity = activity;
       // this.player_id=player_id;
        this.context = context;
        this.devinette_title = devinette_title;
        this.score = score;

    }


        @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.myrow, parent, false);
            return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      //  holder.player_id.setText(String.valueOf(id.get(position)));
        holder.devinette_title.setText(String.valueOf(devinette_title.get(position)));
        holder.score.setText(String.valueOf(score.get(position)));

    }

    @Override
    public int getItemCount() {
        return devinette_title.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView devinette_title,score,player_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
         //   player_id=itemView.findViewById(R.id.player_id);
            devinette_title=itemView.findViewById(R.id.devinette_title);
            score=itemView.findViewById(R.id.score);
        }
    }
}


