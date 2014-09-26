package com.ubante.oven.ctf;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ubante 9/26/14 10:36 AM
 * This is very serious business.
 */
public class OnesComplement {
//    Long.MAX_VALUE: 9223372036854775807
//    Integer.MAX_VALUE: 2147483647
    long decimal;
    String binary;
    String onesComplement;
    int onesComplementDecimal;

    OnesComplement(long decimal) {
        this.decimal = decimal;
        toBinary();
        toOnesComplement();
        toOnesComplementDecimal();
    }

    void toBinary() {
        long dec = decimal;
        binary = "";

        while (dec > 0) {
            long digit = dec % 2;
            binary = digit+binary;
            dec = dec / 2;
        }
    }

    void toOnesComplement() {
        onesComplement = "";
        for (char oneOrZero: binary.toCharArray()) {
            if (oneOrZero == '1') {
                onesComplement += 0;
            } else {
                onesComplement += 1;
            }
        }
    }

    void toOnesComplementDecimal() {
        onesComplementDecimal = 0;
        int power = 0;
        char[] reversed = onesComplement.toCharArray();
        ArrayUtils.reverse(reversed);

        for (char oneOrZero: reversed) {
            if (oneOrZero == '1') {
                onesComplementDecimal += Math.pow(2,power);
            }
            power++;
        }
    }




    public static void main(String[] args) {
        Long total = 0L;
//        List<Integer> numbers =
//                new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        List<Long> numbers1 =
                new ArrayList<Long>(Arrays.asList(
                        214030627L, 2582232842L, 3350859148L, 2538003716L,
                        2697071329L, 1839751079L, 2549119347L, 3064400290L,
                        279794261L, 2671725070L, 623406751L, 2446181947L,
                        4003695875L, 2238736950L, 1387696180L, 101088546L,
                        2675810154L, 2254329209L, 1435352466L, 1506870942L,
                        3576225740L, 1796307569L, 224151451L, 345791926L,
                        3160873761L, 3593153752L, 2102244700L, 1631780643L,
                        1033870757L, 2752089960L, 1377829633L, 956013193L,
                        4294958664L, 4160701632L, 1L, 4160589812L,
                        0L, 0L, 4294958664L, 134515022L
                ));
        List<Long> numbers2 =
                new ArrayList<Long>(Arrays.asList(
                        2350007736L, 1889397872L, 4216836850L, 2449916505L,
                        984786217L, 1778023568L, 1303256678L, 523376402L,
                        339182230L, 516832253L, 628291241L, 3245348967L,
                        3431887009L, 3667746593L, 2308738545L, 2604743862L,
                        1132204426L, 798401992L, 2656110085L, 381638998L,
                        4149824244L, 3555672227L, 2933026328L, 646425559L,
                        3819082655L, 358943078L, 1318430141L, 3414102663L,
                        3464754150L, 301777294L, 3386310709L, 1116096035L,
                        4294958664L, 4160701632L, 1L, 4160589812L,
                        0L, 0L, 4294958664L, 134515022L
                ));

        List<Long> numbers = numbers2;

        System.out.printf("%13s\t%40s\t%40s\t%13s\t%13s\n","i","bin","get1comp","1comp_dec","sum");
        System.out.printf("%13s\t%40s\t%40s\t%13s\t%13s\n","-","---","--------","---------","---");

//        for (int i=120; i<=130; i++) {
        for (Long i: numbers) {
            OnesComplement o = new OnesComplement(i);
            total += o.onesComplementDecimal;

            System.out.printf("%13d\t%40s\t%40s\t%13d\t%13d\n",
                    i,
                    o.binary,
                    o.onesComplement,
                    o.onesComplementDecimal,
                    total);

        }

        int x = 123;
        int y = Integer.MAX_VALUE | x;

        System.out.println(y);

    }


}
