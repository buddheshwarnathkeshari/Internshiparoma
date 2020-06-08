package com.buddheshwar.internshiparoma.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buddheshwar.internshiparoma.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<String> questions;
    private Context context;

    public DataAdapter(Context applicationContext, ArrayList<String> questions, RecyclerView list) {
     this.questions=questions;
     this.context=applicationContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.data_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, final int position) {
       TextView tv=holder.tv;
       ImageView delete=holder.delete;
       tv.setText(questions.get(position));
       delete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               questions.remove(position);
               notifyItemRemoved(position);
               notifyItemRangeChanged(position, questions.size());
           }
       });
    }
    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.txt);
            delete=itemView.findViewById(R.id.delete);
        }
    }
}
