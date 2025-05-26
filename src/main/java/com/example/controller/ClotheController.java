package com.example.controller;

import com.example.domain.Clothe;
import com.example.form.ClotheForm;
import com.example.service.ClotheService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    public String search(Model model, ClotheForm form){
        
        // ラジオボタン用
        Map<String, String> genderMap = new LinkedHashMap<>();
        genderMap.put("0", "Man");
        genderMap.put("1", "Woman");
        model.addAttribute("genderMap", genderMap);

        // セレクトボックス用
        Map<String, String> colorMap = new LinkedHashMap<>();
        colorMap.put("赤", "赤");
        colorMap.put("青", "青");
        colorMap.put("白", "白");
        colorMap.put("黄", "黄");
        model.addAttribute("colorMap", colorMap);


        return "clothe/search-cloth";
    }


    /**
     * 検索結果を出力する.
     *
     * @param form フォーム
     */
    @PostMapping("/search-clothe")
    public String result(ClotheForm form, Model model){
        List<Clothe> clotheList = clotheService.findByGenderAndColor(form.getGender(),form.getColor());
        model.addAttribute("clotheList", clotheList);

        // 同じように選択肢Mapもセット
        Map<String, String> genderMap = new LinkedHashMap<>();
        genderMap.put("0", "Man");
        genderMap.put("1", "Woman");
        model.addAttribute("genderMap", genderMap);

        Map<String, String> colorMap = new LinkedHashMap<>();
        colorMap.put("赤", "赤");
        colorMap.put("青", "青");
        colorMap.put("白", "白");
        colorMap.put("黄", "黄");
        model.addAttribute("colorMap", colorMap);

        return "clothe/search-cloth";
    }

}
