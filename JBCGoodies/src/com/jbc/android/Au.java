package com.jbc.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;

/**
 * @author Jordan Bortz (jordanbortsd[at]gmail[dot]com)
 */


public abstract class Au extends FragmentActivity
/* note you can
 change this
 to Activity
 or leave it
 alone
*/
	{
	protected final static String TAG = Au.class.getSimpleName();

	public void setTV(int id, String val)
		{
		TextView text = (TextView) findViewById(id);
		text.setText(val);
		}

	public void setTV(int id, SpannableStringBuilder sb)
		{
		TextView text = (TextView) findViewById(id);
		text.setText(sb);
		}

	public void displayMessage(String s)
		{
		new AlertDialog.Builder(this).setTitle("Notice").setMessage(s)
				.setNeutralButton("Thanks!", null).show();
		}

	public void toast(String s)
		{

		/*
		 * Toast.makeText(ApplicationChild.getApplicationContext(), message,
		 * Toast.LENGTH_LONG).show();
		 */

		Toast msg = Toast.makeText(this, s, Toast.LENGTH_LONG);
		msg.show();

		}

	public void ignoreException(Exception ex)
		{

		}

	public void logException(Exception ex)
		{
		Log.d("Exception Logger", ex.toString());
		}

	public void log(String s)
		{
		Log.d("General Logger", s);

		}

	public void reportException(Exception e, String tag)
		{
		// Fix this
		// CDSApp.reportException(this, e, tag);
		}

	
	/* from there down we probably don't need to do */
	
	public void disableView(View view)
		{
		hideView(view);
		}

	public void enableView(View view)
		{
		showView(view);
		}

	public void hideView(View view)
		{
		/*
		 * if (view instanceof ViewGroup) { for (int i = 0; i < ((ViewGroup)
		 * view).getChildCount(); i++) { View child = ((ViewGroup)
		 * view).getChildAt(i); if (child instanceof ViewGroup) {
		 * hideView((ViewGroup) child); } else if (child != null) {
		 * view.setVisibility(View.GONE); } } }
		 */
		view.setVisibility(View.GONE);
		}

	public void showView(View view)
		{
		/*
		 * if (view instanceof ViewGroup) { for (int i = 0; i < ((ViewGroup)
		 * view).getChildCount(); i++) { View child = ((ViewGroup)
		 * view).getChildAt(i); if (child instanceof ViewGroup) {
		 * hideView((ViewGroup) child); } else if (child != null) {
		 * view.setVisibility(View.VISIBLE); } } }
		 */
		view.setVisibility(View.VISIBLE);
		}

	@Override
	protected void onStart()
		{
		super.onStart();
		}

	@Override
	protected void onResume()
		{
		super.onResume();
		}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
		{
		super.onActivityResult(requestCode, resultCode, data);
		}

	@Override
	protected void onPause()
		{
		super.onPause();
		}

	@Override
	protected void onStop()
		{
		super.onStop();
		}

	@Override
	protected void onSaveInstanceState(Bundle outState)
		{
		super.onSaveInstanceState(outState);
		}

	@Override
	protected void onDestroy()
		{
		super.onDestroy();
		}



	}
