package ru.molostvov.task20;

import java.util.Date;

public class RussianCallendar {
    private Date date;
    private boolean holiday;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }
}

