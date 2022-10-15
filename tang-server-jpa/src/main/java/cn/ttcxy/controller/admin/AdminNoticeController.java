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
    public StsNotice insert(@RequestBody StsNoticeParam noticeParam){
        StsNotice notice = BeanUtil.toBean(noticeParam, StsNotice.class);
        notice.setCreateDate(DateUtil.date());
        return noticeService.insertNotice(notice);
    }

    @PutMapping
    public StsNotice update(@RequestBody StsNoticeParam noticeParam){
        StsNotice notice = BeanUtil.toBean(noticeParam, StsNotice.class);
        return noticeService.updateNotice(notice);
    }

    @PutMapping("order")
    public void updateOrder(@RequestBody StsNoticeParam[] noticeList){
        noticeService.updateNoticeOrder(noticeList);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")String id){
        noticeService.deleteNotice(id);
    }

    @GetMapping
    public List<StsNotice> select(){
        return noticeService.selectAllNotice();
    }

}
