package br.com.app.t_games.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.app.t_games.R;


public class UsuarioActivity extends AppCompatActivity {

    Spinner spinner;
    EditText edtNome;
    EditText edtEmail;
    EditText edtCidade;
    EditText edtEndereco;
    EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        spinner = (Spinner)findViewById(R.id.spnEstados);
        configuraSpinner();
        desabilitaCampos();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_cadastro, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void configuraSpinner(){
        String[]estados = new String[]{
                "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS",
                "MG","PA","PB","PR","PE","PI"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estados);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_save:

                desabilitaCampos();
                Toast.makeText(UsuarioActivity.this, "Edição Bloqueada", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_edit:

                habilitarCampos();
                Toast.makeText(UsuarioActivity.this, "Edição Liberada", Toast.LENGTH_SHORT).show();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void desabilitaCampos(){

        edtNome= (EditText)findViewById(R.id.edtNome);
        edtNome.setEnabled(false);
        edtEmail= (EditText)findViewById(R.id.edtEmail);
        edtEmail.setEnabled(false);
        edtCidade= (EditText)findViewById(R.id.edtCidade);
        edtCidade.setEnabled(false);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtEndereco.setEnabled(false);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
        edtSenha.setEnabled(false);
        spinner.setEnabled(false);

    }

    private void habilitarCampos (){
        edtNome= (EditText)findViewById(R.id.edtNome);
        edtNome.setEnabled(true);
        edtEmail= (EditText)findViewById(R.id.edtEmail);
        edtEmail.setEnabled(true);
        edtCidade= (EditText)findViewById(R.id.edtCidade);
        edtCidade.setEnabled(true);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtEndereco.setEnabled(true);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
        edtSenha.setEnabled(true);
        spinner.setEnabled(true);
    }
}
