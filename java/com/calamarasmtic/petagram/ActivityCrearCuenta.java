package com.calamarasmtic.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.calamarasmtic.petagram.fragments.PerFragment;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 * Created by Calamar Asmàtic on 26/11/2016.
 */

public class ActivityCrearCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button btnCrear = (Button) findViewById(R.id.btnGuardarCuenta);
        /*btnCrear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // obtener user id del api de instagram, y con él el usuario,
                // a partir de allí obtener ultimas medias de éste y mostrar
                // en recyclerviewFragment!
            }
        });*/
    }

    public void goToPerfil(View view) {
        //Intent i = new Intent(this, PerFragment.class);
        //startActivity(i);
    }
}