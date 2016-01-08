package tools;

import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONException;
import object.LBS;
import object.Record;

//分解lbsjson内容直接储存到数据库
//需不需要新建线程执行任务需要考虑
public class LBS_handle implements Runnable{
	
	private String content = null;
	
	public LBS_handle(String content) {
		this.content = content;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		JSON2Object<LBS> json2object = new JSON2Object<LBS>();
		ArrayList<LBS> rec_array = json2object.handle(content, LBS.class);
	}
}
