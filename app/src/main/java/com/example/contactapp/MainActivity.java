package com.example.contactapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.contactapp.adapter.RecyclerAdapter;
import com.example.contactapp.datebase.ContactDatebase;
import com.example.contactapp.datebase.ContactUser;
import com.example.contactapp.modual.ContactDetails;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton feb ;
    RecyclerView rec ;
    String name  , phone , ori  , rel  , des  ;
    RecyclerAdapter adapter = new RecyclerAdapter();
    EditText fiel1 , fiel2 , fiel3 , fiel4 , fiel5 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        rec.setLayoutManager(new LinearLayoutManager(this ));
        List<ContactUser> lii = null  ;
        lii = getContactFromDatabaseRoom() ;
        setListToAdapter(lii);
        feb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feb.setClickable(false);
                BuildAlertDialog();
                feb.setClickable(true);
            }
        });
    }


    protected void  InitView()
    {
        rec = findViewById(R.id.recycler_user);
        feb = findViewById(R.id.feb_add);
    }
    protected List<ContactUser> getContactFromDatabaseRoom()
    {
        List<ContactUser> list = new ArrayList<>();
        list = ContactDatebase.getContactDatebaseInstance(this).GetQuery().GetEveryContact();
        return list ;
    }
    protected Long AddContact(ContactUser connt)
    {

        long check = ContactDatebase.getContactDatebaseInstance(this).GetQuery().PutUser(connt);
        return  check ;

    }
    protected void BuildAlertDialog()
    {
        final  View vieww  = LayoutInflater.from(this).inflate(R.layout.dialog_layout , null );
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("ADD CONTACT");
        alertDialog.setMessage("ENTER INFO ADOUT YOU CONTACT : ");
        alertDialog.setView(vieww);
        alertDialog.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getData(vieww);
                if (name.equals("") || phone.equals("") || ori.equals("")|| rel.equals("") || des.equals(""))
                {
                    Toast.makeText(MainActivity.this, "CHECK DATA", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    ContactUser contt = new ContactUser( new ContactDetails(ori , rel , des) , name , phone);
                    Long i =  AddContact(contt);
                    if (i >= 0 )
                    {
                        Toast.makeText(MainActivity.this, "Contact Add Successfully ", Toast.LENGTH_SHORT).show();
                    }
                    dialog.dismiss();
                    List<ContactUser> li = new ArrayList<>();
                    li = getContactFromDatabaseRoom() ;
                    setListToAdapter(li);

                }

            }
        });
        alertDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    protected  void getData(View v )
    {

        fiel1 = v.findViewById(R.id.field1);
        fiel2 = v.findViewById(R.id.field2);
        fiel3 = v.findViewById(R.id.field3);
        fiel4 = v.findViewById(R.id.field4);
        fiel5 = v.findViewById(R.id.field5);
        name = fiel1.getText().toString() ;
        phone = fiel2.getText().toString();
        ori = fiel3.getText().toString();
        rel = fiel4.getText().toString();
        des = fiel5.getText().toString();

    }

    protected void setListToAdapter(List<ContactUser> li )
    {
        adapter.initList(li);
        rec.setAdapter(adapter);
    }


}
