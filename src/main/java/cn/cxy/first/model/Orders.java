package cn.cxy.first.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Function: TODO
 * Reason: TODO ADD REASON(可选).</br>
 * Date: 2017/10/9 21:40 </br>
 *
 * @author: cx.yang
 * @since: Thinkingbar Web Project 1.0
 */

@Setter
@Getter
public class Orders {

    private Integer id;
    private String number;
    private Integer userId;
    private Date createTime;
    private String note;

}