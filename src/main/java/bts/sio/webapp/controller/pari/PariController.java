package bts.sio.webapp.controller.pari;

import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Epreuve;
import bts.sio.webapp.model.pari.Pari;
import bts.sio.webapp.service.AthleteService;
import bts.sio.webapp.service.pari.PariService;
import bts.sio.webapp.service.PaysService;
import bts.sio.webapp.service.SportService;
import bts.sio.webapp.service.EpreuveService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
public class PariController {


    @Autowired
    private PariService pariservice;

    @Autowired
    private PaysService paysService;
    @Autowired
    private SportService sportService;
    @Autowired
    private EpreuveService epreuveService;
    @Autowired
    private AthleteService athleteService;



    @GetMapping("/createPari")
    public String createPari(@RequestParam("id") final int id, Model model) {
        Epreuve epreuve = epreuveService.getEpreuve(id);

        if (epreuve == null) {
            return "redirect:/error";
        }

        Pari pari = new Pari();

        pari.setLibelle(epreuve.getLibelle());

        Iterable<Athlete> athletes = athleteService.getAthletes();

        // Ajouter les athlètes au modèle
        model.addAttribute("athletes", athletes);

        model.addAttribute("epreuve", epreuve);
        model.addAttribute("pari", pari);

        return "pari/formNewPari";
    }


    @GetMapping("listParis")
    public String homePari(Model model) {
        Iterable<Pari> listParis = pariservice.getParis();
        model.addAttribute("paris", listParis);
        return "pari/homePari";
    }


    @GetMapping("listParis/{utilisateur_id}")
    public String homePari(@PathVariable Long utilisateur_id, Model model) {
        Iterable<Pari> listParis = pariservice.getParisByUserId(utilisateur_id);
        model.addAttribute("paris", listParis);
        return "pari/homePari";
    }


    @GetMapping("listParisAdm")
    public String homePari2(Model model) {
        Iterable<Pari> listParisAdm = pariservice.getParis();
        model.addAttribute("paris", listParisAdm);
        return "pari/homePari2";
    }




    @GetMapping("interfaceParier")
    public String parier(Model model) {
        Iterable<Pari> interfaceParier = pariservice.getParis();
        model.addAttribute("paris", interfaceParier);

        return "pari/parier";
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
        return new ModelAndView("redirect:/listParis");
    }

    @PostMapping("/savePari")
    public ModelAndView savePari(@ModelAttribute Pari pari) {
        System.out.println("controller save=" + pari.getLibelle());
        if (pari.getId() != null) {
            Pari current = pariservice.getPari(pari.getId());
            pari.setLibelle(current.getLibelle());
        }
        pariservice.savePari(pari);
        return new ModelAndView("redirect:/listParisAdm");
    }

    @PostMapping("/savePari2")
    public ModelAndView savePari2(@ModelAttribute Pari pari) {
        System.out.println("controller save=" + pari.getLibelle());
        if (pari.getId() != null) {
            Pari current = pariservice.getPari(pari.getId());
            pari.setLibelle(current.getLibelle());
        }
        pariservice.savePari(pari);
        return new ModelAndView("redirect:/listParis");
    }


    @GetMapping("/")
    public String home(Model model) {
        Iterable<Pari> listParis = pariservice.getParis();
        model.addAttribute("paris", listParis);
        return "home";

    }


}