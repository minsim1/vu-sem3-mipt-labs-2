package com.example.mipt_lab_2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CurrencyAdapter extends ArrayAdapter<Currency> {

    private final String TAG = "CurrencyAdapter";
    private final LayoutInflater inflater;

    public CurrencyAdapter(Context context, List<Currency> currencies) {
        super(context, 0, currencies);
        Log.i(TAG,"Class initialized");
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i(TAG,"getView called");
        // Reuse view if possible
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_item, parent, false);
        }

        // Get the current currency object
        Currency currency = getItem(position);

        // Find views in the row layout
        TextView codeView = convertView.findViewById(R.id.textCurrencyCode);
        TextView valueView = convertView.findViewById(R.id.textCurrencyValue);

        // Bind data
        if (currency != null) {
            codeView.setText(currency.code);
            valueView.setText(currency.value);
        }

        return convertView;
    }
}
