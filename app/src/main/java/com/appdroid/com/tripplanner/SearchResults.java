package com.appdroid.com.tripplanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class SearchResults extends Activity {
    /*public static android.support.v4.app.Fragment newInstance(Context context) {
        SearchResults fr = new SearchResults();
        return fr;
    }*/


   /* public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_search_results, null);

        Spinner spinSortBy = (Spinner)root.findViewById(R.id.spinSortBy);
        ArrayAdapter<String> adapter;
        List<String> list;
        list = new ArrayList<String>();
        list.add("sort by rating");
        list.add("sort by closing times");
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSortBy.setAdapter(adapter);

        String [] prgmNameList={"Place1","Place2","Place3","Place4","Place5","Place6","Place7","Place8"};
        ListView lv=(ListView)root.findViewById(R.id.listView_searchResults);
        lv.setAdapter(new CustomAdapter(this,prgmNameList));

        return root;
    }*/

    ListView lv;
    ArrayList<String> placesList,placesIdList;
    Spinner spinSortBy;
    ArrayAdapter<String> adapter;
    List<String> list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search_results);
        spinSortBy = (Spinner)findViewById(R.id.spinSortBy);
        lv=(ListView)findViewById(R.id.listView_searchResults);

        placesList= getIntent().getStringArrayListExtra("placesList");
        placesIdList= getIntent().getStringArrayListExtra("placesIdList");

        Toast.makeText(getBaseContext(),String.valueOf(placesList.size()),Toast.LENGTH_SHORT).show();
        /*for(int i=0;i<placesList.size();i++)
            Toast.makeText(getBaseContext(),placesList.get(i).toString(),Toast.LENGTH_SHORT).show();
*/

        list = new ArrayList<String>();
        list.add("sort by rating");
        list.add("sort by closing times");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, placesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinSortBy.setAdapter(adapter);

        //String [] prgmNameList={"Place1","Place2","Place3","Place4","Place5","Place6","Place7","Place8"};

        //lv.setAdapter(adapter);
        boolean set=checkLists(placesList,placesIdList);
        if(!set)
            Toast.makeText(getBaseContext(),"No results to display!",Toast.LENGTH_LONG).show();
        else
        {
            lv.setAdapter(new CustomAdapter(this, placesList.toArray(new String[placesList.size()]), placesIdList.toArray(new String[placesIdList.size()])));
            Toast.makeText(getBaseContext(), "lv length " + String.valueOf(lv.getCount()), Toast.LENGTH_LONG).show();
        }

    }

    public boolean checkLists(ArrayList<String> placesList,ArrayList<String> placesIdList)
    {
        if((placesList.size()==placesIdList.size())) {
            if (placesList.size() > 0)
                return true;
            else
                return false;
        }
        else
            return false;
    }

}
