package br.com.app.t_games.Adpaters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.app.t_games.Jogo;
import br.com.app.t_games.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Fabiano on 29/03/2017.
 */

public class JogoListAdapter extends BaseAdapter {

    Context ctx;
    List<Jogo> jogos;

    public JogoListAdapter(Context ctx, List<Jogo> jogos){
        this.ctx = ctx;
        this.jogos = jogos;
    }

    @Override
    public int getCount() {
        return jogos.size();
    }

    @Override
    public Object getItem(int position) {
        return jogos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Jogo jogo = jogos.get(position);

        ViewHolder holder = null;

        if(convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.lista_meus_jogos, null);
            holder = new ViewHolder();
            holder.capa_Jogo = (ImageView)convertView.findViewById(R.id.capa_Jogo);
            holder.txt_nome_Console = (TextView)convertView.findViewById(R.id.nome_Console);
            holder.txt_nome_Jogo = (TextView)convertView.findViewById(R.id.nome_Jogo);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        Resources res = ctx.getResources();

        holder.txt_nome_Jogo.setText(jogo.nomeJogo);
        holder.txt_nome_Console.setText(jogo.console);
        return convertView;
    }

    public static class ViewHolder {

        ImageView capa_Jogo;
        TextView txt_nome_Jogo;
        TextView txt_nome_Console;

    }
}
