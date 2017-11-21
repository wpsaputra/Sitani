package com.virtualbox.torchick.sitani.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.virtualbox.torchick.sitani.R;
import com.virtualbox.torchick.sitani.Slider.FragmentSlider;
import com.virtualbox.torchick.sitani.Slider.SliderIndicator;
import com.virtualbox.torchick.sitani.Slider.SliderPagerAdapter;
import com.virtualbox.torchick.sitani.Slider.SliderView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //custom
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    private int doAnimation = 1;

    private View view;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4};
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;

        carouselView = (CarouselView) view.findViewById(R.id.carouselView);

        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(sampleImages.length);

//        //Custom
//        SlideShowView slideShowView = (SlideShowView) view.findViewById(R.id.slideshow);
//        SlideShowAdapter slideShowAdapter = new ResourceBitmapAdapter(getContext(), new int[]{R.raw.slide_01, R.raw.slide_02, R.raw.slide_03});
//        slideShowView.setAdapter(slideShowAdapter);
//        slideShowView.play();

        // Matiin dulu
//        sliderView = (SliderView) view.findViewById(R.id.sliderView);
//        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
//        setupSlider();

        // Animation
//        if(doAnimation==1){
//            doSlideAnimation(view);
//        }

        ShimmerFrameLayout container =
                (ShimmerFrameLayout) view.findViewById(R.id.shimmer_view_container);
        container.startShimmerAnimation();

        ShimmerFrameLayout container2 =
                (ShimmerFrameLayout) view.findViewById(R.id.shimmer_view_container_2);
        container2.startShimmerAnimation();

        ShimmerFrameLayout container3 =
                (ShimmerFrameLayout) view.findViewById(R.id.shimmer_view_container_3);
        container3.startShimmerAnimation();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Do Nothing
            doAnimation = savedInstanceState.getInt("doAnimation", 0);
            Log.d("doAnimation", String.valueOf(doAnimation));
        }else{
            doSlideAnimation();
        }

    }

    private void doSlideAnimation() {
        LinearLayout linear1 = (LinearLayout) view.findViewById(R.id.linear1);
        LinearLayout linear2 = (LinearLayout) view.findViewById(R.id.linear2);

        Animation animSlide =  AnimationUtils.loadAnimation(getContext(), R.anim.slide_right_to_left);
        linear1.startAnimation(animSlide);

        Animation animSlideLeft =  AnimationUtils.loadAnimation(getContext(), R.anim.slide_left_to_right);
        linear2.startAnimation(animSlideLeft);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("doAnimation", 0);
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

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance(R.drawable.image_1));
        fragments.add(FragmentSlider.newInstance(R.drawable.image_2));
        fragments.add(FragmentSlider.newInstance(R.drawable.image_3));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getContext(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}
