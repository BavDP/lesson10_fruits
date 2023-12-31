package com.dnipro.beldii.lesson10.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dnipro.beldii.lesson10.R;
import com.dnipro.beldii.lesson10.model.Fruit;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private ArrayList<Fruit> fruits;
    private View.OnClickListener itemClick;

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private final View item;
        private final TextView fruitNameTextView;
        private final TextView familyTextView;
        private final TextView orderTextView;
        private final TextView genusTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView;
            fruitNameTextView = itemView.findViewById(R.id.fruitName);
            orderTextView = itemView.findViewById(R.id.order);
            familyTextView = itemView.findViewById(R.id.family);
            genusTextView = itemView.findViewById(R.id.genus);
        }

        public void bind(Fruit data) {
            this.fruitNameTextView.setText(data.getName());
            this.orderTextView.setText(data.getOrder());
            this.familyTextView.setText(data.getFamily());
            this.genusTextView.setText(data.getGenus());
        }

        public void setClickHandler(View.OnClickListener clickHandler, Fruit fruit) {
            this.item.setOnClickListener(clickHandler);
            this.item.setTag(fruit);
        }
    }

    public FruitAdapter(ArrayList<Fruit> fruits) {
        super();
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = this.fruits.get(position);
        holder.bind(fruit);
        holder.setClickHandler(itemClick, fruit);
    }

    public void setClickListener(View.OnClickListener clickListener) {
        this.itemClick = clickListener;
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }
}
