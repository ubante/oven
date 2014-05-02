package com.ubante.oven.enums;

/**
 * ubante 1/23/14 1:41 PM
 * This is very serious business.
 */
public class EnumTest {
    Day day;

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public EnumTest(Day day) {
        this.day = day;
    }

    public void tellIt() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad");
                break;

            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are good");
                break;

            default:
                System.out.println("The other days are blurg");
        }
    }

    public static void main(String[] args) {
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellIt();
        EnumTest secondDay = new EnumTest(Day.TUESDAY);
        secondDay.tellIt();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellIt();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellIt();
    }
}

