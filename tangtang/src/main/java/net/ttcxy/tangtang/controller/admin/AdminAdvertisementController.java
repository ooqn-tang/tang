package net.ttcxy.tangtang.controller.admin;

import net.ttcxy.tangtang.code.ResponseData;
import net.ttcxy.tangtang.entity.Advertise;
import net.ttcxy.tangtang.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//广告管理
@Controller
@RequestMapping("adminAdv")
public class AdminAdvertisementController {

    @Autowired
    private AdvertisementService advertisementServiceImpl;

    //查询广告
    @GetMapping("show")
    public String show(HttpSession session) {
        //传入查询到的广告集合
        session.setAttribute("list", advertisementServiceImpl.selectAllAdvertisement());
        //跳转到展示页面
        return "advertise/show";
    }

    //根据id查询广告
    @GetMapping("select/{id}")
    public Advertise selectById(@PathVariable("id") String advertisementId) {
        return advertisementServiceImpl.selectById(advertisementId);
    }

    //跳转修改页面
    @RequestMapping("edit")
    public String toEdit(HttpSession session, @RequestParam(name = "id", required = false ) String advertisementId, Model model){
        List<Advertise> list = (List<Advertise>)session.getAttribute("list");
        //判断是否能够从session中获取list
        if (list != null){
            for (Advertise adv : list) {
                if (advertisementId != null && !advertisementId.equals("") && adv.getId().equals(advertisementId)){
                    model.addAttribute("updateAdv", adv);
                    return "advertise/edit";
                }
            }
        }
        //失败返回错误页面
        return "advertise/error";
    }

    //更新广告
    @PostMapping("update")
    public String updateAdvertisement(Advertise advertise){
        int index = advertisementServiceImpl.updateAdvertisement(advertise);
        if (index != 0){
            return "advertise/success";
        }
        return "advertise/error";
    }

    //增加广告
    @RequestMapping("add")
    @ResponseBody
    public ResponseData addAdvertisement() {
        return null;
    }

    //删除广告
    @RequestMapping("delete")
    @ResponseBody
    public ResponseData deleteAdvertisement(@RequestParam(name = "id", required = false) String advertisementId){
        return advertisementServiceImpl.deleteAdvertisement(advertisementId)==1
                ?ResponseData.successful("successful")
                :ResponseData.error("error");
    }

}

