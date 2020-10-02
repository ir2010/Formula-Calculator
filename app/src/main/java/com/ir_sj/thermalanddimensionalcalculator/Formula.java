package com.ir_sj.thermalanddimensionalcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Formula {

    class Exp
    {
        String res;
        String form;
        String asdfgh;
        ArrayList<String> var;

        Exp(String r, String f, ArrayList<String> v)
        {
            res = r;
            form = f;
            var = v;
        }
    }
    static int numOfFormula = 15;
    ArrayList<Exp> exp = new ArrayList<Exp>(numOfFormula);

    HashMap<String, String> values = new HashMap<String, String>();

    Formula()
    {
        setValues();
        setExp();
    }

    void setValues()
    {
        values.put("Qw", "184520");
        values.put("cl", "4187");
        values.put("rho_l", "1000");
        values.put("pl", "80000");
        values.put("n_wp", "2000");
        values.put("del_T_a", "28");
        values.put("T_am", "327");
        values.put("cw", "4187");
        values.put("va", "1000");
        values.put("T_in_w", "365");
        values.put("del_T_w", "10");
        values.put("u", "85");
        values.put("shi_b", "3");
        values.put("rho_a", "1");
        values.put("del_p_fr", "900");
        values.put("rho_0", "0.1");
        values.put("Ra", "287");
        values.put("wa", "22");
        values.put("nf", "0.6");
        values.put("c", "0.53");
        values.put("i", "8");
        values.put("B", "12");
        values.put("m", "0.68");
        values.put("n", "2600");
        values.put("K", "100");
        values.put("alpha", "1.7");
        values.put("pi", String.valueOf(Math.PI));
    }

    void setExp()
    {
        exp.add(new Exp("Gw", "Qw/(cw*del_T_w)", new ArrayList<String>(Arrays.asList("Qw", "cw", "del_T_w"))));
        exp.add(new Exp("GL", "Qw/(cl*rho_l*del_T_w)", new ArrayList<String>(Arrays.asList("Qw", "cl", "rho_l", "del_T_w"))));
        exp.add(new Exp("T_wm", "(T_in_w+(T_in_w-del_T_w))/2", new ArrayList<String>(Arrays.asList("T_in_w", "del_T_w"))));
        exp.add(new Exp("F", "Qw/(K*(T_wm-T_am))", new ArrayList<String>(Arrays.asList("Qw", "K", "T_wm", "T_am"))));
        exp.add(new Exp("Gw", "Gw", new ArrayList<String>(Arrays.asList("Gw"))));
        exp.add(new Exp("Ga", "Qw/(va*del_T_a)", new ArrayList<String>(Arrays.asList("Qw", "va", "del_T_a"))));
        exp.add(new Exp("Gl", "GL*rho_l", new ArrayList<String>(Arrays.asList("GL", "rho_l"))));
        exp.add(new Exp("rho_a", "rho_0*10^6/(Ra*T_am)", new ArrayList<String>(Arrays.asList("rho_0", "Ra", "T_am"))));
        exp.add(new Exp("Gf", "Ga/rho_a", new ArrayList<String>(Arrays.asList("Ga", "rho_a"))));
        exp.add(new Exp("F_rf", "Ga/wa", new ArrayList<String>(Arrays.asList("Ga", "wa"))));
        exp.add(new Exp("D_fan", "2*SQRT(F_rf/pi)", new ArrayList<String>(Arrays.asList("F_rf", "pi"))));
        exp.add(new Exp("u", "shi_b*SQRT(del_p_fr/rho_a)", new ArrayList<String>(Arrays.asList("shi_b", "del_p_fr", "rho_a"))));
        exp.add(new Exp("n_fan", "60*u/(pi*D_fan)", new ArrayList<String>(Arrays.asList("u", "pi", "D_fan"))));
        exp.add(new Exp("N_fan", "Ga*del_p_fr/(nf*1000)", new ArrayList<String>(Arrays.asList("Ga", "del_p_fr", "nf"))));
        exp.add(new Exp("Qc", "c*i*B^(1+2*m)*n^m*(1/alpha)", new ArrayList<String>(Arrays.asList("c", "i", "B", "m", "n", "alpha"))));
    }
}
