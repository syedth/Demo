package git.helloworld;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends MainActivityFragment {

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Username = "username";
    public static final String Password = "password";


    EditText signupuser;
    EditText signuppass;
    Button regsignup;
    View view;

    private SharedPreferences sharedpreferences;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_signup, container, false);
        getActivity().setTitle("Sign up");

        signupuser = (EditText) view.findViewById(R.id.signup_edit_text_user);
        signuppass = (EditText) view.findViewById(R.id.signup_edit_text_pass);
        regsignup = (Button) view.findViewById(R.id.create_signup);

        final SharedPreferences sharedpreferences = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        regsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(signupuser.getText())
                        || TextUtils.isEmpty(signuppass.getText())) {
                    Toast.makeText(getActivity(), "Please fill in all the details", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Username, signupuser.getText().toString());
                    editor.putString(Password, signuppass.getText().toString());
                    editor.commit();
                    Toast.makeText(getActivity(), "Registration successfull", Toast.LENGTH_LONG).show();
                    getMainActivity().switchToFragment(new LoginFragment(), true);
                }
        }
        });

        return view;

    }

}
