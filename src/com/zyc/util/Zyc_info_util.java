package com.zyc.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.zyc.entity.Zyc_info;

public class Zyc_info_util {

	
	public Zyc_info getInfoById(int id) throws IOException{
		Util util=new Util();
		String infoSite="http://www.zyctd.com/exchange-priceInfo-"+id+"-1-0.html";
		String mainsite="http://www.zyctd.com/exchange-priceItem-"+id+"-1-0.html";
		
		String infoDoc=util.getInputStreamByWebsite(infoSite);
		String mainDoc=util.getInputStreamByWebsite(mainsite);
		
		Document infoData=Jsoup.parse(infoDoc);
		Document mainData=Jsoup.parse(mainDoc);
		//用逗号的方式是查找匹配任一选择器的唯一元素，而不是找到满足所有条件的元素，这里错了的，但是勉强能用就没有改动了
		Elements infoList=infoData.select("div.l,div.ml10,div.breedInfoTxt span");
		Elements mainList=mainData.select("div.l,div.iBreedInfo > p");
		Elements kind=infoData.select("div.breadCrumbs,div.skuRangeCrumbs a");
		
		
//		System.out.println("kind="+kind.get(2).text());
//		System.out.println("zyc_name="+infoList.get(3).text());
//		System.out.println("zyc_origin="+mainList.get(7).text());
		
		int zyc_id=id;
		String zyc_name=infoList.get(3).text();
		String zyc_alias=infoList.get(7).text();
		String zyc_latin_name=infoList.get(5).text();
		String zyc_origin=mainList.get(7).text().replace("产区分布：", "");
		String zyc_kind=kind.get(2).text();
		String zyc_property=infoList.get(13).text();
		String zyc_date=mainList.get(5).text().replace("产新时间：", "");
		String zyc_characteristic=mainList.get(6).text().replace("品种特点：", "");
		
		
		Zyc_info info=new Zyc_info();
		info.setZyc_id(zyc_id);
		info.setZyc_name(zyc_name);
		info.setZyc_alias(zyc_alias);
		info.setZyc_latin_name(zyc_latin_name);
		info.setZyc_origin(zyc_origin);
		info.setZyc_kind(zyc_kind);
		info.setZyc_property(zyc_property);
		info.setZyc_date(zyc_date);
		info.setZyc_characteristic(zyc_characteristic);
		
//		System.out.println("产地="+zyc_origin);
		
		return info;
	}
	
}
