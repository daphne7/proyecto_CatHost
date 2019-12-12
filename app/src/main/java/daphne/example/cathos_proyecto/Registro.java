package daphne.example.cathos_proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import daphne.example.cathos_proyecto.conexiones.myData;

public class Registro extends AppCompatActivity {

    ArrayList<String> sexo;
    private EditText etn, eta, etco, etc,sex;
    Button aceptar,cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //para enviar el formulario
                sendData();

            }
        });


        etn = (EditText)findViewById(R.id.txt_nombre);
        eta = (EditText)findViewById(R.id.txt_apellido);
        etco =(EditText)findViewById(R.id.text_correo);
        //etu =(EditText)findViewById(R.id.txt_usuario);
        etc = (EditText)findViewById(R.id.txt_password);
        aceptar= findViewById(R.id.aceptar);
        cancelar= findViewById(R.id.cancelar);



    }

    //para el envio de dato
    private void sendData(){

        EditText etn = findViewById(R.id.txt_nombre);
        EditText eta = findViewById(R.id.txt_apellido);
        EditText etco = findViewById(R.id.text_correo);
        EditText etc = findViewById(R.id.txt_password);
        Spinner sexs = findViewById(R.id.sex);

        AsyncHttpClient registro= new AsyncHttpClient();
        //agregando parametros
        RequestParams params = new RequestParams();


        params.add("txt_nombre", etn.getText().toString());
        params.add("txt_apellido", eta.getText().toString());
        params.add("txt_correo", etco.getText().toString());
        params.add("txt_password", etc.getText().toString());
        params.add("sex", sexo.get(sexs.getSelectedItemPosition()));
        //para el envio
        registro.post(myData.HOST_USER, params, new JsonHttpResponseHandler() {

            public void onFailure(int statusCode, Header[] headers, JSONObject response) {


            }
            public void onSucess(int statusCode, Header[] headers, JSONObject response) {
                if (response.has("message")) {
                    Toast.makeText(Registro.this, "usuario registrado exitosamente", Toast.LENGTH_SHORT);

                }
            }
        });

    }

}
