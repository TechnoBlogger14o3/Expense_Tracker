package com.techno.expensetracker;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class FragmentOTP extends Fragment {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_otp, container, false);
        initView();
        return view;
    }

    private void initView() {


        editText1.addTextChangedListener(new GenericTextWatcher(editText1));
        editText2.addTextChangedListener(new GenericTextWatcher(editText2));
        editText3.addTextChangedListener(new GenericTextWatcher(editText3));
        editText4.addTextChangedListener(new GenericTextWatcher(editText4));
    }

    class GenericTextWatcher implements TextWatcher {
        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // TODO Auto-generated method stub
            String text = editable.toString();
            switch (view.getId()) {

                case R.id.editText1:
                    if (text.length() == 1)
                        editText2.requestFocus();
                    break;
                case R.id.editText2:
                    if (text.length() == 1)
                        editText3.requestFocus();
                    else if (text.length() == 0)
                        editText1.requestFocus();
                    break;
                case R.id.editText3:
                    if (text.length() == 1)
                        editText4.requestFocus();
                    else if (text.length() == 0)
                        editText2.requestFocus();
                    break;
                case R.id.editText4:
                    if (text.length() == 0)
                        editText3.requestFocus();
                    break;
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
        }
    }
}


