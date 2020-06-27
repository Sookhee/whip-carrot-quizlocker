package kr.hs.emirim.shookhee.quizlocker.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import kr.hs.emirim.shookhee.quizlocker.R;
import kr.hs.emirim.shookhee.quizlocker.model.User;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ItemViewHolder> {

    // adapter에 들어갈 list 입니다.
    private ArrayList<User> listData = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    public void addItem(User data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvRanking;
        TextView tvNickname;
        TextView tvCarrotCount;
        ImageView ivCarrotProfile;

        ItemViewHolder(View itemView) {
            super(itemView);

            this.tvRanking = (TextView) itemView.findViewById(R.id.ranking_textview);
            this.tvNickname = (TextView) itemView.findViewById(R.id.nickname_textview);
            this.tvCarrotCount = (TextView) itemView.findViewById(R.id.carrot_count_textview);
            this.ivCarrotProfile = (ImageView)itemView.findViewById(R.id.carrot_imageview);
        }

        void onBind(User data) {
            tvRanking.setText((getItemCount() - getAdapterPosition()) + "");
            tvNickname.setText(data.getNickname());
            tvCarrotCount.setText(data.getCarrotCount() + "");

            switch (data.getProfileId()){
                case 1 : ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character01); break;
                case 2 : ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character02); break;
                case 3 : ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character03); break;
                case 4 : ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character04); break;
                case 5 : ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character05); break;
                case 6 : ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character06); break;
                case 7 : ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character07); break;
                case 8 : ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character08); break;
                case 9 : ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character09); break;
                case 10 : ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character10); break;
                default: ivCarrotProfile.setBackgroundResource(R.drawable.carrot_character01);
            }

        }
    }
}
