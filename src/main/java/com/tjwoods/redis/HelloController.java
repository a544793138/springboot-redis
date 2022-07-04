package com.tjwoods.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return service.hello(name);
    }

    @PutMapping("/hello/{name}")
    public String helloUpdate(@PathVariable("name") String name) {
        return service.update(name);
    }

    @DeleteMapping("/hello/{name}")
    public void delete(@PathVariable("name") String name) {
        service.delete(name);
    }

    @GetMapping("/hello/count")
    public int helloCount() {
        return HelloService.getCount().get();
    }
}
