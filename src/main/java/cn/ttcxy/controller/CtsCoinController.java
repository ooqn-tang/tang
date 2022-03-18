package cn.ttcxy.controller;

import com.github.pagehelper.PageInfo;
import cn.ttcxy.core.security.CurrentUtil;
import cn.ttcxy.entity.model.CtsCoin;
import cn.ttcxy.service.CtsCoinService;
import cn.ttcxy.service.DtsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/coin")
public class CtsCoinController {

    @Autowired
    private CtsCoinService coinService;


    @Autowired
    private DtsDataService dataService;

    @GetMapping("{dataId}")
    public ResponseEntity<Long> selectById(@PathVariable("dataId") String dataId){
        String currentId = CurrentUtil.id();
        Long count = coinService.selectAuthorData(dataId,currentId);
        return ResponseEntity.ok(count);
    }

    @GetMapping
    public ResponseEntity<Double> select(){
        String currentId = CurrentUtil.id();
        Double likeValue = coinService.selectCoinValue(currentId);
        return ResponseEntity.ok(likeValue);
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<CtsCoin>> selectList(){
        String currentId = CurrentUtil.id();
        PageInfo<CtsCoin> coinList = coinService.selectCoinList(currentId);
        return ResponseEntity.ok(coinList);
    }


    /**
     * 打赏硬币给指定内容
     */
    @PostMapping("{dataId}")
    public void giveCoin(@PathVariable("dataId") String dataId){
        String authorId = dataService.selectDataAuthorId(dataId);
        coinService.giveCoin(dataId,authorId);
    }
}