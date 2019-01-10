package com.im.bean;

import com.fasterxml.jackson.databind.node.DoubleNode;

/**
 * 分级分项统计实体类
 * Created by tss on 2019/1/4.
 */
public class GradeSubentry {

    private String collectorName;   //集中器名称

    private String collectorCode;   //集中器Code

    private Double power;   //动力

    private Double lighting;    //照明

    private Double airConditioner;  //空调

    private Double airPressure; //空压

    private Double elevator;    //电梯

    private Double live;    //生活

    private Double special; //特殊

    private Double comprehensive;   //综合能耗

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getCollectorCode() {
        return collectorCode;
    }

    public void setCollectorCode(String collectorCode) {
        this.collectorCode = collectorCode;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Double getLighting() {
        return lighting;
    }

    public void setLighting(Double lighting) {
        this.lighting = lighting;
    }

    public Double getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(Double airConditioner) {
        this.airConditioner = airConditioner;
    }

    public Double getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(Double airPressure) {
        this.airPressure = airPressure;
    }

    public Double getElevator() {
        return elevator;
    }

    public void setElevator(Double elevator) {
        this.elevator = elevator;
    }

    public Double getLive() {
        return live;
    }

    public void setLive(Double live) {
        this.live = live;
    }

    public Double getSpecial() {
        return special;
    }

    public void setSpecial(Double special) {
        this.special = special;
    }

    public Double getComprehensive() {
        return comprehensive;
    }

    public void setComprehensive(Double comprehensive) {
        this.comprehensive = comprehensive;
    }
}
