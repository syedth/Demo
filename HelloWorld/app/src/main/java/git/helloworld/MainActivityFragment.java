package git.helloworld;

import android.support.v4.app.Fragment;

/**
 * Created by syedthoufiq on 24/02/2017.
 */

public class MainActivityFragment extends Fragment {

    public MainActivity getMainActivity() {
        return(MainActivity) getActivity();
    }

}
