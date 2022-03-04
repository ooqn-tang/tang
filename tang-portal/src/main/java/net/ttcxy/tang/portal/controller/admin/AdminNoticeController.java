package net.ttcxy.tang.portal.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.entity.model.StsNotice;
import net.ttcxy.tang.portal.entity.param.StsNoticeParam;
import net.ttcxy.tang.portal.service.StsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/notice")
public class AdminNoticeController {

    @Autowired
    private StsNoticeService noticeService;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody StsNoticeParam noticeParam){
        StsNotice notice = BeanUtil.toBean(noticeParam, StsNotice.class);
        int count = noticeService.insertNotice(notice);
        notice.setCreateDate(DateUtil.date());
        if (count > 0){
            return ResponseEntity.ok(ResponseCode.SUCCESS.getMessage());
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody StsNoticeParam noticeParam){
        StsNotice notice = BeanUtil.toBean(noticeParam, StsNotice.class);
        int count = noticeService.updateNotice(notice);
        if (count > 0){
            return ResponseEntity.ok(ResponseCode.SUCCESS.getMessage());
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @PutMapping("order")
    public void updateOrder(@RequestBody JSONArray noticeList){
        noticeService.updateNoticeOrder(noticeList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id")String id){
        int i = noticeService.deleteNotice(id);
        if (i > 0){
            return ResponseEntity.ok(ResponseCode.SUCCESS.getMessage());
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @GetMapping
    public ResponseEntity<?> select(){
        return ResponseEntity.ok(noticeService.selectAllNotice());
    }



}
