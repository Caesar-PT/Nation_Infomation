package com.example.nation.controller;

import com.example.nation.model.City;
import com.example.nation.model.Nation;
import com.example.nation.service.city.CityService;
import com.example.nation.service.nation.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private NationService nationService;

    @ModelAttribute("nations")
    public List<Nation> getListNation() {
        return nationService.findAll();
    }

    @GetMapping("/index")
    public ModelAndView showListCity() {
        return new ModelAndView("index", "listCity", cityService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("create", "city", new City());
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Validated @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/create");
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/city/index");
        cityService.save(city);
        return modelAndView;
    }

    @GetMapping("/{id}/view")
    public ModelAndView viewCity(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showFormDel(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/{id}/delete")
    public ModelAndView delCity(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/city/index");
        cityService.remove(id);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/{id}/edit")
    public ModelAndView editCity(@PathVariable Long id,@Validated @ModelAttribute City city,BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/edit");
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/city/index");
        city.setId(id);
        cityService.update(city);
        return modelAndView;
    }
}
