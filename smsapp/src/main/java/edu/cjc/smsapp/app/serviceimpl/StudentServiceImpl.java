package edu.cjc.smsapp.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.smsapp.app.model.Student;
import edu.cjc.smsapp.app.repositary.StudentRepositary;
import edu.cjc.smsapp.app.servicei.StudentServiceI;
@Service
public class StudentServiceImpl  implements StudentServiceI{

	@Autowired
	StudentRepositary sr;
	@Override
	public void saveStudent(Student s) {
		sr.save(s);
	}
	@Override
	public List<Student> getAllStudents() {
		return sr.findAll();
	}
	@Override
	public List<Student> searchBatch(String batchNumber) {
		return sr.findAllByBatchNumber(batchNumber);
	}
	

}
