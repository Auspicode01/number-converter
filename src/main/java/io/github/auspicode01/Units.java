package io.github.auspicode01;

import lombok.Getter;

@Getter
public enum Units {

    ZERO(0, "zero"),
    ONE(1, "um"),
    TWO(2, "dois"),
    THREE(3, "três"),
    FOUR(4, "quatro"),
    FIVE(5, "cinco"),
    SIX(6, "seis"),
    SEVEN(7, "sete"),
    EIGHT(8, "oito"),
    NINE(9, "nove");

    private final int number;
    private final String numberName;

    Units(int number, String numberName) {
        this.number = number;
        this.numberName = numberName;
    }
}
