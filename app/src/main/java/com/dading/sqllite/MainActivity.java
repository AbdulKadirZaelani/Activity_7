package com.dading.sqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dading.sqllite.adapter.TemanAdapter;
import com.dading.sqllite.database.DBController;
import com.dading.sqllite.database.teman;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TemanAdapter adapter;
    private ArrayList<teman> temanArrayList;
    DBController controller = new DBController(this);
    String id,nm,tlp;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingbtn);
        BacaData();
        adapter = new TemanAdapter(temanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Temanbaru.class);
                startActivity(intent);
            }
        });

    }
    public  void BacaData(){
        ArrayList<HashMap<String,String>> daftarTeman = controller.getallTeman();
        temanArrayList = new ArrayList<>();
         for (int i=0;i<daftarTeman.size();i++){
             teman teman = new teman();

             teman.setId(daftarTeman.get(i).get("id").toString());
             teman.setId(daftarTeman.get(i).get("nama").toString());
             teman.setId(daftarTeman.get(i).get("telpon").toString());
             temanArrayList.add(teman);
         }
    }
}
