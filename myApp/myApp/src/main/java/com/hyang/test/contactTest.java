package com.hyang.test;

import com.hyang.model.contactData;

import android.graphics.Bitmap;
import android.test.AndroidTestCase;
import android.util.Log;

public class contactTest extends AndroidTestCase{

	public void testGetContactIco(){
		contactData c=new contactData();
		String contactIcoPath="service/photo/";
	    String contactIconame="a.png";
	    Bitmap ico=c.getContactIco(contactIcoPath+contactIconame);
	 }
	
	public void testGetgetIcoUrl(){
		contactData c=new contactData();
		Log.i("info", "得到的路径信息是："+c.getIcoUrl("a.png"));
	}
}
