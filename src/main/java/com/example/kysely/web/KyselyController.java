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

	@RequestMapping(value = "/kyselyLista", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("kyselyt", kyselyRepository.findAll());
        return "kyselyLista";
    }
	
	
	 @RequestMapping(value = "/lisaaKysely", method = RequestMethod.GET)
	    public String lisaaKysely(Model model) {
			model.addAttribute("kysely", new Kysely());

			
	        return "lisaaKysely";
	    }

	 

	@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveKysely(@ModelAttribute Kysely kysely) {
    // kysely.getKysymykset() will now contain a list of questions
    kyselyRepository.save(kysely);
    return "redirect:/kyselyLista";
}
		

		
	    }
	