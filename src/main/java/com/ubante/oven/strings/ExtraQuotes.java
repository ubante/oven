package com.ubante.oven.strings;

/**
 * ubante 8/19/14 7:06 PM
 * This is very serious business.
 */
public class ExtraQuotes {

    public static void main(String[] args) {
        String raw = "http://www.google.com/        130528254092520037      {\"Kif.Schema\":\"WrapStar.Extraction[2.0]\"";
        System.out.println("raw:\n" + raw);

        System.out.println("\nreplaceAll and three backslashes:");
        System.out.println(raw.replaceAll("\"", "\\\""));

        System.out.println("\nreplaceAll and five backslashes:");
        System.out.println(raw.replaceAll("\"", "\\\\\""));

        System.out.println("\nreplace and three backslashes:");
        System.out.println(raw.replace("\"", "\\\""));

        System.out.printf("yes %f ", (double) 11/7);

        StringBuilder explanation = new StringBuilder();
        explanation.append(String.format("Hello %f and %2.1f%%.  Bye.\n", 0.4, (float) 100/7));
        System.out.println(explanation);
    }
}
