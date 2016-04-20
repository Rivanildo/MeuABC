package br.com.ufpb.rivanildo.meuabc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));//setar o vp no adapter personalizado
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        String titulos[] = new String[]{"Frag01","Frag02"};
        public ViewPagerAdapter(FragmentManager fm) {//iniciar o Objeto responsavel por gerenciar os fragments
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if(position == 0){
                fragment = new Fragment01();//inciar o frament na posição
            }
            else if(position == 1){
                fragment = new Fragment02();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("id", position);//controle de posição de cada fragment
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return titulos.length;
        }
    }
}
