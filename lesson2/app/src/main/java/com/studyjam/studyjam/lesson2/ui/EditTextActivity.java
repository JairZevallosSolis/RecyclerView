package com.studyjam.studyjam.lesson2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.studyjam.studyjam.lesson2.R;
import com.studyjam.studyjam.lesson2.manager.UserManager;
import com.studyjam.studyjam.lesson2.model.User;

/**
 * Created by PedroCarrillo on 3/16/16.
 */
public class EditTextActivity extends AppCompatActivity {

    private TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        setupViews();
    }

    private void setupViews() {
        tvUsername = (TextView) findViewById(R.id.tvUserName);
        final EditText etUserName = (EditText)findViewById(R.id.etUserName);
        final EditText etEmail = (EditText)findViewById(R.id.etEmail);
        final EditText etPassword = (EditText)findViewById(R.id.input_password);
        Button btnLogin = (Button)findViewById(R.id.btnLogin);

        etUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                tvUsername.setText(s.toString());
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateEditText(etUserName) && validateEditText(etEmail) && validateEditText(etPassword)) {
                    User user = new User(etUserName.getText().toString(), etEmail.getText().toString());
                    UserManager.getInstance().setUser(user);
                    Intent intent = new Intent(EditTextActivity.this, NotesActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(EditTextActivity.this, R.string.fields_warning, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public boolean validateEditText(EditText et) {
        return et.getText() != null && !et.getText().toString().isEmpty();
    }


}
