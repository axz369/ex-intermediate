package com.example.repository;

import com.example.domain.BaseballTeam;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * teamsテーブルを操作するリポジトリ.
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
        baseballTeam.setHeadquarters(rs.getString("headquarters"));
        baseballTeam.setInauguration(rs.getString("inauguration"));
        baseballTeam.setHistory(rs.getString("history"));
        return baseballTeam;
    };

    private final NamedParameterJdbcTemplate template;

    public BaseballTeamRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    /**
     * 野球チーム一覧を発足日順の昇順で取得.
     *
     * @return 野球チーム一覧 野球チームが存在しない場合はサイズ0の野球チーム一覧を返す
     */
    public List<BaseballTeam> findAll(){
        String sql = """
                select
                id,league_name,team_name,headquarters,inauguration,history
                from teams
                order by inauguration
                ;
                """;

        return template.query(sql,BASEBALL_TEAM_ROW_MAPPER);
    }


    /**
     * 主キーから野球チーム情報を取得する.
     *
     * @param id 検索した野球チームのID
     * @return 野球チーム情報
     */
    public BaseballTeam findById(Integer id){
        String sql = """
                select
                id,league_name,team_name,headquarters,inauguration,history
                from teams
                where id = :id
                ;
                """;
        SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
        return template.queryForObject(sql,param,BASEBALL_TEAM_ROW_MAPPER);
    }
}
