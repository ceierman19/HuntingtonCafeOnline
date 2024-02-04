package com.example.huntingtoncafeonline;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomizationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomizationsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CustomizationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomizationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CustomizationsFragment newInstance(String param1, String param2) {
        CustomizationsFragment fragment = new CustomizationsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    String cheese;
    //ArrayList<String> toppings = new ArrayList<String>();
    Set<String> toppingsSet = new HashSet<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customizations, container, false);

        assert getArguments() != null;
        String orderDetails = getArguments().getString("orderDetails");
        String selectedGrillOption = getArguments().getString("selectedGrillOption");
//        TextView test = view.findViewById(R.id.textViewCustomizationsHeader);
//        test.append(selectedGrillOption);

        Bundle bundle = new Bundle();

        view.findViewById(R.id.buttonAddToOrder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View addToOrderButton) {
                RadioButton cheeseOption1 = view.findViewById(R.id.radioButtonCheeseOption1);
                RadioButton cheeseOption2 = view.findViewById(R.id.radioButtonCheeseOption2);
                RadioButton cheeseOption3 = view.findViewById(R.id.radioButtonCheeseOption3);
                RadioButton cheeseOption4 = view.findViewById(R.id.radioButtonCheeseOption4);
                RadioButton cheeseOption5 = view.findViewById(R.id.radioButtonCheeseOption5);

                if (cheeseOption2.isChecked()) {
                    cheese = "American";
                }
                else if (cheeseOption3.isChecked()) {
                    cheese = "Cheddar";
                }
                else if (cheeseOption4.isChecked()) {
                    cheese = "Pepper Jack";
                }
                else if (cheeseOption5.isChecked()) {
                    cheese = "Provolone";
                }
                else {
                    cheese = "No Cheese";
                }

                CheckBox toppingOption1 = view.findViewById(R.id.checkboxToppings1);
                CheckBox toppingOption2 = view.findViewById(R.id.checkboxToppings2);
                CheckBox toppingOption3 = view.findViewById(R.id.checkboxToppings3);
                CheckBox toppingOption4 = view.findViewById(R.id.checkboxToppings4);

                if (toppingOption1.isChecked()) {
                    toppingsSet.add("Lettuce");
                }
                if (toppingOption2.isChecked()) {
                    toppingsSet.add("Tomato");
                }
                if (toppingOption3.isChecked()) {
                    toppingsSet.add("Pickles");
                }
                if (toppingOption4.isChecked()) {
                    toppingsSet.add("Onions");
                }

                ArrayList<String> toppingsList = new ArrayList<String>(toppingsSet);

                bundle.putString("orderDetails", orderDetails);
                bundle.putString("selectedGrillOption", selectedGrillOption);
                bundle.putString("selectedCheeseOption", cheese);
                bundle.putStringArrayList("selectedToppings", toppingsList);
                Navigation.findNavController(view).navigate(R.id.action_customizationsFragment_to_checkoutFragment, bundle);
            }
        });

        return view;
    }
}