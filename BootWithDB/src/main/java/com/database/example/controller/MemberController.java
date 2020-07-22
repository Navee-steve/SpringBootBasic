package com.database.example.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.database.example.dao.MemberDetailsDao;
import com.database.example.model.Members;
import com.sun.glass.ui.Application;

/**
 * Rest controller will be works with rest API
 * Instead of ResponseBoy i was changing to rest API
 * @author navee
 *
 */
@RestController
public class MemberController {
	
	@Autowired
	MemberDetailsDao memberDetailsdao;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAction")
	public String addAction(Members members) {
		return setActionReturn(members);
	}
	
	@RequestMapping("/updateAction")
	public String updateAction(Members members) {
		return setActionReturn(members);
	}
	
	@RequestMapping("/deleteAction")
	public String deleteAction(Members members) {
		return setActionReturn(members);
	}
	 
	@RequestMapping("/fetchAction")
	public ModelAndView fetchAction(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("fetchPage.jsp");
		Members members = memberDetailsdao.findById(id).orElse(new Members());
		
		/** customized methods */
		System.out.println("***************************");
		System.out.println(memberDetailsdao.findByDevice("Oneplus"));
		System.out.println("***************************");
		System.out.println(memberDetailsdao.findBydeviceSorted("Oneplus"));
		/** customized method ends */
		
		modelAndView.addObject(members);
		return modelAndView;
	}
	
	/**
	 * when we send data from server to client it is produces 
	 * @return
	 */
	@RequestMapping(path ="/details", produces = {"application/xml"})
	public List<Members> getAllData() {
		return memberDetailsdao.findAll();
	}
	
	@RequestMapping("/detail/{id}")
	public Optional<Members> getSelectedData(@PathVariable("id") int id) {
		return memberDetailsdao.findById(id);
	}
	
	/*
	 * Post request
	 * If sending data via RAW DATA in postman tool we have to use @RequestBody
	 * When we accepts data from the client it is known as consumers
	 */
	@PostMapping (path = "/doOperation", consumes = {"application/xml"})
	public Members doSavePostman(@RequestBody Members members) {
		memberDetailsdao.save(members);
		return members;
	}
	
	/**
	 * same request name but different request mapping type 
	 * @param id
	 * @return
	 */
	@DeleteMapping (path = "/doOperation/{id}", consumes = {"application/xml"})
	public String doDeletPostman(@PathVariable int id) {
		Members members = memberDetailsdao.getOne(id);
		memberDetailsdao.delete(members);
		return "deleted";
	}
	
	/**
	 * same request name but different request mapping type 
	 * @param id
	 * @return
	 */
	@PutMapping (path = "/doOperation", consumes = {"application/xml"})
	public Members doUpdateandSavePostman(@RequestBody Members members) {
		memberDetailsdao.save(members);
		return members;
	}
	
	/**
	 * setActionReturn method is used to set the data after insert update and delete
	 * 
	 * @param memberDetail
	 * @return
	 */
	private String setActionReturn(Members members) {
		memberDetailsdao.save(members);
		return "success.jsp" ;
	}
	
	
}
