package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author AMchu
 * @since 2022-10-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Anime_info implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer release_time;

    private String character01;

    private String character02;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer delete_id;

    @Version
    private Integer version;


}
