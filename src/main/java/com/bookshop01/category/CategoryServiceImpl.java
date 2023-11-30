package com.bookshop01.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop01.goods.dao.GoodsDAO;
import com.bookshop01.goods.vo.GoodsVO;

@Service("categoryService")
//@Transactional(propagation=Propagation.REQUIRED)
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private GoodsDAO goodsDAO;
	
	public Map<String,List<GoodsVO>> categoryList() throws Exception {
		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
		List<GoodsVO> goodsList=goodsDAO.selectGoodsList("bestseller");
		goodsMap.put("bestseller",goodsList);
		return goodsMap;		
	}
//	public Map<String,List<GoodsVO>> getDrinkPage() throws Exception {
//		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
//		List<GoodsVO> goodsList=goodsDAO.selectGoodsList("bestseller");
//		goodsMap.put("bestseller",goodsList);
//		return goodsMap;		
//	}
//	public Map<String,List<GoodsVO>> getDairyPage() throws Exception {
//		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
//		List<GoodsVO> goodsList=goodsDAO.selectGoodsList("bestseller");
//		goodsMap.put("bestseller",goodsList);
//		return goodsMap;
//	}
//	public Map<String,List<GoodsVO>> getEtcPage() throws Exception {
//		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
//		List<GoodsVO> goodsList=goodsDAO.selectGoodsList("bestseller");
//		goodsMap.put("bestseller",goodsList);
//		return goodsMap;
//	}
//	public Map<String,List<GoodsVO>> getNoodlePage() throws Exception {
//		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
//		List<GoodsVO> goodsList=goodsDAO.selectGoodsList("bestseller");
//		goodsMap.put("bestseller",goodsList);
//		return goodsMap;
//	}
//	public Map<String,List<GoodsVO>> getSnackPage() throws Exception {
//		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
//		List<GoodsVO> goodsList=goodsDAO.selectGoodsList("bestseller");
//		goodsMap.put("bestseller",goodsList);
//		return goodsMap;
//	}
//	public Map<String,List<GoodsVO>> getSandwichPage() throws Exception {
//		Map<String,List<GoodsVO>> goodsMap=new HashMap<String,List<GoodsVO>>();
//		List<GoodsVO> goodsList=goodsDAO.selectGoodsList("bestseller");
//		goodsMap.put("bestseller",goodsList);
//		return goodsMap;
//	}
	
}
