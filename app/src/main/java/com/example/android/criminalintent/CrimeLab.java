package com.example.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {  // Класс синглтон для хранения списка
    private  static CrimeLab sCrimeLab;
    private List <Crime> mCrimes; //

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {  // конструктор закрытый.
        mCrimes = new ArrayList<>();  //
        // тестовая загрузка листа обьектами.
        for (int i = 0; i <100 ; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" +i);
            crime.setSolved(i % 2 == 0); // для каждого второго обьекта
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {//geter возврвщающий лист.
        return mCrimes;
    }
    public  Crime getCrime(UUID id){
        for (Crime crime: mCrimes) {
            if (crime.getId().equals(id))
                return crime;
        }
        return  null;
    }



}
