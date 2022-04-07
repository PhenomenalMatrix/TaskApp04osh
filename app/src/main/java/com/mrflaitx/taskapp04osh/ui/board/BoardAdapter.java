package com.mrflaitx.taskapp04osh.ui.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.mrflaitx.taskapp04osh.R;
import com.mrflaitx.taskapp04osh.databinding.ItemBoardBinding;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private int[] imgList = {
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_foreground
    };
    private String[] titleList = {
            "First","Second","Third"
    };
    private String[] subTitle = {
            "FIRST Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "SECOND Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "THIRD Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    };

    private ItemBoardBinding binding;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemBoardBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(imgList[position], titleList[position], subTitle[position]);
    }

    @Override
    public int getItemCount() {
        return imgList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View binding) {
            super(binding);
        }

        public void onBind(int image, String title, String subtitle){
            binding.boardIv.setImageResource(image);
            binding.boardTitleTv.setText(title);
            binding.boardSubtitleTv.setText(subtitle);
        }
    }
}
