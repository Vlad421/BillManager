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


public class AddFragment extends Fragment {


    public AddFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_add, container, false);



        FlowListAdapter customAdapter = new FlowListAdapter(new String[] {"qwe","asdfg","cxzawse","cerfghju","qwe","asdfg","cxzawse","cerfghju","qwe","asdfg","cxzawse","cerfghju","qwe","asdfg","cxzawse","cerfghju"});


        RecyclerView flowView = view.findViewById(R.id.recycler_view);
        flowView.setLayoutManager(new LinearLayoutManager(getActivity()));


        flowView.setAdapter(customAdapter);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}