package com.buddheshwar.internshiparoma.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buddheshwar.internshiparoma.R;
import com.buddheshwar.internshiparoma.model.InternshipData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InternshipsAdapter extends RecyclerView.Adapter<InternshipsAdapter.InternshipsViewHolder>{
    private Context mcontext;
    private ArrayList<InternshipData> marraylist;
    public InternshipsAdapter(Context context,ArrayList<InternshipData> arraylist){
        this.mcontext=context;
        this.marraylist=arraylist;
    }
    @NonNull
    @Override
    public InternshipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.forinternships,parent,false);
        return new InternshipsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InternshipsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return marraylist.size();
    }

    public static class InternshipsViewHolder extends RecyclerView.ViewHolder{
        TextView domain,company,stipend,location,duration;
        ImageView logo;
        public InternshipsViewHolder(@NonNull View itemView) {
            super(itemView);
            domain=itemView.findViewById(R.id.internshipdomain);
            company=itemView.findViewById(R.id.internshipcompanyname);
            stipend=itemView.findViewById(R.id.internshipstipend);
            location=itemView.findViewById(R.id.internshiplocation);
            duration= itemView.findViewById(R.id.internshipduration);
            logo=itemView.findViewById(R.id.companylogo);
        }
    }
}
