package com.hyang.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.graphics.Bitmap;

import com.hyang.myapp.myAppConst;
import com.hyang.tool.fileHand;
import com.hyang.tool.preJson;

public class contactData {

	//存放在sd卡上的json文件路径
	//private String jsonPath="service/friendInfo.json";
	//存放头像的文件路径
	//private String contactIcoPath="service/photo/";
	private String jsonPath;
	private String contactIcoPath;
	public contactData() {
		// TODO Auto-generated constructor stub
		jsonPath=myAppConst.JSON_PATH;
		contactIcoPath=myAppConst.ICO_PATH;
	}
	
	//获取json文件路径
	public String filePath(){
		return fileHand.getDefaultFilePath(jsonPath);
	}
	//获取json文件
	public String getFriendJson(){
		return fileHand.getFile(jsonPath);
	}
	//解析的json数据放入list中
	public List<HashMap<String,Object>> contactDataList(){
		return preJson.getPerson(getFriendJson());
	}
	//从list<map>中取出name数据
	public List<String> getNamesList(){
		List<String> temp=new ArrayList<String>();
		for(int i=0;i<contactDataList().size();i++){
			HashMap<String, Object> map=new HashMap<String, Object>();
			map=contactDataList().get(i);
			temp.add((String) map.get("name"));
		}
		return temp;
	}
	//获得SD卡上的图片文件
	public  Bitmap getContactIco(String icoName){
		
		return fileHand.getImage(contactIcoPath+icoName);
		
	}
	//获取图片url
	public String getIcoUrl(String icoName){
		String sdPath=fileHand.getSdCardPath();
		String s=sdPath+"/"+contactIcoPath+icoName;
		return fileHand.getImgURL(s);
	}
	
	
}
