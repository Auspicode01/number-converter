package io.github.auspicode01;

import lombok.Getter;

@Getter
public enum Hundreds {

    UNDEFINED(0, ""),
    ONE_HUNDRED(100, "cem"),
    TWO_HUNDRED(200, "duzentos"),
    THREE_HUNDRED(300, "trezentos"),
    FOUR_HUNDRED(400, "quatrocentos"),
    FIVE_HUNDRED(500, "quinhentos"),
    SIX_HUNDRED(600, "seiscentos"),
    SEVEN_HUNDRED(700, "setecentos"),
    EIGHT_HUNDRED(800, "oitocentos"),
    NINE_HUNDRED(900, "novecentos");

    private final int number;
    private final String numberName;

    Hundreds(int number, String numberName) {
        this.number = number;
        this.numberName = numberName;
    }
}
