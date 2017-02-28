package git.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

public class ComposeEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_email);
        this.setTitle("Compose mail");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_sendmail:
                Logout();
                return true;
            case R.id.menu_feedback:
                MenuFeedback();


            default:
                return super.onOptionsItemSelected(menuItem);

        }
    }

    private void MenuFeedback() {
        Intent intent = new Intent(ComposeEmail.this,FeedbackActivity.class);
        startActivity(intent);
    }

    private void Logout() {
        Toast.makeText(getBaseContext(),"Message sent successfully",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(ComposeEmail.this,NavigationDrawer.class);
        startActivity(intent);
    }

}
