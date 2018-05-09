package com.example.jingdongdeom.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by huoxuebin on 2018/4/22.
 */
@Entity
public class User {
    @Id
    private Long id;
    private String sname;
    public String getSname() {
        return this.sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 405242272)
    public User(Long id, String sname) {
        this.id = id;
        this.sname = sname;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    
}
