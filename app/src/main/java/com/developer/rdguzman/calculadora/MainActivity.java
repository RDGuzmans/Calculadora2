package com.developer.rdguzman.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnBorrar,btnDobleCero,btnEntre,btnIgual,btnLimpiar,btnMas,btnMenos;
    private Button btnMultiplicacion,btnPunto;

    private TextView lblInfo,lblResultado;

    boolean decimal = false;
    float numero1 = 0.0F;
    float numero2 = 0.0F;
    char operador;

    public void obtenerDatos(){
        if(decimal){
            decimal=false;
        }
        if (lblResultado.getText().length() != 0){
            numero1 = Float.parseFloat(lblResultado.getText().toString());
            lblInfo.setText("");
        }else if (lblInfo.getText().length() != 0){
            numero1 = Float.parseFloat(lblInfo.getText().toString());
            lblInfo.setText("");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDobleCero = (Button)findViewById(R.id.btnDobleCero);
        btn0 = (Button) findViewById(R.id.btn0) ;
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnPunto = (Button)findViewById(R.id.btnPunto);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);
        btnBorrar = (Button)findViewById(R.id.btnBorrar);
        btnMas = (Button)findViewById(R.id.btnMas);
        btnMenos = (Button)findViewById(R.id.btnMenos);
        btnEntre = (Button)findViewById(R.id.btnEntre);
        btnMultiplicacion = (Button)findViewById(R.id.btnMultiplicacion);
        btnIgual = (Button)findViewById(R.id.btnIgual);
        lblInfo = (TextView) findViewById(R.id.lblInfo);
        lblResultado = (TextView) findViewById(R.id.lblResultado);



        btnDobleCero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText(lblInfo.getText() + "00");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblInfo.setText(lblInfo.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText(lblInfo.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText(lblInfo.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText(lblInfo.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText(lblInfo.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText(lblInfo.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText(lblInfo.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText(lblInfo.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText(lblInfo.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText(lblInfo.getText() + "9");
            }
        });

        btnPunto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (! decimal){
                    lblInfo.setText(lblInfo.getText() + ".");
                    decimal = true;
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lblInfo.setText("");
                lblResultado.setText("");
                decimal = false;
                numero1 = 0.0F;
                numero2 = 0.0F;
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String borrar;
                borrar = lblInfo.getText().toString();
                if (borrar.length() != 0){
                    borrar = borrar.substring(0, borrar.length() - 1);
                    lblInfo.setText(borrar);
                }
            }
        });

        btnMas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                obtenerDatos();
                operador = '+';
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                obtenerDatos();
                operador = '-';
            }
        });

        btnEntre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                obtenerDatos();
                operador = '/';
            }
        });

        btnMultiplicacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                obtenerDatos();
                operador = '*';
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float f = 0.0F;
                if (lblInfo.getText().length() == 0){
                    Toast.makeText(MainActivity.this, "Ingrese Datos", Toast.LENGTH_SHORT).show();
                }else {
                    numero2 = Float.parseFloat(lblInfo.getText().toString());
                    if (operador == '+') {
                        f = numero1 + numero2;

                    } else if (MainActivity.this.operador == '-') {
                        f = numero1 - numero2;

                    } else if (MainActivity.this.operador == '/') {
                        f = numero1 / numero2;

                    } else if (MainActivity.this.operador == '*') {
                        f = numero1 * numero2;
                    }
                    lblResultado.setText("" + f);
                }
            }
        });
    }
}