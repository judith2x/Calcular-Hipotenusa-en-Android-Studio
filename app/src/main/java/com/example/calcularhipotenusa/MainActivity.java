package com.example.calcularhipotenusa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button botoncalcular, botonlimpiar;
    TextView resultadohipotenusa;
    EditText valorcatetoopuesto, valorcatetoadyacente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorcatetoadyacente=(EditText)findViewById(R.id.catetoadyacente);
        valorcatetoopuesto=(EditText)findViewById(R.id.catetoopuesto);
        resultadohipotenusa=(TextView)findViewById(R.id.resultadohipotenusa);
        botoncalcular=(Button)findViewById(R.id.botoncalcular);
        botoncalcular.setOnClickListener(this);
        botonlimpiar=(Button)findViewById(R.id.botonlimpiar);
        botonlimpiar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botoncalcular:
                int ingresadocatetoopuesto=Integer.valueOf(valorcatetoopuesto.getText().toString());
                int ingresadocatetoadyacente=Integer.valueOf(valorcatetoadyacente.getText().toString());
                if(ingresadocatetoopuesto>ingresadocatetoadyacente){
                    Toast.makeText(this, "El cateto opuesto no puede ser mayor al cateto adyacente", Toast.LENGTH_LONG).show();
                }else{
                    double cuadradocatetoopuesto=ingresadocatetoopuesto*ingresadocatetoopuesto;
                    double cuadradocatetoadyacente=ingresadocatetoadyacente*ingresadocatetoadyacente;
                    double sumacuadrados=cuadradocatetoadyacente+cuadradocatetoopuesto;
                    double resultado=Math.sqrt(sumacuadrados);
                    resultadohipotenusa.setText("EL VALOR DE LA HIPOTENUSA ES: "+resultado);
                }
                break;
            case R.id.botonlimpiar:
                resultadohipotenusa.setText("");
                valorcatetoadyacente.setText("");
                valorcatetoopuesto.setText("");
                break;
        }
    }
}
