package komp.kompiuteriudalys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/")
    public String menu( Model model ) {
      	
        model.addAttribute("lst_menu", Menu.values() );    	
        return "index";
    }	
	
    @GetMapping("/jungtys")
    public String jungtys() {
        return "jungtys";
    }	

    @GetMapping("/komponentai")
    public String komponentai() {

        return "komponentai";
    } 	
	
}
