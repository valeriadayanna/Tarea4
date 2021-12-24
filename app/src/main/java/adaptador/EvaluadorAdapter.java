package adaptador;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ejemplocardview.EvaluadosActivity;
import com.example.ejemplocardview.R;

import java.util.List;

import modelo.Evaluador;

public class EvaluadorAdapter extends RecyclerView.Adapter<EvaluadorAdapter.ViewHolder> {

    private List<Evaluador> listaEvaluador;
    private LayoutInflater lInflater;
    private Context context;

    public EvaluadorAdapter(List<Evaluador> listaEvaluador, Context context) {
        this.listaEvaluador = listaEvaluador;
        this.lInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return listaEvaluador.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = lInflater.inflate(R.layout.layout_item, null);
        ViewHolder holder = new EvaluadorAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final EvaluadorAdapter.ViewHolder holder, final int position) {
        //holder.setItem(items.get(position));
        //holder.
        holder.bindData(listaEvaluador.get(position));
    }

    public List<Evaluador> getListaEvaluador() {
        return listaEvaluador;
    }

    public void setListaEvaluador(List<Evaluador> listaEvaluador) {
        this.listaEvaluador = listaEvaluador;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView lblIDEvaluador, lblNombres, lblArea;
        Button btn;
        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.picImg);
            lblIDEvaluador = itemView.findViewById(R.id.lblIdEvaluador);
            lblNombres = itemView.findViewById(R.id.lblNombreEvaluador);
            lblArea = itemView.findViewById(R.id.lblArea);
            btn=itemView.findViewById(R.id.btn);
        }



        private void bindData(final Evaluador evaluador) {
            Glide.with(context).load(evaluador.getImgJpg()).error("https://evaladmin.uteq.edu.ec/adminimg/unknown.png").into(imageView);
            lblIDEvaluador.setText(evaluador.getIdEvaluador());
            lblNombres.setText(evaluador.getNombres());
            lblArea.setText(evaluador.getArea());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent=new Intent(context, EvaluadosActivity.class);
                    Bundle bundle =new Bundle();
                    bundle.putSerializable("Evaluador", evaluador);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
            btn.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent=new Intent(context, EvaluadosActivity.class);
                    Bundle bundle =new Bundle();
                    bundle.putSerializable("Evaluador", evaluador);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }


    }
}