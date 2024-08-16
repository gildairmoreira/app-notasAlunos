package com.gildair.calculadoradenotas;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText n1,n2,n3,n4,NumeroFaltas;
    private Button btCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        n1 = findViewById(R.id.nota1);
        n2 = findViewById(R.id.nota2);
        n3 = findViewById(R.id.nota3);
        n4 = findViewById(R.id.nota4);
        NumeroFaltas = findViewById(R.id.numeroFaltas);
        btCalcular = findViewById(R.id.bt_calcular);
        txtResultado = findViewById(R.id.txt_resultado);


        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nota1 = Integer.parseInt(n1.getText().toString());
                int nota2 = Integer.parseInt(n2.getText().toString());
                int nota3 = Integer.parseInt(n3.getText().toString());
                int nota4 = Integer.parseInt(n4.getText().toString());
                int numero_faltas = Integer.parseInt(NumeroFaltas.getText().toString());

                int media = (nota1 + nota2 + nota3 + nota4) / 4;

                if (media >= 5 && numero_faltas <= 20) {
                    txtResultado.setText("Aluno Foi Aprovado \n" + "Média Final: " + media);
                    txtResultado.setTextColor(getColor(R.color.green));
                } else if (numero_faltas > 20){
                    txtResultado.setText("Aluno Foi Reprovado por Faltas \n" + "Média Final: " + media);
                    txtResultado.setTextColor(getColor(R.color.red));;
                }else if (media < 5){
                    txtResultado.setText("Aluno Foi Reprovado por Nota \n" + "Média Final: " + media);
                    txtResultado.setTextColor(getColor(R.color.red));;
                }
            }
        });
    }
}