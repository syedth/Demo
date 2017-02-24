package git.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
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

    public void switchToFragment(Fragment targetFragment) {
        switchToFragment(targetFragment, false);
    }

    public void switchToFragment(Fragment targetFragment, boolean addToBackStack) {
        switchToFragment(targetFragment, addToBackStack, null);
    }

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

    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        super.onKeyDown(keyCode, keyEvent);
        int count = getSupportFragmentManager().getBackStackEntryCount()-1;
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (getSupportFragmentManager().getFragments().get(count) instanceof LoginFragment ) {
                finish();
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

}
