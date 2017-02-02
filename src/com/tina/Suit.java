package com.tina;

import java.util.NoSuchElementException;

/**
 * Created by tianrui on 2017-01-20.
 * create 4 suits by using enum
 */
public enum Suit {

    Spade(0), Heart(1), Club(2), Diamond(3);
    private int value;
    private Suit(int v) {
        value = v;
    }
    public int getValue(){
        return value;
    }
    public static  Suit getSuitFromValue(int value){
        switch (value){
            case 0:
                return Spade;
            case 1:
                return Heart;
            case 2:
                return Club;
            case 3:
                return Diamond;
            default:
                throw new IllegalArgumentException("Illegal playing card suit");
        }
    }
}
