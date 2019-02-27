package com.ignacio.lorenz.prrcmobile;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AllDocument extends Fragment {

    ListView listView;

    private static final String dbConnection = "http://localhost/android/all_docus.php";



    public AllDocument(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_all_docu, container, false);

        String[] docuList = {"Document 1",
        "Document 2", "Document 3"};


        ListView listView = (ListView) view.findViewById(R.id.mainMenu);



        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,docuList);

        listView.setAdapter(listViewAdapter);
        return view;

    }

}