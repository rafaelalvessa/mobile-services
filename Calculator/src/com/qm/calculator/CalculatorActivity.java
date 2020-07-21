package com.qm.calculator;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Menu;

public class CalculatorActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculator);
            final _Model myModel = new _Model();
            final _View myView = new _View(this);
            _Controller myController = new _Controller(this, myModel, myView);
            ViewGroup container = (ViewGroup) findViewById(R.id.myLayout);
            container.addView(myView);
            container.addView(myController);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_calculator, menu);
        return true;
    }
}
