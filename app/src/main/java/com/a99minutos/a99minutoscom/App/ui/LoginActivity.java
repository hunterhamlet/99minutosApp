package com.a99minutos.a99minutoscom.App.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.a99minutos.a99minutoscom.App.pruebas.Fruta;
import com.a99minutos.a99minutoscom.R;
import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * @author: Ing Jonatan Hamlet Munguia Martinez de 99minutos.com
 * @version: 1.0.0
 * @description: Pantalla de login para la aplicación 99minutos.com, la cual tiene dos opciones
 *               la primera es ingresar a la actividad por medio de un código QR, el cual contiene
 *               la información del Don Veloz, la segunda es una accción crear una nueva cuenta*/

public class LoginActivity extends AppCompatActivity{
    //Entidades
    private Gson gson;
    private String myResults;

    //---------------------------------Metodos Override--------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        gson = new Gson();
        ButterKnife.bind(this);
        Realm.init(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
            }else {
                //Toast.makeText(this, "Scanenado " + result.getContents(), Toast.LENGTH_SHORT).show();
                myResults = result.getContents();
                Fruta fruta = gson.fromJson(myResults,Fruta.class);
                //Intent intent = new Intent(this,CreateAccountActivity.class);
                //intent.putExtra("fruta",fruta);
                //startActivity(intent);
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //---------------------------------Metodos Generales--------------------------------------------
    public void loginAccess(View view){
        /**
         * @Nombre: loginAccess
         * @param: View view
         * @Descripción: Función que es invocada cuando el boton "login_scan" es presionado, crea
         * objeto del tipo IntentIntegrator par apoder manejar la lectura de código QR, BC.
         * @see: https://github.com/journeyapps/zxing-android-embedded*/
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        intentIntegrator.setPrompt("Escanea tu codigo QR de Don Veloz.");
        intentIntegrator.setBarcodeImageEnabled(true);
        intentIntegrator.initiateScan();
    }

    public void loginCreateAccount(View view){
        /**
         * @Nombre: loginCreateAccount
         * @param: View view
         * @Descripción: Función que nos manda a la activity "CreateAccountActivity" para poder
         * registrar a un nuevo usuario.*/
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

}
