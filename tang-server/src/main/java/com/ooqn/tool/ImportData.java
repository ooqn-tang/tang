package com.ooqn.tool;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

import com.overzealous.remark.Remark;

import cn.hutool.core.util.IdUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

public class ImportData {
    static Remark remark = new Remark();

    public static void main(String[] args) throws SQLException {

        long pageCount = getPageCount();
        for (int i = 0; i < pageCount; i++) {
            getList10(i);
            System.out.println(i);
        }
    }

    public static void getList10(int i) throws SQLException {
        if (i != 0) {
            i = i * 10;
        }

        List<Entity> query = Db.use("tang-ls").query(
                "select * from dts_article t1 , dts_article_content t2 where t1.article_id = t2.article_id limit "
                        + i + ",10");
        for (Entity entity : query) {
            String articleId = entity.getStr("article_id");
            String title = entity.getStr("title");
            String text = entity.getStr("text");
            String authorId = entity.getStr("author_id");
            String synopsis = entity.getStr("synopsis");

            String textId = insertContext(articleId, text);
            String markdownId = insertContext(articleId, remark.convert(text));

            try{
                Entity e = new Entity("dts_article");
                e.set("article_id", articleId);
                e.set("author_id", authorId);
                e.set("create_time", new Date());
                e.set("update_time", new Date());
                e.set("title", title);
                e.set("markdown_context_id", markdownId);
                e.set("text_context_id", textId);
                e.set("state", "1");
                e.set("synopsis", synopsis);
                Db.use("tang-mysql8").insert(e);
            }catch(SQLIntegrityConstraintViolationException ex){
                System.out.println("唯一");
            }
        }
    }

    public static String insertContext(String dataId, String context) throws SQLException {
        String textId = IdUtil.objectId();
        Entity textEntity = new Entity("dts_context");
        textEntity.set("id", textId);
        textEntity.set("data_id", dataId);
        textEntity.set("text",context);
        textEntity.set("create_time", new Date());
        textEntity.set("update_time", new Date());
        Db.use("tang-mysql8").insert(textEntity);
        return textId;
    }

    public static long getPageCount() throws SQLException {
        Entity queryOne = Db.use("tang-ls").queryOne(
                "select count(1) c from dts_article t1 , dts_article_content t2 where t1.article_id = t2.article_id");
        int i = queryOne.getInt("c");
        return i / 10 + 1;
    }

}
