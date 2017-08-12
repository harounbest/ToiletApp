package com.diazapps.toiletapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class StartFragment extends Fragment {

    Button review, find;
    public StartFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.start_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        find = (Button) getActivity().findViewById(R.id.find_button);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToiletListFragment listFrag =  new ToiletListFragment();

                android.support.v4.app.FragmentTransaction transaction = ().beginTransaction();
                transaction.replace(R.id.main_content, new ToiletListFragment()).commit();
            }
        });
        review = (Button) getActivity().findViewById(R.id.review_button);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment rating = new AddToiletFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content, rating).commit();
            }
        });
    }
}
