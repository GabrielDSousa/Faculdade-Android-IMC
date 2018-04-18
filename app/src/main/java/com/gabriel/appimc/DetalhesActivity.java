package com.gabriel.appimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gabriel.appimc.model.Pessoa;

public class DetalhesActivity extends AppCompatActivity {
    private  TextView nomeShow;
    private  TextView dataShow;
    private  TextView pesoShow;
    private  TextView alturaShow;
    private  TextView imcShow;
    private  TextView condicaoShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Intent intent = getIntent();
        Pessoa pessoa = (Pessoa) intent.getSerializableExtra("pessoa");

        nomeShow = findViewById(R.id.detalhes_nome);
        dataShow = findViewById(R.id.detalhes_data);
        pesoShow = findViewById(R.id.detalhes_peso);
        alturaShow = findViewById(R.id.detalhes_altura);
        imcShow = findViewById(R.id.detalhes_imc);

        nomeShow.setText("Nome: "+ pessoa.getNome());
        dataShow.setText("Data: "+ pessoa.getData());
        pesoShow.setText("Peso: " + String.valueOf(pessoa.getPeso()));
        alturaShow.setText("Altura" + String.valueOf(pessoa.getAltura()));
        imcShow.setText("IMC: " + String.valueOf(pessoa.getImc()));
    }
}
