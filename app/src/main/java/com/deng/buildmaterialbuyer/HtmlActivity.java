package com.deng.buildmaterialbuyer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

public class HtmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);

        WebView webView = (WebView) findViewById(R.id.webView);
        String fileName = "file:///android_asset/";
        Intent intent = getIntent();
        String pagestr = intent.getStringExtra("page");
        switch (pagestr)
        {
            case "工字钢规格表":
                fileName += "beams.htm";
                break;
            case "槽钢规格表":
                fileName += "channels.htm";
                break;
            case "角钢规格表":
                fileName += "angles.htm";
                break;
        }
        webView.loadUrl(fileName);

    }
}
