package com.example.listadetarefas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> itemList; // Lista de itens
    private ArrayAdapter<String> adapter; // Adaptador para o ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa a lista e o adaptador
        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);

        // Configura o ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // Configura o botão para abrir a tela de adicionar item
        Button addButton = findViewById(R.id.button);
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
            startActivityForResult(intent, 1); // Abre a nova tela com espera de resultado
        });

        // Configura a exclusão de itens ao clicar em um deles
        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            String item = itemList.get(position);
            itemList.remove(position); // Remove o item da lista
            adapter.notifyDataSetChanged(); // Atualiza o ListView
            Toast.makeText(MainActivity.this, "Item removido: " + item, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String newItem = data.getStringExtra("item");
            if (newItem != null && !newItem.isEmpty()) {
                itemList.add(newItem); // Adiciona o novo item à lista
                adapter.notifyDataSetChanged(); // Atualiza o ListView
            }
        }
    }
}
