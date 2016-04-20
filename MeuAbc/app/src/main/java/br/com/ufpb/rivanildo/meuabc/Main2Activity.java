package br.com.ufpb.rivanildo.meuabc;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;

public class Main2Activity extends AppCompatActivity {

    private TextView mtexto;
    private Button mProximo;
    private Button mAnterior;

    private MeuABCApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ocultarBarraDeNavegação();
        overridePendingTransition(R.anim.slide2, R.anim.slide);
        setContentView(R.layout.content_main2);

        application = (MeuABCApplication) getApplicationContext();

        Letra letra;

        if(getIntent().getExtras() != null){
            int i = getIntent().getExtras().getInt("idx");
            letra = application.getLetra(i);
        }else{
            letra = application.getLetra(application.getCount());
        }



        mtexto = (TextView) findViewById(R.id.txt);
        mtexto.setText(letra.getLetra());

        mProximo = (Button) findViewById(R.id.proximo);
        if(application.getCount()==25){
            mProximo.setVisibility(View.GONE);
        } else{
            mProximo.setText(application.getLetra(application.getCount() + 1).getTitulo());
            mProximo.setVisibility(View.VISIBLE);
            mProximo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    application.setCount();
                    startActivity(new Intent(Main2Activity.this, Main2Activity.class));
                    finish();
                }
            });
        }


        mAnterior = (Button) findViewById(R.id.anterior);
        if(application.getCount()==0){
            mAnterior.setVisibility(View.GONE);
        }else{
            mAnterior.setText(application.getLetra(application.getCount()-1).getTitulo());
            mAnterior.setVisibility(View.VISIBLE);
            mAnterior.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    application.setCount2();
                    startActivity(new Intent(Main2Activity.this, Main2Activity.class));
                    finish();
                }
            });
        }
    }

    private void ocultarBarraDeNavegação() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
