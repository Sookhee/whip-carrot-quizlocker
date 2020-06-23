package kr.hs.emirim.shookhee.quizlocker;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.hs.emirim.shookhee.quizlocker.model.Carrot;


public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ItemViewHolder> {

    private ArrayList<Carrot> listData = new ArrayList<>();
    // 사용자 당근 개수 (임시)
    int userCarrot = 90;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collection, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));

        Carrot carrot = listData.get(position);

        // 정보 전달.
        holder.name = carrot.getName();
        holder.info = carrot.getInfo();
        holder.img = carrot.getImgId();
        holder.unlockCount = carrot.getUnlockCount();

        if(userCarrot < carrot.getUnlockCount()) {
            holder.ivCarrotImg.setImageResource(R.drawable.icon_question);
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    void addItem(Carrot data) {
        listData.add(data);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        String name;
        String info;
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
                        intent.putExtra("img", img);
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