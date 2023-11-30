package com.bookshop01.category;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.goods.vo.GoodsVO;

@Controller("categoryController")
@RequestMapping(value="/category")
public class CategoryControllerImpl implements CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
//  selectGoodsList 추가(카테고리별)
  @RequestMapping(value = "/selectGoodsList.do", method = RequestMethod.GET)
  public ModelAndView selectGoodsList(HttpServletRequest request, HttpServletResponse response,
          @RequestParam(value = "category", required = false, defaultValue = "traditional") String category) throws Exception {
      String viewName = (String) request.getAttribute("viewName");
      Map<String, List<GoodsVO>> goodsList = categoryService.categoryList();
      ModelAndView mav = new ModelAndView(viewName);
      mav.addObject("goodsList", goodsList);
      mav.addObject("category", category); // 추가: 선택한 카테고리를 뷰로 전달
      return mav;
  }
	
	
//	
//	@RequestMapping("/drink.do")
//	public ModelAndView showDrinkPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//	    String viewName = (String) request.getAttribute("viewName");
//	    HttpSession session = request.getSession();
//	    
//	    Map<String, List<GoodsVO>> goodsMap = categoryService.getDrinkPage();  
//	    
//	    ModelAndView mav = new ModelAndView(viewName);
//	    mav.addObject("goodsMap", goodsMap);
//	    return mav;
//
//	}
//	
//	@RequestMapping("/dairy.do")
//	public ModelAndView showDairyPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String viewName = (String) request.getAttribute("viewName");
//		HttpSession session = request.getSession();
//		
//		Map<String, List<GoodsVO>> goodsMap = categoryService.getDairyPage();  
//		
//		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("goodsMap", goodsMap);
//		return mav;
////		return "/category/dairy";
//		
//	}
//	
//	@RequestMapping("/etc.do")
//	public ModelAndView showEtcPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String viewName = (String) request.getAttribute("viewName");
//		HttpSession session = request.getSession();
//		
//		Map<String, List<GoodsVO>> goodsMap = categoryService.getEtcPage();  
//		
//		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("goodsMap", goodsMap);
//		return mav;
//		
//	}
//	
//	@RequestMapping("/noodle.do")
//	public ModelAndView showNoodlePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String viewName = (String) request.getAttribute("viewName");
//		HttpSession session = request.getSession();
//		
//		Map<String, List<GoodsVO>> goodsMap = categoryService.getNoodlePage();  
//		
//		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("goodsMap", goodsMap);
//		return mav;
//		
//	}
//	
//	@RequestMapping("/snack.do")
//	public ModelAndView showSnackPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String viewName = (String) request.getAttribute("viewName");
//		HttpSession session = request.getSession();
//		
//		Map<String, List<GoodsVO>> goodsMap = categoryService.getSnackPage();  
//		
//		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("goodsMap", goodsMap);
//		return mav;
//		
//	}
//	
//	@RequestMapping("/sandwich.do")
//	public ModelAndView showSandwichPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String viewName = (String) request.getAttribute("viewName");
//		HttpSession session = request.getSession();
//		
//		Map<String, List<GoodsVO>> goodsMap = categoryService.getSandwichPage();  
//		
//		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("goodsMap", goodsMap);
//		return mav;
//		
//	}

}
