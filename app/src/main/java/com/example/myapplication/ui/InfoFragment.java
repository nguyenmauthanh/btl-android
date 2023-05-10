package com.example.myapplication.ui;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.db.UserSQL;

public class InfoFragment extends Fragment {
    Button btnLogout, btnChangePass;
    TextView txtUsername,txtRole;

    ImageView img;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        btnLogout = view.findViewById(R.id.btn_logout);
        btnChangePass = view.findViewById(R.id.btn_change_pass);
        txtUsername = view.findViewById(R.id.txt_username);
        txtRole = view.findViewById(R.id.txt_role);
        txtUsername.setText(MainActivity.account.getUsername());
        img = view.findViewById(R.id.im);
        if (MainActivity.account.getUsername().equalsIgnoreCase("anhtuancao")){
            txtRole.setText("Admin");
        }
        else txtRole.setText("Khách hàng");
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                getContext().startActivity(intent);
            }
        });
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChangePassActivity.class);
                getContext().startActivity(intent);
            }
        });
        return view;
    }
}
