package com.example.app3;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewFragment extends Fragment {

    private int defaultValue = 0;
    private static final String TAG = "App3";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int myInt = bundle.getInt("some_int", defaultValue);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_fragment, container, false);
        TextView textView = view.findViewById(R.id.new_text);

        getChildFragmentManager().setFragmentResultListener("reqKey", this,
                new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("bundKey");
                textView.setText(result);
            }
        });

        SecondFragment second_fragment = new SecondFragment();
        getChildFragmentManager().beginTransaction()
                .add(R.id.fragment_new, second_fragment)
                .addToBackStack(null)
                .commit();

        Button button = view.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("bundleKey", textView.getText().toString());
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }
        });

        return view;
    }
}
