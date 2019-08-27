package com.example.imc;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // ATRIBUTOS
    private EditText edtPeso;
    private EditText edtAltura;
    private Button btnCalcular;
    private Button btnLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // REFERENCIAR OS CONTROLES
        edtPeso = (EditText)findViewById(R.id.edtPeso);
        edtAltura = (EditText)findViewById(R.id.edtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = (Button)findViewById(R.id.btnLimpar);

        // ASSOCIAR TRATADOR DE EVENTOS
        btnCalcular.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // TRATADOR DE EVENTOS
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular) {
            double peso = Double.parseDouble(edtPeso.getText().toString());
            double altura = Double.parseDouble(edtAltura.getText().toString());
            double resultado = (peso/Math.pow(altura, 2));

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.app_name);
            dlg.setMessage(String.format("IMC = %.2f", resultado));
            dlg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            dlg.show();

        } else if (v.getId() == R.id.btnLimpar) {
            edtPeso.setText("");
            edtAltura.setText("");
            edtPeso.requestFocus();

            Toast.makeText(this, "Dados apagados", Toast.LENGTH_SHORT).show();
        }
    }
}
