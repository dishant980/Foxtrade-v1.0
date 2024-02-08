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


public class fundAdapter extends RecyclerView.Adapter<fundAdapter.myviewholder> {
    private final List<FundResponse.FundRequest> fundRequests ;




    public fundAdapter(List<FundResponse.FundRequest> fundRequests) {
        this.fundRequests = fundRequests;


    }


    @Override
    public fundAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fund_recycler_view, parent, false);
        return new fundAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        FundResponse.FundRequest fundRequest = fundRequests.get(position);
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSSSS'Z'", Locale.getDefault());
        try {
            Date date = inputFormat.parse(fundRequest.getApprovedAt());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd' 'hh:mm:ss a", Locale.getDefault());
            dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
            String formattedDate = dateFormat.format(date);

            holder.date_txt2.setText(formattedDate);
            holder.admin_txt.setText(String.valueOf(fundRequest.getName()));
            holder.amt_txt.setText("$"+ fundRequest.getApprovedAmount());
            holder.nara_txt.setText(String.valueOf(fundRequest.getAdminRemarks()));


        }
        catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return fundRequests.size();
    }


    public class myviewholder extends RecyclerView.ViewHolder {
        TextView admin_txt,nara_txt, amt_txt, date_txt2,time_text;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            admin_txt = itemView.findViewById(R.id.admin_txt);
            nara_txt = itemView.findViewById(R.id.nara_txt);
            amt_txt = itemView.findViewById(R.id.amt_txt);
            date_txt2 = itemView.findViewById(R.id.date_txt2);
            time_text = itemView.findViewById(R.id.time_txt);
        }
    }
}


