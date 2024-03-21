package com.example.btth4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase myDB;
    RecyclerView listSV;
    RecyclerView.Adapter SVAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertSQL();
        setListSV();

    }

    private void insertSQL() {
        myDB = openOrCreateDatabase("KT",MODE_PRIVATE,null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS sinhvien(title1 VARCHAR,title2 VARCHAR,title3 VARCHAR,img VARCHAR);");
        ArrayList<SV> SVs = new ArrayList<>();
        for (int i=1;i<=5;i++){
            myDB.execSQL("INSERT INTO TutorialsPoint VALUES('Lập trình android '+i,'Bài thực hành thứ '+i,'63CNTT4','avatar')");
        }
    }

    public void setListSV(){
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