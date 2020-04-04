package com.example.edukalp.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.edukalp.R;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private Button btn_unity_2, btn_unity_5;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        btn_unity_2 = root.findViewById(R.id.btn_unity_2);
        btn_unity_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.hovar.trygaze");
                if(launchIntent!=null){
                    startActivity(launchIntent);
                }
                else
                    Toast.makeText(getActivity(), "There is a problem", Toast.LENGTH_SHORT).show();
            }
        });
        btn_unity_5 = root.findViewById(R.id.btn_unity_5);
        btn_unity_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.Microsoft.SpeechSDKTest");
                if(launchIntent!=null){
                    startActivity(launchIntent);
                }
                else
                    Toast.makeText(getActivity(), "There is a problem", Toast.LENGTH_SHORT).show();
            }
        });
//        final TextView textView = root.findViewById(R.id.text_slideshow);
//        slideshowViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}