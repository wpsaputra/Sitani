package com.virtualbox.torchick.sitani.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.virtualbox.torchick.sitani.Model.LinkDataForm;
import com.virtualbox.torchick.sitani.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProgressFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProgressFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgressFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    FrameLayout frameLayoutNoInternet, frameLayoutLoading;
    Button buttonNoInternet;
    LinkDataForm linkDataForm;
    FloatingActionButton fab;
    Context context;

    public ProgressFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProgressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProgressFragment newInstance(String param1, String param2) {
        ProgressFragment fragment = new ProgressFragment();
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
        return inflater.inflate(R.layout.fragment_progress, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        frameLayoutNoInternet = (FrameLayout) view.findViewById(R.id.frame_layout_no_internet);
        frameLayoutLoading = (FrameLayout) view.findViewById(R.id.frame_layout_loading);
        buttonNoInternet = (Button) view.findViewById(R.id.no_internet_button);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        context = view.getContext();

//        linkDataForm =  getIntent().getParcelableExtra("linkDataForm");
//        final WebView webView = (WebView) view.findViewById(R.id.webview);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("http://sultradata.com/project/SISERA_2/data/tampil-data2?id="+linkDataForm.getId_link());

//        linkDataForm =  getIntent().getParcelableExtra("linkDataForm");
        final WebView webView = (WebView) view.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("http://sultra.bps.go.id/sitani/index.php?r=site/index&dokumen=sp_padi&bulan=8&tahun=2017");
        webView.loadUrl("http://sultra.bps.go.id/sitani/index.php?r=site/index");

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                frameLayoutLoading.setVisibility(View.GONE);
//                frameLayoutNoInternet.setVisibility(View.GONE);

            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                frameLayoutNoInternet.setVisibility(View.VISIBLE);
            }


        });

        buttonNoInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(webView.getUrl());
                frameLayoutNoInternet.setVisibility(View.GONE);
                frameLayoutLoading.setVisibility(View.VISIBLE);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "sasas", Toast.LENGTH_SHORT).show();
                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.setting_progress_dialog, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

//                final EditText userInput = (EditText) promptsView
//                        .findViewById(R.id.editTextDialogUserInput);

                final Spinner spinner_dokumen = (Spinner) promptsView.findViewById(R.id.spinner_dokumen);
                final Spinner spinner_tahun = (Spinner) promptsView.findViewById(R.id.spinner_tahun);
                final Spinner spinner_bulan = (Spinner) promptsView.findViewById(R.id.spinner_bulan);


                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                        Log.d("Dokumen", String.valueOf(spinner_dokumen.getSelectedItemPosition()));
                                        Log.d("Tahun", String.valueOf(spinner_tahun.getSelectedItem().toString()));
                                        Log.d("Bulan", String.valueOf(spinner_bulan.getSelectedItem().toString()));

                                        String dokumen, tahun, bulan;
                                        if(spinner_dokumen.getSelectedItemPosition()==0){
                                            dokumen = "sp_padi";
                                        }else{
                                            dokumen = "sp_palawija";
                                        }
                                        tahun = spinner_tahun.getSelectedItem().toString();
                                        bulan = String.valueOf(spinner_bulan.getSelectedItemPosition()+1);

                                        webView.loadUrl(webView.getUrl()+"&dokumen="+dokumen+"&tahun="+tahun+"&bulan="+bulan);
                                        frameLayoutNoInternet.setVisibility(View.GONE);
                                        frameLayoutLoading.setVisibility(View.VISIBLE);


                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
