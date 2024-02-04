package com.example.huntingtoncafeonline;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GrillFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GrillFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GrillFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GrillFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GrillFragment newInstance(String param1, String param2) {
        GrillFragment fragment = new GrillFragment();
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

    String selectedGrillOption;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grill, container, false);

        assert getArguments() != null;
        String source = getArguments().getString("source");
        String orderDetails = getArguments().getString("orderDetails");

        Bundle bundle = new Bundle();

        if (source.equals("checkout")) {
            bundle.putString("orderDetails", orderDetails);
        }

        view.findViewById(R.id.buttonGrillOption1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View grillOption1Button) {
                selectedGrillOption = "Burger";
                bundle.putString("selectedGrillOption", selectedGrillOption);
                Navigation.findNavController(view).navigate(R.id.action_grillFragment_to_customizationsFragment, bundle);
            }
        });

        view.findViewById(R.id.buttonGrillOption2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View grillOption2Button) {
                selectedGrillOption = "Chicken Sandwich";
                bundle.putString("selectedGrillOption", selectedGrillOption);
                Navigation.findNavController(view).navigate(R.id.action_grillFragment_to_customizationsFragment, bundle);
            }
        });

        view.findViewById(R.id.buttonGrillOption3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View grillOption3Button) {
                selectedGrillOption = "Quesadilla";
                bundle.putString("selectedGrillOption", selectedGrillOption);
                Navigation.findNavController(view).navigate(R.id.action_grillFragment_to_customizationsFragment, bundle);
            }
        });

        view.findViewById(R.id.buttonGrillOption4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View grillOption4Button) {
                selectedGrillOption = "Daily Special";
                bundle.putString("selectedGrillOption", selectedGrillOption);
                Navigation.findNavController(view).navigate(R.id.action_grillFragment_to_customizationsFragment, bundle);
            }
        });

        return view;
    }
}