package com.krukun.contoller;

import com.krukun.Service.MenuService;
import com.krukun.entity.Menu;
import com.krukun.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Eugeniy Krukun on 25.04.2016.
 */
@RestController
@RequestMapping("/controller")
public class CustomController {
    @Autowired
    private MenuService service;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> getInfo() {
        return service.getAll();
    }


    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Menu getOne(@PathVariable("id") long id) {
        return service.getOne(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Menu save(@RequestBody Menu menu) {
        return service.save(menu);
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }
}
