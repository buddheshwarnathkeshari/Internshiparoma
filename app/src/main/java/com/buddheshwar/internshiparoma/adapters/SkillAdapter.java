package com.buddheshwar.internshiparoma.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.buddheshwar.internshiparoma.R;
import com.buddheshwar.internshiparoma.model.SkillData;
import com.buddheshwar.internshiparoma.resume.ResumeDetails;
import com.buddheshwar.internshiparoma.resume.Skill;

import java.util.ArrayList;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {

    private Context context;
    private ArrayList<SkillData> skillDataArrayList;

    public SkillAdapter(Context context, ArrayList<SkillData> skillDataArrayList, RecyclerView recyclerViewSkill) {
      this.skillDataArrayList=skillDataArrayList;
      this.context=context;
    }

    @NonNull
    @Override
    public SkillAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View view=layoutInflater.inflate(R.layout.skill_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SkillAdapter.ViewHolder holder, final int position) {
        TextView txtTitle=holder.title;
        TextView skillLevel=holder.skillLevel;

        ImageView edit=holder.edit;
        ImageView delete=holder.delete;

        SkillData skillData=skillDataArrayList.get(position);

        txtTitle.setText(skillData.getTitle());
        skillLevel.setText("intermediate");

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fr = new Skill();
                ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.container_resume, fr).addToBackStack(null).commit();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skillDataArrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, skillDataArrayList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return skillDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,skillLevel;
        ImageView delete,edit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.txtTitle);
            skillLevel=itemView.findViewById(R.id.skillLevel);
            delete=itemView.findViewById(R.id.delete);
            edit=itemView.findViewById(R.id.edit);
        }
    }
}
