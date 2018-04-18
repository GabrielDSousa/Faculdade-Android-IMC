package com.gabriel.appimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gabriel.appimc.dao.PessoaDao;
import com.gabriel.appimc.helper.FormularioHelper;
import com.gabriel.appimc.model.Pessoa;

public class FormularioActivity extends AppCompatActivity {

    private Button btnCalcular;
    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper = new FormularioHelper(this);
        final PessoaDao dao = new PessoaDao(this);

        instanciaBtnCalcular(dao);
    }

    private void instanciaBtnCalcular(final PessoaDao dao) {
        btnCalcular = findViewById(R.id.formula_calcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa pessoa = helper.getPessoa();
                dao.insere(pessoa);

                String condicao;
                if(pessoa.getImc() < 20.7)
                    condicao = "Abaixo do peso";
                else if(pessoa.getImc() < 26.4)
                    condicao = "No peso normal";
                else if(pessoa.getImc() < 27.8)
                    condicao = "Marginalmente acima do peso";
                else if(pessoa.getImc() < 32.3)
                    condicao = "Acima do peso ideal";
                else
                    condicao = "Obeso";


                Toast.makeText(FormularioActivity.this, pessoa.getNome()+" Seu Imc é: "+pessoa.getImc()+". Sua condição é de "+condicao, Toast.LENGTH_LONG).show();
                finish();

            }
        });
    }
}
