package com.zyc.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Zyc_pic_util {

	public String getPicSrcById(int id) throws IOException{
		Util util=new Util();
		String mainsite="http://www.zyctd.com/exchange-priceItem-"+id+"-1-0.html";
		String mainDoc=util.getInputStreamByWebsite(mainsite);
		Document mainData=Jsoup.parse(mainDoc);
		Elements mainList=mainData.select("div.iBreedInfo > img");
		
		String src=mainList.get(0).attr("src");
		if(src.equals("/images/web/nopic.jpg")){
			savePicByAdr("http://img.zyctd.com/images/web/nopic.jpg", id);
		}else{
			savePicByAdr(src, id);
		}
		System.out.println(id);
		return src;
	}
	
	public void savePicByAdr(String adr,int id) throws IOException{
		
		//建立一个新的文件
		String newImageName="D:/zyc_img/"+id+".gif";
		File file=new File(newImageName);
		
		URL url =new URL(adr);
		//打开网络输入流
		DataInputStream dis = new DataInputStream(url.openStream());				
		   
	    FileOutputStream fos = new FileOutputStream(file);
	    
	    byte[] buffer = new byte[1024];
	    
	    int length;
	   
	    //开始填充数据
	   
	    while((length = dis.read(buffer))>0){
	   
	    	fos.write(buffer,0,length);
	   
	    }
	   
	    dis.close();
	   
	    fos.close();
		
	}
}
