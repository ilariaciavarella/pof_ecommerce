package com.pof.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

}
