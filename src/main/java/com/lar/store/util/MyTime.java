package com.lar.store.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTime {
    public static Date getTime() throws ParseException {
        Date now=new Date();
        SimpleDateFormat sfd= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        now=sfd.parse(sfd.format(now));
        return now;
    }
}
