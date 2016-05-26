package com.hyang.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

public class fileHand {
	
	//判断SD卡是否存在
	public static boolean isSdCardExist() {  
	    return Environment.getExternalStorageState().equals(  
	            Environment.MEDIA_MOUNTED);  
	} 
	//获取SD卡路径
	public static String getSdCardPath() {  
	    boolean exist = isSdCardExist();  
	    String sdpath = "";  
	    if (exist) {  
	        sdpath = Environment.getExternalStorageDirectory()  
	                .getAbsolutePath();  
	    } else {  
	        sdpath = "不能获取sd卡路径";  
	    }  
	    return sdpath;  
	  
	} 
	/** 
	 * 获取默认的文件路径   
	 * @return 
	 */  
	public static String getDefaultFilePath(String fPath) {  
	    String filepath = "";  
	    File file = new File(Environment.getExternalStorageDirectory(),fPath);  
	    if (file.exists()) {  
	        filepath = file.getAbsolutePath();  
	    } else {  
	        filepath = "不能获取文件路径";  
	    }  
	    return filepath;  
	}
	/*
	 * 使用bufferReader读取文本文件
	 * */
	public static String getFile(String fPath){
		String fileInfo = null;
	    try {  
	        File file = new File(Environment.getExternalStorageDirectory(),  
	               fPath);  
	        BufferedReader br = new BufferedReader(new FileReader(file));  
	        String readline = "";  
	        StringBuffer sb = new StringBuffer();  
	        while ((readline = br.readLine()) != null) {   
	            sb.append(readline);  
	        }  
	        br.close();  
	        fileInfo=sb.toString();  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    return fileInfo;
	}
	
	/*
	 * 读取sd卡图片文件
	 * */
	public static Bitmap getImage(String path){
		File mFile=new File(path);
		Bitmap bitmap = null;
        //若该文件存在
        if (mFile.exists()) {
            bitmap=BitmapFactory.decodeFile(path);
        }
		return bitmap;
	}
	 /*
	  * 获取SD卡图片URL
	  * 
	  * */
	public static String getImgURL(String FilePath){
		//获取sd卡上图片的路径url 
		Uri fileUrl=null;
		 fileUrl = Uri.fromFile(new File(FilePath));
		return fileUrl.toString();
	}
	/*
	 * 写入字节流
	 * */ 
	
	public static String writeFile(String writeInfo,String fPath){
		String temp=null;
	    try {  
	        File file = new File(Environment.getExternalStorageDirectory(),  
	                fPath);  
	            FileOutputStream fos = new FileOutputStream(file);  
	            String info = writeInfo;  
	               fos.write(info.getBytes());  
	               fos.close();  
	        temp="写入成功：";  
	    } catch (Exception e) {  
	        e.printStackTrace(); 
	        temp="文件写入失败！";
	    }  
		return temp;
	}
	//写入字符流
	public static String writeFileBuffer(String writeInfo,String fPath){
		String temp=null;
		BufferedWriter bw = null;
		try {  
		    File file = new File(Environment.getExternalStorageDirectory(),  
		            fPath);  
		    //第二个参数意义是说是否以append方式添加内容  
			bw = new BufferedWriter(new FileWriter(file, true));  
		    String info = " hey, yoo,bitch";  
		    bw.write(info);  
		    bw.flush();  
		    System.out.println("写入成功");  
		} catch (Exception e) {  
		    e.printStackTrace();  
		}finally{
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return temp;
	}
	
}
