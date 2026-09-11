package com.example.calcimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nome, peso, altura;
    Button calcular, limpar;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.etNome);
        peso = findViewById(R.id.etPeso);
        altura = findViewById(R.id.etAltura);

        calcular = findViewById(R.id.btnCalcular);
        limpar = findViewById(R.id.btnLimpar);

        resultado = findViewById(R.id.tvResultado);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nomeUsuario = nome.getText().toString();
                String pesoTexto = peso.getText().toString();
                String alturaTexto = altura.getText().toString();

                if (nomeUsuario.isEmpty() ||
                        pesoTexto.isEmpty() ||
                        alturaTexto.isEmpty()) {

                    resultado.setText("Preencha todos os campos.");
                    return;
                }

                double pesoUsuario = Double.parseDouble(
                        pesoTexto.replace(",", ".")
                );

                double alturaUsuario = Double.parseDouble(
                        alturaTexto.replace(",", ".")
                );

                double imc = pesoUsuario /
                        (alturaUsuario * alturaUsuario);

                String classificacao;

                if (imc < 18.5) {

                    classificacao = "Abaixo do Peso";

                } else if (imc < 25) {

                    classificacao = "Peso Normal";

                } else if (imc < 30) {

                    classificacao = "Sobrepeso";

                } else if (imc < 35) {

                    classificacao = "Obesidade Grau I";

                } else if (imc < 40) {

                    classificacao = "Obesidade Grau II";

                } else {

                    classificacao = "Obesidade Grau III";
                }

                resultado.setText(
                        "Olá, " + nomeUsuario + "!\n\n" +
                                "Seu IMC é " + String.format("%.2f", imc) + ".\n\n" +
                                "Classificação: " + classificacao + ".\n\n" +
                                "Continue cuidando da sua saúde e mantendo bons hábitos!"
                );
            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nome.setText("");
                peso.setText("");
                altura.setText("");

                resultado.setText("Resultado");
            }
        });
    }
}