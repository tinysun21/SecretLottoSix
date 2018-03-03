package com.tinysun.secretlottosix;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by cys on 2018. 1. 27..
 */

public class FragmentGenerate extends Fragment {

    private Unbinder unbinder;

    @BindView(R.id.generate_btn)
    Button generateBtn;

    public static FragmentGenerate newInstance() {
        FragmentGenerate fragment = new FragmentGenerate();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_generate, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.generate_btn)
    public void onButtonClick(View view) {
        Toast.makeText(getActivity(), "Generate button clicked!", Toast.LENGTH_SHORT).show();
    }



    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
