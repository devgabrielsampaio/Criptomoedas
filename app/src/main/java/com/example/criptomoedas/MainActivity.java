package com.example.criptomoedas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

import cz.msebera.android.httpclient.Header;
public class MainActivity extends AppCompatActivity {

    private final String Base_URL="http://api.coinlayer.com/live?access_key=";
    TextView preco;
    Button botao1;
    EditText consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preco=(TextView) findViewById(R.id.view1);
        consulta=(EditText) findViewById(R.id.edit1);
        botao1=(Button) findViewById(R.id.button1);
        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String publicKey = "f0668a4cf8a258c463d4d8732971f92e";
                String finalUrl = Base_URL + publicKey + "&TARGET=" + consulta.getText() + "&symbols=BTC";
                Log.d("Clima", "Request fail! Status code: " + finalUrl);
                try {
                    letsDoSomeNetworking(finalUrl);
                } catch (Exception e){
                    e.printStackTrace();

                }
            }

        });

    }

    private void letsDoSomeNetworking(String url) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
                Log.d("Clima", "JSON: " + response.toString());
                try {
                    JSONObject price = response.getJSONObject("rates");
                    String object = price.getString("BTC");
                    preco.setText(object);
                } catch (JSONException E) {
                    E.printStackTrace();
                }
            }



        });
    }
}