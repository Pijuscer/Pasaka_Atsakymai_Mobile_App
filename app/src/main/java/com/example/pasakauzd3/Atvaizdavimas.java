package com.example.pasakauzd3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Atvaizdavimas extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE = 1;
    private final Context context;
    private final List<Object> listRecyclerItem;

    public Atvaizdavimas(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView PirmasKl;
        private TextView AntrasKl;
        private TextView TreciasKl;
        private TextView KetvirtasKl;
        private TextView PenktasKl;
        private TextView SestasKl;
        private TextView SeptintasKl;
        private TextView AstuntasKl;
        private TextView DevintasKl;
        private TextView DesimtasKl;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            PirmasKl = (TextView) itemView.findViewById(R.id.pirmaskl);
            AntrasKl = (TextView) itemView.findViewById(R.id.antraskl);
            TreciasKl = (TextView) itemView.findViewById(R.id.treciaskl);
            KetvirtasKl = (TextView) itemView.findViewById(R.id.ketvirtaskl);
            PenktasKl = (TextView) itemView.findViewById(R.id.penktaskl);
            SestasKl = (TextView) itemView.findViewById(R.id.sestaskl);
            SeptintasKl = (TextView) itemView.findViewById(R.id.septintaskl);
            AstuntasKl = (TextView) itemView.findViewById(R.id.astuntaskl);
            DevintasKl = (TextView) itemView.findViewById(R.id.devintaskl);
            DesimtasKl = (TextView) itemView.findViewById(R.id.desimtaskl);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.list_elementai, viewGroup, false);

                return new ItemViewHolder((layoutView));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


        int viewType = getItemViewType(i);


        switch (viewType) {
            case TYPE:
            default:


                ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
                Atsakymai atsakymai = (Atsakymai) listRecyclerItem.get(i);


                itemViewHolder.PirmasKl.setText("1 kl. " + atsakymai.getPirmasKlausimas());
                itemViewHolder.AntrasKl.setText("2 kl. " + atsakymai.getAntrasKlausimas());

                String treciasKl = "3 kl. ";
                for (int k = 0; k < atsakymai.getTreciasKlausimas().size(); k++) {
                    treciasKl += atsakymai.getTreciasKlausimas().get(k);

                    if (k != atsakymai.getTreciasKlausimas().size() - 1) {
                        treciasKl += ", ";
                    }
                }

                itemViewHolder.TreciasKl.setText(treciasKl);

                String ketvirtasKl = "4 kl. ";
                for (int k = 0; k < atsakymai.getKetvirtasKlausimas().size(); k++) {
                    ketvirtasKl += atsakymai.getKetvirtasKlausimas().get(k);

                    if (k != atsakymai.getKetvirtasKlausimas().size() - 1) {
                        ketvirtasKl += ", ";
                    }
                }
                itemViewHolder.KetvirtasKl.setText(ketvirtasKl);
                itemViewHolder.PenktasKl.setText("5 kl. " + atsakymai.getPenktasKlausimas());
                itemViewHolder.SestasKl.setText("6 kl. " + atsakymai.getSestasKlausimas());
                itemViewHolder.SeptintasKl.setText("7 kl. " + atsakymai.getSeptintasKlausimas());

                String astuntasKl = "8 kl. ";
                for (int k = 0; k < atsakymai.getAstuntasKlausimas().size(); k++) {
                    astuntasKl += atsakymai.getAstuntasKlausimas().get(k);

                    if (k != atsakymai.getAstuntasKlausimas().size() - 1) {
                       astuntasKl += ", ";
                    }
                }
                itemViewHolder.AstuntasKl.setText(astuntasKl);

                String devintasKl = "9 kl. ";
                for (int k = 0; k < atsakymai.getDevintasKlausimas().size(); k++) {
                    devintasKl += atsakymai.getDevintasKlausimas().get(k);

                    if (k != atsakymai.getDevintasKlausimas().size() - 1) {
                        devintasKl += ", ";
                    }
                }
                itemViewHolder.DevintasKl.setText(devintasKl);
                itemViewHolder.DesimtasKl.setText("10 kl. " + atsakymai.getDesimtasKlausimas());
        }

    }


    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}

