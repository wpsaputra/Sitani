package com.virtualbox.torchick.rog.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.virtualbox.torchick.rog.Adapter.IstilahAdapter;
import com.virtualbox.torchick.rog.Adapter.PublikasiAdapter;
import com.virtualbox.torchick.rog.Database.ModelIndikator;
import com.virtualbox.torchick.rog.Database.ModelIstilah;
import com.virtualbox.torchick.rog.Model.Indikator;
import com.virtualbox.torchick.rog.Model.Istilah;
import com.virtualbox.torchick.rog.Model.Publikasi;
import com.virtualbox.torchick.rog.Network.ApiClient;
import com.virtualbox.torchick.rog.Network.ApiInterface;
import com.virtualbox.torchick.rog.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EnsiklopediaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EnsiklopediaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnsiklopediaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    // Custom
    private List<Istilah> istilahList = new ArrayList<>();
    private RecyclerView recyclerView;
    private IstilahAdapter istilahAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private FrameLayout frameLayout, frameLayoutSearchNotFound;
    private Button noInternetButton, backButton;
    private ConstraintLayout constraintLayoutLoading;
    LinearLayoutManager mLayoutManager;

    public EnsiklopediaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EnsiklopediaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EnsiklopediaFragment newInstance(String param1, String param2) {
        EnsiklopediaFragment fragment = new EnsiklopediaFragment();
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
        return inflater.inflate(R.layout.fragment_ensiklopedia, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        frameLayout = (FrameLayout) view.findViewById(R.id.frame_layout);
        noInternetButton = (Button) view.findViewById(R.id.no_internet_button);
        constraintLayoutLoading = (ConstraintLayout) view.findViewById(R.id.loading_layout);

        frameLayoutSearchNotFound = (FrameLayout) view.findViewById(R.id.frame_layout_not_found);
        backButton = (Button) view.findViewById(R.id.back_button);



        istilahAdapter = new IstilahAdapter(istilahList, getContext());
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(istilahAdapter);

        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                getPublikasiOffset();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPublikasiOffset();
            }
        });
        noInternetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPublikasiOffset();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPublikasiOffset();
            }
        });
    }

    private void getPublikasiOffset() {
        swipeRefreshLayout.setRefreshing(true);

        ModelIstilah mp = new ModelIstilah(getContext());
//        List<Indikator> lp = mp.getAll();
        List<Istilah> lp = mp.getAll();

        istilahList.clear();

        for(int i=0; i<lp.size(); i++){
            System.out.println(lp.get(i));
            istilahList.add(lp.get(i));
        }



        istilahAdapter.notifyDataSetChanged();
        frameLayoutSearchNotFound.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
    }


    public void getIstilahBySearch(String search) {
        swipeRefreshLayout.setRefreshing(true);

        ModelIstilah mp = new ModelIstilah(getContext());
//        List<Indikator> lp = mp.getAll();
        List<Istilah> lp = mp.getByQuery(search);

        istilahList.clear();

        for(int i=0; i<lp.size(); i++){
            System.out.println(lp.get(i));
            istilahList.add(lp.get(i));
        }

        if(lp.size()==0){
            frameLayoutSearchNotFound.setVisibility(View.VISIBLE);
        }

        istilahAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
