package com.zyc.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Zyc_effect_util {

	public String getEffectById(int id) throws IOException{
		Util util=new Util();
		String site="http://www.zyctd.com/mcodex-item-"+id+"-1-1.html";
		String doc=util.getInputStreamByWebsite(site);
		Document data=Jsoup.parse(doc);
		Elements list=data.select("div#effectCons");
		
		return list.get(0).html();
	}
	
	
}
