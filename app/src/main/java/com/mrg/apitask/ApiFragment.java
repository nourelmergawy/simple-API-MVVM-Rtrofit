package com.mrg.apitask;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviderGetKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mrg.apitask.databinding.FragmentApiBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ApiFragment extends Fragment {

    private FragmentApiBinding binding;
    private ApiViewModel viewModel;
    RecyclerAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentApiBinding.inflate(inflater);
        viewModel = new ViewModelProvider(requireActivity()).get(ApiViewModel.class);
        viewModel.init();
        viewModel.getData();
        setRecycleView();
        viewModel.mutableLiveData.observe(getViewLifecycleOwner(), new Observer<List<MyList>>() {
            @Override
            public void onChanged(List<MyList> myLists) {

                adapter = new RecyclerAdapter(myLists,getActivity().getApplicationContext());
                binding.recyclerview.setAdapter(adapter);
                adapter.updateList(myLists);

            }
        });
        return binding.getRoot();
    }
    public void setRecycleView(){
        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

    }

}