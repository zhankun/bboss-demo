package cn.zhankun.esdemo;

import cn.zhankun.esdemo.entity.EsUser;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class EsDemoApplicationTests {

    @Autowired
    private BBossESStarter bBossESStarter;

    @Test
    void contextLoads() {
        ClientInterface restClient = bBossESStarter.getRestClient();
        EsUser esUser = new EsUser();
        esUser.setUserId(100L);
        esUser.setBirthday(new Date());

        esUser.setUserNick("测试bboss");
        esUser.setHeadPic("www.baidu.com");
        esUser.setSex(1);
        esUser.setCreateTime(new Date());
        restClient.addDocument("es_user", "esUser", esUser, "refresh=true");
        EsUser result = restClient.getDocument("es_user", "esUser", "100", EsUser.class);
        System.out.println(result.toString());
    }

}
