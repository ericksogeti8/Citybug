package florianburel.fr.citybug;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by fl0 on 25/07/2014.
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText loginEditText;
    private EditText passwordEditText;
    private Button connectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.loginEditText = (EditText) findViewById(R.id.loginEditText);
        this.passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        this.connectButton = (Button) findViewById(R.id.connectButton);

        this.connectButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        String user = this.loginEditText.getText().toString();
        String password = this.passwordEditText.getText().toString();

        if(user.equals("test") && password.equals("test"))
        {
            Toast.makeText(this, "Yahooo...", Toast.LENGTH_LONG).show();
        }
        else
        {
            this.loginEditText.setText("");
            this.passwordEditText.setText("");
        }
    }
}
