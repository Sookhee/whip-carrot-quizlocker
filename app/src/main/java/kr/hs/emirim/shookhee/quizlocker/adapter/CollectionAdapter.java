package kr.hs.emirim.shookhee.quizlocker.adapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.hs.emirim.shookhee.quizlocker.CollectionDetailActivity;
import kr.hs.emirim.shookhee.quizlocker.CollectionPopupActivity;
import kr.hs.emirim.shookhee.quizlocker.LoginActivity;
import kr.hs.emirim.shookhee.quizlocker.R;
import kr.hs.emirim.shookhee.quizlocker.model.Carrot;


public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ItemViewHolder> {

    private ArrayList<Carrot> listData = new ArrayList<>();
    int userCarrot = ((LoginActivity)LoginActivity.mContext).postCarrotCount();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));

        holder.carrotPosition = position+1;

        Carrot carrot = listData.get(position);

        // 정보 전달.
        holder.name = carrot.getName();
        holder.info = carrot.getInfo();
        holder.img = carrot.getImgId();
        holder.unlockCount = carrot.getUnlockCount();

        Log.e("CARROT", userCarrot + "");

        if(userCarrot < carrot.getUnlockCount()) {
            holder.ivCarrotImg.setImageResource(R.drawable.icon_question);
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void addItem(Carrot data) {
        listData.add(data);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        String name;
        String info;
        int carrotPosition = 0;
        int img, unlockCount = 100;

        private ImageView ivCarrotImg;

        ItemViewHolder(View itemView) {
            super(itemView);
            ivCarrotImg = itemView.findViewById(R.id.item_img);
            ivCarrotImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(userCarrot >= unlockCount) {
                        Intent intent = new Intent(v.getContext(), CollectionDetailActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("info", info);
                        Log.e("INFO", info);
                        intent.putExtra("img", img);
                        intent.putExtra("carrotPosition", carrotPosition);
                        v.getContext().startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(v.getContext(), CollectionPopupActivity.class);
                        intent.putExtra("메시지", "정답 "+ unlockCount +"개 이상.");
                        v.getContext().startActivity(intent);
                    }
                }
            });
        }

        void onBind(Carrot data) {
            ivCarrotImg.setImageResource(data.getImgId());
        }
    }

}