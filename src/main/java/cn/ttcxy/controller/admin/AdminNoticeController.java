package cn.ttcxy.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.ttcxy.controller.BaseController;
import cn.ttcxy.core.exception.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.model.StsNotice;
import cn.ttcxy.entity.param.StsNoticeParam;
import cn.ttcxy.service.StsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/notice")
public class AdminNoticeController extends BaseController {

    @Autowired
    private StsNoticeService noticeService;

    @PostMapping
    public String insert(@RequestBody StsNoticeParam noticeParam){
        StsNotice notice = BeanUtil.toBean(noticeParam, StsNotice.class);
        int count = noticeService.insertNotice(notice);
        notice.setCreateDate(DateUtil.date());
        if (count > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @PutMapping
    public String update(@RequestBody StsNoticeParam noticeParam){
        StsNotice notice = BeanUtil.toBean(noticeParam, StsNotice.class);
        int count = noticeService.updateNotice(notice);
        if (count > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @PutMapping("order")
    public void updateOrder(@RequestBody StsNoticeParam[] noticeList){
        noticeService.updateNoticeOrder(noticeList);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")String id){
        int i = noticeService.deleteNotice(id);
        if (i > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @GetMapping
    public List<StsNotice> select(){
        return noticeService.selectAllNotice();
    }

}
