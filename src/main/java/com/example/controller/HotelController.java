package com.example.controller;

import com.example.domain.Hotel;
import com.example.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ホテル情報を操作するコントローラ.
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }


    /**
     * 検索画面を出力する.
     *
     * @return 検索画面
     */
    @GetMapping("/search")
    public String search(Model model){
        return "hotel/search";
    }

    /**
     * 検索結果を出力する.
     *
     * @param price 値段
     * @param model モデル
     */
    @PostMapping("/search")
    public void result(Integer price, Model model){
        List<Hotel> hotelList = hotelService.search(price);
        model.addAttribute("hotelList",hotelList);
        search(model);
    }
}
