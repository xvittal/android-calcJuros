package com.example.tabalho2;

public class Juros
{
    public Float JurosSimples(Float capital, Float juros, Integer meses)
    {
        return capital+(capital * (juros/100) * meses);
    }
    public Float JurosComposto(Float capital, Float juros, Integer meses)
    {
        Double resultado = (capital * (Math.pow((1+(juros/100)), meses)));
        return Float.parseFloat(resultado.toString());
    }

}
