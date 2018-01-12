package jp.wizcorp.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.unity3d.player.UnityPlayerActivity;
import android.util.Log;
import android.content.Intent;

public class MainActivity extends UnityPlayerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate called!");
    }

    public void OpenWebView() {

    }

    public void shareText(String subject, String body) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

}
