package com.tinysun.secretlottosix;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by YS CHOI on 2017-12-31.
 */

public class CustomInputPreWinNumDialog extends Dialog {

    Context context;

    EditText mInputEt_1;
    EditText mInputEt_2;
    EditText mInputEt_3;
    EditText mInputEt_4;
    EditText mInputEt_5;
    EditText mInputEt_6;

    Button mCancelBtn;
    Button mOkBtn;

    Boolean isCancel = true;
    ArrayList<Integer> inputNum;

    public CustomInputPreWinNumDialog(@NonNull Context _context) {
        super(_context);

        context = _context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀 바 삭제
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setContentView(R.layout.custom_input_pre_win_num_dialog);

        mInputEt_1 = (EditText)findViewById(R.id.custom_dialog_et_1);
        mInputEt_2 = (EditText)findViewById(R.id.custom_dialog_et_2);
        mInputEt_3 = (EditText)findViewById(R.id.custom_dialog_et_3);
        mInputEt_4 = (EditText)findViewById(R.id.custom_dialog_et_4);
        mInputEt_5 = (EditText)findViewById(R.id.custom_dialog_et_5);
        mInputEt_6 = (EditText)findViewById(R.id.custom_dialog_et_6);

        mCancelBtn = (Button)findViewById(R.id.custom_dialog_cancel_btn);
        mOkBtn = (Button)findViewById(R.id.custom_dialog_ok_btn);

        mCancelBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        mOkBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                isCancel = false;

                int num1 = (Integer)Integer.valueOf(mInputEt_1.getText().toString());
                int num2 = (Integer)Integer.valueOf(mInputEt_2.getText().toString());
                int num3 = (Integer)Integer.valueOf(mInputEt_3.getText().toString());
                int num4 = (Integer)Integer.valueOf(mInputEt_4.getText().toString());
                int num5 = (Integer)Integer.valueOf(mInputEt_5.getText().toString());
                int num6 = (Integer)Integer.valueOf(mInputEt_6.getText().toString());

                inputNum = new ArrayList<Integer>();

                inputNum.add(0, num1);
                inputNum.add(1, num2);
                inputNum.add(2, num3);
                inputNum.add(3, num4);
                inputNum.add(4, num5);
                inputNum.add(5, num6);

                dismiss();
            }
        });
    }

    public Boolean isCancel() { return isCancel; }
    public ArrayList<Integer> getInputNum() { return inputNum; }

}
