package br.com.app.t_games;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static br.com.app.t_games.R.drawable.jogo;
import static br.com.app.t_games.R.id.txtNomeJogo;

/**
 * Created by Fabiano on 17/03/2017.
 */

public class JogoGridAdapter extends BaseAdapter {

    Context ctx;
    List<Jogo> jogos;

    public JogoGridAdapter(Context ctx, List<Jogo> jogos){
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
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_jogo_grid, null);
            holder = new ViewHolder();
            holder.imgCapaJogo = (ImageView)convertView.findViewById(R.id.imgCapaJogo);
            holder.txtNomeJogo = (TextView)convertView.findViewById(R.id.txtNomeJogo);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        Resources res = ctx.getResources();
        //imgCapaJogo.setImageDrawable();
        holder.txtNomeJogo.setText(String.valueOf(jogo.nomeJogo));
        return convertView;
    }

    static class ViewHolder {
        ImageView imgCapaJogo;
        TextView txtNomeJogo;
    }
}
