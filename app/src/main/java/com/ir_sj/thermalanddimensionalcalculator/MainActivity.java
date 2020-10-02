package com.ir_sj.thermalanddimensionalcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.udojava.evalex.Expression;

import java.sql.SQLOutput;
import java.util.HashMap;

import static com.ir_sj.thermalanddimensionalcalculator.Formula.numOfFormula;

public class MainActivity extends AppCompatActivity {
    Button calc;
    EditText qw_;
    Formula formula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        toolbar.setTitle("Calculator");
        calc = (Button)findViewById(R.id.button);
        qw_ = (EditText) findViewById(R.id.editText);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                populate();
            }
        });
    }

    void calculate()
    {
        formula = new Formula();
        //if(qw_.getText().toString() == "")
           formula.values.put("Qw", qw_.getText().toString());
           int i,j;
        for( i = 0; i< formula.exp.size(); i++)
        {
            try
            {
                System.out.println(i +" "+ formula.exp.get(i).res);
                Expression expression = new Expression(formula.exp.get(i).form).with(formula.exp.get(i).var.get(0), formula.values.get(formula.exp.get(i).var.get(0)));

                for(j=1; j<formula.exp.get(i).var.size(); j++)
                {
                    expression = expression.and(formula.exp.get(i).var.get(j), formula.values.get(formula.exp.get(i).var.get(j)));
                }

                formula.values.put(formula.exp.get(i).res, expression.eval().toString());
            }
            catch (IndexOutOfBoundsException e)
            {
                Toast.makeText(this, "Qw is null!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void populate()
    {
        String[] title1 = {"Amount of water circulating in system", "Water circulation rate", "Mean temperature of water in radiator",
                           "Cooling surface area of radiator", "Amount of water flowing through radiator", "Amount of air passing through radiator",
                           "Mass flow rate of water passing radiator", "Air density in radiator at its mean temperature", "Fan capacity",
                           "Front area of radiator", "Fan diameter", "Fan peripheral velocity", "Fan speed", "Input power of cooling fan",
                           "Heat transferred to coolant" };

        String[] title2 = {"Gw", "GL", "T_wm", "F", "Gl", "Ga", "Gl", "rho_a", "Gf", "F_rf", "D_fan", "u", "n_fan", "N_fan", "Qc"};
        String[] result = new String[numOfFormula];
        String[] unit = {"Kg/s", "m^3/s", "K", "m^2", "Kg/s", "Kg/s", "Kg/s", "Kg/m^3", "Kg/s", "m^2", "m", "m/s", "rpm", "kW", "J/s"};

        for(int i=0; i<numOfFormula; i++)
        {
            System.out.println(formula.values.get(title2[i]));
            result[i] = formula.values.get(title2[i]);
        }

        MyListAdapter adapter = new MyListAdapter(this, title1, title2, result, unit);
        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
    }
}
