package com.example.android.criminalintent_3;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {
    private static final String EXTRA_CRIME_ID=
            "com.example.android.criminalintent.crime_id"; // строковый ключ для интената
// этот метод вызовем в CrimeListFragment.
    public  static Intent newIntent(Context packageContext, UUID crimeID){
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeID);
        return intent;
    }


    @Override
    protected Fragment createFragment() {
        //return new CrimeFragment();
        UUID crimed = (UUID)getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return  CrimeFragment.newInstance(crimed);
    }
}
