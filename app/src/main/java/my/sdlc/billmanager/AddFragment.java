package my.sdlc.billmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import my.sdlc.billmanager.helpers.Constants;

public class AddFragment extends Fragment {

    Spinner spinnerListType;
    Spinner spinnerListCategory;
    EditText editTextDescription;
    EditText editTextAmount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_add_entry, container, false);
        spinnerListType = view.findViewById(R.id.spinner_type);
        spinnerListCategory = view.findViewById(R.id.spinner_category);

        editTextDescription = view.findViewById(R.id.edit_text_add_text_description);
        editTextAmount = view.findViewById(R.id.edit_text_add_amount);
        editTextDescription.setEnabled(false);
        editTextAmount.setEnabled(false);
        spinnerListCategory.setEnabled(false);

        String[] spinnerTypeItems = Stream.of(Constants.Type.values()).map(Constants.Type::name).toArray(String[]::new);
        ArrayAdapter<String> adapterType = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, spinnerTypeItems) {
            @Override
            public int getCount() {
                return super.getCount() - 1;            // don't display last item. It is used as hint.
            }
        };
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerListType.setAdapter(adapterType);
        spinnerListType.setSelection(2);
        String[] spinnerCategoriesList = {"Chose entry type first"};
        ArrayAdapter<String> adapterCategory = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, new ArrayList<>(Arrays.asList(spinnerCategoriesList)));
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerListCategory.setAdapter(adapterCategory);

        spinnerListType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position < 2) {
                    //spinnerListCategory.setAdapter(null);
                    adapterCategory.clear();
                    String[] spinnerCategoriesList = new String[0];
                    //adapterCategory.notifyDataSetInvalidated();

                    if (spinnerListType.getSelectedItem().equals(Constants.Type.INCOME.toString())) {

                        spinnerCategoriesList = Constants.Categories.getDefaultIncomeCategories().keySet().toArray(new String[0]);
                        Toast.makeText(requireContext(), "Inc", Toast.LENGTH_SHORT).show();
                        //System.out.println(4);
                    } else if (spinnerListType.getSelectedItem().equals(Constants.Type.SPENT.toString())) {
                        spinnerCategoriesList = Constants.Categories.getDefaultSpentCategories().keySet().toArray(new String[0]);
                        Toast.makeText(requireContext(), "Spe", Toast.LENGTH_SHORT).show();
                        //System.out.println(5);
                    }

                    adapterCategory.addAll(new ArrayList<String >(Arrays.asList(spinnerCategoriesList)));

                    adapterCategory.notifyDataSetChanged();
                    //spinnerListCategory.setAdapter(adapterCategory);
                    spinnerListCategory.setEnabled(true);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;

    }
}
