package com.buddheshwar.internshiparoma.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.buddheshwar.internshiparoma.R;
import com.buddheshwar.internshiparoma.model.NotificationData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder>{
    private Context mcontext;
    private ArrayList<NotificationData> marraylist;
    public NotificationsAdapter(Context context, ArrayList<NotificationData> arraylist){
        mcontext=context;
        marraylist=arraylist;
    }
    @NonNull
    @Override
    public NotificationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.notificationsitems,parent,false);
        return new NotificationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationsViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return marraylist.size();
    }

    public static class NotificationsViewHolder extends RecyclerView.ViewHolder{
        TextView notificationcontent,time;
        ImageView logo;
        public NotificationsViewHolder(@NonNull View itemView) {
            super(itemView);
            notificationcontent=itemView.findViewById(R.id.notificationcontent);
            logo=itemView.findViewById(R.id.notificationlogo);
            time=itemView.findViewById(R.id.notificationtime);

        }
    }
}
