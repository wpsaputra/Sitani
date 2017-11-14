package com.virtualbox.torchick.rog.Slider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.virtualbox.torchick.rog.R;

//import com.bumptech.glide.Glide;

/**
 * Created by ocittwo on 2/28/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class FragmentSlider extends Fragment {

    private static final String ARG_PARAM1 = "params";

    private int imageUrls;


    public FragmentSlider() {
    }

    public static FragmentSlider newInstance(int params) {
        FragmentSlider fragment = new FragmentSlider();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, params);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        imageUrls = getArguments().getInt(ARG_PARAM1);
        View view = inflater.inflate(R.layout.fragment_slider_item, container, false);


        ImageView img = (ImageView) view.findViewById(R.id.img);

//        img.setImageResource(R.drawable.webngadu);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        img.setImageResource(imageUrls);
        // Prevent memory leak
        Glide.with(getActivity()).load(imageUrls).into(img);
        return view;
    }
}