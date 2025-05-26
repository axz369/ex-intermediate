package com.example.service;

import com.example.domain.Clothe;
import com.example.repository.ClotheRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服情報を操作するサービス.
 */
@Service
@Transactional
public class ClotheService {

    private final ClotheRepository clotheRepository;
    public ClotheService(ClotheRepository clotheRepository){
        this.clotheRepository = clotheRepository;
    }


    /**
     * 性別と色から服を取得する.
     *
     * @param gender 性別
     * @param color 色
     * @return 服情報
     */
    public List<Clothe> findByGenderAndColor(Integer gender, String color){
        return clotheRepository.findByGenderAndColor(gender,color);
    }
}
