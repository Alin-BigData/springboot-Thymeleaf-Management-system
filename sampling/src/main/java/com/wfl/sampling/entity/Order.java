package com.wfl.sampling.entity;

import java.util.Date;

public class Order extends BaseObject{
    /**
     * 与数据库一一对应
     * 驼峰命名方法
     * 以包装类型 才好做非空校验
     * CREATE TABLE `tb_order`(
     * 	`id` int(20) NOT NULL AUTO_INCREMENT,
     * 	`order_id` varchar(50) NOT NULL,
     * 	`user_name` varchar(20) NOT NULL,
     * 	`sex` char(1) NOT NULL,
     * 	`phone_num` varchar(20) NOT NULL,
     * 	`birthday` datetime DEFAULT NULL,
     * 	`email` char(50) DEFAULT NULL,
     * 	`region` char(20) NOT NULL,
     * 	`location` char(100) NOT NULL,
     * 	`paper_status` int(1)  DEFAULT NULL COMMENT '0：否\n1：是',
     * 	`project_type` int(1) DEFAULT NULL COMMENT '0：类型0\n1：类型1',
     * 	`pay_status` int(1)  DEFAULT NULL COMMENT '0：未支付\n1：已支付',
     * 	`sms_num` char(4) DEFAULT NULL,
     * 	`sms_status` int(1) DEFAULT NULL COMMENT '0：未发送\n1：已发送',
     * 	`sms_time` datetime DEFAULT NULL,
     * 	`create_time` datetime DEFAULT NULL,
     * 	`handle_status` int(1) DEFAULT NULL COMMENT '0：待处理\n1：处理中\n3：已处理\n4:已作废',
     * 	`handle_time` datetime DEFAULT NULL,
     * 	`remarks_msg` varchar(50) DEFAULT NULL,
     * 	`src_address` varchar(50) DEFAULT NULL,
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
     */
    private Integer id;
    private String orderId;
    private String userName;
    //sex 0 表示女性 1 表示男性
    private String sex;
    private Date birthday;
    private String email;
    private String region;
    private String location;
    private String phoneNum;

    // 0 表示不用纸质  1 表示需要 纸质
    private Integer paperStatus;
    //projectType 用0 1 2 3代表不同的类别
    private Integer projectType;

    // 0 表示未支付  1 表示已支付
    private Integer payStatus;
    private String smsNum;
    // 0 未发送 1 已发送
    private Integer smsStatus;
    private Date smsTime;
    private Date createTime;
    private Integer handleStatus;
    private Date handleTime;
    private String srcAddress;

    private Date startTime;
    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(Integer paperStatus) {
        this.paperStatus = paperStatus;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getSmsNum() {
        return smsNum;
    }

    public void setSmsNum(String smsNum) {
        this.smsNum = smsNum;
    }

    public Integer getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(Integer smsStatus) {
        this.smsStatus = smsStatus;
    }

    public Date getSmsTime() {
        return smsTime;
    }

    public void setSmsTime(Date smsTime) {
        this.smsTime = smsTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getHandleStatus() {
        return handleStatus;
    }

    public void setHandleStatus(Integer handleStatus) {
        this.handleStatus = handleStatus;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getSrcAddress() {
        return srcAddress;
    }

    public void setSrcAddress(String srcAddress) {
        this.srcAddress = srcAddress;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", region='" + region + '\'' +
                ", location='" + location + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", paperStatus=" + paperStatus +
                ", projectType=" + projectType +
                ", payStatus=" + payStatus +
                ", smsNum='" + smsNum + '\'' +
                ", smsStatus=" + smsStatus +
                ", smsTime=" + smsTime +
                ", createTime=" + createTime +
                ", handleStatus=" + handleStatus +
                ", handleTime=" + handleTime +
                ", srcAddress='" + srcAddress + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
