package com.example.tabalho2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    private EditText Capital;
    private EditText Juros;
    private EditText Meses;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Capital = findViewById(R.id.edtCapital);
        Juros = findViewById(R.id.edtJuros);
        Meses = findViewById(R.id.edtMeses);
    }
    public void CalculaExibe(View view)
    {
        Valida(Capital.getText().toString(), Juros.getText().toString(), Meses.getText().toString());
        Bagagem(Capital.getText().toString(), Juros.getText().toString(), Meses.getText().toString());
    }
    public void Bagagem(String capital, String juros, String meses){
        Intent exibeCalculo = new Intent(this, Calcula.class);

        exibeCalculo.putExtra("Capital", Float.parseFloat(capital));
        exibeCalculo.putExtra("Juros", Float.parseFloat(juros));
        exibeCalculo.putExtra("Meses", Integer.parseInt(meses));

        startActivity(exibeCalculo);
    }
    public void Valida(String capital, String juros, String meses)
    {
        if(capital.isEmpty())
            Capital.setText("0");
        if(juros.isEmpty())
            Juros.setText("0");
        if (meses.isEmpty())
            Meses.setText("0");
    }
    public void Limpa(View view)
    {
        Capital.setText("");
        Capital.setHint("Ex: 1200,50");
        Juros.setText("");
        Juros.setHint("Taxa de juros (% ao mes)");
        Meses.setText("");
        Meses.setHint("Número de meses");
    }

}