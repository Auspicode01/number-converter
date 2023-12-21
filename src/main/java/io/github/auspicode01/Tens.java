package io.github.auspicode01;

import lombok.Getter;

@Getter
public enum Tens {

    TEN(10, "dez"),
    ELEVEN(11, "onze"),
    TWELVE(12, "doze"),
    THIRTEEN(13, "treze"),
    FOURTEEN(14, "catorze"),
    FIFTEEN(15, "quinze"),
    SIXTEEN(16, "dezasseis"),
    SEVENTEEN(17, "dezassete"),
    EIGHTEEN(18, "dezoito"),
    NINETEEN(19, "dezanove"),
    TWENTY(20, "vinte"),
    THIRTY(30, "trinta"),
    FORTY(40, "quarenta"),
    FIFTY(50, "cinquenta"),
    SIXTY(60, "sessenta"),
    SEVENTY(70, "setenta"),
    EIGHTY(80, "oitenta"),
    NINETY(90, "noventa");

    private final int number;
    private final String numberName;

    Tens(int number, String numberName) {
        this.number = number;
        this.numberName = numberName;
    }
}
