package com.example.pasakauzd3;

import android.Manifest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Object> viewItems = new ArrayList<>();

    private int REQUEST_READ_EXTERNAL_STORAGE_PERMISSION=1;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_READ_EXTERNAL_STORAGE_PERMISSION);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new Atvaizdavimas(this, viewItems);
        mRecyclerView.setAdapter(mAdapter);

        addItemsFromJSON();

    }

    private void addItemsFromJSON() {
        try {

            String jsonDataString = loadJson();
            JSONArray jsonArray = new JSONArray(jsonDataString);

            for (int i=0; i<jsonArray.length(); ++i) {

                JSONObject itemObj = jsonArray.getJSONObject(i);


                String pirmas = itemObj.getString("PirmasKlausimas");
                String antras = itemObj.getString("AntrasKlausimas");


                JSONArray treciasKlJsonMasyvas = itemObj.getJSONArray("TreciasKlausimas");
                List<String> trecias=new ArrayList<>();

                for (int k=0; k<treciasKlJsonMasyvas.length(); k++) {
                    JSONObject treciasKlJsonObjektas=treciasKlJsonMasyvas.getJSONObject(k);
                    String variantas=treciasKlJsonObjektas.getString("Variantas");
                    trecias.add(variantas);
                }

                JSONArray ketvirtasKlJsonMasyvas = itemObj.getJSONArray("KetvirtasKlausimas");
                List<String> ketvirtas=new ArrayList<>();

                for (int k=0; k<ketvirtasKlJsonMasyvas.length(); k++) {
                    JSONObject ketvirtasKlJsonObjektas=ketvirtasKlJsonMasyvas.getJSONObject(k);
                    String variantas=ketvirtasKlJsonObjektas.getString("Variantas");
                    ketvirtas.add(variantas);
                }

                String penktas = itemObj.getString("PenktasKlausimas");
                String sestas = itemObj.getString("SestasKlausimas");
                String septintas = itemObj.getString("SeptintasKlausimas");

                JSONArray astuntasKlJsonMasyvas = itemObj.getJSONArray("AstuntasKlausimas");
                List<String> astuntas=new ArrayList<>();

                for (int k=0; k<astuntasKlJsonMasyvas.length(); k++) {
                    JSONObject astuntasKlJsonObjektas=astuntasKlJsonMasyvas.getJSONObject(k);
                    String variantas=astuntasKlJsonObjektas.getString("Variantas");
                    astuntas.add(variantas);
                }

                JSONArray devintasKlJsonMasyvas = itemObj.getJSONArray("DevintasKlausimas");
                List<String> devintas=new ArrayList<>();

                for (int k=0; k<devintasKlJsonMasyvas.length(); k++) {
                    JSONObject devintasKlJsonObjektas=devintasKlJsonMasyvas.getJSONObject(k);
                    String variantas=devintasKlJsonObjektas.getString("Variantas");
                    devintas.add(variantas);
                }
                String desimtas = itemObj.getString("DesimtasKlausimas");

                Atsakymai ats = new Atsakymai(pirmas, antras, trecias, ketvirtas, penktas, sestas, septintas, astuntas, devintas, desimtas);
                viewItems.add(ats);
            }

        } catch (JSONException e) {
            Log.d(TAG, "addItemsFromJSON: ", e);
        }
    }


    public String loadJson() {
        String json="";
        try {
            File file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "AnketaAtsakymuJson.json");
            if(file.exists() && file.length()>0) {
                FileInputStream fis = new FileInputStream(file);
                int size = fis.available();
                byte[] buffer = new byte[size];
                fis.read(buffer);
                fis.close();
                json = new String(buffer, "UTF-8");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }


}

