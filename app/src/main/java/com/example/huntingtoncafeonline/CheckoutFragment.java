package com.example.huntingtoncafeonline;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CheckoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckoutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CheckoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckoutFragment newInstance(String param1, String param2) {
        CheckoutFragment fragment = new CheckoutFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_checkout, container, false);

        assert getArguments() != null;
        String previousOrderDetails = getArguments().getString("orderDetails");
        String selectedGrillOption = getArguments().getString("selectedGrillOption");
        String selectedCheeseOption = getArguments().getString("selectedCheeseOption");
        ArrayList<String> selectedToppings = getArguments().getStringArrayList("selectedToppings");

        TextView orderDetails = view.findViewById(R.id.textViewOrderDetails);
        String potentialOrderDetails = previousOrderDetails + "\n" + selectedGrillOption + "\n" + selectedCheeseOption + "\n" + selectedToppings;

        if (potentialOrderDetails.contains("null")) {
            orderDetails.append(selectedGrillOption + "\n" + selectedCheeseOption + "\n" + selectedToppings + "\n");
        }
        else {
            orderDetails.append(previousOrderDetails + "\n" + selectedGrillOption + "\n" + selectedCheeseOption + "\n" + selectedToppings + "\n");
        }

        EditText nameField = view.findViewById(R.id.editTextName);

        Bundle orderDetailsBundle = new Bundle();
        orderDetailsBundle.putString("orderDetails", orderDetails.getText().toString());
        orderDetailsBundle.putString("source", "checkout");

        view.findViewById(R.id.buttonAddNewItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View addNewItemButton) {
                Navigation.findNavController(view).navigate(R.id.action_checkoutFragment_to_grillFragment, orderDetailsBundle);
            }
        });

        view.findViewById(R.id.buttonCheckout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View checkoutButton) {
                String name = nameField.getText().toString();

                if (name.isEmpty()) {
                    Toast toast = Toast.makeText(getActivity(),"Please enter your name.", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                orderDetailsBundle.putString("name", name);

                Navigation.findNavController(view).navigate(R.id.action_checkoutFragment_to_orderNumFragment, orderDetailsBundle);
            }
        });

        return view;
    }
}