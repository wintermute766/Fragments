package ru.sberbank.learning.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user10 on 02.05.2017.
 */

public class ButtonFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View button = inflater.inflate(R.layout.button_fragment, container, false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TestFragmentHost) getActivity()).changeText("ABCDE");
            }
        });
        return button;
    }
}
