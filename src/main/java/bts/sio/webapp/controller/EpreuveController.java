package bts.sio.webapp.controller;

import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Epreuve;
import bts.sio.webapp.model.Pays;
import bts.sio.webapp.model.pari.Pari;
import bts.sio.webapp.service.AthleteService;
import bts.sio.webapp.service.EpreuveService;
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
public class EpreuveController {


    @Autowired
    private EpreuveService epreuveservice;

    @Autowired
    private PaysService paysService;
    private SportService sportService;

    @GetMapping("listEpreuves")
    public String home(Model model) {
        Iterable<Epreuve> listEpreuves = epreuveservice.getEpreuves();
        model.addAttribute("epreuves", listEpreuves);
        return "pari/parier";
    }

    @GetMapping("listAdmInterface")
    public String homePari3(Model model) {
        Iterable<Epreuve> listEpreuves = epreuveservice.getEpreuves();
        model.addAttribute("epreuves", listEpreuves);
        return "pari/homePari3";
    }

    @GetMapping("/createEpreuve")
    public String createEpreuve(Model model) {
        Epreuve a = new Epreuve();
        model.addAttribute("epreuve", a);

        Iterable<Pays> listPays = paysService.getLesPays();
        model.addAttribute("listPays", listPays);



        return "epreuve/formNewEpreuve";
    }

    @GetMapping("/updateEpreuve/{id}")
    public String updateEpreuve(@PathVariable("id") final int id, Model model) {
        Epreuve a = epreuveservice.getEpreuve(id);
        model.addAttribute("epreuve", a);

        Iterable<Pays> listPays = paysService.getLesPays();
        model.addAttribute("listPays", listPays);



        return "epreuve/formUpdateEpreuve";
    }

    @GetMapping("/deleteEpreuve/{id}")
    public ModelAndView deleteEpreuve(@PathVariable("id") final int id) {
        epreuveservice.deleteEpreuve(id);
        return new ModelAndView("redirect:listAdmInterface");
    }

}