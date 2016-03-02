package com.slidepanel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ListView listView;
    private ArrayList<String> list = new ArrayList<>();
    private SlideBottomPanel sbv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sbv = (SlideBottomPanel) findViewById(R.id.sbv);

        Button button = (Button) findViewById(R.id.button);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sbv.displayPanel();
            }
        });

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.list_item, getData()));

    }

    private ArrayList<String> getData() {
        for (int i = 0; i < 20; i++) {
            list.add("Item " + i);
        }
        return list;
    }

    @Override
    public void onBackPressed() {
        if (sbv.isPanelShowing()) {
            sbv.hide();
            return;
        }
        super.onBackPressed();
    }
}
