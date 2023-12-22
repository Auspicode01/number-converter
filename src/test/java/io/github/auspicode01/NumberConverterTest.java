package io.github.auspicode01;

import io.github.auspicode01.exception.InvalidInputException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.github.auspicode01.exception.ErrorMessages.INVALID_INPUT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberConverterTest {

    @ParameterizedTest
    @CsvSource(value = {"0:zero", "1:um", "2:dois", "3:três", "4:quatro", "5:cinco", "6:seis", "7:sete", "8:oito", "9:nove"}, delimiter = ':')
    void whenConvertUnits_ReturnString(Integer number, String expectedResult) {
        String result = NumberConverter.convertNumber(number);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"10:dez", "11:onze", "12:doze", "13:treze", "14:catorze", "15:quinze", "16:dezasseis", "17:dezassete", "18:dezoito", "19:dezanove", "20:vinte", "30:trinta", "40:quarenta", "50:cinquenta", "60:sessenta", "70:setenta", "80:oitenta", "90:noventa", "24:vinte e quatro", "36:trinta e seis", "43:quarenta e três", "59:cinquenta e nove", "61:sessenta e um", "78:setenta e oito", "85:oitenta e cinco", "92:noventa e dois"}, delimiter = ':')
    void whenConvertTens_ReturnString(Integer number, String expectedResult) {
        String result = NumberConverter.convertNumber(number);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"100:cem", "200:duzentos", "300:trezentos", "400:quatrocentos", "500:quinhentos", "600:seiscentos", "700:setecentos", "800:oitocentos", "900:novecentos", "109:cento e nove", "126:cento e vinte e seis", "237:duzentos e trinta e sete", "408:quatrocentos e oito", "513:quinhentos e treze", "617:seiscentos e dezassete", "654:seiscentos e cinquenta e quatro", "749:setecentos e quarenta e nove", "838:oitocentos e trinta e oito", "902:novecentos e dois", "999:novecentos e noventa e nove"}, delimiter = ':')
    void whenConvertHundreds_ReturnString(Integer number, String expectedResult) {
        String result = NumberConverter.convertNumber(number);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:mil", "2000:dois mil", "3000:três mil", "4000:quatro mil", "5000:cinco mil", "6000:seis mil", "7000:sete mil", "8000:oito mil", "9000:nove mil", "1109:mil cento e nove", "2126:dois mil cento e vinte e seis", "3237:três mil duzentos e trinta e sete", "4408:quatro mil quatrocentos e oito", "5513:cinco mil quinhentos e treze", "6617:seis mil seiscentos e dezassete", "7654:sete mil seiscentos e cinquenta e quatro", "8749:oito mil setecentos e quarenta e nove", "9838:nove mil oitocentos e trinta e oito", "3002:três mil e dois", "9999:nove mil novecentos e noventa e nove"}, delimiter = ':')
    void whenConvertThousands_ReturnString(Integer number, String expectedResult) {
        String result = NumberConverter.convertNumber(number);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000:dez mil", "12000:doze mil", "13000:treze mil", "14000:catorze mil", "15000:quinze mil", "16000:dezasseis mil", "17000:dezassete mil", "18000:dezoito mil", "19000:dezanove mil", "20000:vinte mil", "30000:trinta mil", "40000:quarenta mil", "50000:cinquenta mil", "60000:sessenta mil", "70000:setenta mil", "80000:oitenta mil", "90000:noventa mil", "21109:vinte e um mil cento e nove", "32126:trinta e dois mil cento e vinte e seis", "43237:quarenta e três mil duzentos e trinta e sete", "54408:cinquenta e quatro mil quatrocentos e oito", "65513:sessenta e cinco mil quinhentos e treze", "76617:setenta e seis mil seiscentos e dezassete", "87654:oitenta e sete mil seiscentos e cinquenta e quatro", "98749:noventa e oito mil setecentos e quarenta e nove", "19838:dezanove mil oitocentos e trinta e oito", "13002:treze mil e dois", "99999:noventa e nove mil novecentos e noventa e nove"}, delimiter = ':')
    void whenConvertTensOfThousands_ReturnString(Integer number, String expectedResult) {
        String result = NumberConverter.convertNumber(number);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"100000:cem mil", "200000:duzentos mil", "300000:trezentos mil", "400000:quatrocentos mil", "500000:quinhentos mil", "600000:seiscentos mil", "700000:setecentos mil", "800000:oitocentos mil", "900000:novecentos mil", "234006:duzentos e trinta e quatro mil e seis", "307149:trezentos e sete mil cento e quarenta e nove", "430012:quatrocentos e trinta mil e doze", "566937:quinhentos e sessenta e seis mil novecentos e trinta e sete", "609200:seiscentos e nove mil e duzentos", "741522:setecentos e quarenta e um mil quinhentos e vinte e dois", "815001:oitocentos e quinze mil e um", "984430:novecentos e oitenta e quatro mil quatrocentos e trinta", "999999:novecentos e noventa e nove mil novecentos e noventa e nove"}, delimiter = ':')
    void whenConvertHundredsOfThousands_ReturnString(Integer number, String expectedResult) {
        String result = NumberConverter.convertNumber(number);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-123", "1000000"})
    void whenConvertInvalidNumber_ThrowInvalidInputException(Integer number) {
        InvalidInputException invalidInputException = assertThrows(InvalidInputException.class, () -> NumberConverter.convertNumber(number));

        assertThat(invalidInputException.getMessage()).isEqualTo(INVALID_INPUT);
    }
}