package com.example.flightsystem.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		return oder==null?false:true;
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
        if(name.equals(surname) && id.equals(iid)) {
        	return true;
        }
        
		return false;
	}

	@Override
	public boolean loginById(String id) {
		
		StringBuffer strB = new StringBuffer();   //strB用来存储txt文件里的内容
	    String str = "";
	    //需要假设一个txt之类的文档是机器传输过来的信息就可以
	    String txtUrl ="http://127.0.0.1:8080/dd/file.action";//文件路径我是从后台传的 就是 http://127.0.0.1......
	    URL url = null;
	    try {
	        url = new URL(txtUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        InputStreamReader isr = new InputStreamReader(connection.getInputStream());
	        BufferedReader br = new BufferedReader(isr);
	        while ((str = br.readLine()) != null) {
	            strB.append(str).append("<br>");   //将读取的内容放入strB
	            String[] array=str.split(",");   //假设每行数据是以逗号分隔，id是第一个位置
	            if(array.length>0 && id.equals(array[0])) {
	            	return true;
	            }
	        }
	        br.close();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
      
}
