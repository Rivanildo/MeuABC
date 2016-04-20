package br.com.ufpb.rivanildo.meuabc;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rivanildo on 20/04/16.
 */
public class MeuABCApplication extends Application {

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count +=1 ;
    }

    private int count;
    private List<Letra> letras;

    @Override
    public void onCreate() {
        super.onCreate();
        letras = new ArrayList<Letra>();
        crearLetrasPadrao();
        count = 0;

    }

    private void crearLetrasPadrao(){
        letras.add(new Letra("Aa","A"));
        letras.add(new Letra("Bb","B"));
        letras.add(new Letra("Cc","C"));
        letras.add(new Letra("Dd","D"));
        letras.add(new Letra("Ee","E"));
        letras.add(new Letra("Ff","F"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));
//        letras.add(new Letra("Aa"));

    }

    public Letra getLetra(int idx){
        return letras.get(idx);
    }


    public void setCount2() {
        this.count -=1 ;

    }

    public List<Letra> getLetras() {
        return letras;
    }
}
