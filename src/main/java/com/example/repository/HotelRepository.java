package com.example.repository;

import com.example.domain.Hotel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * hotelsテーブルを操作するリポジトリ.
 */
@Repository
public class HotelRepository {

    /**
     * Hotelオブジェクトを生成するローマッパー.
     */
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setAreaName(rs.getString("area_name"));
        hotel.setAddress(rs.getString("address"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        hotel.setParking(rs.getString("parking"));
        return hotel;
    };

    private final NamedParameterJdbcTemplate template;
    public HotelRepository(NamedParameterJdbcTemplate template){
        this.template = template;
    }


    /**
     * 値段からホテル情報を取得する.
     *
     * @param price 値段
     * @return 条件に一致するホテル情報一覧
     */
    public List<Hotel> findByPrice(Integer price){
        String sql = """
                SELECT 
                id,area_name,hotel_name,address,nearest_station,price,parking
                FROM hotels
                WHERE price <= 10000
                ;
                """;
        SqlParameterSource param = new MapSqlParameterSource().addValue("price",price);
        return template.query(sql,param,HOTEL_ROW_MAPPER);
    }
}
