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

import modelo.Evaluado;

public class EvaluadoAdapter extends RecyclerView.Adapter<EvaluadoAdapter.ViewHolder> {

    private List<Evaluado> listaEvaluados;
    private LayoutInflater lInflater;
    private Context context;

    public EvaluadoAdapter(List<Evaluado> listaEvaluados, Context context) {
        this.listaEvaluados = listaEvaluados;
        this.lInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return listaEvaluados.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = lInflater.inflate(R.layout.layout_itemevaluados, null);
        ViewHolder holder = new EvaluadoAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final EvaluadoAdapter.ViewHolder holder, final int position) {
        holder.bindData(listaEvaluados.get(position));
    }

    public List<Evaluado> getListaEvaluador() {
        return listaEvaluados;
    }

    public void setListaEvaluador(List<Evaluado> listaEvaluados) {
        this.listaEvaluados = listaEvaluados;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView lblCargo, lblNombreEvaluado, lblSituacion, lblFechaInicio;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.picImgEvaluado);
            lblCargo = itemView.findViewById(R.id.lblCargo);
            lblNombreEvaluado = itemView.findViewById(R.id.lblNombreEvaluado);
            lblSituacion = itemView.findViewById(R.id.lblSituacion);
            lblFechaInicio = itemView.findViewById(R.id.lblFechaInicio);
        }

        private void bindData(final Evaluado evaluador) {
            Glide.with(context).load(evaluador.getImgJpg()).error("https://evaladmin.uteq.edu.ec/adminimg/unknown.png").into(imageView);
            lblCargo.setText(evaluador.getIdEvaluado());
            lblNombreEvaluado.setText("Nombre: "+evaluador.getNombres());
            lblSituacion.setText(evaluador.getSituacion());
            lblFechaInicio.setText("Inicio: "+evaluador.getFechaInicio());
        }
    }
}