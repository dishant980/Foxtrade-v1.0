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

public class InvestmentAdapter extends RecyclerView.Adapter<InvestmentAdapter.myviewholder>implements Filterable {
    private final List<InvestmentResponse.InvestmentItem> investmentItems;
    private final List<InvestmentResponse.InvestmentItem> backup3;

    public InvestmentAdapter(List<InvestmentResponse.InvestmentItem> investmentItems) {
        this.investmentItems = investmentItems;
        this.backup3 = new ArrayList<>(investmentItems);
    }


    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.roi_recyclerview, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        InvestmentResponse.InvestmentItem item = investmentItems.get(position);
        holder.data_txt.setText(String.valueOf(item.getTransactionDate()));
        holder.tot_txt.setText("$"+ item.getTotal());
        holder.amt_txt.setText("$"+ item.getAmount());
        holder.nar_txt.setText(String.valueOf(item.getNarration()));

    }

    @Override
    public int getItemCount() {
        return investmentItems.size();
    }


    @Override
    public Filter getFilter() {
        return filter;
    }
    public  Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<InvestmentResponse.InvestmentItem> investmentItems1 = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                investmentItems1.addAll(backup3);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (InvestmentResponse.InvestmentItem item : backup3) {
                    if (item.getTransactionDate().toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getTotal()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getAmount()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getNarration()).toLowerCase().contains(filterPattern)
                          ) {
                        investmentItems1.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = investmentItems1;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            investmentItems.clear();
            if (results.values != null) {
                investmentItems.addAll((List<InvestmentResponse.InvestmentItem>) results.values);
            }else {
                investmentItems.addAll(backup3);
            }
            notifyDataSetChanged();
        }
    };

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView data_txt,nar_txt, amt_txt, tot_txt;

        public myviewholder(View itemView) {
            super(itemView);
            data_txt = itemView.findViewById(R.id.date_txt);
            nar_txt = itemView.findViewById(R.id.nar_txt);
            amt_txt = itemView.findViewById(R.id.amt_txt);
            tot_txt = itemView.findViewById(R.id.tot_txt);

        }
    }
}


