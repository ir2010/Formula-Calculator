package com.ir_sj.thermalanddimensionalcalculator;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.ir_sj.thermalanddimensionalcalculator.Formula.numOfFormula;

public class MyListAdapter extends ArrayAdapter{

    private AppCompatActivity context;
    private String[] title = new  String[numOfFormula];
    private String[] result = new  String[numOfFormula];
   // private String[] unit = new  String[numOfFormula];

    public MyListAdapter(AppCompatActivity c, String[] t1, String[] t2, String[] r, String[] u)
    {
        super(c, R.layout.results_view, t1);

        context = c;
        for(int i=0; i<numOfFormula; i++)
        {
            title[i] = t1[i] + ", " + t2[i];
            result[i] = r[i] + " " + u[i];
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater li=context.getLayoutInflater();
        View rowview = li.inflate(R.layout.results_view,null,true);
        TextView titles = rowview.findViewById(R.id.title);
        TextView res = rowview.findViewById(R.id.result);

        titles.setText(title[position]);
        res.setText(result[position]);

        return rowview;
    }
}
