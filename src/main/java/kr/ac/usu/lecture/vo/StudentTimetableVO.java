package kr.ac.usu.lecture.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import kr.ac.usu.schoolaffairsschedule.vo.SemesterVO;
import kr.ac.usu.user.vo.StudentVO;
import kr.ac.usu.validate.grouphint.InsertGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author PC-25
 *
 * @author 이재혁
 * @since 2023. 11. 9.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet 
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2023. 11. 9.      이재혁      최초작성
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Data
@EqualsAndHashCode(of = "tmtbSe")
@ToString
public class StudentTimetableVO {
	
	@NotBlank
	@Size(min = 2 , max = 2)
	private String tmtbSe;
	
	@NotBlank(groups = InsertGroup.class)
	@Size(min = 5 , max = 5)
	private String semstrNo;
	
	@NotBlank
	@Size(min = 8 , max = 8)
	private String stdntNo;
	
	private SemesterVO semester;
	private StudentVO student;
}
