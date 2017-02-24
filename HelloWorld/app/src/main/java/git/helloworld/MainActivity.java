package git.helloworld;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchToFragment(new LoginFragment(),true);
    }



    @Override
    public void onClick(View v) {
    }

    /**
     * Does not add fragment to backStack and sends in a null bundle.
     *
     * @param targetFragment A fragment to be opened.
     */
    public void switchToFragment(Fragment targetFragment) {
        switchToFragment(targetFragment, false);
    }

    /**
     * Adds fragment to backStack based on the addToBackStack flag and sends null bundle.
     *
     * @param targetFragment A fragment to be opened.
     * @param addToBackStack A boolean that is used to say if the fragment is to be added to the
     *                       BackStack.
     */
    public void switchToFragment(Fragment targetFragment, boolean addToBackStack) {
        switchToFragment(targetFragment, addToBackStack, null);
    }

    /**
     * Adds fragment to backStack based on the addToBackStack flag and sends the bundle as an
     * argument.
     *
     * @param targetFragment A fragment to be opened.
     * @param addToBackStack A boolean that is used to say if the fragment is to be added to the
     *                       backStack.
     * @param bundle         A bundle that holds the information to be passed to the fragment.
     */
    public void switchToFragment(Fragment targetFragment, boolean addToBackStack, Bundle bundle) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (bundle != null) {
            targetFragment.setArguments(bundle);
        } else {
            if (targetFragment.getArguments() != null) {
                targetFragment.getArguments().clear();
            }
            targetFragment.setArguments(null);
        }
        fragmentTransaction.replace(R.id.activity_main, targetFragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    /**
     * Adds fragment to backStack based on the addToBackStack flag and Animate fragment from bottom
     * to top
     *
     * @param targetFragment A fragment to be opened.
     * @param addToBackStack A boolean that is used to say if the fragment is to be added to the
     *                       backStack.
     */
    public void fragmentTransitionAnim(Fragment targetFragment, boolean addToBackStack, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (TextUtils.isEmpty(tag)) {
            fragmentTransaction.add(R.id.activity_main, targetFragment, "");
        } else {
            fragmentTransaction.add(R.id.activity_main, targetFragment, tag);
        }

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    /**
     * Adds fragment to backStack based on the addToBackStack
     *
     * @param targetFragment A fragment to be opened.
     * @param addToBackStack A boolean that is used to say if the fragment is to be added to the
     *                       backStack
     */
    public void fragmentTransition(Fragment targetFragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.activity_main, targetFragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    /**
     * Removes fragment from back stack
     *
     * @param targetFragment A fragment to be removed.
     */
    public void removeFragment(Fragment targetFragment) {
        getSupportFragmentManager().popBackStack();
    }


}
