package com.cos.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.domain.LectureVO;
import com.cos.service.CategoryService;
import com.cos.service.LectureService;

@Controller
public class LectureController {

	@Inject
	private CategoryService ctService;
	@Inject
	private LectureService lcService;
	
	
	@RequestMapping(value = "/lectureView", method = RequestMethod.GET)
	public String lectureView(Model model, LectureVO lecture) throws Exception{
		model.addAttribute("ctg1", ctService.selectGubun1(1));
		model.addAttribute("ctg2", ctService.selectGubun1(2));
		model.addAttribute("ctg3", ctService.selectGubun1(3));
		model.addAttribute("ctg4", ctService.selectGubun1(4));
		
		List<LectureVO> lectureTitle = lcService.selectTitle(lecture.getCtNum());
		model.addAttribute("lectureTitle", lectureTitle);

		if(lecture.getLcNum() == 0 && lectureTitle.size() > 0) {
			int lcMinNum = lcService.selectMinNum(lecture.getCtNum()).getLcNum();
			model.addAttribute("lecture", lcService.select(lcMinNum));
		}else if(lecture.getLcNum() == 0 && lectureTitle.size() == 0) {
			model.addAttribute("lecture", lecture);
		}else {
			model.addAttribute("lecture", lcService.select(lecture.getLcNum()));
		}
		
		return "lecture/lectureView";
	}
	
	@RequestMapping(value = "/lectureWriteForm", method = RequestMethod.GET)
	public String lectureWriteForm(Model model, @RequestParam("ctNum") int ctNum) throws Exception{
		model.addAttribute("ctg1", ctService.selectGubun1(1));
		model.addAttribute("ctg2", ctService.selectGubun1(2));
		model.addAttribute("ctg3", ctService.selectGubun1(3));
		model.addAttribute("ctg4", ctService.selectGubun1(4));
		model.addAttribute("ctNum", ctNum);
		return "lecture/lectureWriteForm";
	}
	
	@RequestMapping(value = "/lectureWrite", method = RequestMethod.POST)
	public String lectureWrite(Model model, LectureVO lecture) throws Exception{
		lcService.insert(lecture);
		int lcMaxNum = lcService.selectMaxNum(lecture.getCtNum()).getLcNum();
		return "redirect:lectureView?ctNum="+lecture.getCtNum()+"&lcNum="+lcMaxNum;
	}
	
	@RequestMapping(value = "/lectureDelete", method = RequestMethod.GET)
	public String lectureDelete(Model model, LectureVO lecture) throws Exception{
		lcService.delete(lecture.getLcNum());
		return "redirect:lectureView?ctNum="+lecture.getCtNum();
	}
}
