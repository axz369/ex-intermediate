package com.example.service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 野球チーム情報を操作するサービス.
 */
@Service
@Transactional
public class BaseballTeamService {

    private final BaseballTeamRepository baseballTeamRepository;

    public BaseballTeamService(BaseballTeamRepository baseballTeamRepository){
        this.baseballTeamRepository = baseballTeamRepository;
    }


    /**
     * 野球チーム情報を全件取得する.
     *
     * @return 野球チーム情報一覧
     */
    public List<BaseballTeam> showList(){
        return baseballTeamRepository.findAll();
    }
}
