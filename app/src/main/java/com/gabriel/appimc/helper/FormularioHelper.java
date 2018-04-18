package com.gabriel.appimc.helper;

import android.widget.EditText;
import android.widget.TextView;

import com.gabriel.appimc.FormularioActivity;
import com.gabriel.appimc.R;
import com.gabriel.appimc.model.Pessoa;

public class FormularioHelper {
    private final EditText campoNome;
    private final EditText campoData;
    private final EditText campoPeso;
    private final EditText campoAltura;


    private Pessoa pessoa;

    public FormularioHelper(FormularioActivity activity){
        campoNome = activity.findViewById(R.id.formulario_nome);
        campoData = activity.findViewById(R.id.formulario_data);
        campoPeso = activity.findViewById(R.id.formulario_peso);
        campoAltura = activity.findViewById(R.id.formulario_altura);
        pessoa = new Pessoa();
    }

    public Pessoa getPessoa(){
        Double peso = Double.valueOf(String.valueOf(campoPeso.getText()));
        Double altura = Double.valueOf(String.valueOf(campoAltura.getText()));

        pessoa.setNome(campoNome.getText().toString());
        pessoa.setData(campoData.getText().toString());
        pessoa.setPeso(peso);
        pessoa.setAltura(altura);
        pessoa.setImc(peso, altura);

        return pessoa;
    }

}
