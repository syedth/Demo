package git.helloworld;


import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends MainActivityFragment {

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Username = "username";
    public static final String Password = "password";
    SharedPreferences sharedpreferences;
    Button createsignUp;
    Button createlogin;
    Button forgotpassword;

    private EditText edituser;

    private EditText editpass;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        getActivity().setTitle("Log in");
        SharedPreferences sharedpreferences = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        final String username = (sharedpreferences.getString(Username, ""));
        final String password = (sharedpreferences.getString(Password, ""));
        edituser = (EditText) view.findViewById(R.id.create_edit_text_user);
        editpass = (EditText) view.findViewById(R.id.create_edit_text_pass);


        createlogin = (Button) view.findViewById(R.id.create_btn_login);
        createlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.equals(edituser.getText().toString()) && password.equals(editpass.getText().toString())) {
                    getMainActivity().switchToFragment(new LoggedinFragment(), true);


                } else {
                    Toast.makeText(getActivity(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
        createsignUp = (Button) view.findViewById(R.id.create_btn_signup);
        createsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMainActivity().switchToFragment(new SignupFragment(), true);
            }
        });

        forgotpassword = (Button) view.findViewById(R.id.btn_forgot_password);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "A link  has been sent to registered e-mail id", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }


}
