package kr.ac.usu;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.ac.usu.common.enumpkg.ServiceResult;
import kr.ac.usu.lecture.service.StudentAttendanceLectureService;
import kr.ac.usu.lecture.vo.StudentAttendanceLectureVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ForInsertDummyData extends AbstractRootContextTestFor {

	@Inject
	private StudentAttendanceLectureService service;
	
	private final String STDNTNO = "20221212";
	
	// 가변
	private final String SEMCD = "20231";

//	
//	
//	
//	
//	
//	
	
	@Test
	void test() {
		StudentAttendanceLectureVO attendance = new StudentAttendanceLectureVO();
		//----------------------------------------------------------------
		// 수강신청할 강의코드 여기서 변경
		String lctreNo = "C01623101";
		// 수강신청할 잔여 포인트 계산 해서 여기서
		Integer pnt = 15;
		
		//----------------------------------------------------------------
		attendance.setStdntNo(STDNTNO);
		attendance.setSemCd(SEMCD);
		attendance.setPnt(pnt);
		attendance.setLctreNo(lctreNo);
		
		ServiceResult result = service.createAttendanceLecture(attendance);
		
		log.info("결과물 : {}",result);
		
		
		
	}

}
