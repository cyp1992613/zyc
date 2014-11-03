package com.zyc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zyc.dao.Zyc_effectDAO;
import com.zyc.dao.Zyc_infoDAO;
import com.zyc.entity.Zyc_effect;
import com.zyc.entity.Zyc_info;
import com.zyc.util.Util;
import com.zyc.util.Zyc_effect_util;
import com.zyc.util.Zyc_info_util;
import com.zyc.util.Zyc_pic_util;
@SuppressWarnings("serial")
@Controller
public class Test extends ActionSupport{
	@Resource
	Zyc_infoDAO dao;
	@Resource
	Zyc_effectDAO efdao;
	
	public void test() {
		System.out.print(dao.findByProperty("zyc_id", "1").size());
	}

	public void pt() {
		System.out.print("hello world!");
	}
	
	
	public void pw(){
		Util util=new Util();
		String adr="http://www.zyctd.com/exchange-priceInfo-557-1-0.html";
		try {
			System.out.print(util.getInputStreamByWebsite(adr));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pv() throws IOException{
		Zyc_info_util u=new Zyc_info_util();
		u.getInfoById(3);
		
	}
	
	public void update() throws IOException{
		for(int i=1;i<=1774;i++){
			Zyc_info zyc_info=new Zyc_info();
			Zyc_info_util util=new Zyc_info_util();
			zyc_info=util.getInfoById(i);
			dao.saveOrUpdate(zyc_info);
		}
	}
	
	public void pic() throws IOException{
		for(int i=1;i<=1774;i++){
			Zyc_pic_util u=new Zyc_pic_util();
			
			String src=u.getPicSrcById(i);
			System.out.println("src="+src);
			
			u=null;
		}
	}
	
	
	public void ef() throws IOException{
		Zyc_effect_util u=new Zyc_effect_util();
		System.out.println(u.getEffectById(5));
	}
	
	public void writeef() throws IOException{
		for(int i=1;i<=1774;i++){
			Zyc_effect_util u=new Zyc_effect_util();
			String html=u.getEffectById(i);
			Zyc_effect effect=new Zyc_effect();
			effect.setZyc_id(i);
			effect.setZyc_name(dao.findByProperty("id", i).get(0).getZyc_name());
			effect.setZyc_effect(Hibernate.createBlob(html.getBytes("utf-8")));
			efdao.saveOrUpdate(effect);
			effect=null;
			System.out.println(i);
		}
	}
	
	public void readef() throws SQLException, IOException{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request = ServletActionContext.getRequest();	
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		Zyc_effect effect=efdao.findByProperty("id", 15).get(0);
		
		byte[] b=new byte[(int) effect.getZyc_effect().length()];
		InputStream in=effect.getZyc_effect().getBinaryStream();
		
		int count = 0;
		int temp = 0;
		while ((temp = in.read()) != (-1)) {
			b[count++] = (byte) temp;
		}
		
		String s=new String(b,"utf-8");
		
		response.getWriter().write(s);
	}

}
