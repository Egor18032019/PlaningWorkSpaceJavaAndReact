package com.work.space.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Tag(name = "Authorized news controller")
@Controller
public class NewsController {

    @ResponseBody
    @GetMapping("/news")
    public HashMap<String, HashMap> getNews() {
        HashMap<String, HashMap> map = new HashMap<>();
        HashMap<String, String> news = new HashMap<>();
        //TODO обдумать.
        // Сделать еще одну SQL таблицу >??
        // Читать из файла ,,?
        // Как будут постить новости ? Каким образом ?
        news.put("10.10.10", "Внимание жильцы. Сверка показаний счетчиков будет проходить с 00 по **.Просьба быть дома");
        news.put("11.11.21", "Уважаемы жители дома ХХ. Большая просьба быть дома и пускать газовую службу");

        map.put("message", news);

        return map;
    }
}