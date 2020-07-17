package com.database.example.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.database.example.dao.MemberDetailsDao;
import com.database.example.model.Members;

@Controller
public class MemberController {
	
	@Autowired
	MemberDetailsDao MemberDetailsdao;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAction")
	public String addAction(Members members) {
		return setActionReturn(members);
	}
	
	@RequestMapping("/fetchAction")
	public ModelAndView fetchAction(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("fetchPage.jsp");
		Members members = MemberDetailsdao.findById(id).orElse(new Members());
		
		/** customized methods */
		System.out.println("***************************");
		System.out.println(MemberDetailsdao.findByDevice("Oneplus"));
		System.out.println("***************************");
		System.out.println(MemberDetailsdao.findBydeviceSorted("Oneplus"));
		/** customized method ends */
		
		modelAndView.addObject(members);
		return modelAndView;
	}
	
	@RequestMapping("/updateAction")
	public String updateAction(Members members) {
		return setActionReturn(members);
	}
	
	@RequestMapping("/deleteAction")
	public String deleteAction(Members members) {
		return setActionReturn(members);
	}
	
	@RequestMapping("/details")
	@ResponseBody
	public List<Members> getAllData() {
		return MemberDetailsdao.findAll();
	}
	
	@RequestMapping("/detail/{id}")
	@ResponseBody
	public Optional<Members> getSelectedData(@PathVariable("id") int id) {
		return MemberDetailsdao.findById(id);
	}
	
	/**
	 * setActionReturn method is used to set the data after insert update and delete
	 * 
	 * @param memberDetail
	 * @return
	 */
	private String setActionReturn(Members members) {
		MemberDetailsdao.save(members);
		return "success.jsp" ;
	}
}
