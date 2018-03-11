package com.geowarin.mvc.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.geowarin.mvc.base.data.Spittle;
import com.geowarin.mvc.base.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spittleRepository;
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam("count") int count) {
		return spittleRepository.findSpittles(max, count);
		
	}
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String showSpittle(
	@RequestParam("spittle_id") long spittleId,
	Model model) {
		List<Spittle> spittleList = new ArrayList<>();
		spittleList.add(spittleRepository.findOne(spittleId));
	model.addAttribute(spittleList);
	return "spittles";
	}
	
}
