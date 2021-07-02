package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.model.Student;
import in.nareshit.raghu.service.StudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private StudentService service;
	
	/*
	@PostMapping("/create")
	public Mono<String> saveStudent(
			@RequestBody Student student
			) 
	{
		Mono<String> mono = null;
		try {
			service.saveStudent(student);
			mono = Mono.just("Student Created!");
		} catch (Exception e) {
			e.printStackTrace();
			mono = Mono.just("Creation Failed!");
		}
		
		return mono;
	}*/
	
	@PostMapping("/create")
	public Mono<Student> saveStudent(
			@RequestBody Student student
			) 
	{
		return service.saveStudent(student);
	}
	
	@GetMapping("/all")
	public Flux<Student> getAllStudents() {
		return service.getAllStudents();
	}
	
	@GetMapping("/one/{id}")
	public Mono<Student> getOneStudents(
			@PathVariable Integer id) 
	{
		return service.getOneStudent(id);
	}
	
	@DeleteMapping("/remove/{id}")
	public Mono<Void> deleteStudent(
			@PathVariable Integer id
			) 
	{
		return service.deleteOneStudent(id);
	}
	
}
