package com.example.aplicativo11.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplicativo11.Exception.UserInvalidDate;
import com.example.aplicativo11.Exception.UserNotFound;
import com.example.aplicativo11.R;
import com.example.aplicativo11.controller.MainController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private EditText senha;
    private EditText login;
    private Button entrar;
    private CheckBox check;
    private FloatingActionButton floadCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        findVIew();
        setEvent();

    }

    private void findVIew() {
        login = findViewById(R.id.editLogin);
        senha = findViewById(R.id.editSenha);
        entrar  = findViewById(R.id.buttonEntrar);
        check = findViewById(R.id.checkBox);
        floadCadastro = findViewById(R.id.floatCadastrar);
    }
    private void setEvent() {
        entrar.setOnClickListener(view -> entrar());
        floadCadastro.setOnClickListener(view -> cadastrar());
    }
    private void entrar(){
        String loginUser =  login.getText().toString();
        String senhaUser = senha.getText().toString();
        MainController controller = new MainController(this.getBaseContext());
        try {
            boolean login1 = controller.login(loginUser, senhaUser);
        } catch (UserNotFound e) {
            Toast.makeText(this, "Usuario não encontrado", Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        } catch (UserInvalidDate e) {
            Toast.makeText(this, "Dados invalidos", Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }
    }
    private void cadastrar(){}

}