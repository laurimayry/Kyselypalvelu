package com.example.kysely.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.kysely.domain.Kysely;
import com.example.kysely.domain.KyselyRepository;
import com.example.kysely.domain.Kysymys;
import com.example.kysely.domain.KysymysRepository;

@Controller
public class KyselyController {

	@Autowired
	private KyselyRepository kyselyRepository;
	
	@Autowired
	private KysymysRepository kysymysRepository;
	
	 @RequestMapping(value = "/lisaaKysely", method = RequestMethod.GET)
	    public String lisaaKysely(Model model) {
	        model.addAttribute("kysely", new Kysely());
	        return "lisaaKysely";
	    }

	 

	    @RequestMapping(value = "/lisaaKysely", method = RequestMethod.POST)
	    public String lisaaKysymys(Kysely kysely) {
	        kyselyRepository.save(kysely);
	        return "redirect:/lisaaKysymys";
    }
		 @RequestMapping(value = "/lisaaKysymys", method = RequestMethod.GET)
		    public String naytaLisayslomake(Model model) {
		        model.addAttribute("kysymys", new Kysymys());
		        return "lisaaKysymys";
		    }

		 

		    @RequestMapping(value = "/lisaaKysymys", method = RequestMethod.POST)
		    public String lisaaKysymys(Kysymys kysymys) {
		        kysymysRepository.save(kysymys);
		        return "redirect:/lisaaKysymys";
	    }
	}

