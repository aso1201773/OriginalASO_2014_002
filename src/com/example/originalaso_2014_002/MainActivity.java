package com.example.originalaso_2014_002;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

	public void onClick(View v) {

		int bbb = 0;
		switch(v.getId()){
		case R.id.hitokoto:
			bbb = 1;
		break;

		case R.id.mente:
			bbb = 0;
		break;
		}

		    Intent intent = null;
		    switch(bbb){
		    case 0:
		    	intent = new Intent(MainActivity.this,MaintenanceActivity.class);
		    	startActivity(intent);
		    	break;
		    case 1:
		    	intent = new Intent(MainActivity.this,HitokotoActivity.class);
		    	startActivity(intent);
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
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
