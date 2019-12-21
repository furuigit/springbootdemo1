package com.fr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author Fr
 * @Date 2019/12/18 19:07
 * @Version 1.0
 */
@Data //set get 方法
@AllArgsConstructor //有参构造
@NoArgsConstructor //无参构造
public class User {
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date bir;
}
