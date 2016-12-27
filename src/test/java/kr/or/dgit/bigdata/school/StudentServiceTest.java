package kr.or.dgit.bigdata.school;

import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.school.dto.PhoneNumber;
import kr.or.dgit.bigdata.school.dto.Student;
import kr.or.dgit.bigdata.school.service.StudentService;

public class StudentServiceTest {
	private static StudentService studentService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}

	@Test
	public void test() {
		List<Student> list = studentService.findAllStudent();
		Assert.assertNotNull(list);
	}

	@Test
	public void testSelectByNo(){
		Student std = studentService.selectByNo(3);
		Assert.assertNotNull(std);
	}
	
	@Test
	public void testInsertItem(){
		Calendar cal = Calendar.getInstance();
		cal.set(2000, 01, 01);
		
		Student insStd = new Student(1, "강보미3", "kbm@test.co.kr", new PhoneNumber("010-1234-1234"),cal.getTime());
		studentService.insertItem(insStd);
		
		List<Student> list = studentService.findAllStudent();
		
		Assert.assertEquals(5, list.size());
	}
	
	@Test
	public void testDeleteItem(){
		studentService.deleteItem(3);
		
		Student std = studentService.selectByNo(1);
		
		Assert.assertNull(std);
	}
	
	@Test
	public void testUpdateItem(){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2000,  01, 01);
		
		Student update = new Student(4, "이유진", "lyj@test.co.kr", new PhoneNumber("010-1111-1111"), cal.getTime());
		
		studentService.updateItem(update);
		
		Student selectItem = studentService.selectByNo(4);
	
		Assert.assertEquals(selectItem, update);
	}

}
