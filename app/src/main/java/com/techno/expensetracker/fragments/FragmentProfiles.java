package com.techno.expensetracker.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.techno.expensetracker.R;


public class FragmentProfiles extends CoreFragment {

    private View view;
    private EditText edtName;
    private TextView txtProfileName, txtTitle;
    private Button btnSave;
    RadioButton rbMale, rbFemale, rb1824, rb2534, rb3544, rb45;
    RadioGroup radioGender, radioAgeGroup, radio1834, radio35;
    ImageView imgProfile,imgLogOut;
    String strDummyImageURL = "https://blog.zenstudios.com/wp-content/uploads/2012/09/Zen_Pinball_THD_The_Avengers_key_art_300dpi_02.jpg";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profiles, container, false);
        hideToolBar();
        showBottomBar();
        initView();
        return view;
    }

    private void initView() {
        edtName = view.findViewById(R.id.edtName);
        txtProfileName = view.findViewById(R.id.txtProfileName);
        txtTitle = view.findViewById(R.id.txtTitle);
        btnSave = view.findViewById(R.id.btnSave);
        imgProfile = view.findViewById(R.id.imgProfile);
        imgLogOut = view.findViewById(R.id.imgLogOut);

        radioGender = view.findViewById(R.id.radioGender);

        radio1834 = view.findViewById(R.id.radio1834);
        radio35 = view.findViewById(R.id.radio35);

        rbMale = view.findViewById(R.id.rbMale);
        rbFemale = view.findViewById(R.id.rbFemale);

        rb1824 = view.findViewById(R.id.rb1824);
        rb2534 = view.findViewById(R.id.rb2534);

        rb3544 = view.findViewById(R.id.rb3544);
        rb45 = view.findViewById(R.id.rb45);

        radioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbMale.isChecked()) {
                    Toast.makeText(getActivity(), "Male", Toast.LENGTH_SHORT).show();
                    rbFemale.setAlpha(0.5f);
                    rbMale.setAlpha(1.0f);
                }
                if (rbFemale.isChecked()) {
                    Toast.makeText(getActivity(), "Female", Toast.LENGTH_SHORT).show();
                    rbMale.setAlpha(0.5f);
                    rbFemale.setAlpha(1.0f);
                }
            }
        });


        radio1834.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rb1824.isChecked()) {
                    Toast.makeText(getActivity(), "18-24", Toast.LENGTH_SHORT).show();
                    rb1824.setAlpha(1.0f);
                    rb2534.setAlpha(0.5f);
                    rb45.setAlpha(0.5f);
                    rb3544.setAlpha(0.5f);
                }
                if (rb2534.isChecked()) {
                    Toast.makeText(getActivity(), "25-34", Toast.LENGTH_SHORT).show();
                    rb2534.setAlpha(1.0f);
                    rb1824.setAlpha(0.5f);
                    rb45.setAlpha(0.5f);
                    rb3544.setAlpha(0.5f);
                }
            }
        });

        radio35.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rb3544.isChecked()) {
                    Toast.makeText(getActivity(), "35-44", Toast.LENGTH_SHORT).show();
                    rb3544.setAlpha(1.0f);
                    rb1824.setAlpha(0.5f);
                    rb2534.setAlpha(0.5f);
                    rb45.setAlpha(0.5f);
                }
                if (rb45.isChecked()) {
                    Toast.makeText(getActivity(), "44+", Toast.LENGTH_SHORT).show();
                    rb45.setAlpha(1.0f);
                    rb1824.setAlpha(0.5f);
                    rb2534.setAlpha(0.5f);
                    rb3544.setAlpha(0.5f);
                }
            }
        });

        Glide.with(mActivity)
                .load(strDummyImageURL)
                .apply(RequestOptions.circleCropTransform())
                .into(imgProfile);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentCategories fragmentCategories = new FragmentCategories();
                mActivity.callFragment(fragmentCategories, false);
            }
        });

        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.onBackPressed();
            }
        });

        imgLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}


