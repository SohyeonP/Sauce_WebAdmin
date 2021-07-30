package co.kr.circus.sauceweb.store.mapper;

import co.kr.circus.sauceweb.store.dto.Store;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreMapper {

    @Insert("INSERT INTO store(store_biz_storename, store_phone, store_biz_bossname, store_biz_address, store_biz_number) VALUES(#{store.biz_storename}, #{store.phone}, #{store.biz_bossname}, #{store.biz_address}, #{store.biz_number})")
    @Options(useGeneratedKeys = true, keyProperty = "store_id")
    int insert(@Param("store") Store store);

    @Select("SELECT * FROM store")
    @Results(id="StoreMap", value={
            @Result(property= "biz_storename", column = "store_biz_storename"),
            @Result(property= "phone", column = "store_phone"),
            @Result(property= "biz_bossname", column = "store_biz_bossname"),
            @Result(property= "biz_address", column = "store_biz_address"),
            @Result(property= "biz_number", column = "store_biz_number")
    })
    List<Store> getAll();

    @Select("SELECT * FROM store WHERE store_id=#{store_id}")
    @ResultMap("StoreMap")
    Store getById(@Param("store_id") int store_id);
}
