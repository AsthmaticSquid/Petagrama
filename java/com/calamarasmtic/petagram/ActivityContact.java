package com.calamarasmtic.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class ActivityContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button btnEnviar = (Button) findViewById(R.id.btnEnviarMail);
        btnEnviar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String nombre = ((EditText) findViewById(R.id.etContactName)).getText().toString();
                String email = ((EditText) findViewById(R.id.etEmail)).getText().toString();
                String desc = ((EditText) findViewById(R.id.etMensaje)).getText().toString();
                String from = "calamarasmatic@gmail.com";
                String pwd = "************";
                //Donde estan los asteriscos, debe estar el password, que por respeto a mi intimidad, no voy a poner.
                //De modo que la app subida al repositorio, no podrá mandar emails.
                //No obstante, si os apetece probar, podeis introducir vuestro email y password para probar!

                Properties props = new Properties();
                props.put("google.mail.com", "google.mail.com");
                Session session = Session.getInstance(props, null);

                try {
                    MimeMessage msg = new MimeMessage(session);
                    msg.setFrom(from);
                    msg.setRecipients(Message.RecipientType.TO, email);
                    msg.setSubject("Mensaje de Petagram");
                    msg.setSentDate(new Date());
                    msg.setText(desc);
                    Transport.send(msg, from, pwd);

                } catch (MessagingException mex) {
                    System.out.println("send failed, exception: " + mex);
                }
            }
        });
    }@
}
