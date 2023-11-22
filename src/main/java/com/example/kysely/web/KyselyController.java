package com.example.kysely.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String listKysymykset(@PathVariable Long kyselyId, Model model) {
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

	// ei näytä uutta kyselyä kyselyListassa, koska kyselyt haetaan kysymysReposta.

	@RequestMapping(value = "/saveKysely", method = RequestMethod.POST)
	public String saveKysely(@ModelAttribute Kysely kysely, Model model) {

		kyselyRepository.save(kysely);
		return "redirect:/lisaaKysymys";
	}

	// PALAUTTAA SELAIMEEN UUDEN KYSYMYKSEN LISÄYSLOMAKKEEN
	@RequestMapping(value = "/lisaaKysymys/{kyselyId}", method = RequestMethod.GET)
	public String lisaaKysymys(Model model, @PathVariable Long kyselyId) {
		Kysely kysely = new Kysely();
		kysely.setKyselyId(kyselyId);
		model.addAttribute("kysymys", new Kysymys());
        model.addAttribute("kysely", kysely);
		return "lisaaKysymys"; // lisaaKysymys.html
	}
    // TALLENTAA KYSYMYKSEN TIETOKANTAAN
	@RequestMapping(value = "/saveKysymys/{kyselyId}", method = RequestMethod.POST)
	public String saveKysymys(@ModelAttribute Kysymys kysymys, Model model, @PathVariable Long kyselyId) {
		System.out.print("kysymys" + kysymys);
		Kysely kysely = new Kysely();
		kysely.setKyselyId(kyselyId);
		kysymys.setKysely(kysely);
		kysymysRepository.save(kysymys);
		return "redirect:/kyselyLista";
	}



		
 //shows as JSON using RESTful service
	@CrossOrigin
    @RequestMapping(value="/kysymyksetREST", method = RequestMethod.GET)
    public @ResponseBody List <Kysymys> kysymysListaRest(){
        return(List<Kysymys>) kysymysRepository.findAll();
    }

	@CrossOrigin
	@RequestMapping(value="/kyselytREST", method = RequestMethod.GET)
    public @ResponseBody List <Kysely> kyselyListaRest(){
        return(List<Kysely>) kyselyRepository.findAll();
    }
	
	@CrossOrigin
	 @RequestMapping(value="/kysymyksetREST/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional <Kysymys> kysymysByIdRest(@PathVariable Long id){
        return(Optional <Kysymys>)  kysymysRepository.findById(id);
    }

	@CrossOrigin
     @RequestMapping(value="/kyselytREST/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional <Kysely> kyselyByIdRest(@PathVariable Long id){
        return(Optional <Kysely>)  kyselyRepository.findById(id);
    }
		
}
	

