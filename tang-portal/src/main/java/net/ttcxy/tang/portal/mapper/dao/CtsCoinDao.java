package net.ttcxy.tang.portal.mapper.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;

public interface CtsCoinDao {
    Double selectCoinValue(String authorId);

    Double todayCoin(String authorId);

    @MapKey("author_id")
    List<JSONObject> selectAuthorCoin();
}
