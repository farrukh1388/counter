package com.example.counter.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CounterServiceImpl implements CounterService{

    private Map<String, Long> map = new HashMap();

    @Override
    public String add(String name) {
        if (map.containsKey(name)) {
            return "Счетчик с именем " + name + " уже существует.";
        }
        map.put(name, 0L);
        return "Счетчик с именем " + name + " создан.";
    }

    @Override
    public String increment(String name) {
        Long counter;
        if ((counter = map.get(name)) != null) {
            map.put(name, ++counter);
            return "Счетчик с именем " + name + " инкрементирован.";
        }
        return "Счетчика с именем " + name + " не существует.";
    }

    @Override
    public Long getValue(String name) {
        return map.get(name);
    }

    @Override
    public String delete(String name) {
        if (map.containsKey(name)) {
            map.remove(name);
            return "Счетчик с именем " + name + " удален.";
        }
        return "Счетчика с именем " + name + " не существует.";
    }

    @Override
    public Long getValues() {
        return map.values().stream().reduce(0L, Long::sum);
    }

    @Override
    public Set<String> getNames() {
        return map.keySet();
    }
}
