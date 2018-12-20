package com.example.jcmilena.apptomodify1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ControllerActivity extends AppCompatActivity  implements EasyFragment.FragmentWombatListener {

    int fragment_number = 1;
    int fragment_color = R.color.colorFragment1;
    int fragment_container = R.id.fragment_container1;
    String fragment_tag = "Frag1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);

        /* FALTA ALGO */

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = EasyFragment.newInstance(fragment_number, fragment_color);

        fm.beginTransaction().replace(fragment_container, fragment,fragment_tag).commit();

    }

    @Override
    public void pulsado(String numero) {
        if(numero.equalsIgnoreCase("1")){
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragmentToRemove = fm.findFragmentByTag("Frag1");
            fm.beginTransaction().remove(fragmentToRemove).commit();
            fragment_number = 2;
            fragment_color = R.color.colorFragment2;
            fragment_container = R.id.fragment_container2;
            fragment_tag = "Frag2";
            Fragment fragment = EasyFragment.newInstance(fragment_number, fragment_color);
            fm.beginTransaction().replace(fragment_container, fragment, fragment_tag).remove(fragmentToRemove).commit();
        } else {
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragmentToRemove = fm.findFragmentByTag("Frag2");
            fm.beginTransaction().remove(fragmentToRemove).commit();
            fragment_number = 1;
            fragment_color = R.color.colorFragment1;
            fragment_container = R.id.fragment_container1;
            fragment_tag = "Frag1";
            Fragment fragment = EasyFragment.newInstance(fragment_number, fragment_color);
            fm.beginTransaction().replace(fragment_container, fragment, fragment_tag).remove(fragmentToRemove).commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numero", fragment_number);
        outState.putInt("color",fragment_color);
        outState.putInt("container", fragment_container);
        outState.putString("tag", fragment_tag);
    }
}