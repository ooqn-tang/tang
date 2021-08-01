import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class DatabaseOutData {

    public static void main(String[] args) {
        ExecutorService executorService = ThreadUtil.newExecutor(15);

        List<String> strings = FileUtil.readLines("C:\\Users\\Administrator\\Desktop\\1.csv", "UTF-8");
        int i = 0;
        for (String string : strings) {
            i++;
            string = string.replaceAll("\"","");
            String finalString = string;
            int finalI1 = i;
            executorService.execute(()->{
                List<Entity> query;
                if (finalI1 % 10000 == 0){
                    System.out.println(finalI1);
                }
                try {
                    if (FileUtil.exist("G:\\web_page1\\" + finalString +".data")){
                        return;
                    }
                    query = Db.use().query("select * from web_page where id = ?", finalString);
                    if (query.isEmpty()){
                        System.out.println(finalString);
                        return;
                    }
                    FileUtil.appendUtf8String(JSONUtil.toJsonStr(query) + "\n","G:\\web_page1\\"+finalString+".data");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
