package lab.spring.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.web.model.ProductVO;
import lab.spring.web.service.ProductService;

//("/add.do")
@Controller
public class ProductAction {

	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/add.do", method=RequestMethod.GET)
	public String form() {
		System.out.println("Get");
		return "product_form";
		
		//일반 Controller는 jsp로 이동이 되지만, 
		//RestController는 일반 String으로 처리가 되서 return을 해준다.
	}
	
	@RequestMapping(value = "/add.do", method=RequestMethod.POST)
	public ModelAndView addProduct (@ModelAttribute("product") ProductVO vo) {		
		//BindingResult는 에러메세지를 담는 객체
		System.out.println(vo);
	ModelAndView mav = new ModelAndView();

	if(service.addProduct(vo)>0) {
		System.out.println("성공");
		mav.setViewName("redirect:/list.do");

	}else {
		System.out.println("errrrror");
		mav.setViewName("product_form");
	}		

	return mav;
	}
	
	
	@RequestMapping("/list.do")
	public ModelAndView listProduct(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List<ProductVO> productList = null;
			productList = service.getProductList();
			System.out.println(productList.size());
			System.out.println(productList.get(0));
			mav.addObject("products",productList);
			mav.setViewName("product_list");

//		
		return mav;
	}


	@RequestMapping("/view.do")
	public ModelAndView viewProduct(@RequestParam("pcode")String pcode) {
		ModelAndView mav = new ModelAndView();
		ProductVO vo = null;
		vo = service.findProduct(pcode);
		mav.addObject("product",vo);
		mav.setViewName("product_view");
		return mav;
	}
	
	@RequestMapping("/modify.do")
	public ModelAndView modifyProduct(@RequestParam("pcode")String pcode) {
		ModelAndView mav = new ModelAndView();
		ProductVO vo = null;
		vo = service.findProduct(pcode);
		mav.addObject("product",vo);
		mav.setViewName("product_modify"); //여기 모디파이였음
		return mav;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView updateProduct(ProductVO vo) {
		
		ModelAndView mav = new ModelAndView();
		if(service.updateProduct(vo)>0) {
			mav.setViewName("redirect:/list.do");
		}else {
			mav.setViewName("redirect:/login.do");
		}		
		return mav;
	}
	
	@RequestMapping("/delete.do")
		public ModelAndView removeProduct(@RequestParam("pcode")String pcode) {
		
		ModelAndView mav = new ModelAndView();
		if(service.removeProduct(pcode)>0) {
			mav.setViewName("redirect:/list.do");
		}else {
			mav.setViewName("redirect:/login.do");
		}		
		return mav;
	}
	

	
	
	
}
