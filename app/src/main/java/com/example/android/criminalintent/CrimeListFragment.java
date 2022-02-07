package com.example.android.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Locale.KOREAN;

// класс контроллер должен отображать список
public class CrimeListFragment extends Fragment {
    // пока пусто
    private RecyclerView mCrimeRecyclerView;
    private  CrimeAdapter mAdapter;


    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       //надуваем fragment_crime_list
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
    // метод для возможности обновсть данные
    private void updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());// создаём экземпляр класс CrimeLab
        List<Crime> crimes = crimeLab.getCrimes();  // Создаём лист с экземплярами Crime
        if (mAdapter == null) {
            mAdapter = new CrimeAdapter(crimes); // инициализируем CrimeAdapter. и вставляем в его конструктор лист с экземплярами Crime.
            mCrimeRecyclerView.setAdapter(mAdapter);  //Устанавливаем для нашего RecyclerView адаптер.
        }else {
            mAdapter.notifyDataSetChanged();
        }
    }

    //реализуем ViewHolder для заполнения макета list_item_crime
    private  class CrimeHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private  Crime mCrime;
        // поля для одного item.
        private TextView mTitleTextView;
        private TextView mDateTextView;

        private ImageView mSolvedImageView;// переменная картинки

        // в этом конструкторе происходит заполнение
        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime,parent, false));

            itemView.setOnClickListener(this); // Слушатель

            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);
            mSolvedImageView = (ImageView)itemView.findViewById(R.id.crime_solved);

        }
        //bind вызывается каждый раз когда в CrimeHolder олжен отображаться новый обьет Crime
        // вызывается в onBindViewHolder
        public void bind (Crime crime){
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(mCrime.getDate().toString());

            mSolvedImageView.setVisibility(crime.getSolved()? View.VISIBLE: View.GONE);

        }
        // обработка касания на СrimeHolder , выводим пока тост
        @Override
        public void onClick(View view) {
            //Toast.makeText(getActivity(), mCrime.getTitle()+ "  cliced" , Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(getActivity(), CrimeActivity.class); //Запускаем CrimeActivity
            Intent intent = CrimeActivity.newIntent(getActivity(), mCrime.getId());
            startActivity(intent);
        }
    }

    // создаем адаптер
    //Класс RecycclerView сам взаимодействует с адаптером когда хочет создать или взять
    // существующий Viewholder c  обьектом Crime.
    private  class  CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater =LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater,parent);
        }
        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bind(crime);
        }
        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }



}
