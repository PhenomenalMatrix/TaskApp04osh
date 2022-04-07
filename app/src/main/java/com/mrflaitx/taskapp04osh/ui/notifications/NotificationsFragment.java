package com.mrflaitx.taskapp04osh.ui.notifications;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mrflaitx.taskapp04osh.databinding.FragmentNotificationsBinding;

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
        super.onViewCreated(view, savedInstanceState);
        int permissionStatusContact;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permissionStatusContact = requireContext().
                    checkSelfPermission(Manifest.permission.READ_CONTACTS);
        }else {
            permissionStatusContact = 0;
        }
        String[] permissions = {
          Manifest.permission.READ_CONTACTS
        };

        binding.readBtn.setOnClickListener(v ->{
            if(permissionStatusContact == PackageManager.PERMISSION_GRANTED){
                Log.e("TAG", "permissionStatusContact: good");
            }else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requireActivity().requestPermissions(permissions,101);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 101:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Log.e("TAG", "permissionStatusContact: read");
                }else {
                    Log.e("TAG", "permissionStatusContact: notRead");

                }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}