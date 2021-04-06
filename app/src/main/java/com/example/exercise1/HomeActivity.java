package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    SearchView searchView;

    private ListView list;

    private ListViewAdapter adapter;

    String[] listnama;

    public static ArrayList<com.example.exercise1.ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();

    Intent intent;

    ArrayAdapter<String> arrayAdapter;

    String namaKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchView = findViewById(R.id.search_bar);

        listnama = new String[]{"Beni", "Dita", "Rubi", "Agil", "Luki",
                "Alin", "Yuzi"};


        arrayAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, android.R.id.text1, listnama);
        list = findViewById(R.id.ListKontak);

        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listnama.length; i++) {
            com.example.exercise1.ClassNama classNama = new com.example.exercise1.ClassNama(listnama[i]);
            classNamaArrayList.add(classNama);
            adapter = new ListViewAdapter(this);
            list.setAdapter(arrayAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    namaKontak = classNamaArrayList.get(position).getNama();

                    bundle.putString("a", namaKontak.trim());
                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                    pm.setOnMenuItemClickListener(HomeActivity.this);
                    pm.inflate(R.menu.popup_menu);
                    pm.show();

                }
            });
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    HomeActivity.this.arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    HomeActivity.this.arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId()) {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                String nomor = namaKontak.trim();
                String  isinomor = "";
                if (nomor == "Beni"){
                    isinomor ="082378557815";
                }
                else if (nomor == "Dita"){
                    isinomor ="082378557815";
                }
                else if (nomor == "Rubi"){
                    isinomor ="082378557815";
                }
                else if (nomor == "Agil"){
                    isinomor ="082378557815";
                }
                else if (nomor == "Luki"){
                    isinomor ="082378557815";
                }
                else if (nomor == "Alin"){
                    isinomor ="082378557815";
                }
                else if (nomor == "Yuzi"){
                    isinomor ="082378557815";
                }

                Toast.makeText(getApplicationContext(), isinomor,
                        Toast.LENGTH_LONG).show();
                break;

        }
        return false;
    }
}


