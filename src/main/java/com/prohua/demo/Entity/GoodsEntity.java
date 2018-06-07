package com.prohua.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "goods", schema = "demo", catalog = "")
public class GoodsEntity {
    private int sid;

    public GoodsEntity() {

    }

    public GoodsEntity(int sid) {
        this.sid = sid;
    }

    @Id
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsEntity that = (GoodsEntity) o;
        return sid == that.sid;
    }

    @Override
    public int hashCode() {

        return Objects.hash(sid);
    }
}
