package com.example.lalumomena;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lalumomena.model.Anjing;
import com.example.lalumomena.model.Hewan;
import com.example.lalumomena.model.Kucing;
import com.example.lalumomena.model.Ular;

import java.util.List;
public class HewanActivity extends AppCompatActivity {

    public final static String HEWAN_TERPILIH ="hewan_obj_key";
    List<Hewan> hewans;
    ListView listView;
    String jenisHewan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_profile_hewan);
        Intent intent = getIntent();
        jenisHewan = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        hewans = DataProvider.getHewansByTipe(this,jenisHewan);
        // sesuaikan judul
        TextView txJudulList = findViewById(R.id.text_title_daftar);
        String judul="";
        if (hewans.get(0) instanceof Kucing) {
            judul = getString(R.string.kucing);
        } else if (hewans.get(0) instanceof Ular) {
            judul = getString(R.string.ular);
        } else if (hewans.get(0) instanceof Anjing) {
            judul = getString(R.string.anjing);
        }
        txJudulList.setText(judul);
        setupListView();
    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_hewan);
        HewanAdapter adapter = new HewanAdapter(this,hewans);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Hewan terpilih = hewans.get(position);
            bukaProfileHewan(terpilih);
        }
    };

    private void bukaProfileHewan(Hewan hewanT) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, DetailHewan.class);
        intent.putExtra(HEWAN_TERPILIH, hewanT);
        startActivity(intent);
    }
}
