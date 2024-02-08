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

public class CommisionAdapter extends RecyclerView.Adapter<CommisionAdapter.myviewholder>implements Filterable {
    private final List<CommissionResponse.CommissionItem> commissionItems;
    private final List<CommissionResponse.CommissionItem> backup1;

    public CommisionAdapter(List<CommissionResponse.CommissionItem> commissionItems) {
        this.commissionItems = commissionItems;
        this.backup1 = new ArrayList<>(commissionItems);
    }


    @Override
    public CommisionAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view1, parent, false);
        return new CommisionAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        CommissionResponse.CommissionItem commissionItem = commissionItems.get(position);

        holder.Date_text2.setText(String.valueOf(commissionItem.getTransactionDate()));
        holder.down_text3.setText( String.valueOf(commissionItem.getDownlineId()));
        holder.level_text4.setText(String.valueOf(commissionItem.getLevel()));
        holder.return_text1.setText("$"+ commissionItem.getInvestment());
        holder.com_text5.setText("$"+ commissionItem.getCommOnRoi());
        holder.total_text6.setText("$"+ commissionItem.getTotal());
    }

    @Override
    public int getItemCount() {
        return commissionItems.size();
    }


    @Override
    public Filter getFilter() {
        return filter;
    }
    public  Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CommissionResponse.CommissionItem> commissionItems1 = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                commissionItems1.addAll(backup1);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (CommissionResponse.CommissionItem item : backup1) {
                    if (item.getTransactionDate().toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getDownlineId()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getLevel()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getInvestment()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getCommOnRoi()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getTotal()).toLowerCase().contains(filterPattern)) {
                        commissionItems1.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = commissionItems1;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            commissionItems.clear();
            if (results.values != null) {
                commissionItems.addAll((List<CommissionResponse.CommissionItem>) results.values);
            }else {
                commissionItems.addAll(backup1);
            }
            notifyDataSetChanged();
        }
        };

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView Date_text2, down_text3, level_text4, return_text1, com_text5, total_text6;

        public myviewholder(View itemView) {
            super(itemView);
            Date_text2 = itemView.findViewById(R.id.Date_text2);
            down_text3 = itemView.findViewById(R.id.down_text3);
            level_text4 = itemView.findViewById(R.id.level_text4);
            return_text1 = itemView.findViewById(R.id.return_text1);
            com_text5 = itemView.findViewById(R.id.com_text5);
            total_text6 = itemView.findViewById(R.id.total_text6);
        }
    }
}


