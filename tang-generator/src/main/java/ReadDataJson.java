import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.Session;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.sql.SQLException;
import java.util.List;

public class ReadDataJson {
    public static void main(String[] args) {
        System.out.println("读取");
        List<String> strings = FileUtil.readLines("C:\\Users\\Administrator\\Desktop\\1.csv", "UTF-8");
        System.out.println("读取");
        int i = 0;
        for (int j = 295596; j < strings.size(); j++) {
            String string;
            try{
                string = FileUtil.readString("G:\\web_page1\\" + strings.get(j).replaceAll("\"","") + ".data", "utf-8");
            }catch (Exception e){
                System.out.println("异常"+e.getMessage());
                continue;
            }

            JSONArray objects;
            try{
                objects = JSONUtil.parseArray(string);
            }catch (Exception e){
                continue;
            }
            i += objects.size();
            for (Object object : objects) {
                JSONObject jsonObject = (JSONObject) object;
                Entity entity1 = new Entity("data_info");
                entity1.set("id",jsonObject.getStr("id"));
                entity1.set("url",jsonObject.getStr("url"));
                entity1.set("host",jsonObject.getStr("host"));
                entity1.set("state",jsonObject.getStr("state"));
                entity1.set("create_date", DateUtil.date(jsonObject.getLong("create_date")));
                entity1.set("update_date",DateUtil.date(jsonObject.getLong("update_date")));

                Entity entity2 = new Entity("data_text");
                entity2.set("data_id",jsonObject.getStr("id"));
                entity2.set("text",jsonObject.getStr("html"));

                Session session = Session.create();
                try {
                    session.beginTransaction();
                    session.insert(entity1);
                    session.insert(entity2);
                    session.commit();
                    System.out.println("添加成功：" + jsonObject.getStr("id"));
                } catch (SQLException e) {
                    session.quietRollback();
                    System.out.println(e.getMessage() + "重复 数据 :" + jsonObject.getStr("id"));
                }
            }
        }
    }
}
