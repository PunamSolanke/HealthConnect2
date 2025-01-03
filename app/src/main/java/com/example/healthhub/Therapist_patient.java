package com.example.healthhub;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Therapist_patient extends Fragment {

    private RecyclerView recyclerView;
    private DoctorAdapter doctorAdapter;
    private ArrayList<Doctor> doctorList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_therapist_patient, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        doctorList = new ArrayList<>();
        doctorAdapter = new DoctorAdapter(doctorList);
        recyclerView.setAdapter(doctorAdapter);

        fetchDataFromFirebase("Therapist");  // Fetch only Therapist doctors

        return view;
    }

    private void fetchDataFromFirebase(String speciality) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Doctors");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                doctorList.clear();  // Clear previous list data before adding new data
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Doctor doctor = dataSnapshot.getValue(Doctor.class);  // Get doctor object from snapshot
                    if (doctor != null && doctor.getSpecialty().equals(speciality)) {
                        doctorList.add(doctor);  // Add doctor to list if specialty matches
                    }
                }
                // Notify adapter to update the UI with formatted text
                doctorAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors if needed
                Log.e("FirebaseError", "Error fetching data: " + error.getMessage());
            }
        });
    }
}
