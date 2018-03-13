package com.virtual.lab.pojo;

import java.util.Date;

public class TbResportDesc {
    private Long resportId;

    private Date created;

    private Date updated;

    private String resportDesc;

    public Long getResportId() {
        return resportId;
    }

    public void setResportId(Long resportId) {
        this.resportId = resportId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getResportDesc() {
        return resportDesc;
    }

    public void setResportDesc(String resportDesc) {
        this.resportDesc = resportDesc == null ? null : resportDesc.trim();
    }
}