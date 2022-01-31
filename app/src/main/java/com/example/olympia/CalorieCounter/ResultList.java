package com.example.olympia.CalorieCounter;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.olympia.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultList extends Fragment {
    private ListView listView;

    private SearchView searchView;
    private ArrayAdapter<Object> adapter;

    ArrayAdapter<String> testAdapter;

    private ArrayList<FoodItem> foodList = CalorieCounterSearch.FoodItems;

    public static FoodItem selectedFood;
   // List<foodItem> = search.



 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ResultList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentList.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultList newInstance(String param1, String param2) {
        ResultList fragment = new ResultList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.result_list, container, false);

        //setting listview and adapter for search results
        listView = (ListView) view.findViewById(R.id.idListView);
        FoodAdapter foodAdapter = new FoodAdapter(getActivity().getApplicationContext(), R.layout.resultlist_item, foodList);
        listView.setAdapter(foodAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedFood = (FoodItem)parent.getAdapter().getItem(position);

                Intent intent = new Intent(getActivity(), AddFood.class);
                startActivity(intent);
            }
        });


        return view;
    }
}