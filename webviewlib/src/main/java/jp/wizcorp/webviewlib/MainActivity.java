package jp.wizcorp.webviewlib;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;
import android.util.Log;
import android.content.Intent;
import android.webkit.WebView;
import android.content.Context;

import java.lang.reflect.Method;

public class MainActivity extends UnityPlayerActivity {

    public static String GameObject;
    public static String MethodName;
    public static String Message;
    public static String Url = "https://wizcorp.jp/";

    public void SetupCallBack(String gameObject, String methodName, String message) {
        Log.d("MainActivity", "SetupCallBack");

        GameObject = gameObject;
        MethodName = methodName;
        Message = message;
    }

    public void OpenWebView() {
        final Context context = this;
        Intent intent = new Intent(context, WebViewActivity.class);
        startActivity(intent);
    }

    public void OpenWebView(String url) {
        Url = url;

        final Context context = this;
        Intent intent = new Intent(context, WebViewActivity.class);
        startActivity(intent);
    }

    public void ShareText(String subject, String body) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public static void CallBackToUnity() {
        Log.d("MainActivity", "CallbackToUnity");
        UnityPlayer.UnitySendMessage(GameObject, MethodName, Message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
