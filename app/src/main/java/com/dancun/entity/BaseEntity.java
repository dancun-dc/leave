package com.dancun.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class BaseEntity implements Serializable {
    private static String schoolName;
    private static String startDate;
    private static String endDate;
    private static String leaveType;
    private static String leaveCause;
    private static String carbon;
    private static String carbon2;
    private static String carbon3;
    private static String local;
    private static String tel;
    private static String name;
    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        BaseEntity.name = name;
    }

    public static String getSchoolName() {
        return schoolName;
    }

    public static void setSchoolName(String schoolName) {
        BaseEntity.schoolName = schoolName;
    }

    public static String getStartDate() {
        return startDate;
    }

    public static void setStartDate(String startDate) {
        BaseEntity.startDate = startDate;
    }

    public static String getEndDate() {
        return endDate;
    }

    public static void setEndDate(String endDate) {
        BaseEntity.endDate = endDate;
    }

    public static String getLeaveType() {
        return leaveType;
    }

    public static void setLeaveType(String leaveType) {
        BaseEntity.leaveType = leaveType;
    }

    public static String getLeaveCause() {
        return leaveCause;
    }

    public static void setLeaveCause(String leaveCause) {
        BaseEntity.leaveCause = leaveCause;
    }

    public static String getCarbon() {
        return carbon;
    }

    public static void setCarbon(String carbon) {
        BaseEntity.carbon = carbon;
    }

    public static String getLocal() {
        return local;
    }

    public static void setLocal(String local) {
        BaseEntity.local = local;
    }

    public static String getTel() {
        return tel;
    }

    public static void setTel(String tel) {
        BaseEntity.tel = tel;
    }

    public static String getCarbon2() {
        return carbon2;
    }

    public static void setCarbon2(String carbon2) {
        BaseEntity.carbon2 = carbon2;
    }

    public static String getCarbon3() {
        return carbon3;
    }

    public static void setCarbon3(String carbon3) {
        BaseEntity.carbon3 = carbon3;
    }
}
