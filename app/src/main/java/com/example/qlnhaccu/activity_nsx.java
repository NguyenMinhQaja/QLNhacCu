package com.example.qlnhaccu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qlnhaccu.adapter.AdapterNSX;
import com.example.qlnhaccu.dao.NSXDAO;
import com.example.qlnhaccu.database.database;
import com.example.qlnhaccu.model.NSX;

import java.util.ArrayList;
import java.util.List;

public class activity_nsx extends AppCompatActivity {
    private ListView lvNSX;
    private List<NSX> ListNSX;
    private NSXDAO nsxdao;
    private AdapterNSX adapterNSX;
    private ImageButton imgDeleteNSX;
    com.example.qlnhaccu.database.database database;
    NSX nsx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nsx);

        //Ánh xạ
        lvNSX = (ListView) findViewById(R.id.lv_nsx);

        ListNSX = new ArrayList<NSX>();
        nsxdao = new NSXDAO(activity_nsx.this);
        ListNSX = nsxdao.getAllNSX();

        adapterNSX = new AdapterNSX(getApplicationContext(),ListNSX);
        lvNSX.setAdapter(adapterNSX);

        SuKien_ListView();

    }

    private void SuKien_ListView() {
        lvNSX.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NSX nsx = ListNSX.get(position);
                Intent intent = new Intent(activity_nsx.this,EditNSX.class);
                intent.putExtra("DU LIEU", nsx);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option_nsx, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.btn_them_nsx)
        {
            Intent intent = new Intent(activity_nsx.this,AddNsxActivity.class);
            startActivity(intent);
        }
        if(id == R.id.btn_thoat_nsx)
        {
            finish();
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListNSX.clear();
        ListNSX.addAll(nsxdao.getAllNSX());
        adapterNSX.notifyDataSetChanged();
    }
}