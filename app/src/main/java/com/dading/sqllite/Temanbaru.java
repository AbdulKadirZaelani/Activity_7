package com.dading.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dading.sqllite.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class Temanbaru extends AppCompatActivity {
    private TextInputEditText tNama,tTelpon;
    private Button simpanbtn;
    String nm,tlp;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temanbaru);

        tNama = (TextInputEditText)findViewById(R.id.tieNama);
        tTelpon = (TextInputEditText)findViewById(R.id.teiTelpon);
        simpanbtn = (Button)findViewById(R.id.buttonsave);

        simpanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tNama.getText().toString().equals("")||tTelpon.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Data Masih Lengkap !", Toast.LENGTH_SHORT).show();

                }else {
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();

                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("Nama",nm);
                    qvalues.put("Telpon",tlp);

                    controller.insertdata(qvalues);
                    callhome();
                }

            }
        });
    }
    public void callhome(){
        Intent intent = new Intent(Temanbaru.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
