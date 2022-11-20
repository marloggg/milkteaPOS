package com.example.marvinsmilkteapos;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuantityDetailsAdapter extends RecyclerView.Adapter<QuantityDetailsAdapter.ViewHolder> {

    QuantityDetailsModel [] quantityDetailsModels;

    public QuantityDetailsAdapter(QuantityDetailsModel [] quantityDetailsModels){
        this.quantityDetailsModels = quantityDetailsModels;
    }

    @NonNull
    @Override
    public QuantityDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cart_item,null,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return (ViewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuantityDetailsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final QuantityDetailsModel data = quantityDetailsModels [position];
        holder.productSize.setText(""+data.getProductSize());
        holder.productQuantity.setText(""+data.getQuantity());
        holder.productUnitPrice.setText(""+data.getUnitPrice());
        holder.productTotalPrice.setText(""+data.getTotal());

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
        return quantityDetailsModels.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView productSize, productQuantity, productUnitPrice, productTotalPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productSize = itemView.findViewById(R.id.productSize);
            productQuantity= itemView.findViewById(R.id.productQuantity);
            productUnitPrice = itemView.findViewById(R.id.productUnitPrice);
            productTotalPrice= itemView.findViewById(R.id.productTotalPrice);
        }

    }
}
