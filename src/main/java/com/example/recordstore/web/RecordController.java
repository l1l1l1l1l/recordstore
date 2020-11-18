package com.example.recordstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.recordstore.model.GenreRepository;
import com.example.recordstore.model.Record;
import com.example.recordstore.model.RecordRepository;
import com.example.recordstore.services.RecordService;

@Controller
public class RecordController {

	@Autowired
	private RecordRepository repository;

	@Autowired
	private GenreRepository grepository;

	@Autowired
	private RecordService service;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// RESTful service to get all records
	@GetMapping(value = "/records")
	public @ResponseBody List<Record> recordListRest() {
		return (List<Record>) service.getRecords();
	}

	// RESTful service to get record by id
	@GetMapping(value = "/record/{id}")
	public @ResponseBody Optional<Record> findRecordRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}

	@RequestMapping(value = { "/", "/recordlist" })
	public String recordList(Model model, String keyword) {
		
		if(keyword != null) {
			model.addAttribute("records", service.findByKeyword(keyword));
		} else {
			model.addAttribute("records", service.getRecords());		
		}
		
		return "recordlist";
	}

	@RequestMapping(value = "/add")
	public String addRecord(Model model) {
		model.addAttribute("record", new Record());
		model.addAttribute("genres", grepository.findAll());
		return "addrecord";
	}

	@PostMapping(value = "/save")
	public String save(Record record) {
		repository.save(record);
		return "redirect:recordlist";
	}

	@GetMapping(value = "/delete/{id}")
	public String deleteRecord(@PathVariable("id") Long recordId, Model model) {
		repository.deleteById(recordId);
		return "redirect:../recordlist";
	}

	@GetMapping(value = "/edit/{id}")
	public String addRecord(@PathVariable("id") Long recordId, Model model) {
		model.addAttribute("record", repository.findById(recordId));
		model.addAttribute("genres", grepository.findAll());
		return "editrecord";

	}

}
