package com.buddheshwar.internshiparoma.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buddheshwar.internshiparoma.R;
import com.buddheshwar.internshiparoma.model.CitiesModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>{
    private Context mcontext;
    private onclicklistener mlistener;
    private ArrayList<CitiesModel> marraylist;
    public interface onclicklistener{
        public void oncityselelected(int position);
    }
    public void setonclicklistener(onclicklistener listener){
        this.mlistener=listener;
    }
    public CitiesAdapter(Context context,ArrayList<CitiesModel> arrayList){
        this.mcontext=context;
        this.marraylist=arrayList;
    }

    @NonNull
    @Override
    public CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.itemforcitiesrecyclerview,parent,false);
        return new CitiesViewHolder(view,mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesViewHolder holder, int position) {
        CitiesModel obj=marraylist.get(position);
        holder.cityname.setText(obj.getCityname());
        holder.cityimage.setImageResource(obj.getCityimageresource());
    }

    @Override
    public int getItemCount() {
        return marraylist.size();
    }

    public static class CitiesViewHolder extends RecyclerView.ViewHolder{
        public ImageView cityimage;
        public TextView cityname;
        public CitiesViewHolder(@NonNull View itemView, final onclicklistener listener) {
            super(itemView);
            cityimage=itemView.findViewById(R.id.cityimage);
            cityname=itemView.findViewById(R.id.cityname);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.oncityselelected(position);
                        }
                    }

                }
            });

        }
    }
}
