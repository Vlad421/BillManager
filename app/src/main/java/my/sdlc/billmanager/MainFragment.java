/*
 * Copyright (c) 2024.
 * Vlad421 https://github.com/Vlad421
 */

package my.sdlc.billmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import my.sdlc.billmanager.helpers.Constants;

/**
 * @author Vlad421 <a href="https://github.com/Vlad421">...</a>
 */
public class MainFragment extends Fragment {
    /**
     * Main Fragment handles main screen UI
     */
    private MainFragment fragment;
    private Button incomeButton;
    private Button expensesButton;

    public MainFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        Bundle navigate = new Bundle();


        incomeButton = view.findViewById(R.id.button_income_flow);
        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate.putString("flow_type", Constants.Type.INCOME.toString());
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_incomeFlowFragment, navigate);
            }

        });

        expensesButton = view.findViewById(R.id.button_expenses_flow);
        expensesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                navigate.putString("flow_type", Constants.Type.SPENT.toString());
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_expensesFlowFragment, navigate);
            }

        });


        return view;

    }
}