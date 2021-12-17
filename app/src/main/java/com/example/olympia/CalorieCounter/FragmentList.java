package com.example.olympia.CalorieCounter;

import android.os.Bundle;

import androidx.core.app.ComponentActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.olympia.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentList extends Fragment {
    ListView listView;

    SearchView searchView;
    ArrayAdapter<Object> adapter;

    ArrayAdapter<String> testAdapter;
    String[] stringData;
    String[] testData = {"Hamburger", "Chicken", "Toast", "Fries", "Salad", "Pizza", "Cheese"};
    ArrayList<foodItem> foodList = CalorieCounterSearch.foodItems;

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

    public FragmentList() {
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
    public static FragmentList newInstance(String param1, String param2) {
        FragmentList fragment = new FragmentList();
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

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = (ListView) view.findViewById(R.id.idListView);
        testAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getStringList());
        listView.setAdapter(testAdapter);
        return view;
    }
    private String[] getStringList(){
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < foodList.size(); i++){
            String test = foodList.get(i).getLabel();
            String test2 = foodList.get(i+1).getLabel();
            if(foodList.get(i).getLabel().equals(foodList.get(i+1).getLabel())){
                list.add(foodList.get(i).getLabel());
                break;
            }
            list.add(foodList.get(i).getLabel());
        }
        return list.toArray(new String[list.size()]);
    }
}