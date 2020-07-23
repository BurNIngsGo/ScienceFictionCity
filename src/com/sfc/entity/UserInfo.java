package com.sfc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sfc.dao.EntityClass;

/**
 * 用户信息类
 */
public class UserInfo implements EntityClass<UserInfo> {
    private int uId;            //用户编号

    private String uName;       //姓名

    private int uSex;           //性别

    private String uEmail;      //邮箱

    private String uCard;       //身份证号

    private String uPhone;      //电话号码

    private String uPwd;        //密码

    private String uHeadImg;    //头像

    private int uLv;            //等级

    private int uMember;        //会员编号

    private int uPost;          //用户角色

    public int getuEmpirical() {
        return uEmpirical;
    }

    public void setuEmpirical(int uEmpirical) {
        this.uEmpirical = uEmpirical;
    }

    private int uEmpirical;     //等级经验

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getuSex() {
        return uSex;
    }

    public void setuSex(int uSex) {
        this.uSex = uSex;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuCard() {
        return uCard;
    }

    public void setuCard(String uCard) {
        this.uCard = uCard;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuHeadImg() {
        return uHeadImg;
    }

    public void setuHeadImg(String uHeadImg) {
        this.uHeadImg = uHeadImg;
    }

    public int getuLv() {
        return uLv;
    }

    public void setuLv(int uLv) {
        this.uLv = uLv;
    }

    public int getuMember() {
        return uMember;
    }

    public void setuMember(int uMember) {
        this.uMember = uMember;
    }

    public int getuPost() {
        return uPost;
    }

    public void setuPost(int uPost) {
        this.uPost = uPost;
    }

    @Override
    @JSONField(serialize = false)
    public UserInfo getNew() {
        return new UserInfo();
    }
}
