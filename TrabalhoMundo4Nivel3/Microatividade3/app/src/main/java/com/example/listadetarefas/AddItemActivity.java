package com.example.listadetarefas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        // Campo de texto para o item
        EditText itemEditText = findViewById(R.id.itemEditText);

        // Botão para adicionar o item
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v -> {
            String item = itemEditText.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("item", item); // Retorna o item para a MainActivity
            setResult(RESULT_OK, resultIntent);
            finish(); // Fecha a tela
        });
    }
}
