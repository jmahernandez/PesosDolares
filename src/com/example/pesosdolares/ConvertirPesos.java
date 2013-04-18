package com.example.pesosdolares;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;

import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class ConvertirPesos extends Activity {

    public final static String RESULT = "com.example.pesosdolares.RESULT";
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertir_pesos);
        // Show the Up button in the action bar.
        setupActionBar();
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.convertir_pesos, menu);
        return true;
    }
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void CalcularPesos(View view) {
    	Intent intent = new Intent(this, CalcularPesos.class);
    	
    	EditText editText = (EditText) findViewById(R.id.editText1);
    	
    	Double pesos = Double.parseDouble(editText.getText().toString());
    	Double dolares = pesos * 14;
    	
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	
    	String result = twoDForm.format(dolares);
    	
    	intent.putExtra(RESULT, result);
    			
    	startActivity(intent);
    }

}
