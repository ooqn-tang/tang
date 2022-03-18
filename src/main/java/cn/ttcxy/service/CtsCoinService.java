package cn.ttcxy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.core.security.CurrentUtil;
import cn.ttcxy.entity.model.CtsCoin;
import cn.ttcxy.entity.model.CtsCoinExample;
import cn.ttcxy.mapper.CtsCoinMapper;
import cn.ttcxy.mapper.dao.CtsCoinDao;
import cn.ttcxy.mapper.dao.DtsDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class CtsCoinService {

    @Autowired
    private CtsCoinMapper coinMapper;

    @Autowired
    private CtsCoinDao coinDao;

    @Autowired
    private DtsDataDao dataDao;

    public Double selectCoinValue(String currentId) {
        Double num = coinDao.selectCoinValue(currentId);
        return num == null?0:num;
    }

    public PageInfo<CtsCoin> selectCoinList(String currentId) {
        CtsCoinExample coinExample = new CtsCoinExample();
        coinExample.createCriteria().andAuthorIdEqualTo(currentId);
        coinExample.setOrderByClause("create_time desc");
        return new PageInfo<>(coinMapper.selectByExample(coinExample));
    }

    public void insert(CtsCoin coin) {
        coinMapper.insertSelective(coin);
    }

    public int selectCount(String dataId,String authorId){
        CtsCoinExample coinExample = new CtsCoinExample();
        coinExample.createCriteria()
                .andDataIdEqualTo(dataId)
                .andAuthorIdEqualTo(authorId)
                .andTypeEqualTo(3);
        return coinMapper.selectByExample(coinExample).size();
    }

    public Double selectAuthorCoin(String authorId){
        return coinDao.selectCoinValue(authorId);
    }

    /**
     * 打赏硬币给指定内容
     * @param dataId 给予的内容
     * @param authorId 消费硬币的用户ID
     */
    public void giveCoin(String dataId,String authorId){
        if (selectAuthorCoin(authorId) < 1){
            throw new ApiException(ResponseCode.VALIDATE_FAILED.getStatus(),"积分不足");
        }

        int count = selectCount(dataId, CurrentUtil.id());
        if (count > 0){
            return;
        }
        String dataAuthorId = dataDao.selectDataAuthorId(dataId);
        // dataAuthorId 增加
        CtsCoin coin1 = new CtsCoin();
        coin1.setCoinId(IdUtil.objectId());
        coin1.setCoinValue(0.1);
        coin1.setAuthorId(dataAuthorId);
        coin1.setType(2);
        coin1.setCreateTime(DateUtil.date());
        coin1.setCreateDate(DateUtil.date());
        coin1.setCause("打赏硬币给创作者");
        insert(coin1);

        // authorId 减少一个币
        CtsCoin coin2 = new CtsCoin();
        coin2.setCoinId(IdUtil.objectId());
        coin2.setCoinValue(-1.0);
        coin2.setAuthorId(CurrentUtil.id());
        coin2.setDataId(dataId);
        coin2.setType(3);
        coin2.setCreateTime(DateUtil.date());
        coin2.setCreateDate(DateUtil.date());
        coin2.setCause("打赏硬币给创作者");
        insert(coin2);
    }

    // 使用获取金币
    public void useCoin(){
        if (todayCoin() > 10){
            return;
        }
        try{
            CtsCoin coin = new CtsCoin();
            coin.setCoinId(IdUtil.objectId());
            coin.setCoinValue(1.0);
            coin.setCause("每日使用获取金币");
            coin.setAuthorId(CurrentUtil.id());
            coin.setType(1);
            coin.setCreateTime(DateUtil.date());
            coin.setCreateDate(DateUtil.date());
            coinMapper.insertSelective(coin);
        }catch (DuplicateKeyException | ApiException ignored){}
    }

    // 评论获取金币
    public void commentCoin(){
        if (todayCoin() > 10){
            return;
        }
        try{
            CtsCoin coin = new CtsCoin();
            coin.setCoinId(IdUtil.objectId());
            coin.setCoinValue(1.0);
            coin.setCause("评论获取金币");
            coin.setAuthorId(CurrentUtil.id());
            coin.setType(1);
            coin.setCreateTime(DateUtil.date());
            coin.setCreateDate(DateUtil.date());
            coinMapper.insertSelective(coin);
        }catch (DuplicateKeyException ignored){}
    }

    // 点赞获取金币
    public void likeCoin(){
        if (todayCoin() > 10){
            return;
        }
        // 每日使用获取金币
        try{
            CtsCoin coin = new CtsCoin();
            coin.setCoinId(IdUtil.objectId());
            coin.setCoinValue(1.0);
            coin.setCause("点赞获取金币");
            coin.setAuthorId(CurrentUtil.id());
            coin.setType(1);
            coin.setCreateTime(DateUtil.date());
            coin.setCreateDate(DateUtil.date());
            coinMapper.insertSelective(coin);
        }catch (DuplicateKeyException ignored){}
    }

    public Double todayCoin(){
        try{
            Double num = coinDao.todayCoin(CurrentUtil.id());
            return num == null?0:num;
        }catch (ApiException exception){
            return 0.0;
        }
    }

    public Long selectAuthorData(String dataId, String authorId) {
        CtsCoinExample coinExample = new CtsCoinExample();
        coinExample.createCriteria()
                .andDataIdEqualTo(dataId)
                .andAuthorIdEqualTo(authorId)
                .andTypeEqualTo(3);
        return coinMapper.countByExample(coinExample);
    }
}
