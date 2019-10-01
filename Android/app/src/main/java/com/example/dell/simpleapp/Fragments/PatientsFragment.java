package com.example.dell.simpleapp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dell.simpleapp.Activities.SearchActivity;
import com.example.dell.simpleapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatientsFragment extends Fragment {

    Button btnNewPatient;
    public PatientsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patients, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNewPatient = getView().findViewById(R.id.button_patient_search);
        btnNewPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
                //getFragmentManager().beginTransaction().addToBackStack(null).commit();
            }
        });
    }
}
