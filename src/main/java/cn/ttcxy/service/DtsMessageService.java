package cn.ttcxy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.model.DtsMessage;
import cn.ttcxy.entity.model.DtsMessageExample;
import cn.ttcxy.mapper.DtsMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsMessageService {

    @Autowired
    private DtsMessageMapper messageMapper;

    public void insert(DtsMessage message) {
        messageMapper.insertSelective(message);
    }

    public boolean isData(String dataId){
        DtsMessageExample messageExample = new DtsMessageExample();
        messageExample.createCriteria().andDataIdEqualTo(dataId);

        List<DtsMessage> dtsMessages = messageMapper.selectByExample(messageExample);
        return dtsMessages.size() > 0;
    }

    public void update(DtsMessageExample messageExample,DtsMessage message){
        messageMapper.updateByExampleSelective(message,messageExample);
    }

    public void insertMessage(String dataId,String text,String url,String issuer,String recipient){
        DtsMessage message = new DtsMessage();
        message.setMessage(text);
        message.setMessageId(IdUtil.objectId());
        message.setCreateDate(DateUtil.date());
        message.setIssuer(issuer);
        message.setUrl(url);
        if (isData(dataId)){
            DtsMessageExample messageExample = new DtsMessageExample();
            messageExample.createCriteria().andDataIdEqualTo(dataId);
            update(messageExample,message);
        }else{
            insert(message);
        }
    }
}
