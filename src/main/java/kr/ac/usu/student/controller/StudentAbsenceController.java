package kr.ac.usu.student.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.usu.student.service.StudentAbsenceService;
import kr.ac.usu.student.vo.AbsenceSchoolVO;
import kr.ac.usu.validate.grouphint.InsertGroup;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StudentAbsenceController {
	
	@Inject
	private StudentAbsenceService service;

	@GetMapping("/student/vacRequest/{abssklNo}")
	public String vacRequest(
			Model model
			, @PathVariable(name = "abssklNo") String abssklNo
			, Authentication auth
		) {
		AbsenceSchoolVO absence = new AbsenceSchoolVO();
		
		absence.setAbssklNo(abssklNo);
		absence.setStdntNo(auth.getName());
		
		model.addAttribute("data", service.retrieveAbsence(absence)); 
		
		return "jsonView";
	}
	
	
	
	@GetMapping("/student/vacRequestList")
	public String studentVacRequsetList(
			Model model
			, Authentication auth
		) {
		
		model.addAttribute("dataList", service.retrieveAbsenceList(auth.getName()));
		
		return "jsonView";
	}
	
	@DeleteMapping("/student/vacRequest/{abssklNo}")
	public String cancelVacRequest(
			Model model
			, @PathVariable(name = "abssklNo") String abssklNo
			, Authentication auth
		) {
		AbsenceSchoolVO absence = new AbsenceSchoolVO();
		absence.setAbssklNo(abssklNo);
		absence.setStdntNo(auth.getName());
		try {
			service.modifyAbsence(absence);
			model.addAttribute("success", true);
			model.addAttribute("message", "휴학신청 취소를 성공했습니다");
		} catch (Exception e) {
			model.addAttribute("success", false);
			model.addAttribute("message", "취소할 수 없습니다");
		}
		
		return "jsonView";
	}
	
	@PostMapping("/student/vacRequest")
	public String studentVacRequest(
		Authentication auth
		, @Validated(InsertGroup.class) AbsenceSchoolVO absence
		, Model model
	) {
		String authId = auth.getName();
//		log.info("authId : {}",authId);
		if(authId.equals(absence.getStdntNo())) {
//			log.info("is That True");
			try {
				int res = service.createAbsence(absence);
				model.addAttribute("success", true);
				model.addAttribute("message", "신청 완료!");
			} catch (Exception e) {
				model.addAttribute("success", false);
				model.addAttribute("message", "이미 동일학기에 신청 내역이 있습니다.");
			}
		}else {
			model.addAttribute("success", false);
			model.addAttribute("message", "잘못된 요청입니다.");
		}
		
		log.info("{}",absence);
		
		
		return "jsonView";
	}
}
