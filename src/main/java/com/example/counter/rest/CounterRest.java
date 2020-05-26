package com.example.counter.rest;

import com.example.counter.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/counter")
public class CounterRest {

    private final CounterService counterService;

    @Autowired
    public CounterRest(CounterService counterService) {
        this.counterService = counterService;
    }

    @RequestMapping("/add/{name}")
    public String create(@PathVariable("name") String name) {
        return counterService.add(name);
    }

    @RequestMapping("/increment/{name}")
    public String increment(@PathVariable String name) {
        return counterService.increment(name);
    }

    @GetMapping("/get_value/{name}")
    public Long getValue(@PathVariable String name) {
        return counterService.getValue(name);
    }

    @RequestMapping("/delete/{name}")
    public String delete(@PathVariable String name) {
        return counterService.delete(name);
    }

    @GetMapping("/get_values")
    public Long getValues() {
        return counterService.getValues();
    }

    @GetMapping("/get_names")
    public Set<String> getNames() {
        return counterService.getNames();
    }
}
