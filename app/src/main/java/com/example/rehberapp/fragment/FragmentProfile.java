package com.example.rehberapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.rehberapp.R;
import com.example.rehberapp.db.Sqlitedb;
import com.example.rehberapp.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfile extends Fragment {

    public FragmentProfile() {
        // Required empty public constructor
    }

    TextView ad, soyad, telefon, fax, adres;

    Sqlitedb sqlitedb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        ad = view.findViewById(R.id.txtAd);
        soyad = view.findViewById(R.id.txtSoyad);
        telefon = view.findViewById(R.id.txtTelefon);
        fax = view.findViewById(R.id.txtFax);
        adres = view.findViewById(R.id.txtAdres);

        sqlitedb = new Sqlitedb(getContext());


        if (sqlitedb.getList().size() > 0) {
            User user = sqlitedb.getList().get(0);

            ad.setText(user.getAd());
            soyad.setText(user.getSoyad());
            telefon.setText(user.getTelefonNo());
            fax.setText(user.getFax());
            adres.setText(user.getAdress());
        }

        return view;
    }
}
