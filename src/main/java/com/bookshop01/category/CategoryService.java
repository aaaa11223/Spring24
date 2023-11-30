package com.bookshop01.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop01.goods.dao.GoodsDAO;
import com.bookshop01.goods.vo.GoodsVO;


public interface CategoryService {

	public Map<String,List<GoodsVO>> categoryList() throws Exception;
//	public Map<String,List<GoodsVO>> getDrinkPage() throws Exception;
//	public Map<String,List<GoodsVO>> getDairyPage() throws Exception;
//	public Map<String,List<GoodsVO>> getEtcPage() throws Exception;
//	public Map<String,List<GoodsVO>> getNoodlePage() throws Exception;
//	public Map<String,List<GoodsVO>> getSnackPage() throws Exception;
//	public Map<String,List<GoodsVO>> getSandwichPage() throws Exception;
	

	
}