package com.hyang.test;

import com.hyang.model.contactData;
import com.hyang.tool.fileHand;

import android.test.AndroidTestCase;
import android.util.Log;

public class fileHandTest extends AndroidTestCase{

	public void testGetSdCardPath(){
		Log.i("info", "得到的SD卡路径是："+fileHand.getSdCardPath());
		//System.out.println("得到的SD卡路径是："+fileHand.getSdCardPath());
	}
	
	public void testGetImageUrl(){
		contactData c=new contactData();
		Log.i("info", "得到的路径信息是："+c.getIcoUrl("a.png"));
		Log.e("error", "获取图片Uri:"+fileHand.getImgURL("/storage/sdcard0/service/photo/a.png"));
	}
}
