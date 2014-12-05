package com.example;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    this.setContentView(R.layout.ex_main);
    Button btn = (Button) findViewById(R.id.button1_exmain);
    
    btn.setOnClickListener(new OnClickListener(){

      @Override
      public void onClick(View arg0) {
        DialogFragment expChkList = new DialogFragmentWithExpandCheckBoxList();
        expChkList.show(getFragmentManager(), "Example");
      }
      
    });
  }
}
