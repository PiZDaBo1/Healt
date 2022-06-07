package com.example.healt.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.healt.Launch;
import com.example.healt.Login;
import com.example.healt.Save;
import com.example.healt.databinding.FragmentNotificationsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
        String currentUserID = auth.getCurrentUser ().getUid ();


        database.child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               String username = snapshot.child("name").getValue().toString();
//               String growth = snapshot.child("Growth").getValue().toString();
//               String height = snapshot.child("Height").getValue().toString();

               binding.username.setText(username);
//               binding.rost.setText(growth);
//               binding.ves.setText(height);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.child(currentUserID).push().setValue(new Save(
                        binding.username.getText().toString(),
                        binding.rost.getText().toString(),
                        binding.ves.getText().toString()
                ));
            }
        });

        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(NotificationsFragment.this.getActivity(), Login.class));
                NotificationsFragment.this.getActivity().finish();
            }
        });




    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}