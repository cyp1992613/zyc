package com.zyc.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Zyc_knowledgeDAO {
	@Resource
	SessionFactory factory;

}
