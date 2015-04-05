package com.jbc.android;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.util.Config;

/**
 * @author Jordan Bortz (jordanbortsd[at]gmail[dot]com)
 */
public class ProtoApp extends Application
	{

	public static void reportException(Context ctxt, Exception e, String tag)
		{

		Class<? extends Exception> c = e.getClass();
		String cs = c.getSimpleName();
		String msg = e.getMessage();
		String pss = "";

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		ps.flush();
		ps.close();

		try
			{
			pss = baos.toString("ISO-8859-1"); // e.g. ISO-8859-1

			} catch (Exception ee)
			{
			// ignore exceptions especially encoding exceptions
			}

		new AlertDialog.Builder(ctxt).setTitle("Exception Reported in " + tag)
				.setMessage("Error: " + msg + pss)
				.setNeutralButton("Close", null).show();

		}

	public static void sleep(int i)
		{
		try
			{
			Thread.sleep(i);
			} catch (InterruptedException e)
			{
			// TODO Auto-generated catch block
			// e.printStackTrace();
			}
		}

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressWarnings("unused")
	@Override
	public void onCreate()
		{
		/*
		 * if (Config.DEVELOPER_MODE && Build.VERSION.SDK_INT >=
		 * Build.VERSION_CODES.GINGERBREAD) { StrictMode.setThreadPolicy(new
		 * StrictMode.ThreadPolicy.Builder()
		 * .detectAll().penaltyDialog().build()); StrictMode.setVmPolicy(new
		 * StrictMode.VmPolicy.Builder() .detectAll().penaltyDeath().build()); }
		 * 
		 * super.onCreate();
		 */
		// MockDB.getInstance().buildMockDB();
		// initImageLoader(getApplicationContext());
		}

	}