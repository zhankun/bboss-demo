package cn.zhankun.esdemo.entity;

import com.frameworkset.orm.annotation.ESId;
import lombok.Data;
import org.frameworkset.elasticsearch.entity.ESBaseData;

import java.util.Date;

@Data
public class EsUser extends ESBaseData {

    @ESId
    private Long userId;

    private String userNick;

    private Integer sex;

    private String headPic;

    private Date birthday;

    private Date createTime;
}
