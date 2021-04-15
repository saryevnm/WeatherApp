package com.example.weatherapp.ui.base_Frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewbinding.ViewBinding;

import com.example.weatherapp.R;

public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {
    protected VB bind;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bind = fetchTheView();
        return bind.getRoot();
    }

    public void navigate(int id,Bundle bundle){
        NavHostFragment navHostFragment =
                (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentcontainer);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        navController.navigate(id,bundle);
    }

    protected abstract VB fetchTheView();
}
