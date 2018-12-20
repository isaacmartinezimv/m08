package com.example.jcmilena.apptomodify1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class EasyFragment extends Fragment {

    private static final String argumentOne = "numero";
    private static final String argumentTwo = "color";

    private Integer mParam1 = 1;
    private int mParam2 = R.color.colorBlanco;
    FragmentWombatListener wombatListener;

    public EasyFragment() {}

    public static EasyFragment newInstance(int param1, int param2) {

        EasyFragment fragment = new EasyFragment();
        Bundle args = new Bundle();
        args.putInt(argumentOne, param1);
        args.putInt(argumentTwo, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(argumentOne);
            mParam2 = getArguments().getInt(argumentTwo);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_easy, container, false);

        TextView textView = (TextView) view.findViewById(R.id.text_fragment);

        textView.setText("Soy el fragment "+ mParam1);
        textView.setBackgroundResource(mParam2);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wombatListener.pulsado(Integer.toString(mParam1));
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        wombatListener = (FragmentWombatListener)getActivity();
    }

    @Override public void onDetach() {

        super.onDetach();
    }

    //Introducimos la interface
    public interface FragmentWombatListener {

        public void pulsado (String numero);
    }


}
