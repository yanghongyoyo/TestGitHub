package com.hyang.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class preJson {
	private static List<HashMap<String, Object>> listInfo;
	
	/*
	 * 解析json函数
	 * */
	 public static  List<HashMap<String, Object>>  getPerson(String jsonStr){
		 
		 listInfo=new ArrayList<HashMap<String, Object>>();
		 try {
			JSONArray jsonArray=new JSONArray(jsonStr);
			
			for(int i=0;i<jsonArray.length();i++){
				HashMap<String, Object> map=new HashMap<String, Object>();
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				Integer id=jsonObject.getInt("id");
				map.put("id", id);
				String name=jsonObject.getString("name");
				map.put("name", name);
				String photo=jsonObject.getString("photo");
				map.put("photo", photo);
				String address=jsonObject.getString("address");
				map.put("address", address);
				String phone=jsonObject.getString("phone");
				map.put("phone", phone);
				String email=jsonObject.getString("email");
				map.put("email", email);
				
				listInfo.add(map);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("json数据解析错误");
		 }
		 return listInfo;
	  }
	
}
