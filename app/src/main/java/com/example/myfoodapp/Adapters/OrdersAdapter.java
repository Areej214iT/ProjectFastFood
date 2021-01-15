package com.example.myfoodapp.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.DatabaseHelper;
import com.example.myfoodapp.DetailActivity;
import com.example.myfoodapp.Models.MainModel;
import com.example.myfoodapp.Models.OrderModels;
import com.example.myfoodapp.OrderActivity;
import com.example.myfoodapp.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewholder> {
    ArrayList<OrderModels> list;
    Context context;

    public OrdersAdapter(ArrayList<OrderModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ordersample , parent , false);

        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final OrderModels model = list.get(position);
        holder.orderImage.setImageResource(model.getOrderimage());
        holder.soldItemName.setText(model.getSoldItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.orderprice.setText(model.getOrderprice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", Integer.parseInt(model.getOrderNumber()));
                intent.putExtra("type", 2);
                context.startActivity(intent);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete Item")
                        .setMessage("Are you sure you want to delete this item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DatabaseHelper helper = new DatabaseHelper(context);
                                if(helper.deleteOrder(model.getOrderNumber()) > 0){
                                    Toast.makeText(context, "Deleted.", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(context, "Error.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                            }
                        }).show();
                return false;

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
    ImageView orderImage;
    TextView orderprice, soldItemName, orderNumber;




        public viewholder(@NonNull View itemView) {
            super(itemView);
            orderImage = itemView.findViewById(R.id.orderimage);
            orderprice = itemView.findViewById(R.id.orderPrice);
            soldItemName = itemView.findViewById(R.id.orderitemname);
            orderNumber = itemView.findViewById(R.id.ordernumber);

        }
    }
}
