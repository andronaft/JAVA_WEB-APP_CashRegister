package com.zuk.zuk.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Objects;

@Entity
@Table(name = "TRANSACTION", schema = "DB", catalog = "TEST")
public class TransactionEntity {
    private int id;
    private int idworker;
    private String goods;
    private Timestamp dateandtime;

    @Basic
    @Column(name = "DATEANDTIME")
    public Timestamp getDateandtime() {
        return dateandtime;
    }

    public void setDateandtime(Timestamp dateandtime) {
        this.dateandtime = dateandtime;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IDWORKER")
    public int getIdworker() {
        return idworker;
    }

    public void setIdworker(int idworker) {
        this.idworker = idworker;
    }

    @Basic
    @Column(name = "GOODS")
    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return id == that.id &&
                idworker == that.idworker &&
                Objects.equals(goods, that.goods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idworker, goods);
    }
}
