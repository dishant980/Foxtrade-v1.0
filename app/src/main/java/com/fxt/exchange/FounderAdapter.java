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

public class FounderAdapter extends RecyclerView.Adapter<FounderAdapter.myviewholder>implements Filterable {
    private final List<SalaryResponse.SalaryItem> salaryItems;
    private final List<SalaryResponse.SalaryItem> backup4;

    public FounderAdapter(List<SalaryResponse.SalaryItem> salaryItems) {
        this.salaryItems = salaryItems;
        this.backup4 = new ArrayList<>(salaryItems);
    }


    @Override
    public FounderAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.founder_recycler_view, parent, false);
        return new FounderAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        SalaryResponse.SalaryItem salaryItem= salaryItems.get(position);

        holder.month_txt.setText(String.valueOf(salaryItem.getMonthStart()));
        holder.salary1_txt.setText("$"+ salaryItem.getSalary());
        holder.salary_txt.setText(String.valueOf(salaryItem.getSalaryRank()));
        holder.club_name_txt.setText(String.valueOf(salaryItem.getClubName()));
        holder.club_txt.setText(String.valueOf(salaryItem.getClubId()));
        holder.Level_txt.setText(String.valueOf(salaryItem.getLevel()));

    }

    @Override
    public int getItemCount() {
        return salaryItems.size();
    }


    @Override
    public Filter getFilter() {
        return filter;
    }
    public  Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<SalaryResponse.SalaryItem> salaryItems1 = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                salaryItems1.addAll(backup4);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (SalaryResponse.SalaryItem item : backup4) {
                    if (item.getClubId().toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getSalary()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getSalaryRank()).toLowerCase().contains(filterPattern) ||
                            String.valueOf(item.getMonthStart()).toLowerCase().contains(filterPattern)||
                            String.valueOf(item.getClubName()).toLowerCase().contains(filterPattern)
                    ) {
                        salaryItems1.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = salaryItems1;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            salaryItems.clear();
            if (results.values != null) {
                salaryItems.addAll((List<SalaryResponse.SalaryItem>) results.values);
            }else {
                salaryItems.addAll(backup4);
            }
            notifyDataSetChanged();
        }
    };

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView month_txt,club_txt, salary_txt, Level_txt,salary1_txt,club_name_txt;

        public myviewholder(View itemView) {
            super(itemView);
            month_txt = itemView.findViewById(R.id.month_txt);
            club_txt = itemView.findViewById(R.id.club_txt);
            club_name_txt=itemView.findViewById(R.id.club_name_txt);
            salary_txt = itemView.findViewById(R.id.salary_txt);
            Level_txt = itemView.findViewById(R.id.Level_txt);
            salary1_txt = itemView.findViewById(R.id.salary1_txt);
        }
    }
}



