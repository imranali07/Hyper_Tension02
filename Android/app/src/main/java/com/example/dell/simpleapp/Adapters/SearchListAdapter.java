package com.example.dell.simpleapp.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.example.dell.simpleapp.Activities.SearchItem;
import com.example.dell.simpleapp.R;

/**
 * Created by DELL on 20/09/2019.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.SearchHolder> {
    SearchItem[] patientNameArray;

  //  SearchItem[] newPatientArray;
    //ItemFilter mFilter;

    public SearchListAdapter(SearchItem[] patientNameArray) {
        this.patientNameArray = patientNameArray;
       // newPatientArray = patientNameArray;
        //mFilter = new ItemFilter();
    }


    @NonNull
    @Override
    public SearchListAdapter.SearchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_list_layout, parent, false);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchHolder holder, int position) {
        SearchItem si = patientNameArray[position];
        holder.textPatientName.setText(si.Name);
        holder.textPatientAddress.setText(si.Address);
        holder.textPatientDob.setText(si.Dob);
        holder.textPatientPhoneNo.setText(si.PhoneNo);
    }

//    public Filter getFilter() {
//        return mFilter;
//    }

    @Override
    public int getItemCount() {
        return patientNameArray.length;
    }

    public class SearchHolder extends RecyclerView.ViewHolder {
        private TextView textPatientName;
        private TextView textPatientAddress;
        private TextView textPatientDob;
        private  TextView textPatientPhoneNo;

        public SearchHolder(View itemView) {
            super(itemView);
            textPatientName = itemView.findViewById(R.id.patient_name_text_view);
            textPatientAddress = itemView.findViewById(R.id.patient_address_text_view);
            textPatientDob = itemView.findViewById(R.id.patient_dob_text_view);
            textPatientPhoneNo = itemView.findViewById(R.id.patient_PhoneNo_text_view);

        }
    }

//    private class ItemFilter extends Filter {
//
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            String patientName = constraint.toString().toLowerCase();
//            FilterResults results = new FilterResults();
//            String[] arrayName = patientNameArray;
//            int count = arrayName.length;
//            String[] newArrayName = new String[count];
//            String filterName;
//            for (int i = 0; i < count; i++) {
//                filterName = arrayName[i];
//                if (filterName.toLowerCase().contains(patientName)) {
//                    newArrayName[0] = arrayName[i];
//                }
//            }
//            results.values = newArrayName;
//            results.count = newPatientArray.length;
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            newPatientArray = (String[]) results.values;
//            notifyDataSetChanged();
//        }
//    }
}
