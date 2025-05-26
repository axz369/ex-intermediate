package com.example.controller;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;
import com.example.service.BaseballTeamService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 野球チーム情報を操作するコントローラ.
 */
@Controller
@RequestMapping("/baseballTeam")
public class BaseballTeamController {

    private final BaseballTeamService baseballTeamService;
    public BaseballTeamController(BaseballTeamService baseballTeamService){
        this.baseballTeamService = baseballTeamService;
    }


    /**
     * 野球チーム一覧画面を出力する.
     *
     * @param model モデル
     * @return 野球チーム一覧画面
     */
    @GetMapping("/show-list")
    public String showList(Model model){
        List<BaseballTeam> baseballTeams = baseballTeamService.showList();
        model.addAttribute("baseballTeams",baseballTeams);
        return "baseballTeam/show-list";
    }

    @GetMapping("/show-detail")
    public String showDetail(String id, Model model){
        BaseballTeam baseballTeam = baseballTeamService.showDetail(Integer.parseInt(id));

        model.addAttribute("baseballTeam",baseballTeam);
        return "baseballTeam/show-detail";
    }
}
