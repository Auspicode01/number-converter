package io.github.auspicode01;

import io.github.auspicode01.exception.InvalidInputException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static io.github.auspicode01.Constants.*;
import static io.github.auspicode01.exception.ErrorMessages.INVALID_INPUT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberConverter {

    public static String convertNumber(Integer number) {
        if (number < 0 || number > 999999) {
            throw new InvalidInputException(INVALID_INPUT);
        } else if (number < 10) {
            return convertUnits(number);
        } else if (number < 100) {
            return convertTens(number);
        } else if (number < 1000) {
            return convertHundreds(number);
        } else if (number < 10000) {
            return convertThousands(number);
        } else {
            return convertHundredsOfThousandsAndTensOfThousands(number);
        }
    }

    private static String convertUnits(Integer number) {
        String result = "";
        for (Units u : Units.values()) {
            if (number == u.getNumber()) {
                result = u.getNumberName();
            }
        }
        return result;
    }

    private static String convertTens(Integer number) {
        for (Tens t : Tens.values()) {
            if (number == t.getNumber()) {
                return t.getNumberName();
            }
        }
        if (number < 10) {
            return convertUnits(number);
        } else if (number < 30) {
            return Tens.TWENTY.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertUnits(getUnits(number)));
        } else if (number < 40) {
            return Tens.THIRTY.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertUnits(getUnits(number)));
        } else if (number < 50) {
            return Tens.FORTY.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertUnits(getUnits(number)));
        } else if (number < 60) {
            return Tens.FIFTY.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertUnits(getUnits(number)));
        } else if (number < 70) {
            return Tens.SIXTY.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertUnits(getUnits(number)));
        } else if (number < 80) {
            return Tens.SEVENTY.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertUnits(getUnits(number)));
        } else if (number < 90) {
            return Tens.EIGHTY.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertUnits(getUnits(number)));
        } else {
            return Tens.NINETY.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertUnits(getUnits(number)));
        }
    }

    private static String convertHundreds(Integer number) {
        Hundreds hundreds = iterateThroughHundredsEnum(number);
        if (!hundreds.equals(Hundreds.UNDEFINED)) {
            return hundreds.getNumberName();
        }
        if (number < 100) {
            return convertTens(getTens(number, 0));
        } else if (number < 200) {
            return ONE_HUNDRED_AND_SOMETHING_NUMBER_NAME.concat(NUMBER_NAME_CONNECTOR).concat(convertTens(getTens(number, 100)));
        } else if (number < 300) {
            return Hundreds.TWO_HUNDRED.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertTens(getTens(number, 200)));
        } else if (number < 400) {
            return Hundreds.THREE_HUNDRED.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertTens(getTens(number, 300)));
        } else if (number < 500) {
            return Hundreds.FOUR_HUNDRED.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertTens(getTens(number, 400)));
        } else if (number < 600) {
            return Hundreds.FIVE_HUNDRED.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertTens(getTens(number, 500)));
        } else if (number < 700) {
            return Hundreds.SIX_HUNDRED.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertTens(getTens(number, 600)));
        } else if (number < 800) {
            return Hundreds.SEVEN_HUNDRED.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertTens(getTens(number, 700)));
        } else if (number < 900) {
            return Hundreds.EIGHT_HUNDRED.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertTens(getTens(number, 800)));
        } else {
            return Hundreds.NINE_HUNDRED.getNumberName().concat(NUMBER_NAME_CONNECTOR).concat(convertTens(getTens(number, 900)));
        }
    }

    private static Hundreds iterateThroughHundredsEnum(Integer number) {
        for (Hundreds h : Hundreds.values()) {
            if (number == h.getNumber()) {
                return h;
            }
        }
        return Hundreds.UNDEFINED;
    }

    private static String convertThousands(Integer number) {
        String result = THOUSANDS_NUMBER_NAME;
        Integer thousands = getSecondClass(number);
        Integer hundreds = getHundreds(number, thousands * 1000);
        if (thousands != 1) {
            result = convertUnits(thousands).concat(" ").concat(THOUSANDS_NUMBER_NAME);
        }
        if (hundreds == 0) {
            return result;
        }
        if (!iterateThroughHundredsEnum(hundreds).equals(Hundreds.UNDEFINED) || hundreds < 100) {
            return result.concat(NUMBER_NAME_CONNECTOR).concat(convertHundreds(hundreds));
        } else {
            return result.concat(" ").concat(convertHundreds(hundreds));
        }
    }

    private static String convertHundredsOfThousandsAndTensOfThousands(Integer number) {
        Integer secondClass = getSecondClass(number);
        String result;
        if (secondClass < 100) {
            result = convertTens(secondClass).concat(" ").concat(THOUSANDS_NUMBER_NAME);
        } else {
            result = convertHundreds(secondClass).concat(" ").concat(THOUSANDS_NUMBER_NAME);
        }
        Integer hundreds = getHundreds(number, secondClass * 1000);
        if (hundreds == 0) {
            return result;
        }
        if (!iterateThroughHundredsEnum(hundreds).equals(Hundreds.UNDEFINED) || hundreds < 100) {
            return result.concat(NUMBER_NAME_CONNECTOR).concat(convertHundreds(hundreds));
        } else {
            return result.concat(" ").concat(convertHundreds(hundreds));
        }
    }

    private static Integer getUnits(Integer number) {
        return number % 10;
    }

    private static Integer getTens(Integer number, Integer hundreds) {
        return number - hundreds;
    }

    private static Integer getHundreds(Integer number, Integer thousands) {
        return number - thousands;
    }

    private static Integer getSecondClass(Integer number) {
        Integer result;
        result = number / 10;
        for (int i = 0; i < 2; i++) {
            result = result / 10;
        }
        return result;
    }
}
