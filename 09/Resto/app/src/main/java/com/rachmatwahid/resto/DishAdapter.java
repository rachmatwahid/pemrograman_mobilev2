package com.rachmatwahid.resto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// TODO: 6. Membuat Adapter class
// TODO: 10. Mewariskan RecyclerView.Adapter untuk Adapter class
public class DishAdapter extends RecyclerView.Adapter<DishAdapter.ViewHolder> {

    private int[] dishImages;
    private String[] dishNames;
    private int[] dishPrices;

    private OnItemClickCallback onItemClickCallback;

    // TODO: 7. Membuat constructor untuk Adapter class
    public DishAdapter(int[] images, String[] names, int[] prices) {
        this.dishImages = images;
        this.dishNames = names;
        this.dishPrices = prices;
    }

    // TODO: 11. Melakukan Overriding dari RecyclerView.Adapter
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // TODO: 12. Menggunakan layout setiap item untuk digunakan ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dish_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // TODO: 13. Mengubah konten setiap item sesuai himpunan data
        holder.imageViewDish.setImageResource(dishImages[position]);
        holder.textViewDish.setText(dishNames[position]);
        holder.textViewPrice.setText(String.valueOf(dishPrices[position]));

        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(dishPrices[position]));
    }

    @Override
    public int getItemCount() {
        // TODO: 14. Menentukan banyaknya data
        return dishNames.length;
    }

    // TODO: 8. Membuat ViewHolder class
    public static class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView imageViewDish;
        final TextView textViewDish;
        final TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // TODO: 9. Menghubungkan ViewHolder class dengan View di layout setiap item
            imageViewDish = itemView.findViewById(R.id.imageViewDish);
            textViewDish = itemView.findViewById(R.id.textViewDish);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }

    public void setOnItemClickCallback(OnItemClickCallback callback) {
        this.onItemClickCallback = callback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(int dishPrice);
    }
}
