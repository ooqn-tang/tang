package net.ttcxy.tang.portal.controller;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.model.PtsCredit;
import net.ttcxy.tang.portal.service.UtsCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/credit")
public class PtsCreditController {

    @Autowired
    private UtsCreditService creditService;

    @GetMapping
    public ResponseEntity<Integer> select(){
        String currentId = CurrentUtil.id();
        Integer likeValue = creditService.selectCreditValue(currentId);
        return ResponseEntity.ok(likeValue);
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<PtsCredit>> selectList(){
        String currentId = CurrentUtil.id();
        PageInfo<PtsCredit> creditList = creditService.selectCreditList(currentId);
        return ResponseEntity.ok(creditList);
    }
}
