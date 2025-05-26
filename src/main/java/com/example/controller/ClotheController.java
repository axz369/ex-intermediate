package com.example.controller;

import com.example.domain.Clothe;
import com.example.form.ClothForm;
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
    @GetMapping("/search-clothe")
    public String search(Model model){
        if (!model.containsAttribute("clotheForm")) {
            model.addAttribute("clotheForm", new ClothForm());
        }
        return "clothe/search-cloth";
    }


    /**
     * 検索結果を出力する.
     *
     * @param form フォーム
     */
    @PostMapping("/search-clothe")
    public String result(ClothForm form, Model model){
        List<Clothe> clotheList = clotheService.findByGenderAndColor(form.getGender(),form.getColor());
        model.addAttribute("clotheList", clotheList);
        model.addAttribute("clotheForm", form);  // ← ここを"clotheForm"に変更
        return "clothe/search-cloth";
    }

}
