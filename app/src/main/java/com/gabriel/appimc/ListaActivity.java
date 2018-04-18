package com.gabriel.appimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.gabriel.appimc.dao.PessoaDao;
import com.gabriel.appimc.model.Pessoa;

import java.lang.reflect.Array;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private ListView listaImc;
    private Spinner listaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listaImc = findViewById(R.id.lista_imc);
        listaData = findViewById(R.id.lista_datas);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carrgaListas();

        listaImc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pessoa pessoa = (Pessoa) listaImc.getItemAtPosition(position);
                Intent intentMostraDetalhes = new Intent(ListaActivity.this, DetalhesActivity.class);
                intentMostraDetalhes.putExtra("pessoa", pessoa);
                startActivity(intentMostraDetalhes);
            }
        });
    }

    private void carrgaListas() {
        PessoaDao dao = new PessoaDao(this);
        List<Pessoa> pessoas = dao.buscaPessoas();
        List<String> datas = dao.buscarDatas();
        dao.close();


        ArrayAdapter<Pessoa> adapterImc = new ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, pessoas);
        listaImc.setAdapter(adapterImc);
        ArrayAdapter<String> adapterDatas = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        listaData.setAdapter(adapterDatas);
    }
}
