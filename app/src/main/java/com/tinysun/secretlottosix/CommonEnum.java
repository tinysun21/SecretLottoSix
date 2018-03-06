package com.tinysun.secretlottosix;

import java.util.ArrayList;

/**
 * Created by YS CHOI on 2018-01-01.
 */

public class CommonEnum {

    public static final String LOG_PREFIX = "SECRET_LOTTO_SIX_LOG";
    public static final int TOTAL_NUM_OF_LOTTO_SIX = 6;
    public static final int MIN_NUM_OF_LOTTO_SIX = 1;
    public static final int MAX_NUM_OF_LOTTO_SIX = 43;

    public static int PREVIOUS_ROUNDS;
    public static ArrayList<Integer> PREVIOUS_WINNING_NUM_LIST;

    // 카운트 최대값
    public enum CountMaxValue{

        COUNT_MAX_VALUE(100);

        private int maxValue;

        CountMaxValue(int i) {
            maxValue = i;
        }

        public int getCountMaxValue() {
            return maxValue;
        }
    }

    // 카운트 1세트 카운트 수
    public enum CountNumOf1Set{

        COUNT_NUM_OF_1_SET(5);

        private int num;

        CountNumOf1Set(int i) {
            num = i;
        }

        public int getCountNumOf1Set() {
            return num;
        }
    }

    // 카운트 1줄 전체의 카운트 수
    public enum CountNumOf1Line{

        COUNT_NUM_OF_1_LINE(10);

        private int num;

        CountNumOf1Line(int i) {
            num = i;
        }

        public int getCountNumOf1Line() {
            return num;
        }
    }

    // 카운트 1줄 전체의 카운트 수
    public enum CountLayoutParams{

        RELATIVE_LAYOUT_TOP_MARGIN(16),
        IMAGE_VIEW_LEFT_MARGIN(24);

        private int margin;

        CountLayoutParams(int i) {
            margin = i;
        }

        public int getMargin() {
            return margin;
        }
    }

}
