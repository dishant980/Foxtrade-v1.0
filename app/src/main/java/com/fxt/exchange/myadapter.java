package com.fxt.exchange;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> implements Filterable {
    private final List<ResponseModel.Child> data;
    private final List<ResponseModel.Child> backup;

    public myadapter(List<ResponseModel.Child> data) {


        this.data = data;
        backup = new ArrayList<>(data);

    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout, parent, false);
        return new myviewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        ResponseModel.Child child = data.get(position);
        holder.idtext1.setText("" + child.getName());
        holder.idtext2.setText("$" + child.getTeam_business());
        holder.idtext3.setText("" + child.getRefer_code());
        holder.idtext4.setText("$" + child.getInvestment());
        holder.idtext5.setText("" + child.getTeam_size());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private final Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<ResponseModel.Child> filterData = new ArrayList<>();

            if (constraint.toString().isEmpty()) {
                filterData.addAll(backup);
            } else {
                for (ResponseModel.Child child : backup) {
                    if (child.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filterData.add(child);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filterData;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, @NonNull FilterResults results) {
            data.clear();
            if (results.values != null) {
                data.addAll((List<ResponseModel.Child>) results.values);
            } else {
                data.addAll(backup);
            }
            notifyDataSetChanged();
        }
    };

    class myviewholder extends RecyclerView.ViewHolder {
        TextView idtext1, idtext2, idtext3, idtext4, idtext5;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            idtext1 = itemView.findViewById(R.id.idtext1);
            idtext2 = itemView.findViewById(R.id.idtext2);
            idtext3 = itemView.findViewById(R.id.idtext3);
            idtext4 = itemView.findViewById(R.id.idtext4);
            idtext5 = itemView.findViewById(R.id.idtext5);

        }
    }
}






