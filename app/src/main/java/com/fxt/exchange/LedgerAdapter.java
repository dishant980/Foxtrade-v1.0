package com.fxt.exchange;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LedgerAdapter extends RecyclerView.Adapter<LedgerAdapter.myviewholder> implements Filterable {
    public final List<TransactionResponse.TransactionItem> transactionList;
    private final List<TransactionResponse.TransactionItem> backup2;


    public LedgerAdapter(List<TransactionResponse.TransactionItem> transactionList) {
        this.transactionList = transactionList;
        this.backup2 = new ArrayList<>(transactionList);
    }


    @Override
    public LedgerAdapter.myviewholder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        return new LedgerAdapter.myviewholder(view);

    }

    @Override
    public void onBindViewHolder(LedgerAdapter.myviewholder holder, int position) {

        TransactionResponse.TransactionItem transaction = transactionList.get(position);
        transaction.getUserId();
        holder.text1.setText("$"+transaction.getBalance());
        holder.text2.setText(""+transaction.getTransactionDate());
        holder.text3.setText(""+transaction.getNarration());
        holder.text4.setText("$"+transaction.getCredit());
        holder.text5.setText("$"+transaction.getDebit());

    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    public  Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<TransactionResponse.TransactionItem> transactionItems  = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                transactionItems.addAll(backup2);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (TransactionResponse.TransactionItem transactionItem : backup2) {
                    if (
                            String.valueOf(transactionItem.getBalance()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(transactionItem.getTransactionDate()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(transactionItem.getCredit()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(transactionItem.getDebit()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(transactionItem.getNarration()).toLowerCase().contains(filterPattern)) {
                        transactionItems.add(transactionItem);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = transactionItems;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            transactionList.clear();
            if (results.values != null) {
                transactionList.addAll((List<TransactionResponse.TransactionItem>) results.values);
            }else {
                transactionList.addAll(backup2);
            }
            notifyDataSetChanged();
        }
    };

    class myviewholder extends RecyclerView.ViewHolder {
        TextView text1, text2, text3, text4, text5;
        public myviewholder(View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            text3 = itemView.findViewById(R.id.text3);
            text4 = itemView.findViewById(R.id.text4);
            text5 = itemView.findViewById(R.id.text5);

        }
    }
}
