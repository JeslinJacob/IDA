package com.example.jeslin.ida;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jeslin.ida.AdaptersAndClasses.News;
import com.example.jeslin.ida.AdaptersAndClasses.NewsAdapter;
import com.example.jeslin.ida.AdaptersAndClasses.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link NewsandEvents#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsandEvents extends Fragment {
    private List<News> newsList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public NewsandEvents() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment NewsandEvents.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsandEvents newInstance() {
        NewsandEvents fragment = new NewsandEvents();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_newsand_events, container, false);
        getActivity().setTitle("News and Evets");

        RecyclerView recyclerView=(RecyclerView)v.findViewById(R.id.rv_news);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);



        newsList=new ArrayList<>();
        initializedata();
        NewsAdapter adapter=new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);

        return v;
    }

    public void initializedata()
    {

        newsList.add(new News("Prime minister dead","There are many variations of passages of Lorem Ipsum available, but the majority have suffered "));
        newsList.add(new News("Road accident","There are many variations of passages of Lorem Ipsum available, but the majority have suffered"));
        newsList.add(new News("Relicopter landed","There are many variations of passages of Lorem Ipsum available, but the majority have suffered "));
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction("");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
