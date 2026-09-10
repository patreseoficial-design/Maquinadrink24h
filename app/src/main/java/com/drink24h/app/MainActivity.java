package com.drink24h.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout tela = new LinearLayout(this);
        tela.setOrientation(LinearLayout.VERTICAL);
        tela.setPadding(30, 40, 30, 30);
        tela.setGravity(Gravity.CENTER_HORIZONTAL);
        tela.setBackgroundColor(Color.WHITE);

        TextView titulo = new TextView(this);
        titulo.setText("MÁQUINA DRINK 24H");
        titulo.setTextSize(28);
        titulo.setTextColor(Color.BLACK);
        titulo.setGravity(Gravity.CENTER);
        titulo.setPadding(0, 0, 0, 40);

        tela.addView(titulo);

        TextView instrucao = new TextView(this);
        instrucao.setText("Escolha sua bebida");
        instrucao.setTextSize(20);
        instrucao.setTextColor(Color.DKGRAY);
        instrucao.setGravity(Gravity.CENTER);
        instrucao.setPadding(0, 0, 0, 30);

        tela.addView(instrucao);

        adicionarProduto(
                tela,
                "Água",
                "R$ 3,00",
                20
        );

        adicionarProduto(
                tela,
                "Refrigerante",
                "R$ 6,00",
                15
        );

        adicionarProduto(
                tela,
                "Energético",
                "R$ 10,00",
                10
        );

        setContentView(tela);
    }

    private void adicionarProduto(
            LinearLayout tela,
            String nome,
            String preco,
            int estoque
    ) {

        Button botao = new Button(this);

        botao.setText(
                nome +
                "  -  " +
                preco +
                "\nEstoque: " +
                estoque
        );

        botao.setTextSize(18);

        LinearLayout.LayoutParams parametros =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        120
                );

        parametros.setMargins(0, 10, 0, 10);

        tela.addView(botao, parametros);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(
                        MainActivity.this,
                        "Você escolheu " + nome,
                        Toast.LENGTH_SHORT
                ).show();

            }
        });
    }
}
