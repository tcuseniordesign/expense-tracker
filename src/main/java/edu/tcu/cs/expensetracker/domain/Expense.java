package edu.tcu.cs.expensetracker.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;

@Entity
public class Expense implements Serializable {
    @Id
    private Integer id;
    private String name;
    private Double money;
    private Long account;
    private Date createtime;
    private String desc;

    public Expense() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
