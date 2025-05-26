package com.example.controller;

import com.example.domain.Clothe;
import com.example.form.ClotheForm;
import com.example.service.ClotheService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
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

    //Applicationスコープを使うための設定
    @Autowired
    private ServletContext application;


    private final ClotheService clotheService;

    public ClotheController(ClotheService clotheService, ServletContext application){
        this.clotheService = clotheService;
    }


    /**
     * 検索画面を出力する.
     *
     * @return 検索画面
     */
    @GetMapping("/search-clothe")
    public String search(Model model, ClotheForm form){

        //applicationスコープに選択肢がなかったら格納
        if(application.getAttribute("genderMap")==null){
            // ラジオボタン用
            Map<String, String> genderMap = new LinkedHashMap<>();
            genderMap.put("0", "Man");
            genderMap.put("1", "Woman");
            application.setAttribute("genderMap", genderMap);
        }
        if(application.getAttribute("colorMap")==null){
            // セレクトボックス用
            Map<String, String> colorMap = new LinkedHashMap<>();
            colorMap.put("赤", "赤");
            colorMap.put("青", "青");
            colorMap.put("白", "白");
            colorMap.put("黄", "黄");
            application.setAttribute("colorMap", colorMap);
        }

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
        return "clothe/search-cloth";
    }
}
