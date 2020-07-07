package com.phonedev.inventarioventas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ActivityReg extends AppCompatActivity {

    Button Revisar;
    EditText PicanteText;
    EditText ClasicaText;
    EditText ExtraText;
    TextView Total;

    EditText Fecha, Nombre, Direccion, Numero;
    Button Guardar;

    int picante = 19;
    double clasica = 17.5;
    double extra = 0;
    String Total1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        PicanteText = (EditText) findViewById(R.id.editPicante);
        ClasicaText = (EditText) findViewById(R.id.editClasica);
        ExtraText = (EditText) findViewById(R.id.editExtra);
        Total = (TextView) findViewById(R.id.textViewTotal);

        Fecha = (EditText) findViewById(R.id.editFecha);
        Nombre = (EditText) findViewById(R.id.editNombre);
        Direccion = (EditText) findViewById(R.id.editDireccion);
        Numero = (EditText) findViewById(R.id.editNumero);
        Guardar = (Button) findViewById(R.id.btnGuardar);


    }

    public void Total(View view){

        String PicanteS= PicanteText.getText().toString();
        String ClasicaS = ClasicaText.getText().toString();
        String ExtraS = ExtraText.getText().toString();

        int Picante1=Integer.parseInt(PicanteS);
        int Clasica1=Integer.parseInt(ClasicaS);
        int Extra1=Integer.parseInt(ExtraS);

        int TotalPicante = Picante1 * picante;
        double TotalClasica = Clasica1 * clasica;
        double TotalExtra = Extra1 * extra;

        double TotalPagar = TotalPicante + TotalClasica + TotalExtra;

        final String Total1 = String.valueOf(TotalPagar);

        Total.setText("Q." + Total1);

    }

    public void registrar (View view){
        AdminSQLiteOpenHelper admin =  new AdminSQLiteOpenHelper( this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String fecha = Fecha.getText().toString();
        String nombre = Nombre.getText().toString();
        String direccion = Direccion.getText().toString();
        String numero = Numero.getText().toString();
        String total = Total.getText().toString();

        if(!fecha.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty() && !numero.isEmpty() &&!total.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("fecha", fecha);
            registro.put("nombre", nombre);
            registro.put("numero", numero);
            registro.put("total", total);

            BaseDeDatos.insert("ventas", null, registro);
            BaseDeDatos.close();

            Fecha.setText("");
            Nombre.setText("");
            Direccion.setText("");
            Numero.setText("");
            Total.setText("");

            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

    //Metodo para consultar ventas
    public void buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
    }


}
