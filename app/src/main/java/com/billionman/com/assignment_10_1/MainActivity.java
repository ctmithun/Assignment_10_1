package com.billionman.com.assignment_10_1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SimpleAddition frag1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        invisibleFragment();
    }

    public void showText(View view) {
        FragmentManager fm = getSupportFragmentManager();
        frag1 = new SimpleAddition();
        EditText ev = (EditText) findViewById(R.id.editText);
        if(ev.getText() != null && !"".equals(ev.getText().toString())) {
            frag1.setText(ev.getText().toString());
            fm.beginTransaction().add(R.id.frag_id,frag1).commit();
            findViewById(R.id.frag_id).setVisibility(View.VISIBLE);
        } else {
            invisibleFragment();
        }
    }

    private void invisibleFragment() {
        if(frag1 != null) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().remove(frag1).commit();
        }
        findViewById(R.id.frag_id).setVisibility(View.GONE);
    }
}
