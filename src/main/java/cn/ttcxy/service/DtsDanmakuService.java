package cn.ttcxy.service;

import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.model.DtsDanmaku;
import cn.ttcxy.entity.model.DtsDanmakuExample;
import cn.ttcxy.mapper.DtsDanmakuMapper;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsDanmakuService {

    @Autowired
    private DtsDanmakuMapper danmakuMapper;


    public JSONObject select(String id) {
        DtsDanmakuExample danmakuExample = new DtsDanmakuExample();
        danmakuExample.createCriteria().andVideoIdEqualTo(id);
        List<DtsDanmaku> dtsDanmakus = danmakuMapper.selectByExample(danmakuExample);
        JSONArray data = new JSONArray();
        for (DtsDanmaku danmakus : dtsDanmakus) {
            JSONArray jsonArray = new JSONArray();
            jsonArray.add(danmakus.getTime());
            jsonArray.add("0");
            jsonArray.add(danmakus.getColor());
            jsonArray.add("");
            jsonArray.add(danmakus.getText());
            data.add(jsonArray);
        }
        JSONObject object = new JSONObject();
        object.put("code",0);
        object.put("data",data);
        return object;
    }

    public void insert(JSONObject json) {
        DtsDanmaku danmaku = new DtsDanmaku();
        danmaku.setDanmakuId(IdUtil.objectId());
        danmaku.setColor(json.getInteger("color"));
        danmaku.setTime(json.getInteger("time"));
        danmaku.setText(json.getString("text"));
        danmaku.setAuthorId(json.getString("authorId"));
        danmaku.setVideoId(json.getString("id"));
        danmakuMapper.insert(danmaku);
    }
}
