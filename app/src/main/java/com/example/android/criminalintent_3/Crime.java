package com.example.android.criminalintent_3;

import java.util.Date;
import java.util.UUID;
 // класс модель
public class Crime {

    private UUID mId;  // клас андроида- универсальный идификатор
    private String mTitle;
    private Date mDate;
    private  Boolean mSolved;  // "решенный"

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();// инициализация по умолчанию( присваевается текущая дата).
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Boolean getSolved() {
        return mSolved;
    }

    public void setSolved(Boolean solved) {
        mSolved = solved;
    }
}
