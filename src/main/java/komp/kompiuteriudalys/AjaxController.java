package komp.kompiuteriudalys;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import komp.kompiuteriudalys.Jungtys;
import komp.kompiuteriudalys.JungtysRepository;

import komp.kompiuteriudalys.Komponentai;
import komp.kompiuteriudalys.KomponentaiRepository;

@Controller
@RequestMapping(path="/ajax") 
public class AjaxController {

	@Autowired
	private JungtysRepository jungtysRepository;
	
	@Autowired
	private KomponentaiRepository komponentaiRepository;
	
	@GetMapping(path="/saugoti-jungti") // Map ONLY GET Requests
	public @ResponseBody String saugotiJungti (
			@RequestParam Integer id 
			, @RequestParam String pavadinimas
			, @RequestParam String paveiksliukas
			, @RequestParam String aprasymas
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		Jungtys n = new Jungtys();
		
		if (id > 0) {
		
			Optional <Jungtys> found = jungtysRepository.findById( id );
		
			// variantas trynimui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
		}
		
	    n.setPavadinimas( pavadinimas );
	    n.setPaveiksliukas( paveiksliukas );
	    n.setAprasymas( aprasymas );
	       			   
	    jungtysRepository.save(n);	
	    res = "Saved";
	    
		return res;
	}
	
	@GetMapping(path="/salinti-jungti") // Map ONLY GET Requests
	public @ResponseBody String salintiJungti (@RequestParam Integer id 
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Jungtys> found = jungtysRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Jungtys n = found.get();
			   jungtysRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}	
	
	@GetMapping(path="/saugoti-komponenta") // Map ONLY GET Requests
	public @ResponseBody String saugotiKomponenta (
			@RequestParam Integer id 
			, @RequestParam String indiv_pav
			, @RequestParam String tipas
			, @RequestParam String gamintojas
			, @RequestParam String pagam_data
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		String res = "Not done";
		Komponentai n = new Komponentai();
		
		if (id > 0) {
		
			Optional <Komponentai> found = komponentaiRepository.findById( id );
		
			// variantas trynimui
			// uzsakymaiRepository.deleteById(id);
		
			if ( found.isPresent() ) {
			
			   n = found.get();
			   n.setId(id);
			}
		}
		
	    n.setIndiv_pav( indiv_pav );
	    n.setTipas( tipas );
	    n.setGamintojas( gamintojas );
	    n.setPagam_data( pagam_data );
	       			   
	    komponentaiRepository.save(n);	
	    res = "Saved";
	    
		return res;
	}
	
	@GetMapping(path="/salinti-komponenta") // Map ONLY GET Requests
	public @ResponseBody String salintiKomponenta (@RequestParam Integer id 
			) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		
		Optional <Komponentai> found = komponentaiRepository.findById( id );
		
		String res = "Not done";
		
		if ( found.isPresent() ) {
			
			   Komponentai n = found.get();
			   komponentaiRepository.deleteById(id);
			   res = "Deleted";
		}		
		return res;
	}	

	@GetMapping(path="/lst-jungtys")
	public @ResponseBody Iterable<Jungtys> getAllJungtys() {
		// This returns a JSON or XML with the users
		return jungtysRepository.findAll();
	}
	
	@GetMapping(path="/lst-komponentai")
	public @ResponseBody Iterable<Komponentai> getAllKomponentai() {
		// This returns a JSON or XML with the users
		return komponentaiRepository.findAll();
	}

}
