package com.example.movienight.ui.recommendations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.movienight.R;

public class RecommendationsFragment extends Fragment {

    private RecommendationsViewModel recommendationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recommendationsViewModel =
                ViewModelProviders.of(this).get(RecommendationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recommendations, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        recommendationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}