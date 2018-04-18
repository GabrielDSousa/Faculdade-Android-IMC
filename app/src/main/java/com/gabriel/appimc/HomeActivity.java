package com.gabriel.appimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button btnImc;
    private Button btnResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        instanciaBtnImc();
        instanciaBtnResultados();
    }


    private void instanciaBtnResultados() {
        btnResultados = findViewById(R.id.resultados);
        btnResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiParaLista = new Intent(HomeActivity.this, ListaActivity.class);
                startActivity(intentVaiParaLista);
            }
        });
    }

    private void instanciaBtnImc() {
        btnImc = findViewById(R.id.btn_imc);
        btnImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiParaFormulario = new Intent(HomeActivity.this, FormularioActivity.class);
                startActivity(intentVaiParaFormulario);
            }
        });
    }
}
