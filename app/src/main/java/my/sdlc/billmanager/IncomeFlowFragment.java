package my.sdlc.billmanager;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import my.sdlc.billmanager.entity.Earn;


public class IncomeFlowFragment extends Fragment {


    public IncomeFlowFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_income_flow, container, false);



        FlowListAdapter IncomeFlowAdapter = new FlowListAdapter(new ArrayList<Earn>());


        RecyclerView flowView = view.findViewById(R.id.recycler_view);
        flowView.setLayoutManager(new LinearLayoutManager(getActivity()));


        flowView.setAdapter(IncomeFlowAdapter);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}