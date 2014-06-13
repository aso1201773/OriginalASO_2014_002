package com.example.originalaso_2014_002;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener{

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;
	public void onClick(View v) {
		  Intent intent = null;
		int bbb = 0;
		switch(v.getId()){
		case R.id.mente:
			bbb = 0;
		break;
		
		case R.id.hitokoto:
			bbb = 1;
		break;

		case R.id.touroku:
			bbb = 2;
		break;
		
		}

		  
		    switch(bbb){
		    case 0:
		    	intent = new Intent(MainActivity.this,MaintenanceActivity.class);
		    	startActivity(intent);
		    	break;
		    case 1:
		    	String strHitokoto = helper.selectRandomHitokoto(sdb);
		    	intent = new Intent(MainActivity.this,HitokotoActivity.class);
		    	intent.putExtra("hitokoto",strHitokoto);
		    	startActivity(intent);
		    	break;
		    case 2:
		    	EditText etv = (EditText)findViewById(R.id.edtMsg);
		    	String inputMsg = etv.getText().toString();
		    	
		    	if(inputMsg!=null && !inputMsg.isEmpty()){
		    		helper.insertHitokoto(sdb, inputMsg);
		    	}
		    	etv.setText("");
		    	
		    	
		    	break;


		}
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button touroku = (Button)findViewById(R.id.touroku);
		touroku.setOnClickListener(this);

		Button hitokoto = (Button)findViewById(R.id.hitokoto);
		hitokoto.setOnClickListener(this);

		Button mente = (Button)findViewById(R.id.mente);
		mente.setOnClickListener(this);
		
		if(sdb == null){
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			return;
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
