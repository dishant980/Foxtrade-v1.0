package com.fxt.exchange;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class SelfAdapter extends RecyclerView.Adapter<SelfAdapter.MyViewHolder> {

    private final List<UserWalletResponse.FundRequest> fundRequests;

    public SelfAdapter(List<UserWalletResponse.FundRequest> fundRequests) {
        this.fundRequests = fundRequests;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.self_investment_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserWalletResponse.FundRequest fundRequest = fundRequests.get(position);

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.getDefault());
        try {
            Date date = inputFormat.parse(fundRequest.getTransactionDate());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
            String formattedDate = dateFormat.format(date);

            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());
            timeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
            String formattedTime = timeFormat.format(date);

            holder.date_txt.setText(formattedDate);
            holder.time_txt.setText(formattedTime);
            holder.amount_txt.setText(String.valueOf(fundRequest.getTransactionAmount()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return fundRequests.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView amount_txt, date_txt,time_txt;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            amount_txt = itemView.findViewById(R.id.amount_txt);
            date_txt = itemView.findViewById(R.id.date_txt);
            time_txt=itemView.findViewById(R.id.time_txt);

        }
    }

}

