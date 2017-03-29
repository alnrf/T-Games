package br.com.app.t_games.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.app.t_games.Adpaters.JogoListAdapter;
import br.com.app.t_games.Jogo;
import br.com.app.t_games.R;

import static br.com.app.t_games.R.drawable.jogo;

public class MeusJogosActivity extends AppCompatActivity {

    List<Jogo> jogos;
    JogoListAdapter adapter;
    ListView listView;
    ImageButton btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = new ListView(this);
        setContentView(listView);

        jogos = new ArrayList<Jogo>();
        jogos.add(new Jogo("Fifa 2016", "XBox 360", jogo));
        jogos.add(new Jogo("Guitar Hero Legends", "PlayStation 4", jogo));
        jogos.add(new Jogo("Gran Turismo Gt", "XBox One", jogo));

        adapter = new JogoListAdapter(this, jogos);
        listView.setAdapter(adapter);

    }


}
