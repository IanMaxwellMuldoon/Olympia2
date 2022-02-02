package com.example.olympia.CalorieCounter.FoodDetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.olympia.CalorieCounter.FoodItem;
import com.example.olympia.CalorieCounter.ResultList;
import com.example.olympia.CalorieCounter.FoodItem;
import com.example.olympia.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodDetailsFragment extends Fragment {

    ListView lv;

    String[] nutrients;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodDetailsFragment newInstance(String param1, String param2) {
        FoodDetailsFragment fragment = new FoodDetailsFragment();
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
        FoodItem selectedFood = new FoodItem();
        selectedFood = ResultList.selectedFood;
        nutrients = selectedFood.getStringArray();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_details, container, false);

        //listview and adapter
        ListView listview = (ListView) view.findViewById(R.id.detaillistid);
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.food_detail_item, nutrients);
        return view;
    }
}