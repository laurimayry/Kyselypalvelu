package com.example.kysely.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/kyselyLista", method = RequestMethod.GET)
    public String listKyselyt(Model model) {
        model.addAttribute("kysymykset", kysymysRepository.findAll());
        return "kyselyLista";
    }

	@RequestMapping(value = "/kysymykset", method = RequestMethod.GET)
    public String listKysymykset(Model model) {
        model.addAttribute("kysymykset", kysymysRepository.findAll());
        return "kysymykset";
    }
	
	
	 @RequestMapping(value = "/lisaaKysely", method = RequestMethod.GET)
	    public String lisaaKysely(Model model) {
			model.addAttribute("kysymys", new Kysymys());
			
	        return "lisaaKysely";
	    }

	 

	@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveKysely(@ModelAttribute Kysymys kysymys) {
   
    kysymysRepository.save(kysymys);
    return "redirect:/kyselyLista";
}
		

		
	    }
	