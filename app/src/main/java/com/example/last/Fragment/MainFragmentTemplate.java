package com.example.last.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.last.R;
import com.example.last.adapter.PhotoListAdapter;
import com.example.last.adapter.PhotoListAdapter;
import com.example.last.dao.PhotoitemcollectionDao;
import com.example.last.manager.http.HttpManager;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MainFragmentTemplate extends Fragment {
    ListView listView;
    PhotoListAdapter listAdapter;

    public MainFragmentTemplate() {
        super();
    }

    public static MainFragmentTemplate newInstance() {
        MainFragmentTemplate fragment = new MainFragmentTemplate();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        listView =(ListView)rootView.findViewById(R.id.listView);
        // Init 'View' instance(s) with rootView.findViewById here
        listAdapter = new PhotoListAdapter();
        listView.setAdapter(listAdapter);
        Call<PhotoitemcollectionDao> Call = HttpManager.getInstance().getService().loadPhotoList();
        Call.enqueue(new Callback<PhotoitemcollectionDao>() {
            @Override
            public void onResponse(retrofit2.Call<PhotoitemcollectionDao> call,
                                   Response<PhotoitemcollectionDao> response) {
                if(response.isSuccessful()){
                    PhotoitemcollectionDao dao= response.body();
                    Toast.makeText(getActivity(),
                            dao.getResults().get(0).getName(),
                            Toast.LENGTH_SHORT)
                            .show();
                }else {
                    try {
                        Toast.makeText(getActivity(),
                                response.errorBody().string(),
                                Toast.LENGTH_SHORT)
                                .show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(retrofit2.Call<PhotoitemcollectionDao> call,
                                  Throwable throwable) {
                Toast.makeText(getActivity(),
                        throwable.toString(),
                        Toast.LENGTH_SHORT)
                        .show();

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
}
