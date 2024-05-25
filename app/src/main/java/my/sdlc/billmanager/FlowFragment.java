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

import my.sdlc.billmanager.entity.flow.Entry;
import my.sdlc.billmanager.helpers.dataBase.DBManager;


public class FlowFragment extends Fragment {


    public FlowFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_income_flow, container, false);

        // reads db


        FlowListAdapter incomeFlowAdapter = new FlowListAdapter(readEntries());


        RecyclerView flowView = view.findViewById(R.id.recycler_view);
        flowView.setLayoutManager(new LinearLayoutManager(getActivity()));


        flowView.setAdapter(incomeFlowAdapter);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }



    private ArrayList<Entry> readEntries(){
        return DBManager.getInstance(requireContext()).readEntries();
    }
}