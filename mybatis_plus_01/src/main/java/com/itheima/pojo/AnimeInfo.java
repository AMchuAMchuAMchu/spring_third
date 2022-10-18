package com.itheima.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Description ==> TODO
 * BelongsProject ==> spring_third
 * BelongsPackage ==> com.itheima.pojo
 * Version ==> 1.0
 * CreateTime ==> 2022-10-18 15:44:58
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
@Data
@TableName("anime_info")
public class AnimeInfo {

    @TableField("name")
    private String name;
//    @TableField(select = false)
    private Integer releaseTime;

    private String character01;

    private String character02;

    private Integer id;

    @TableField(exist = false)
    private String online;

}
