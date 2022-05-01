package com.example.flightsystem.entity;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.flightsystem.entity.impl.LoginImpl;

/**
 * 登录
 * @author Administrator
 *
 */
public class Login implements LoginImpl{
    
	private Passenger passenger;

	@Override
	public boolean loginByBookingNo(String bookingNo) {
		Order oder=passenger.selectOrder(bookingNo);
		return oder != null;
	}

	@Override
	public boolean loginBySurnameAndId(String surname, String id) {
		String name=passenger.getGivenName();
		String iid=passenger.getId();
		if(surname==null) {
			return false;	
		}
        if(id==null) {
    	   return false;	
		}
		return name.equals(surname) && id.equals(iid);
	}

	@Override
	public boolean loginById(String id) {

		StringBuilder strB = new StringBuilder();   //strB用来存储txt文件里的内容
	    String str;
	    //需要假设一个txt之类的文档是机器传输过来的信息就可以
		String path="/src/main/resources/com/example/flightsystem/input_files/id.txt"; //格式：id，surname, given name, gender
		File file = new File(path); // 要读取以上路径的input.txt文件
	    try {
			BufferedReader br = new BufferedReader(new FileReader(file));
	        while ((str = br.readLine()) != null) {
	            strB.append(str).append("<br>");   //将读取的内容放入strB
	            String[] array=str.split(",");   //假设每行数据是以逗号分隔，id是第一个位置
	            if(array.length>0 && id.equals(array[0])) {
	            	return true;
	            }
	        }
	        br.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

		return false;
	}
      
}
