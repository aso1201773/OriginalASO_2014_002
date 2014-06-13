package com.example.originalaso_2014_002;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HitokotoActivity extends Activity {


	protected void onResume(){
		super.onResume();

		Intent intent = this.getIntent();
		String strHitokoto = intent.getStringExtra("hitokoto");

		TextView txt = (TextView)findViewById(R.id.txvHITOKOTO);
		txt.setText(strHitokoto);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hitokoto_activity);
	}

}
