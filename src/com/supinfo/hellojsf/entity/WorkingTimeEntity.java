package com.supinfo.hellojsf.entity;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */
@Entity
@Table(name = "working_time", schema = "", catalog = "hellojsf")
public class WorkingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
    private ClientEntity client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkingTimeEntity that = (WorkingTimeEntity) o;

        if (id != that.id) return false;
        if (beginDate != null ? !beginDate.equals(that.beginDate) : that.beginDate != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }
}
