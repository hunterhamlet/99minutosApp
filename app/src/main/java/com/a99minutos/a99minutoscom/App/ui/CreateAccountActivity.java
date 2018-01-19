package com.a99minutos.a99minutoscom.App.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.a99minutos.a99minutoscom.App.ui.fragments.InfoPersonalFragment;
import com.a99minutos.a99minutoscom.App.ui.fragments.InfoVehicleFragment;
import com.a99minutos.a99minutoscom.App.ui.fragments.UploadDocumentsFragment;
import com.a99minutos.a99minutoscom.R;

import butterknife.BindView;

public class CreateAccountActivity extends AppCompatActivity {
    //Variables
    private int contador = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        showToolBar("Registro", true);
        showFragment(new InfoPersonalFragment(),R.id.create_account_container);

    }

    public void showToolBar(String titleToolBar,boolean upBtn){
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(titleToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upBtn);

    }

    private void showFragment(Fragment fragment, int idContainer){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(idContainer,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null).commit();
    }

    public void nextOption(View view){
        contador++;
        switch (contador){
            case 1:
                showFragment(new InfoVehicleFragment(),R.id.create_account_container);
                break;
            case 2:
                showFragment(new UploadDocumentsFragment(),R.id.create_account_container);
                break;
            default:
                contador = 0;
                Intent intent = new Intent (this,LoginActivity.class);
                startActivity(intent);
                break;
        }

    }
}
