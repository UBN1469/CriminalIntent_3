package com.example.android.criminalintent_3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
// создаём экземпляр фрагмента с помощью createFragment() и устанавливаем в activity_fragment
public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();// абстрактный метод для создания экземпляра фрагмента
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();// получаем обьект FragmentManager
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
