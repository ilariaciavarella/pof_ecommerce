package com.pof.util;

import java.text.*;
import java.util.*;

public class DataFormatter {

    public static Integer formatId(String stringId) {
        return Integer.parseInt(stringId);
    }

    public static Date formatDate(String stringDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(stringDate);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Double formatPrice(String stringPrice) {
        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        try {
            return nf.parse(stringPrice).doubleValue();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String capitalise(String string) {
        StringBuilder builder = new StringBuilder(string);
        builder.setCharAt(0, Character.toUpperCase(string.charAt(0)));
        for (int i = 0; i < builder.length(); i++) {
            if (Character.isWhitespace(builder.charAt(i)) || !Character.isLetterOrDigit(builder.charAt(i))) {
                builder.setCharAt(i + 1, Character.toUpperCase(builder.charAt(i + 1)));
            }
        }
        return builder.toString();
    }

}
