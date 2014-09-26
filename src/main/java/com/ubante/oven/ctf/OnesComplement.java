package com.ubante.oven.ctf;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sample output:
 *             i	                                     bin	                                get1comp	    1comp_dec	          sum
 -	                                     ---	                                --------	    ---------	          ---
 3469955794	        11001110110100110101001011010010	        00110001001011001010110100101101	    825011501	    825011501
 3456429757	        11001110000001001110111010111101	        00110001111110110001000101000010	    838537538	   1663549039
 2132653646	         1111111000111011011011001001110	         0000000111000100100100110110001	     14830001	   1678379040
 1020765282	          111100110101111010010001100010	          000011001010000101101110011101	     52976541	   1731355581
 284283847	           10000111100011101001111000111	           01111000011100010110000111000	    252587064	   1983942645
 4090666243	        11110011110100101001110100000011	        00001100001011010110001011111100	    204301052	   2188243697
 4172109509	        11111000101011010101011011000101	        00000111010100101010100100111010	    122857786	   2311101483
 3352535014	        11000111110100111001111111100110	        00111000001011000110000000011001	    942432281	   3253533764
 2316464850	        10001010000100100111001011010010	        01110101111011011000110100101101	   1978502445	   5232036209
 2179727493	        10000001111011000000000010000101	        01111110000100111111111101111010	   2115239802	   7347276011
 3727411389	        11011110001010111100100010111101	        00100001110101000011011101000010	    567555906	   7914831917
 2866921972	        10101010111000011100000111110100	        01010101000111100011111000001011	   1428045323	   9342877240
 3309205088	        11000101001111100111011001100000	        00111010110000011000100110011111	    985762207	  10328639447
 2196508821	        10000010111011000001000010010101	        01111101000100111110111101101010	   2098458474	  12427097921
 418204824	           11000111011010100110010011000	           00111000100101011001101100111	    118666087	  12545764008
 672097253	          101000000011110110001111100101	          010111111100001001110000011010	    401644570	  12947408578
 196365968	            1011101101000100111010010000	            0100010010111011000101101111	     72069487	  13019478065
 2529543965	        10010110110001011100011100011101	        01101001001110100011100011100010	   1765423330	  14784901395
 3579713693	        11010101010111100001100010011101	        00101010101000011110011101100010	    715253602	  15500154997
 2021028500	         1111000011101100111001010010100	         0000111100010011000110101101011	    126455147	  15626610144
 3571589174	        11010100111000100010000000110110	        00101011000111011101111111001001	    723378121	  16349988265
 2747162902	        10100011101111100110000100010110	        01011100010000011001111011101001	   1547804393	  17897792658
 2962663185	        10110000100101101010011100010001	        01001111011010010101100011101110	   1332304110	  19230096768
 2561181178	        10011000101010001000010111111010	        01100111010101110111101000000101	   1733786117	  20963882885
 1804684468	         1101011100100010100110010110100	         0010100011011101011001101001011	    342799179	  21306682064
 3982906708	        11101101011001100101010101010100	        00010010100110011010101010101011	    312060587	  21618742651
 2107886265	         1111101101000111100101010111001	         0000010010111000011010101000110	     39597382	  21658340033
 428455625	           11001100010011011011011001001	           00110011101100100100100110110	    108415286	  21766755319
 2284957623	        10001000001100011010111110110111	        01110111110011100101000001001000	   2010009672	  23776764991
 622556114	          100101000110110111001111010010	          011010111001001000110000101101	    451185709	  24227950700
 3390992352	        11001010000111100110111111100000	        00110101111000011001000000011111	    903974943	  25131925643
 3546730000	        11010011011001101100111000010000	        00101100100110010011000111101111	    748237295	  25880162938
 4294958664	        11111111111111111101111001001000	        00000000000000000010000110110111	         8631	  25880171569
 4160701632	        11110111111111110100010011000000	        00001000000000001011101100111111	    134265663	  26014437232
 1	                                       1	                                       0	            0	  26014437232
 4160589812	        11110111111111011000111111110100	        00001000000000100111000000001011	    134377483	  26148814715
 0	                                        	                                        	            0	  26148814715
 0	                                        	                                        	            0	  26148814715
 4294958664	        11111111111111111101111001001000	        00000000000000000010000110110111	         8631	  26148823346
 134515022	            1000000001001000100101001110	            0111111110110111011010110001	    133920433	  26282743779
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

        // This set of numbers from the server produces a sum of 28257492851
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
        // The below has a sum of 23851979089
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
        // The below has a sum of 26282743779
        List<Long> numbers3 =
                new ArrayList<Long>(Arrays.asList(
                        3469955794L, 3456429757L, 2132653646L, 1020765282L,
                        284283847L, 4090666243L, 4172109509L, 3352535014L,
                        2316464850L, 2179727493L, 3727411389L, 2866921972L,
                        3309205088L, 2196508821L, 418204824L, 672097253L,
                        196365968L, 2529543965L, 3579713693L, 2021028500L,
                        3571589174L, 2747162902L, 2962663185L, 2561181178L,
                        1804684468L, 3982906708L, 2107886265L, 428455625L,
                        2284957623L, 622556114L, 3390992352L, 3546730000L,
                        4294958664L, 4160701632L, 1L, 4160589812L,
                        0L, 0L, 4294958664L, 134515022L
                ));
        List<Long> numbers4 =
                new ArrayList<Long>(Arrays.asList(
                        4294958664L, 4160701632L, 1L, 4160589812L,
                        0L, 0L, 4294958664L, 134515022L
                ));

        List<Long> numbers = numbers4;

        System.out.printf("%13s\t%40s\t%40s\t%13s\t%13s\n","i","bin","get1comp","1comp_dec","sum");
        System.out.printf("%13s\t%40s\t%40s\t%13s\t%13s\n","-","---","--------","---------","---");

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

    }


}
