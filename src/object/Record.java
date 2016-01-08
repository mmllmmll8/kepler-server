package object;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

//这是应用上传的信息的元类型，包含了一次停留所产生的信息
public class Record {
	public String date;
	public String username;
	public String lbsinfo;
	public String poiinfo;
}
