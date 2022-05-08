package com.example.rehberapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.rehberapp.R;
import com.example.rehberapp.db.Sqlitedb;
import com.example.rehberapp.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAdd extends Fragment {

    public FragmentAdd() {
        // Required empty public constructor
    }

    EditText ad, soyad, telefon, fax, adres, foto;
    Sqlitedb sqlitedb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        ad = view.findViewById(R.id.edtAd);
        soyad = view.findViewById(R.id.edtSoyad);
        telefon = view.findViewById(R.id.edtTelefon);
        fax = view.findViewById(R.id.edtFax);
        adres = view.findViewById(R.id.edtAdres);
        foto = view.findViewById(R.id.edtFoto);

        Button btnkayit = view.findViewById(R.id.btnKayit);

        btnkayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sqlitedb = new Sqlitedb(getActivity());

                User user = new User(0, ad.getText().toString(),
                        soyad.getText().toString(),
                        telefon.getText().toString(),
                        fax.getText().toString(),
                        adres.getText().toString(), 0);

                sqlitedb.addUser(user);

                clear();
            }
        });


        return view;
    }


    void clear() {
        ad.setText("");
        soyad.setText("");
        telefon.setText("");
        fax.setText("");
        adres.setText("");
        foto.setText("");

    }
}
