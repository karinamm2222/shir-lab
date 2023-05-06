package com.example.shiiir.ui.vneuch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.shiiir.AcademActivity;
import com.example.shiiir.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VneuchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VneuchFragment extends Fragment {
    VideoView mVideoView;
    MediaController mediaController;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VneuchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VneuchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VneuchFragment newInstance(String param1, String param2) {
        VneuchFragment fragment = new VneuchFragment();
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
        View rootview = inflater.inflate(R.layout.fragment_vneuch, container, false);
        // here you have the reference of your button

        mVideoView = (VideoView) rootview.findViewById(R.id.mVideoView);
        mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(mVideoView);
        Uri localUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.mvideo);

        mVideoView.setVideoURI(localUri);
        mVideoView.setMediaController(mediaController);

        mVideoView.start();
        return rootview;
    }
}