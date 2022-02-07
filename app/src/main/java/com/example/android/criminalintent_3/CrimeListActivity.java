package com.example.android.criminalintent_3;

import androidx.fragment.app.Fragment;
// класс контроллер
public class CrimeListActivity extends SingleFragmentActivity {
    //переопределённый абстрактный метод из класса SingleFragmentActivity
    // создаёт экземпляр класс CrimeListFragment
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
