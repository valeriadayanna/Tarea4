package adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.picImg);
            lblIDEvaluador = itemView.findViewById(R.id.lblIDEvaluador);
            lblNombres = itemView.findViewById(R.id.lblNombre);
            lblArea = itemView.findViewById(R.id.lblArea);
        }

        private void bindData(final Evaluador Evaluador) {
            Glide.with(context).load(Evaluador.getImgJpg()).into(imageView);
            lblIDEvaluador.setText(Evaluador.getIdEvaluador());
            lblNombres.setText(Evaluador.getNombres());
            lblArea.setText(Evaluador.getArea());
        }
    }
}