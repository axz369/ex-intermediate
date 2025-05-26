package com.example.controller;

import com.example.domain.Clothe;
import com.example.service.ClotheService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 服情報を操作するコントローラ.
 */
@Controller
@RequestMapping("/clothe")
public class ClotheController {

    private final ClotheService clotheService;
    public ClotheController(ClotheService clotheService){
        this.clotheService = clotheService;
    }


    /**
     * 検索画面を出力する.
     *
     * @return 検索画面
     */
    @GetMapping("/search")
    public String search(){
        return "clothe/search-cloth";
    }


    /**
     * 検索結果を出力する.
     *
     * @param gender 性別
     * @param color 色
     * @return 検索結果
     */
    @PostMapping("search")
    public String result(Integer gender, String color, Model model){
        List<Clothe> clotheList = clotheService.findByGenderAndColor(gender,color);
        model.addAttribute("clotheList",clotheList);
        return "clothe/search-cloth";
    }
}
