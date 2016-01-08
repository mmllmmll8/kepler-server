package input;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.util.JSONPObject;

import gvjava.org.json.JSONException;
import gvjava.org.json.JSONObject;
import tools.LBS_handle;
import tools.Rec_handle;

/**
 * Servlet implementation class senddate
 */
@WebServlet("/senddate")
public class senddate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public senddate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String content = request.getParameter("content");
		try {
			JSONObject jcontent = new JSONObject(content);
			String type = jcontent.optString("type","");	
			String data = jcontent.optString("data","");
			//第一次拆分，了解数据内容
			switch (type) {
				case "record"://停留时收集的数据
					new Thread(new LBS_handle(data)).start();
					break;
				case "lbs"://运动轨迹的数据
					new Thread(new Rec_handle(data)).start();
					break;
				default:
					break;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}

}
