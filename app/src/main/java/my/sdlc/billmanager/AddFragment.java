package my.sdlc.billmanager;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

import my.sdlc.billmanager.helpers.Constants;
import my.sdlc.billmanager.helpers.UI.NDSpinner;
import my.sdlc.billmanager.helpers.dataBase.DBManager;

public class AddFragment extends Fragment {


    final Calendar myCalendar = Calendar.getInstance();

    AppCompatSpinner spinnerType;
    NDSpinner spinnerCategory;
    EditText editTextDescription;
    EditText editTextAmount;
    EditText editTextDatePick;
    Button buttonAddEntry;
    TextView textViewLabelType;
    TextView textViewLabelCategory;

    String entryType;
    String category;
    String description;
    float amount;
    int year;
    int month;
    int day;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_add_entry, container, false);
        textViewLabelType = view.findViewById(R.id.text_view_entry_type);
        textViewLabelCategory = view.findViewById(R.id.text_view_category);
        spinnerType = view.findViewById(R.id.spinner_type);
        spinnerCategory = view.findViewById(R.id.spinner_category);
        editTextDescription = view.findViewById(R.id.edit_text_add_text_description);
        editTextAmount = view.findViewById(R.id.edit_text_add_amount);
        editTextDatePick = view.findViewById(R.id.edit_text_pick_date);
        buttonAddEntry = view.findViewById(R.id.button_add_entry);

        updateDateLabel();

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDateLabel();
            }


        };
        editTextDatePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(requireContext(), date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        editTextDescription.setEnabled(false);
        editTextAmount.setEnabled(false);
        spinnerCategory.setEnabled(false);
        editTextDatePick.setEnabled((false));

        String[] entryTypes = Stream.of(Constants.Type.values()).map(Constants.Type::name).toArray(String[]::new);
        ArrayAdapter<String> adapterType = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, entryTypes) {
            @Override
            public int getCount() {
                return super.getCount() - 1;            // don't display last item. It is used as hint.
            }
        };
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerType.setAdapter(adapterType);
        spinnerType.setSelection(2);
        String[] categoriesList = {"Chose entry type first"};
        ArrayAdapter<String> adapterCategory = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, new ArrayList<>(Arrays.asList(categoriesList)));
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);


        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position < 2) {

                    entryType = spinnerType.getSelectedItem().toString();
                    adapterCategory.clear();
                    String[] spinnerCategoriesList = new String[0];

                    Toast.makeText(requireContext(), entryType, Toast.LENGTH_SHORT).show();
                    if (entryType.equals(Constants.Type.INCOME.toString())) {

                        spinnerCategoriesList = Constants.Categories.getDefaultIncomeCategories().values().toArray(new String[0]);

                    } else if (entryType.equals(Constants.Type.SPENT.toString())) {
                        spinnerCategoriesList = Constants.Categories.getDefaultSpentCategories().values().toArray(new String[0]);

                    }

                    adapterCategory.addAll(new ArrayList<String>(Arrays.asList(spinnerCategoriesList)));

                    adapterCategory.notifyDataSetChanged();
                    textViewLabelType.setVisibility(View.GONE);
                    spinnerCategory.setEnabled(true);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinnerCategory.getAdapter().getCount() > 1) {
                    category = spinnerCategory.getSelectedItem().toString();
                    editTextDescription.setEnabled(true);
                    editTextAmount.setEnabled(true);
                    editTextDatePick.setEnabled(true);
                    textViewLabelCategory.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if (spinnerCategory.getCount() > 1) {
                    category = spinnerCategory.getSelectedItem().toString();

                }
            }

        });

        buttonAddEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entryType = spinnerType.getSelectedItem().toString();
                category = spinnerCategory.getSelectedItem().toString();
                description = editTextDescription.getText().toString();
                amount = Float.parseFloat(editTextAmount.getText().toString());

                year = myCalendar.get(Calendar.YEAR);
                day = myCalendar.get(Calendar.DAY_OF_MONTH);
                month = myCalendar.get(Calendar.MONTH); //month starts from 0
                String textToToast = entryType + " " + category + " " + description + " " + amount + " " + year + " " + month + " " + day;
                DBManager.getInstance(requireContext()).writeEntry(entryType,category,description,amount,year,month,day);
                //Toast.makeText(requireContext(), textToToast, Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }


    private void updateDateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        editTextDatePick.setText(dateFormat.format(myCalendar.getTime()));

    }


}