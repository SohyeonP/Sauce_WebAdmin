package co.kr.circus.sauceweb.store.mapper;

import co.kr.circus.sauceweb.store.dto.Store;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreMapper {

    @Insert("INSERT INTO store(biz_storename, phone, biz_bossname, biz_address, biz_number) VALUES(#{store.storename}, #{store.storephone}, #{store.bossname}, #{store.address}, #{store.number})")
    @Options(useGeneratedKeys = true, keyProperty = "store_id")
    int insert(@Param("store") Store store);

    @Select("SELECT * FROM store")
    @Results(id="StoreMap", value={
            @Result(property= "storename", column = "biz_storename"),
            @Result(property= "storephone", column = "phone"),
            @Result(property= "bossname", column = "biz_bossname"),
            @Result(property= "address", column = "biz_address"),
            @Result(property= "number", column = "biz_number")
    })
    List<Store> getAll();

    @Select("SELECT * FROM store WHERE store_id=#{store_id}")
    @ResultMap("StoreMap")
    Store getById(@Param("store_id") int store_id);
}
