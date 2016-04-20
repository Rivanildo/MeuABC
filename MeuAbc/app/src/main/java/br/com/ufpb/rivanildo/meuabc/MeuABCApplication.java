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
        letras.add(new Letra("Gg","G"));
        letras.add(new Letra("Hh","h"));
        letras.add(new Letra("Ii","I"));
        letras.add(new Letra("Jj","j"));
        letras.add(new Letra("Kk","K"));
        letras.add(new Letra("Ll","L"));
        letras.add(new Letra("Mm","m"));
        letras.add(new Letra("Nn","N"));
        letras.add(new Letra("Oo","O"));
        letras.add(new Letra("Pp","p"));
        letras.add(new Letra("Qq","q"));
        letras.add(new Letra("Rr","R"));
        letras.add(new Letra("Ss","s"));
        letras.add(new Letra("Tt","t"));
        letras.add(new Letra("Uu","u"));
        letras.add(new Letra("Vv","v"));
        letras.add(new Letra("Ww","w"));
        letras.add(new Letra("Xx","x"));
        letras.add(new Letra("Yy","Y"));
        letras.add(new Letra("Zz","Z"));


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
