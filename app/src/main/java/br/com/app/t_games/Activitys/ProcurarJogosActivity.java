package br.com.app.t_games.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v4.view.MenuItemCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import br.com.app.t_games.Jogo;
import br.com.app.t_games.JogoGridAdapter;
import br.com.app.t_games.R;


public class ProcurarJogosActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,
 MenuItemCompat.OnActionExpandListener{

    List<Jogo> mJogo;
    GridView mGridView;
    JogoGridAdapter adapter;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procurar_jogos);
        mGridView = (GridView)findViewById(R.id.gridview);
        spinner = (Spinner)findViewById(R.id.spnJogos);

        mJogo = new ArrayList<Jogo>();
        mJogo.add(new Jogo("Battle Field", "XBox", R.drawable.jogo));
        mJogo.add(new Jogo("Gran Turismo", "XBox", R.drawable.jogo));
        mJogo.add(new Jogo("Minecraft", "XBox", R.drawable.jogo));
        mJogo.add(new Jogo("Guitar Hero", "XBox", R.drawable.jogo));
        mJogo.add(new Jogo("Qualquer um", "XBox", R.drawable.jogo));

        adapter = new JogoGridAdapter(this, mJogo);
        mGridView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_busca_jogos, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Insira o nome do jogo");
        MenuItemCompat.setOnActionExpandListener(searchItem, this);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return true;
    }


}

