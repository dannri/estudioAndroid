package com.example.estudio1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_actividad2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText_per);


        button.setOnClickListener(v->{
                    Intent intent= new Intent(this,MainActivity.class);
                    intent.putExtra("nombre", editText.getText().toString());

        Toast.makeText(this, "añadido correctamente", Toast.LENGTH_LONG).show();

        try{
            setResult(RESULT_OK, intent);
            finish();

        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "ha fallado", Toast.LENGTH_LONG).show();
        }
        });
    }
}