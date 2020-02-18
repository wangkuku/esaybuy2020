package com.buy.entity;

import java.io.Serializable;

/**
 * (EasybuyNews)实体类
 *
 * @author makejava
 * @since 2020-02-18 16:42:55
 */
public class EasybuyNews implements Serializable {
    private static final long serialVersionUID = -24942484460444348L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 标题
    */
    private String title;
    /**
    * 内容
    */
    private String content;
    /**
    * 创建时间
    */
    private String createtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

}