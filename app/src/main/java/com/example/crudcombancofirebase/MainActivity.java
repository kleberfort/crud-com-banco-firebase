package com.example.crudcombancofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudcombancofirebase.model.Usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    private String nome, sobrenome, email;
    private int contato;
    private EditText editNome, editSobrenome, editEmail, editContato;
    private Button btnCriar;

    private DatabaseReference banco  = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editNome = findViewById(R.id.editName);
        editSobrenome = findViewById(R.id.editSobrenome);
        editEmail = findViewById(R.id.editEmail);
        editContato = findViewById(R.id.editContato);
        btnCriar = findViewById(R.id.btnCriar);







        btnCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference usuarios = banco.child("usuarios");
                Usuario usuario = new Usuario();


                nome = editNome.getText().toString();
                sobrenome = editSobrenome.getText().toString();
                email = editEmail.getText().toString();
                contato = Integer.parseInt(editContato.getText().toString());

                usuario.setNome(nome);
                usuario.setSobrenome(sobrenome);
                usuario.setEmail(email);
                usuario.setContato(contato);

                usuarios.push().setValue(usuario);

                Toast.makeText(getApplicationContext(), "Usuário cadastrado", Toast.LENGTH_LONG).show();

            }
        });

    }



}