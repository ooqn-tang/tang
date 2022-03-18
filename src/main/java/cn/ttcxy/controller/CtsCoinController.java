package cn.ttcxy.controller;

import cn.ttcxy.entity.model.CtsCoin;
import cn.ttcxy.service.CtsCoinService;
import cn.ttcxy.service.DtsDataService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/coin")
public class CtsCoinController extends BaseController{

    @Autowired
    private CtsCoinService coinService;


    @Autowired
    private DtsDataService dataService;

    @GetMapping("{dataId}")
    public ResponseEntity<Long> selectById(@PathVariable("dataId") String dataId){
        String currentId = authorId();
        Long count = coinService.selectAuthorData(dataId,currentId);
        return ResponseEntity.ok(count);
    }

    @GetMapping
    public ResponseEntity<Double> select(){
        String currentId = authorId();
        Double likeValue = coinService.selectCoinValue(currentId);
        return ResponseEntity.ok(likeValue);
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<CtsCoin>> selectList(){
        String currentId = authorId();
        PageInfo<CtsCoin> coinList = coinService.selectCoinList(currentId);
        return ResponseEntity.ok(coinList);
    }


    /**
     * 打赏硬币给指定内容
     */
    @PostMapping("{dataId}")
    public void giveCoin(@PathVariable("dataId") String dataId){
        String authorId = dataService.selectDataAuthorId(dataId);
        coinService.giveCoin(dataId,authorId,authorId());
    }
}
