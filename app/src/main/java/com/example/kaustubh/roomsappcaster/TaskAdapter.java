package com.example.kaustubh.roomsappcaster;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.kaustubh.roomsappcaster.databinding.ContentMainBinding;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context ctx;
    private List<Task> taskList;

    public TaskAdapter(Context ctx) {
        this.ctx = ctx;
    }

    void setData(List<Task> taskList){
        this.taskList = taskList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if(layoutInflater==null){
            layoutInflater = LayoutInflater.from(ctx);
        }
        ContentMainBinding binding = DataBindingUtil.inflate(layoutInflater,R.layout.content_main,viewGroup,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.binding.content.setText(taskList.get(i).getValue());
    }

    @Override
    public int getItemCount() {
        if(taskList!=null)
            return taskList.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ContentMainBinding binding;

        public ViewHolder(@NonNull ContentMainBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }
    }
}
