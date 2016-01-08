package tools;

import java.util.ArrayList;

import object.LBS;
import object.Record;

public class Rec_handle implements Runnable{
	private String content = null;
	
	public Rec_handle(String content) {
		// TODO Auto-generated constructor stub
		this.content = content;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		JSON2Object<Record> json2object = new JSON2Object<Record>();
		ArrayList<Record> rec_array = json2object.handle(content, Record.class);
		//对象数组保存数据库
		
	}
}
