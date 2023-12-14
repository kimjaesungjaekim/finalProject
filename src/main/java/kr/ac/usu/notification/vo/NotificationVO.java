package kr.ac.usu.notification.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.usu.validate.grouphint.InsertGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author PC-25
 *
 * @author 이재혁
 * @since 2023. 11. 8.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet 
 * <pre>
 * [[개정이력(Modification Information)]]
 * 수정일                          수정자               수정내용
 * --------     --------    ----------------------
 * 2023. 11. 8.      이재혁      최초작성
 * Copyright (c) 2023 by DDIT All right reserved
 * </pre>
 */
@Data
@EqualsAndHashCode(of = "ntcnNo")
@ToString
public class NotificationVO {
	
	@NotBlank
	private String ntcnNo;
	
	@NotBlank(groups = InsertGroup.class)
	@Size(max = 8, min = 8,groups = InsertGroup.class)
	private String ntcnRcver;
	
	@NotBlank(groups = InsertGroup.class)
	private String ntcnCn;
	
	@NotBlank(groups = InsertGroup.class)
	@Size(max = 10, min = 10,groups = InsertGroup.class)
	private String ntcnDate;
}
