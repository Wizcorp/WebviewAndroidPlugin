package jp.wizcorp.webviewlib;

/**
 * Created by kyeong-jaemin on 2017/12/28.
 */

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.MotionEvent;
import android.view.View;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class WebViewActivity extends Activity {

    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity CUA = UnityPlayer.currentActivity;

        webView = new WebView(CUA);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        setContentView(webView);

        webView.loadUrl(MainActivity.Url);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            MainActivity.CallBackToUnity();
            super.onBackPressed();
        }
    }
}