package com.networkcallapiapp.retrofitdemoexample.DemoTwo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.networkcallapiapp.retrofitdemoexample.DemoTwo.MainActivityTwo;
import com.networkcallapiapp.retrofitdemoexample.DemoTwo.ModalClass.UserModal;
import com.networkcallapiapp.retrofitdemoexample.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    Context context;
    List<UserModal> allUsersList;

    public UserAdapter(Context context, List<UserModal> allUsersList) {
        this.context = context;
        this.allUsersList = allUsersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_users, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvItem.setText(allUsersList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return allUsersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }
}
