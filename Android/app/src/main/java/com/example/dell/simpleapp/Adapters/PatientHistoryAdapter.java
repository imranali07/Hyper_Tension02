package com.example.dell.simpleapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.dell.simpleapp.R;

/**
 * Created by DELL on 23/09/2019.
 */

public class PatientHistoryAdapter extends RecyclerView.Adapter<PatientHistoryAdapter.PatientHistoryHolder> {
    private String[] diseaseList;


    public PatientHistoryAdapter(String[] diseaseList){
        this.diseaseList = diseaseList;
    }
    @NonNull
    @Override
    public PatientHistoryAdapter.PatientHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_patient_history_list, parent, false);
        return new PatientHistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientHistoryHolder holder, final int position) {
        holder.textView.setText(diseaseList[position]);
    }


    @Override
    public int getItemCount() {
        return diseaseList.length;
    }

    public class PatientHistoryHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CheckBox chkbox;
        public PatientHistoryHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            chkbox = itemView.findViewById(R.id.checkBox);


        }


    }
}
