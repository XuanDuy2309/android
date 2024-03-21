package com.example.btth4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView listSV;
    RecyclerView.Adapter SVAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listSV = findViewById(R.id.listSV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listSV.setLayoutManager(linearLayoutManager);
        ArrayList<SV> SVs = new ArrayList<>();
        for (int i=1;i<=5;i++){
            SVs.add(new SV("Lập trình android "+i,"Bài thực hành thứ "+i,"63CNTT4","avatar"));
        }
        SVAdaptor = new SVAdaptor(SVs);
        listSV.setAdapter(SVAdaptor);

    }
}