package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DescriptionContact extends AppCompatActivity {
    String orgn , desc , rele ;

    TextView org , des , rel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_contact);
        IntiView();
        Intent intent = getIntent();
        orgn = intent.getStringExtra("org");
        desc = intent.getStringExtra("des");
        rele = intent.getStringExtra("rel");
        if (orgn!="" && desc!="" && rele != "")
        {
            SetDataToView();
        }
    }

    protected void IntiView()
    {
        org = findViewById(R.id.ori);
        des = findViewById(R.id.des);
        rel = findViewById(R.id.rel);
    }
    protected void SetDataToView()
    {
        org.setText(orgn);
        des.setText(desc);
        rel.setText(rele);
    }
}
