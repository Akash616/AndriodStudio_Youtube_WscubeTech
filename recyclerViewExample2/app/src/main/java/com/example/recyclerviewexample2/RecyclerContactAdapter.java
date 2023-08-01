package com.example.recyclerviewexample2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    //Custom Adapter
    /*Jitni bhi property recycler view ka jo ADAPTER ka hoti hai, woh sari property
    * hamara jo ADAPTER hai follow karna chahiya -  extends RecyclerView.Adapter<VH>
    * <VH> -> View ko jo hold karta hai, usko bolta hai View Holder. Recycler view ka andar jo View
    * bar bar reuse hora hai woh kiska anadar hoga, View Holder ka through. */

    //Inner Class
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtNumber;
        ImageView imgContact;
        //abstract method should be overridden
        //Constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
        }

    }

    //Constructor - for context -> LayoutInflater.from()
    Context context;
    ArrayList<ContactModel> arrContacts;
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;
    }

    /*extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> Why error? -> By default Recycler View ka
    adapter ka andar three (abstract)/overridden method milta hai, onCreateViewHolder(), onBindViewHolder(),
    getItemCount() */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View Holder create hota hai
        /*In Android, jab bhi apko Layout say View generate karwana hai/ya View Inflate karwana hai,
        hum use karta hai, LayoutInflater Class.*/
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Data set hoga means data binding.
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);
    }

    @Override
    public int getItemCount() {
        /*Adapter ko pata bhi toh hona chahiya, kaunsa iska last element hai.
        kab tak scroll chalta rahaga. */
        return arrContacts.size();
    }

}
