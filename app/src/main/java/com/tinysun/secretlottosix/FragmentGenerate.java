package com.tinysun.secretlottosix;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.tinysun.secretlottosix.CommonEnum.LOG_PREFIX;
import static com.tinysun.secretlottosix.CommonEnum.MAX_NUM_OF_LOTTO_SIX;
import static com.tinysun.secretlottosix.CommonEnum.MIN_NUM_OF_LOTTO_SIX;
import static com.tinysun.secretlottosix.CommonEnum.TOTAL_NUM_OF_LOTTO_SIX;
import static com.tinysun.secretlottosix.DummyData.PREVIOUS_WINNING_NUM_LIST;

/**
 * Created by cys on 2018. 1. 27..
 */

public class FragmentGenerate extends Fragment {

    private Unbinder unbinder;

    @BindView(R.id.generate_btn)
    Button generateBtn;

    @BindView(R.id.generate_num_tv)
    TextView generateNumTv;

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

        ArrayList<Integer> generatedNum = getLottoSixNumber();
        String strGeneratedNum = "";
        for (int i = 0; i < generatedNum.size(); i++) {
            if(i == generatedNum.size()-1){
                strGeneratedNum += generatedNum.get(i);
            }else{
                strGeneratedNum += generatedNum.get(i)+", ";
            }

        }

        generateNumTv.setText(strGeneratedNum);

    }


    private ArrayList<Integer> getLottoSixNumber(){

        ArrayList<Integer> generatedNumList = new ArrayList<>();

        Random r = new Random();

        while (true) {
            ArrayList<Integer> tmpGeneratedNumList = new ArrayList<>();

            // 1~43까지 숫자 중 6개 번호를 중복되지 않게 생성
            for (int i = 0; i < TOTAL_NUM_OF_LOTTO_SIX; i++) {
                while(true)
                {
                    Integer next = r.nextInt((MAX_NUM_OF_LOTTO_SIX+1) - MIN_NUM_OF_LOTTO_SIX) + MIN_NUM_OF_LOTTO_SIX;
                    if (!tmpGeneratedNumList.contains(next))
                    {
                        // Done for this iteration
                        tmpGeneratedNumList.add(next);
                        break;
                    }
                }
            }

            /* 생성된 번호를 검증한다.
             * RULE 중 한 가지라도 위반되는 번호라면 다시 처음부터 생성한다.
             */

            int numOfConsecutiveNum = 0;
            int numOfSameLastNum = 0;
            int numOfSamePreviousWinNum = 0;
            for (int i = 0; i < tmpGeneratedNumList.size(); i++) {
                for (int j = i+1; j < tmpGeneratedNumList.size(); j++) {
                    int targetNum1 = tmpGeneratedNumList.get(i);
                    int targetNum2 = tmpGeneratedNumList.get(j);

                    // RULE 1 : 연속되는 숫자를 1쌍 선정
                    if( (targetNum1+1) == targetNum2 || (targetNum1-1) == targetNum2 ){
                        numOfConsecutiveNum += 1;
                    }

                    // RULE 2 : 끝자리가 같은 숫자를 1쌍 선정
                    if( (targetNum1 % 10) == (targetNum2 % 10) ){
                        numOfSameLastNum += 1;
                    }
                }

                // RULE 3 : 전(前) 회차 당첨번호에서 1개를 선정
                for (int k = 0; k < PREVIOUS_WINNING_NUM_LIST.size(); k++) {
                    int targetNum1 = tmpGeneratedNumList.get(i);
                    int targetNum2 = PREVIOUS_WINNING_NUM_LIST.get(k);

                    if (targetNum1 == targetNum2){
                        numOfSamePreviousWinNum += 1;
                    }
                }
            }
            if(numOfConsecutiveNum == 1
                    && numOfSameLastNum == 1
                    && numOfSamePreviousWinNum == 1){

                Collections.sort(tmpGeneratedNumList); // 오름차순으로 정렬
                generatedNumList.addAll(tmpGeneratedNumList);
                break;
            }else{
                continue;
            }

        }

        Log.d(LOG_PREFIX, generatedNumList.get(0)+","+generatedNumList.get(1)+","+generatedNumList.get(2)+","+generatedNumList.get(3)+","+generatedNumList.get(4)+","+generatedNumList.get(5));

        return generatedNumList;
    }




    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
