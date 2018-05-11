package com.example.jeslin.ida;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.jeslin.ida.AdaptersAndClasses.MemberClass;
import com.example.jeslin.ida.AdaptersAndClasses.MemberInter;
import com.example.jeslin.ida.AdaptersAndClasses.MyAPI;
import com.example.jeslin.ida.AdaptersAndClasses.OnFragmentInteractionListener;
import com.example.jeslin.ida.AdaptersAndClasses.RVAdapterformembersList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link Execmember#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Execmember extends Fragment {

    private OnFragmentInteractionListener mListener;
    RecyclerView recyclerView;
    private List<MemberClass> persons;
    private Toolbar mToolbar;
    public Execmember() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment Execmember.
     */
    // TODO: Rename and change types and number of parameters
    public static Execmember newInstance() {
        Execmember fragment = new Execmember();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_execmember, container, false);
        getActivity().setTitle("Executive members");

        recyclerView=(RecyclerView)view.findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        MemberInter apiService =
                MyAPI.getClient().create(MemberInter.class);

        Call<ArrayList<MemberClass>> call = apiService.getMyObjects();

        call.enqueue(new Callback<ArrayList<MemberClass>>() {
            @Override
            public void onResponse(Call<ArrayList<MemberClass>> call, Response<ArrayList<MemberClass>> response) {
                Log.d("SIZE>>",32+" "+response.body());
                System.out.println("######################## "+response.body());
                RVAdapterformembersList adapter=new RVAdapterformembersList(getContext(),response.body());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<MemberClass>> call, Throwable t) {



            }
        });


        return view;




    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        Toast.makeText(getContext(),"hai",Toast.LENGTH_LONG).show();


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
