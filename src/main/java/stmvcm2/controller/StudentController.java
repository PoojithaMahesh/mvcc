package stmvcm2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import stmvcm2.dao.StudentDao;
import stmvcm2.dto.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentDao studentDao;

	@RequestMapping("/register")
	public ModelAndView registerStudent() {
		ModelAndView modelAndView=new ModelAndView();
	    modelAndView.addObject("student",new Student());
		modelAndView.setViewName("register.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView=new ModelAndView();
		studentDao.saveStudent(student);
		modelAndView.addObject("list", studentDao.getAllStudents());
		modelAndView.setViewName("display.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteStudent(@RequestParam int id) {
		ModelAndView modelAndView=new ModelAndView();
		studentDao.deleteStudentById(id);
		modelAndView.addObject("list", studentDao.getAllStudents());
		modelAndView.setViewName("display.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/update")
	public ModelAndView updateStudent(int id) {
		ModelAndView modelAndView=new ModelAndView();
		Student student=studentDao.getStudentById(id);
		modelAndView.addObject("student",student );
		modelAndView.setViewName("edit.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView=new ModelAndView();
		studentDao.updateStudent(student);
		modelAndView.addObject("list", studentDao.getAllStudents());
		modelAndView.setViewName("display.jsp");
		return modelAndView;
	}
	
	
	
	
	
}
