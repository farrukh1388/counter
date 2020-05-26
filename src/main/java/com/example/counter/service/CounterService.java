package com.example.counter.service;

import java.util.Set;

public interface CounterService {

    String add(String name);

    String increment(String name);

    Long getValue(String name);

    String delete(String name);

    Long getValues();

    Set<String> getNames();
}
