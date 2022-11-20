package com.example.marvinsmilkteapos;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuantityAdapter extends RecyclerView.Adapter<QuantityAdapter.ViewHolder> {

    QuantityModel[] quantityModels;

    public QuantityAdapter(QuantityModel[] quantityModels) {
        this.quantityModels = quantityModels;
    }

    @NonNull
    @Override
    public QuantityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sales_item, null, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return (ViewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuantityAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final QuantityModel data = quantityModels[position];
        holder.pid1.setText("" + data.getId());
        holder.pamount.setText("" + data.getTotalAmount());
        holder.pdate.setText("" + data.getOrderDate());
        holder.pcashier.setText("" + data.getCashier());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                Toast.makeText(holder.itemView.getContext(),"ITEM POSITION: "+ position, Toast.LENGTH_LONG).show();
                                DefaultData.cartList.remove(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quantityModels.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView pid1, pamount, pdate, pcashier;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pid1 = itemView.findViewById(R.id.pid1);
            pamount = itemView.findViewById(R.id.pamount);
            pdate = itemView.findViewById(R.id.pdate);
            pcashier = itemView.findViewById(R.id.pcashier);
        }

    }
}