package com.android.vehicletracking.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.android.vehicletracking.R;


/**
 * Created by EMD028 on 9/30/2015.
 */
public class InputWidget extends LinearLayoutCompat {

    private String mErrorTextValue;
    private String mHintTextValue;
    private boolean mShowErrorText;
    private int mInputType;

    private TextInputLayout mTextInputLayout;
    private EditText mInputEditText;
    private AppCompatTextView mInputErrorTextView;

    public InputWidget(Context context) {
        super(context);
        InItInitializer(context, null, 0);
    }

    public InputWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        InItInitializer(context, attrs, 0);
    }

    public InputWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        InItInitializer(context, attrs, defStyleAttr);
    }


    private void InItInitializer(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.InputWidget,
                defStyleAttr, 0);
        try {
            mErrorTextValue = a.getString(R.styleable.InputWidget_errorText);
            mHintTextValue = a.getString(R.styleable.InputWidget_hintText);
            mShowErrorText = a.getBoolean(R.styleable.InputWidget_showError, true);
            mInputType = a.getInteger(R.styleable.InputWidget_inputType, InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } finally {
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.widget_input_view, this, true);

        mTextInputLayout = (TextInputLayout) findViewById(R.id.widget_input_layout);
        mInputEditText = (EditText) findViewById(R.id.widget_input_edit_view);
        mInputErrorTextView = (AppCompatTextView) findViewById(R.id.widget_input_error_view);

        mInputEditText.setInputType(mInputType);
        mInputEditText.setSingleLine(false);
        setHintValue(mHintTextValue);
        setErrorValue(mErrorTextValue);

        mInputErrorTextView.setVisibility(mShowErrorText ? View.INVISIBLE : View.GONE);
        mInputEditText.addTextChangedListener(new EditTextChangeListener(mInputErrorTextView));
    }

    public void setErrorValue(String errorValue) {
        mInputErrorTextView.setVisibility(View.VISIBLE);
        mInputErrorTextView.setText(errorValue);
    }

    public void setInputTypeValue(int inputType) {
        EditText appCompatEditText = mTextInputLayout.getEditText();
        if (appCompatEditText != null) {
            appCompatEditText.setInputType(inputType);
        }
    }

    public void setHintValue(String hintValue) {
        mTextInputLayout.setHint(hintValue);
    }

    public String getText() {
        return mInputEditText.getText().toString();
    }

    public void setText(String notes) {
        mInputEditText.setText(notes);
    }

    public class EditTextChangeListener implements TextWatcher {

        private AppCompatTextView mErrorTextView;

        public EditTextChangeListener(AppCompatTextView mInputErrorTextView) {
            this.mErrorTextView = mInputErrorTextView;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!TextUtils.isEmpty(s.toString()) && mShowErrorText) {
                mErrorTextView.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

}
