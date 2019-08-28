package com.jnnvc.vblog.service.Vlog;

import com.jnnvc.vblog.entity.Vlog;

import java.util.List;

/**
 * @Auther: yancong
 * @Date: create by 13:36 2019/8/27
 * @Description:
 */
public interface Vlogservice {


    List<Vlog> queryVlogList(Vlog vlog);
}
