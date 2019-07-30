package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web_page extends AppCompatActivity {

    WebView wvPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_page);

        wvPage = findViewById(R.id.webPage);

        wvPage.setWebViewClient(new WebViewClient());

        Intent intentReceived = getIntent();
        String url = intentReceived.getStringExtra("URL");


        wvPage.loadUrl(url);

        wvPage.getSettings().setJavaScriptEnabled(true);
        wvPage.getSettings().setBuiltInZoomControls(true);

    }

}
