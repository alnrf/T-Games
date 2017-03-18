package br.com.app.t_games;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static br.com.app.t_games.R.drawable.jogo;

public class ProcurarJogosActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,
 MenuItemCompat.OnActionExpandListener{

    List<Jogo> mJogo;
    GridView mGridView;
    JogoGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procurar_jogos);
        mGridView = (GridView)findViewById(R.id.gridview);


        mJogo = new ArrayList<Jogo>();
        mJogo.add(new Jogo("Battle Field", 1, R.drawable.jogo));
        mJogo.add(new Jogo("Gran Turismo", 1, R.drawable.jogo));
        mJogo.add(new Jogo("Minecraft", 1, R.drawable.jogo));
        mJogo.add(new Jogo("Guitar Hero", 1, R.drawable.jogo));
        mJogo.add(new Jogo("Qualquer um", 1, R.drawable.jogo));

        adapter = new JogoGridAdapter(this, mJogo);
        mGridView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_busca_jogos, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Procurar jogos");
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

