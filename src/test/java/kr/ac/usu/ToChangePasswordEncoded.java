package kr.ac.usu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.ac.usu.common.mapper.UtilForChange;
import kr.ac.usu.user.vo.ProfessorVO;
import kr.ac.usu.user.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ToChangePasswordEncoded extends AbstractRootContextTestFor {
	
//	@Inject
//	private UtilForChange dao;
	
	@Inject
	private PasswordEncoder encoder;
	
	@Test
	void test2() {
		String origin = "00000001";
		String encoded = encoder.encode(origin);
		log.info("target : {}",encoded);
	}
	/*
	@Test
	void test() {
		List<StudentVO> list1 = dao.selectStudentList();
		log.info("{}",list1.size());
		
		int cnt = 0;
		for(StudentVO vo : list1) {
			String origin = vo.getStdntNo();
			String encoded = encoder.encode(origin);
			vo.setStdntPassword(encoded);
			cnt += dao.updateStudentPassword(vo);
		}
		
		log.info("변환 완료 갯수 : {}", cnt);
	}
	
	@Test
	void test3() {
		List<ProfessorVO> list = dao.selectProfessorList();
		
		int cnt = 0;
		for(ProfessorVO vo : list) {
			String origin = vo.getPrfsorNo();
			String encoded = encoder.encode(origin);
			vo.setPrfsorPassword(encoded);
			cnt += dao.updateProfessorPassword(vo);
		}
		log.info("변환 완료 갯수 : {}",cnt);
		
	}
	*/
	@Test
	void test4() {
		
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 8;
		Random random = new Random();

		String generatedString = random.ints(leftLimit,rightLimit + 1)
		  .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		  .limit(targetStringLength)
		  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		  .toString();
		
		String genKey = generatedString.toLowerCase();
		
	}
	
	
}
