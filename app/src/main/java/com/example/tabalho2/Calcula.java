package com.example.tabalho2;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Calcula extends AppCompatActivity
{
    private TextView rCapital;
    private TextView rJuros;
    private TextView rMeses;
    private TextView rJurosSimples;
    private TextView rJurosComposto;
    private Juros cJuros;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcula_exibe);

        Float capital = getIntent().getFloatExtra("Capital",0);
        Float juros = getIntent().getFloatExtra("Juros", 0);
        Integer meses = getIntent().getIntExtra("Meses", 0);

        rCapital = findViewById(R.id.rCapital);
        rJuros = findViewById(R.id.rJuros);
        rMeses = findViewById(R.id.rMeses);

        cJuros = new Juros();
        rJurosSimples = findViewById(R.id.txtJurosSimples);
        rJurosComposto = findViewById(R.id.txtJurosComposto);

        DecimalFormat fSimples = new DecimalFormat("#.##");
        DecimalFormat fComposto = new DecimalFormat("#.##");

        rCapital.setText("CAPITAL INVESTIDO: R$ "+capital.toString());
        rJuros.setText("TAXA DE JUROS: "+juros.toString()+"% ao Mês");
        rMeses.setText("PERÍODO: "+meses.toString()+" mes(es)");


        if (teste(capital.toString(), juros.toString(), meses.toString()))
            rJurosSimples.setText("Valor(es) Inválidos!");
        else
        {
            Double simples = Double.parseDouble(cJuros.JurosSimples(capital, juros, meses).toString());
            rJurosSimples.setText("Montate Juros Simples: R$ "+fSimples.format(simples).replace('.', ','));
            Double composto = Double.parseDouble(cJuros.JurosComposto(capital, juros, meses).toString());
            rJurosComposto.setText("Montate Juros Composto: R$ "+fComposto.format(composto).replace('.',','));
        }

    }
    protected boolean teste(String capital, String juros, String meses)
    {
        if (capital.equals("0.0")||juros.equals("0.0")||meses.equals("0"))
            return true;
        return false;
    }

}
