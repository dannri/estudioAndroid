package com.example.estudio1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        DatosListView.InicializarArrayList();

        /*ListView*/
        ListView listView = findViewById(R.id.lv_lista1);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, DatosListView.listaPersonas);

        listView.setAdapter(adapter);

        //coger clicks
        listView.setOnItemClickListener((parent, view, position, id) ->
        {
            Toast.makeText(this, "has pulsado " + DatosListView.listaPersonas.get(position), Toast.LENGTH_LONG ).show();
        });

    }
    /*menu contextual*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mi_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.item_1:
                DatosListView.AniadirPersona();
                Toast.makeText(this, "que guay",Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
                return true;
            case R.id.item_2:
                if(DatosListView.EliminarPersona()) {

                    Toast.makeText(this, "borrado", Toast.LENGTH_LONG).show();
                    adapter.notifyDataSetChanged();
                    return true;
                } else {
                    Toast.makeText(this, "bobo hijo", Toast.LENGTH_LONG).show();
                    return true;
                }
            case R.id.anadir_Personalizada:
                intent = new Intent(this, Actividad2.class);
                try{
                    startActivityForResult(intent, 1);
                    return true;
                }catch (ActivityNotFoundException e ){
                    Toast.makeText(this, "no puedes cambiar de pantalla", Toast.LENGTH_LONG).show();
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }

    
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String nombre = data.getStringExtra("nombre");
            if (nombre != null) {
                DatosListView.AnadirPersona(nombre);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Persona añadida: " + nombre, Toast.LENGTH_LONG).show();
            }
        }
    }

}

