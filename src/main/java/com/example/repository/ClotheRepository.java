package com.example.repository;

import com.example.domain.Clothe;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * clothesテーブルを操作するリポジトリ.
 */
@Repository
public class ClotheRepository {

    /**
     * Clotheオブジェクトを生成するローマッパー.
     */
    private static final RowMapper<Clothe> CLOTHE_TEAM_ROW_MAPPER = (rs, i) -> {
        Clothe clothe = new Clothe();
        clothe.setId(rs.getInt("id"));
        clothe.setCategory(rs.getString("category"));
        clothe.setGenre(rs.getString("genre"));
        clothe.setGender(rs.getInt("gender"));
        clothe.setColor(rs.getString("color"));
        clothe.setPrice(rs.getInt("price"));
        clothe.setSize(rs.getString("size"));
        return clothe;
    };

    private final NamedParameterJdbcTemplate template;
    public ClotheRepository(NamedParameterJdbcTemplate template){
        this.template = template;
    }


    /**
     * 性別と色から服を取得する.
     *
     * @param gender 性別
     * @param color 色
     * @return 条件に一致する服一覧
     */
    public List<Clothe> findByGenderAndColor(Integer gender, String color){
        String sql = """
                SELECT
                id,category,genre,gender,color,price,size
                FROM clothes
                WHERE 
                gender = :gender
                AND
                color = :color
                order by genre
                ;
                """;
        SqlParameterSource param = new MapSqlParameterSource().addValue("gender",gender).addValue("color",color);
        return template.query(sql,param,CLOTHE_TEAM_ROW_MAPPER);
    }
}
