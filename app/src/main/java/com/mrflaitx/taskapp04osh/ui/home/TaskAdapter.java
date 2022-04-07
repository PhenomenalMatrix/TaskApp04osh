package com.mrflaitx.taskapp04osh.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrflaitx.taskapp04osh.R;
import com.mrflaitx.taskapp04osh.model.TaskModel;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<TaskModel> list = new ArrayList<>();
    private OnItemClick listener;

    public void setTask(TaskModel task){
        list.add(task);
        notifyDataSetChanged();
    }

    public void setTaskList(List<TaskModel> taskList){
        list.clear();
        list.addAll(taskList);
        notifyDataSetChanged();
    }

    public void setListener(OnItemClick listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,
                parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.itemView.setOnClickListener(v ->{
            listener.onClick(list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        public ViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.item_tv);
        }

        public void onBind(TaskModel task) {
            title.setText(task.getTask());
        }
    }

    interface OnItemClick{
        void onClick(TaskModel task);
    }
}
