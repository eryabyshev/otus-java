package ru.evgeny.datanow;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateNow {
    public static String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh.mm.ss");
        return formatter.format(new Date());
    }

}
