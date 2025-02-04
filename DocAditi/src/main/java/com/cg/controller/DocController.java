package com.cg.controller;

import java.util.List;
import java.util.Optional;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.DoctorDTO;
import com.cg.entity.Doctor;
import com.cg.service.DocService;
import com.cg.service.IDocService;


// We make our end points always in Controller And gives response to view
@RestController
public class DocController {
	
	@Autowired
	IDocService docService;
	
	
	@GetMapping(path = "/alldocs")
	public List<DoctorDTO> getDocs(){
		return	docService.getdocs();
	}
	
	@PostMapping(path ="/createdoc")
	public DoctorDTO createDoc(@RequestBody Doctor doc)
	{
		return docService.createDocInDB(doc);
	}
	
	
	@GetMapping(path="/getbyid/{id}")
	public Optional<DoctorDTO> getById(@PathVariable int id) {
		return docService.getById(id);
	}
	
	@PutMapping(path = "/updateDoc/{id}")
	public Doctor update(@PathVariable int id, @RequestBody Doctor doc)
	{
		return docService.updateDoc(id, doc);
	}
	
	@DeleteMapping(path ="/delete/{id}")
	public void delete(@PathVariable int id) {
		 docService.deleteDoc(id);
	}
	
	
//	@GetMapping(path = "/alldocs")
//	public List<Doctor> getDocs(){
//		return	docService.getdocs();
//	}
//	
//	@PostMapping(path ="/createdoc")
//	public Doctor createDoc(@RequestBody Doctor doc)
//	{
//		return docService.createDocInDB(doc);
//	}
//	
//	
//	@GetMapping(path="/getbyid/{id}")
//	public Optional<Doctor> getById(@PathVariable int id) {
//		return docService.getById(id);
//	}
//	
//	@PutMapping(path = "/updateDoc/{id}")
//	public Doctor update(@PathVariable int id, @RequestBody Doctor doc)
//	{
//		return docService.updateDoc(id, doc);
//	}
//	
//	@DeleteMapping(path ="/delete/{id}")
//	public void delete(@PathVariable int id) {
//		 docService.deleteDoc(id);
//	}
	
	
}
