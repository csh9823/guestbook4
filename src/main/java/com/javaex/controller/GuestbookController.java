package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value = "/guest") // 대표주소
public class GuestbookController {
	// 필드
	@Autowired
	private GuestbookDao guestbookDao;
	// 생성자

	// 메소드 g/s

	// 메소드 일반

	@RequestMapping(value = "/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		
		System.out.println("GuestController>addList");

		List<GuestbookVo> guestbookList = guestbookDao.getList();
		model.addAttribute("guestbookList", guestbookList);

		return "addList";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestController>add");

		guestbookDao.insert(guestbookVo);

		return "redirect:/guest/addList";
	}

	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm(@RequestParam("no") int no, Model model) {
		System.out.println("GuestController>deleteForm");

		model.addAttribute("no", no);

		return "deleteForm";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestController>delete");

		guestbookDao.delete(guestbookVo);

		return "redirect:/guest/addList";
	}

}
