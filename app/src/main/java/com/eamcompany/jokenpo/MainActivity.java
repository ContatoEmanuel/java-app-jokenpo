package com.eamcompany.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int num = new Random().nextInt(3);

        String[] opcoes={
                "pedra",
                "papel",
                "tesoura"
        };

        String opcaoApp=opcoes[num];

        switch (opcaoApp){
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (opcaoApp=="pedra" && opcaoSelecionada=="tesoura")||
                (opcaoApp=="papel" && opcaoSelecionada=="pedra")||
                (opcaoApp=="tesoura" && opcaoSelecionada=="papel")
        ){
            textoResultado.setText("Você Perdeu!");
        }else if(
                (opcaoApp=="pedra" && opcaoSelecionada=="papel")||
                (opcaoApp=="papel" && opcaoSelecionada=="tesoura")||
                (opcaoApp=="tesoura" && opcaoSelecionada=="pedra")
        ){
            textoResultado.setText("Você Ganhou!");
        }else{
            textoResultado.setText("Empate!");
        }

    }
}