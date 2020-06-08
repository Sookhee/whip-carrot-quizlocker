package kr.hs.emirim.shookhee.quizlocker;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ItemViewHolder> {

    private ArrayList<Carrot> listData = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.collect_carrot_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));

        Carrot carrot = listData.get(position);

        holder.name = carrot.getName();
        holder.info = carrot.getInfo();
        holder.img = carrot.getImgId();
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
        int img;
        private ImageView ivCarrotImg;

        ItemViewHolder(View itemView) {
            super(itemView);
            ivCarrotImg = itemView.findViewById(R.id.item_img);
            ivCarrotImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), CollectionInfoAcivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("info", info);
                    intent.putExtra("img", img);
                    v.getContext().startActivity(intent);
                }
            });
        }

        void onBind(Carrot data) {
            ivCarrotImg.setImageResource(data.getImgId());
        }
    }
}