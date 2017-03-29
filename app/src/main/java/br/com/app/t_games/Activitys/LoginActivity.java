package br.com.app.t_games.Activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.app.t_games.MainActivity;
import br.com.app.t_games.R;

import static android.R.string.ok;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mEdtEmail;
    EditText mEdtSenha;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEdtEmail = (EditText) findViewById(R.id.edtEmail);
        mEdtSenha = (EditText)findViewById(R.id.edtSenha);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if (!ValidaCampos()){
            return;
        }

        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);

    }

    public boolean ValidaCampos(){
        boolean valida = true;

        String email = mEdtEmail.getText().toString();
        String senha = mEdtSenha.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEdtEmail.setError("Insira um e-mail válido");
            valida = false;
        }

        if (TextUtils.isEmpty(senha)) {
            mEdtSenha.setError("Insira sua senha");
            valida = false;
        }
        return valida;
    }
}
