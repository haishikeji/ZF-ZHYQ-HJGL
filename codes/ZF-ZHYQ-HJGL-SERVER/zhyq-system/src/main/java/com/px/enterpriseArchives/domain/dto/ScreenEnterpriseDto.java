package com.px.enterpriseArchives.domain.dto;

import java.util.List;

public class ScreenEnterpriseDto {
    private String delFlag;
    private String enterpriseName;
    private String onlineMonitoringFacility;
    private String  pollutionSourceTypeList;
    private List<String> involvePollutionList;

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getPollutionSourceTypeList() {
        return pollutionSourceTypeList;
    }

    public void setPollutionSourceTypeList(String pollutionSourceTypeList) {
        this.pollutionSourceTypeList = pollutionSourceTypeList;
    }

    public List<String> getInvolvePollutionList() {
        return involvePollutionList;
    }

    public void setInvolvePollutionList(List<String> involvePollutionList) {
        this.involvePollutionList = involvePollutionList;
    }

    public String getOnlineMonitoringFacility() {
        return onlineMonitoringFacility;
    }

    public void setOnlineMonitoringFacility(String onlineMonitoringFacility) {
        this.onlineMonitoringFacility = onlineMonitoringFacility;
    }


    @Override
    public String toString() {
        return "screenEnterpriseDto{" +
                "delFlag='" + delFlag + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", onlineMonitoringFacility=" + onlineMonitoringFacility +
                ", pollutionSourceTypeList=" + pollutionSourceTypeList +
                ", involvePollutionList=" + involvePollutionList +
                '}';
    }
}
