package com.qm.calculator;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Button;

class _Controller extends LinearLayout {
    public _Controller(Activity activity, final _Model _model,
            final _View _view) {
        super(activity, null);
        LayoutInflater layoutInflater = (LayoutInflater)
                activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.keyboard, this);

        final Button button0 = (Button) view.findViewById(R.id.button0);
        button0.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('0');
                _view.setView(_model.getModel());
            }
        });

        final Button button1 = (Button) view.findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('1');
                _view.setView(_model.getModel());
            }
        });

        final Button button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('2');
                _view.setView(_model.getModel());
            }
        });

        final Button button3 = (Button) view.findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('3');
                _view.setView(_model.getModel());
            }
        });

        final Button button4 = (Button) view.findViewById(R.id.button4);
        button4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('4');
                _view.setView(_model.getModel());
            }
        });

        final Button button5 = (Button) view.findViewById(R.id.button5);
        button5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('5');
                _view.setView(_model.getModel());
            }
        });

        final Button button6 = (Button) view.findViewById(R.id.button6);
        button6.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('6');
                _view.setView(_model.getModel());
            }
        });

        final Button button7 = (Button) view.findViewById(R.id.button7);
        button7.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('7');
                _view.setView(_model.getModel());
            }
        });

        final Button button8 = (Button) view.findViewById(R.id.button8);
        button8.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('8');
                _view.setView(_model.getModel());
            }
        });

        final Button button9 = (Button) view.findViewById(R.id.button9);
        button9.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('9');
                _view.setView(_model.getModel());
            }
        });

        final Button buttonPlus = (Button) view.findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('+');
                _view.setView(_model.getModel());
            }
        });

        final Button buttonEqual = (Button) view.findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('=');
                _view.setView(_model.getModel());
            }
        });

        final Button buttonMinus = (Button) view.findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('-');
                _view.setView(_model.getModel());
            }
        });

        final Button buttonC = (Button) view.findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('C');
                _view.setView(_model.getModel());
            }
        });

        final Button buttonTimes = (Button) view.findViewById(R.id.buttonTimes);
        buttonTimes.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('*');
                _view.setView(_model.getModel());
            }
        });

        final Button buttonDivide = (Button)
                view.findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                _model.setModel('/');
                _view.setView(_model.getModel());
            }
        });
    }
}
