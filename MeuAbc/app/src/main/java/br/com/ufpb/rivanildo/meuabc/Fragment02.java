package br.com.ufpb.rivanildo.meuabc;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Rivanildo on 19/04/16.
 */
public class Fragment02 extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_02,container,false);
        TextView textView = (TextView) view.findViewById(R.id.txt);
        Typeface fonte = Typeface.createFromAsset(getContext().getAssets(), "fonts/klee.ttc");
        textView.setTypeface(fonte);
        return view;
    }
}
