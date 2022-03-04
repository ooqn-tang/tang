package net.ttcxy.tang.portal.mapper.dao;

import cn.hutool.core.date.DateTime;

public interface CtsCoinDao {
    Double selectCoinValue(String authorId);

    Double todayCoin(String authorId);
}
