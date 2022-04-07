package com.mrflaitx.taskapp04osh.ui.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrflaitx.taskapp04osh.R;
import com.mrflaitx.taskapp04osh.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    public static final String KEY_RESULT = "keyResult";
    public static final String KEY_BUNDLE = "keyBundle";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
    }

    private void initListeners() {
        binding.saveTaskBtn.setOnClickListener(v ->{
            sendData();
            closeFragment();
        });
    }

    private void closeFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.main_container);
        navController.navigateUp();
    }

    private void sendData() {
        String text = binding.taskEt.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_BUNDLE,text);
        getParentFragmentManager().setFragmentResult(KEY_RESULT, bundle);
    }
}