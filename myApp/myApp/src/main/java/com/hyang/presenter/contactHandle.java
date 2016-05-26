package com.hyang.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

import com.hyang.model.contactData;
import com.hyphenate.easeui.domain.EaseUser;

public class contactHandle {
	
	List<String> namesList;
	contactData cd;
	public contactHandle() {
		 // TODO Auto-generated constructor stub
		 //从model中拿到联系人名称的list数据
		 namesList=new ArrayList<String>();
		 cd=new contactData();
		 namesList=cd.getNamesList();
	}

	public  Map<String, EaseUser> getContacts(){
        Map<String, EaseUser> contacts = new HashMap<String, EaseUser>();
        contactData c=new contactData();
        for(int i=0;i<namesList.size();i++){
        	EaseUser user = new EaseUser(namesList.get(i));
        	user.setAvatar(c.getIcoUrl("b.png"));
        	//Log.i("info", "是否设置成功了图片");
        	contacts.put("user" + i, user);
        }
        return contacts;
    }
}
