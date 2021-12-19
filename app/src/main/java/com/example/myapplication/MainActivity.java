package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class MainActivity extends AppCompatActivity {
   // implementation 'com.google.firebase:firebase-database:20.0.3'
    private EditText name,email,number,ad,nid;
    private Button btn;
    private DatabaseReference df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        number = (EditText) findViewById(R.id.number);
        ad = (EditText) findViewById(R.id.address);
        nid = (EditText) findViewById(R.id.nid);
        btn = (Button) findViewById(R.id.button);
        df = FirebaseDatabase.getInstance().getReference("Data");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString().trim();
                String age1 = email.getText().toString().trim();
                String number1 = number.getText().toString().trim();
                String ad1 = ad.getText().toString().trim();
                String nid1 = nid.getText().toString().trim();
                String key = df.push().getKey();
        df.child(key).setValue("1. Name : "+name1+" 2. Email : "+age1+" 3. Phone Number : "+number1+" 4. Address : "
        +ad1+" 5. NID : "+nid1);
        Toast.makeText(getApplicationContext(), "Data Sent Successfully", Toast.LENGTH_LONG).show();
        name.setText("");
        email.setText("");
        number.setText("");
        ad.setText("");
        nid.setText("");
            }
        });
    }
}