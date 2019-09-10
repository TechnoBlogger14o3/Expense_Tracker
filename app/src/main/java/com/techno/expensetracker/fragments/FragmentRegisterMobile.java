package com.techno.expensetracker.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.techno.expensetracker.R;


public class FragmentRegisterMobile extends CoreFragment {

    private View view;
    private EditText edtMobileNumber;
    private Button btnGetOTP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        hideToolBar();
        hideBottomBar();
        initView();
        return view;
    }

    private void initView() {
        edtMobileNumber = view.findViewById(R.id.edtMobileNumber);
        btnGetOTP = view.findViewById(R.id.btnGetOTP);
        edtMobileNumber.addTextChangedListener(new GenericTextWatcher(edtMobileNumber));

        btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentOTP fragmentOTP = new FragmentOTP();
                mActivity.callFragment(fragmentOTP, false);
            }
        });

    }

    class GenericTextWatcher implements TextWatcher {
        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void afterTextChanged(Editable editable) {
            String inputText = edtMobileNumber.getText().toString();
            /*
            if (inputText.length() == 10) {
                btnGetOTP.setEnabled(true);
                btnGetOTP.setAlpha(1.0f);
            } else {
                btnGetOTP.setEnabled(false);
                btnGetOTP.setAlpha(0.7f);
            }
            */
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }
    }
}


