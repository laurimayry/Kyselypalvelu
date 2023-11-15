package com.example.kysely.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
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
		
        model.addAttribute("kyselyt", kyselyRepository.findAll());
        return "kyselyLista";
    }
	
	@GetMapping(value = "/kysymykset/{kyselyId}")
    public String listKysymykset(@PathVariable Long kyselyId ,Model model) {
		Kysely kysely = new Kysely();
		kysely.setKyselyId(kyselyId);
		List <Kysymys> kysymysLista = kysymysRepository.findByKysely(kysely);
        model.addAttribute("kysymykset", kysymysLista);
        return "kysymykset";
    }
	
	
	 @RequestMapping(value = "/lisaaKysely", method = RequestMethod.GET)
	    public String lisaaKysely(Model model) {
			model.addAttribute("kysely", new Kysely());
			
	        return "lisaaKysely";
	    }

	 
		//ei näytä uutta kyselyä kyselyListassa, koska kyselyt haetaan kysymysReposta. 
	@RequestMapping(value = "/saveKysely", method = RequestMethod.POST)
public String saveKysely(@ModelAttribute Kysely kysely, Model model) {
	

    kyselyRepository.save(kysely);
    return "redirect:/kyselyLista";
}
		

		
	    }
	