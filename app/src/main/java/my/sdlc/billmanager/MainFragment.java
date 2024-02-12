package my.sdlc.billmanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#getInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    private static MainFragment fragment;
    private Button incomeButton;
    private Button expensesButton;

    public MainFragment() {

    }


    public static MainFragment getInstance() {
        if (fragment == null) {
            fragment = new MainFragment();
        }


        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        incomeButton = view.findViewById(R.id.button_add_income);
        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_addFragment);
            }
        });
        return view;

    }
}