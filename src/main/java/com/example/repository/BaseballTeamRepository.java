package com.example.repository;

import com.example.domain.BaseballTeam;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 野球チームのテーブルを操作するリポジトリ.
 */
@Repository
public class BaseballTeamRepository {
    /**
     * BaseballTeamオブジェクトを生成するローマッパー.
     */
    private static final RowMapper<BaseballTeam> BASEBALL_TEAM_ROW_MAPPER = (rs, i) -> {
        BaseballTeam baseballTeam = new BaseballTeam();
        baseballTeam.setId(rs.getInt("id"));
        baseballTeam.setLeagueName(rs.getString("league_name"));
        baseballTeam.setTeamName(rs.getString("team_name"));
        baseballTeam.setHeadquarters(rs.getString("inauguration"));
        baseballTeam.setHistory(rs.getString("history"));
        return baseballTeam;
    };

    private final NamedParameterJdbcTemplate template;

    public BaseballTeamRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    public List<BaseballTeam> findAll(){
        String sql = """
                select
                id,league_name,team_name,headquarters,inauguration,history
                from
                teams
                ;
                """;

        return template.query(sql,BASEBALL_TEAM_ROW_MAPPER);
    }
}
