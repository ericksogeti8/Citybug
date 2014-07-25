package florianburel.fr.citybug.Services;

/**
 * Created by fl0 on 25/07/2014.
 */
public interface OnConnectionResultListener {

    void onConnectionSuccess();

    void onConnectionError(Exception e);
}
