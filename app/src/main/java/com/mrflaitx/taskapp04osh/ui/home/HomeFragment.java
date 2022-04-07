package com.mrflaitx.taskapp04osh.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.room.Room;

import com.mrflaitx.taskapp04osh.App;
import com.mrflaitx.taskapp04osh.R;
import com.mrflaitx.taskapp04osh.data.local.AppDatabase;
import com.mrflaitx.taskapp04osh.databinding.FragmentHomeBinding;
import com.mrflaitx.taskapp04osh.model.TaskModel;
import com.mrflaitx.taskapp04osh.ui.detail.DetailFragment;

import java.util.List;

public class HomeFragment extends Fragment implements TaskAdapter.OnItemClick {

    private FragmentHomeBinding binding;
    private TaskAdapter adapter = new TaskAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        initRecyclerView();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.setTaskList(App.database.taskDao().getAllTasks());
    }

    private void initRecyclerView() {
        adapter.setListener(this);
        binding.taskRv.setAdapter(adapter);
    }

    private void initListeners() {
        binding.addTaskBtn.setOnClickListener(view -> {
            openDetailFragment();
        });

        getParentFragmentManager().setFragmentResultListener(DetailFragment.KEY_RESULT,
                getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String text = result.getString(DetailFragment.KEY_BUNDLE);
                App.database.taskDao().addTask(new TaskModel(text));
            }
        });
    }

    private void openDetailFragment() {
       NavController navController = Navigation.findNavController(requireActivity(),
               R.id.main_container);
       navController.navigate(R.id.detailFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(TaskModel task) {
//        Toast.makeText(requireContext(), task,Toast.LENGTH_LONG).show();
    }
}