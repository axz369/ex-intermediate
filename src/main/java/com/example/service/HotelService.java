package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

/**
 * ホテル情報を操作するサービス.
 */
@Service
@Transactional
public class HotelService {

    private final HotelRepository hotelRepository;
    public HotelService(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    /**
     * 値段からホテル情報を取得する.
     *
     * @param price 値段
     * @return 条件に一致するホテル情報一覧
     */
    public List<Hotel> search(Integer price){
        if(price == null){//空欄で入力されたら全件検索
            return hotelRepository.findAll();
        }
        return hotelRepository.findByPrice(price);
    }
}
