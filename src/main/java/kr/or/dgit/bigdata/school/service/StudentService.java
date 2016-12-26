package kr.or.dgit.bigdata.school.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.school.dao.StudentDao;
import kr.or.dgit.bigdata.school.dto.Student;
import kr.or.dgit.bigdata.school.util.MyBatisSqlSessionFactory;

public class StudentService {
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(StudentService.class);

	private static final StudentService instance = new StudentService();

	public static StudentService getInstance() {
		return instance;
	}

	private StudentService() {
	}


	public List<Student> findAllStudent() {
		if (logger.isDebugEnabled()) {
			logger.debug("findAllStudent() - start");
		}

//		logger.debug("selectbyAll()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			List<Student> returnList = studentDao.selectByAll();
			if (logger.isDebugEnabled()) {
				logger.debug("findAllStudent() - end");
			}
			return returnList;
		} finally {
			sqlSession.close();
		}
	}
	
	public Student selectByNo(int studId){
		if (logger.isDebugEnabled()) {
			logger.debug("selectByNo(int) - start");
		}

//		logger.debug("selectByNo()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			Student returnStudent = studentDao.selectByNo(studId);
			if (logger.isDebugEnabled()) {
				logger.debug("selectByNo(int) - end");
			}
			return returnStudent;
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertItem(Student std){
		if (logger.isDebugEnabled()) {
			logger.debug("insertItem(Student) - start");
		}

//		logger.debug("insertItem()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		try {
			studentDao.insertItem(std);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("insertItem(Student) - end");
		}
	}
	
	public void deleteItem(int idx){
		if (logger.isDebugEnabled()) {
			logger.debug("deleteItem(int) - start");
		}

//		logger.debug("deleteItem()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		try {
			studentDao.deleteItem(idx);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("deleteItem(int) - end");
		}
	}
	
	public void updateItem(Student std){
		if (logger.isDebugEnabled()) {
			logger.debug("updateItem(Student) - start");
		}

//		logger.debug("updateItem()");
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
		try {
			studentDao.updateItem(std);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

		if (logger.isDebugEnabled()) {
			logger.debug("updateItem(Student) - end");
		}
	}
}
