package florianburel.fr.citybug.Services;

import android.content.Context;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by fl0 on 25/07/2014.
 */
public class CityBugService
{

    private String API_KEY = "YERjcTIo2Urc3f1wqEqxm4cZWgETsbPyrpNKHrfH";
    private String CLIENT_KEY = "kP3v4VheP5m2ldH9mmT7hzq8lL1i8G7FVXTselcX";

    private static CityBugService sInstance;

    public static CityBugService getInstance(Context context) {
        if (sInstance == null) {
            //Always pass in the Application Context
            sInstance = new CityBugService(context.getApplicationContext());
        }

        return sInstance;
    }


    private CityBugService(Context context) {

        Parse.initialize(context, API_KEY, CLIENT_KEY);

    }



    public void connect(String username, String password, final OnConnectionResultListener listener)
    {
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {

                if(e != null)
                {
                    listener.onConnectionError(e);
                }
                else
                {
                    listener.onConnectionSuccess();
                }

            }
        });
    }
}
