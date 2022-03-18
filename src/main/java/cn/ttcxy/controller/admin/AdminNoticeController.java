package cn.ttcxy.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONArray;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.model.StsNotice;
import cn.ttcxy.entity.param.StsNoticeParam;
import cn.ttcxy.service.StsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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