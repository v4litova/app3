package com.example.app3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

public class MainFragment extends Fragment {
    public MainFragment() {
        super(R.layout.main_fragment);
    }
    private int defaultValue = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("MainFragment", "onCreate event");
        Toast.makeText(getContext(), "Fragment is CREATED", Toast.LENGTH_SHORT).show();

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        TextView name = rootView.findViewById(R.id.textView3);
        //Передача результатов между фрагментами (1 способ)
        getParentFragmentManager().setFragmentResultListener("requestKey", this,
                new FragmentResultListener() {
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("bundleKey");
                name.setText(result);
            }
        });

        Log.d("MainFragment", "onCreateView event");
        Toast.makeText(getContext(), "Fragment is CREATED", Toast.LENGTH_SHORT).show();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("MainFragment", "onViewCreated event");
        Toast.makeText(getContext(), "Fragment is CREATED", Toast.LENGTH_SHORT).show();
    }

    public void onViewStateRestored(Bundle savedInstanceState){
        super.onViewStateRestored(savedInstanceState);
        Log.d("MainFragment", "onViewStateRestored event");
        Toast.makeText(getContext(), "Fragment is CREATED", Toast.LENGTH_SHORT).show();
    }

    public void onStart(){
        super.onStart();
        Log.d("MainFragment", "onStart event");
        Toast.makeText(getContext(), "Fragment is STARTED", Toast.LENGTH_SHORT).show();
    }

    public void onResume(){
        super.onResume();
        Log.d("MainFragment", "onResume event");
        Toast.makeText(getContext(), "Fragment is RESUMED", Toast.LENGTH_SHORT).show();
    }

    public void onPause(){
        super.onPause();
        Log.d("MainFragment", "onPause event");
        Toast.makeText(getContext(), "Fragment is STARTED", Toast.LENGTH_SHORT).show();
    }
    public void onStop(){
        super.onStop();
        Log.d("MainFragment", "onStop event");
        Toast.makeText(getContext(), "Fragment is CREATED", Toast.LENGTH_SHORT).show();
    }
    public void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d("MainFragment", "onSaveInstanceState event");
        Toast.makeText(getContext(), "Fragment is CREATED", Toast.LENGTH_SHORT).show();
    }
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MainFragment", "onDestroyView event");
        Toast.makeText(getContext(), "Fragment is CREATED", Toast.LENGTH_SHORT).show();
    }
    public void onDestroy() {
        super.onDestroy();
        Log.d("MainFragment", "onDestroy event");
        Toast.makeText(getContext(), "Fragment is DESTROYED", Toast.LENGTH_SHORT).show();
    }
}
