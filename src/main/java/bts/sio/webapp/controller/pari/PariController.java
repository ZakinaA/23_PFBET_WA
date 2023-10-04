package bts.sio.webapp.controller.pari;

import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Pays;
import bts.sio.webapp.model.Sport;
import bts.sio.webapp.model.pari.Pari;
import bts.sio.webapp.service.pari.PariService;
import bts.sio.webapp.service.PaysService;
import bts.sio.webapp.service.SportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class PariController {


    @Autowired
    private PariService pariservice;

    @Autowired
    private PaysService paysService;
    private SportService sportService;


    @GetMapping("/createPari")
    public String createPari(Model model) {
        Pari a = new Pari();
        model.addAttribute("pari", a);

        return "pari/formNewPari";
    }

    @GetMapping("listParis")
    public String homePari(Model model) {
        Iterable<Pari> listParis = pariservice.getParis();
        model.addAttribute("paris", listParis);
        return "pari/homePari";
    }

    @GetMapping("listParisAdm")
    public String homePari2(Model model) {
        Iterable<Pari> listParis = pariservice.getParis();
        model.addAttribute("paris", listParis);
        return "pari/homePari2";
    }

    @GetMapping("/updatePari/{id}")
    public String updatePari(@PathVariable("id") final int id, Model model) {
        Pari a = pariservice.getPari(id);
        model.addAttribute("pari", a);


        return "pari/formUpdatePari";
    }

    @GetMapping("/deletePari/{id}")
    public ModelAndView deletePari(@PathVariable("id") final int id) {
        pariservice.deletePari(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/savePari")
    public ModelAndView savePari(@ModelAttribute Pari pari) {
        System.out.println("controller save=" + pari.getLibelle());
        if (pari.getId() != null) {
            Pari current = pariservice.getPari(pari.getId());
            pari.setLibelle(current.getLibelle());
        }
        pariservice.savePari(pari);
        return new ModelAndView("redirect:/");
    }


    @GetMapping("/")
    public String home(Model model) {
        Iterable<Pari> listParis = pariservice.getParis();
        model.addAttribute("paris", listParis);
        return "home";

    }
}