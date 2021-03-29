package com.android.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Validator.ValidationListener {
    @NotEmpty(message = "Name is a mandatory field.")
    @Length(min = 3, max = 20, message = "Name must contain between 3 and 20 characters.")
    private TextInputEditText textName;

    @Email(message = "Please, insert a valid e-mail")
    private TextInputEditText textEmail;

    @Length(min = 14, max = 14, message = "Phone must contain 14 characters.")
    private TextInputEditText textPhone;

    @Length(min = 10, max = 10, message = "Birthdate must contain 10 characters.")
    private TextInputEditText textBirthDate;

    private CheckBox checkTwilight;
    private CheckBox checkHP;
    private RadioGroup gender;
    private RadioButton selectedGender;
    private Button buttonRegister;
    private Button buttonSend;
    private Calendar calendar;
    private int day, month, year;

    private Validator validator;

    public static List<User> registeredUsers = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        validator = new Validator(this);
        validator.setValidationListener(this);

        setContentView(R.layout.activity_main);
        this.initializer();
        User user = new User();
        checkTwilight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                user.setTwilightFan(isChecked);
            }
        });

        checkHP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                user.setHpFan(isChecked);
            }
        });

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        user.setGender("Male");
                        break;
                    case R.id.female:
                        user.setGender("Female");
                        break;
                }
                selectedGender = findViewById(checkedId);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(textName.getText().toString());
                user.setEmail(textEmail.getText().toString());
                user.setPhone(textPhone.getText().toString());

                DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
                Date date = null;
                try {
                    date = formatter.parse(textBirthDate.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                user.setBirthDate(date);

                user.setHpFan(checkHP.isChecked());
                user.setTwilightFan(checkTwilight.isChecked());
                validator.validate();

                registeredUsers.add(user);
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivityUsers.class);
                startActivity(intent);
            }
        });
    }

    private void initializer() {
        this.textName = findViewById(R.id.text_name);
        this.textEmail = findViewById(R.id.text_mail);
        this.textPhone = findViewById(R.id.text_phone);
        this.textBirthDate = findViewById(R.id.text_birthdate);
        this.checkTwilight = findViewById(R.id.check_twilight);
        this.checkHP = findViewById(R.id.check_hp);
        this.gender = findViewById(R.id.gender);
        this.buttonRegister = findViewById(R.id.bt_register);
        this.buttonSend = findViewById(R.id.bt_send);


        //BirthDate Mask
        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(textBirthDate, smf);
        textBirthDate.addTextChangedListener(mtw);

        //Phone Mask
        SimpleMaskFormatter smf2 = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher mtw2 = new MaskTextWatcher(textPhone, smf2);
        textPhone.addTextChangedListener(mtw2);
    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View component = error.getView();
            String msg = error.getCollatedErrorMessage(this);
            if (component instanceof TextInputEditText) {
                ((EditText) component).setError(msg);
            }
        }
    }

}