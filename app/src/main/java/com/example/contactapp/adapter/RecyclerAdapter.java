package com.example.contactapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.DescriptionContact;
import com.example.contactapp.R;
import com.example.contactapp.datebase.ContactUser;
import com.example.contactapp.modual.ContactDetails;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {

    int i = 0 ;

    List<ContactUser> contact = new ArrayList<>();
    public  void initList( List<ContactUser> contact)
    {
        if (i == 1 )
        {
            contact.clear();
            i = i+1 ;
        }
        this.contact = contact ;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_rec , parent , false);
        return new Holder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.name.setText(contact.get(position).getName());
        holder.phone.setText(contact.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        if (contact == null || contact.size() == 0 )
        {
            ContactUser con = new ContactUser();
            con.setName("No Contact Here");
            con.setPhone("Not Founded");
            con.setContactDetails(new ContactDetails("NOT FOUNDED" , "NOT FOUNDED" , "NOT FOUNDED"));
            contact.add(con);
            i = i+1 ;
        }
        return contact.size() ;
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView name , phone ;

        public Holder(@NonNull final View itemView ) {
            super(itemView);
            name = itemView.findViewById(R.id.name_user);
            phone = itemView.findViewById(R.id.phone_user);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext()  , DescriptionContact.class);
                    intent.putExtra("rel" ,
                            contact.get(getAdapterPosition()).getContactDetails().getRelation());
                    intent.putExtra("des" ,
                            contact.get(getAdapterPosition()).getContactDetails().getDescription());
                    intent.putExtra("org" ,
                            contact.get(getAdapterPosition()).getContactDetails().getOrgnization());

                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}
