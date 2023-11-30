package com.bookshop01.category;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.goods.vo.GoodsVO;

@Controller("categoryController")
@RequestMapping(value="/category")
public class CategoryController{

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/drink.do")
	public ModelAndView showDrinkPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    String viewName = (String) request.getAttribute("viewName");
	    HttpSession session = request.getSession();
	    
	    // goodsService에서 bestseller 상품들을 가져옴
	    Map<String, List<GoodsVO>> goodsMap = categoryService.getDrinkPage();  
	    
	    ModelAndView mav = new ModelAndView(viewName);
	    mav.addObject("goodsMap", goodsMap);
	    return mav;
	
//		return "/category/drink";
	}


}