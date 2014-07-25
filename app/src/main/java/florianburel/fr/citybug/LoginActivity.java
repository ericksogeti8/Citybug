package florianburel.fr.citybug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import florianburel.fr.citybug.Services.CityBugService;
import florianburel.fr.citybug.Services.OnConnectionResultListener;

/**
 * Created by fl0 on 25/07/2014.
 */
public class LoginActivity extends Activity implements View.OnClickListener, OnConnectionResultListener {

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

        CityBugService service = CityBugService.getInstance(this);

        service.connect(user, password, this);
    }

    @Override
    public void onConnectionSuccess() {


        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }

    @Override
    public void onConnectionError(Exception e) {

        this.loginEditText.setText("");
        this.passwordEditText.setText("");

    }
}
