package br.com.app.t_games.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import br.com.app.t_games.Adapters.JogoListAdapter;
import br.com.app.t_games.Jogo;
import br.com.app.t_games.R;


public class MeusJogosActivity extends AppCompatActivity {

    List<Jogo> jogos;
    JogoListAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = new ListView(this);
        setContentView(listView);

        jogos = new ArrayList<Jogo>();
        jogos.add(new Jogo("Fifa 2016", "XBox 360", R.drawable.jogo));
        jogos.add(new Jogo("Guitar Hero Legends", "PlayStation 4", R.drawable.jogo));
        jogos.add(new Jogo("Gran Turismo Gt", "XBox One", R.drawable.jogo));

        adapter = new JogoListAdapter(this, jogos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Jogo jogo = (Jogo)adapterView.getItemAtPosition(position);
                Toast.makeText(MeusJogosActivity.this, jogo.nomeJogo + "clicou no jogo", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
