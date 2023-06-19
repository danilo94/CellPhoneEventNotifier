
import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.*;
import android.content.Context;

public class MqttClient {

    private MqttAndroidClient mqttClient;



    public void conectar(String broker,String usuario, String senha){
        mqttClient = new MqttAndroidClient(getApplicationContext(),broker,"");
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(usuario);
        options.setPassword(senha.toCharArray());

        try {
            mqttClient.connect(options);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
