package com.example.huntingtoncafeonline;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderNumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderNumFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderNumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderNumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderNumFragment newInstance(String param1, String param2) {
        OrderNumFragment fragment = new OrderNumFragment();
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
        View view = inflater.inflate(R.layout.fragment_order_num, container, false);

        assert getArguments() != null;
        Bundle orderDetailsBundle = getArguments();
        String name = orderDetailsBundle.getString("name");

        TextView nameTextView = view.findViewById(R.id.textViewName);
        nameTextView.setText("Name: " + name);

        TextView orderNumTextView = view.findViewById(R.id.textViewOrderNum);
        orderNumTextView.setText("Your Order Number: 78");

        view.findViewById(R.id.buttonDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View doneButton) {
                Navigation.findNavController(view).navigate(R.id.action_orderNumFragment_to_homeFragment);
            }
        });

        return view;
    }
}