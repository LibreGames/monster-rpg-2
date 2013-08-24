package com.nooskewl.monsterrpg2;

import org.liballeg.app.AllegroActivity;
import android.net.Uri;
import android.content.Intent;
import android.text.ClipboardManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.File;
import android.view.KeyEvent;
import android.util.Log;
import android.app.ActivityManager;
import android.os.Bundle;
import java.io.*;
import android.util.*;
import java.util.*;
import java.security.spec.*;
import android.app.Activity;
import android.view.View;

public class MO2Activity extends AllegroActivity {

   /* load libs */
   static {
      System.loadLibrary("allegro");
      System.loadLibrary("allegro_memfile");
      System.loadLibrary("allegro_primitives");
      System.loadLibrary("allegro_image");
      System.loadLibrary("allegro_font");
      System.loadLibrary("allegro_ttf");
      System.loadLibrary("allegro_color");
      System.loadLibrary("bass");
      System.loadLibrary("bassflac");
   }

	public void logString(String s)
	{
		Log.d("MRPG2", s);
	}

	public String getSDCardPrivateDir()
	{
		File f = getExternalFilesDir(null);
		if (f != null) {
			return f.getAbsolutePath();
		}
		else {
			return getFilesDir().getAbsolutePath();
		}
	}

	public boolean wifiConnected()
	{
		ConnectivityManager connManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		return mWifi.isConnected();
	}

	public void openURL(String url)
	{
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.monster-rpg.com"));
		startActivity(intent);
	}

	private boolean clip_thread_done = false;

	public void setClipData(String saveState)
	{
		final String ss = saveState;

		Runnable runnable = new Runnable() {
			public void run() {
				ClipboardManager m = 
					(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);

				m.setText(ss);

				clip_thread_done = true;
				}
			};
		runOnUiThread(runnable);

		while (!clip_thread_done)
			;
		clip_thread_done = false;
	}

	private String clipdata;

	public String getClipData()
	{
		Runnable runnable = new Runnable() {
			public void run() {
				ClipboardManager m = 
					(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);

				clipdata = m.getText().toString();

				clip_thread_done = true;
			}
		};
		runOnUiThread(runnable);

		while (!clip_thread_done)
			;
		clip_thread_done = false;

		return clipdata;
	}
}

