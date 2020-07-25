package com.sfc.impl;

import com.sfc.dao.ExpandToolDao;
import com.sfc.dao.Function;
import com.sfc.entity.*;

import java.util.Date;

public class ExpandToolDaoImpl implements ExpandToolDao {

    @Override
    public Function[] newArrayFunc(Object stu) {
        Function[] arrayFun = null;
        if(stu instanceof AddressInfo){
            arrayFun = new Function[]{
                    (param)->((AddressInfo)stu).setAid((int)param),
                    (param)->((AddressInfo)stu).setaAddress((String)param),
                    (param)->((AddressInfo)stu).setaPhone((String)param),
                    (param)->((AddressInfo)stu).setaCode((String)param),
                    (param)->((AddressInfo)stu).setaUid((int)param)
            };
        } else if(stu instanceof BookEva) {
            arrayFun = new Function[]{
                    (param)->((BookEva)stu).setBeId((int)param),
                    (param)->((BookEva)stu).setBkStar((int) param),
                    (param)->((BookEva)stu).setBkEva((String)param),
                    (param)->((BookEva)stu).setuId((int) param),
                    (param)->((BookEva)stu).setBkLuad((int) param),
                    (param)->((BookEva)stu).setbId((int) param)
            };
        } else if(stu instanceof BookInfo) {
            arrayFun = new Function[]{
                    (param)->((BookInfo)stu).setbId((int)param),
                    (param)->((BookInfo)stu).setbName((String)param),
                    (param)->((BookInfo)stu).setbType((int)param),
                    (param)->((BookInfo)stu).setbPress((int) param),
                    (param)->((BookInfo)stu).setbAuthor((String)param),
                    (param)->((BookInfo)stu).setbPrice(Double.parseDouble(param.toString())),
                    (param)->((BookInfo)stu).setbPresent((String)param),
                    (param)->((BookInfo)stu).setbImg((String)param),
                    (param)->((BookInfo)stu).setbSales((int)param),
                    (param)->((BookInfo)stu).setbTime((Date)param),
                    (param)->((BookInfo)stu).setbCount((int)param),
                    (param)->((BookInfo)stu).setbContent((String)param)
            };
        } else if(stu instanceof BookType) {
            arrayFun = new Function[]{
                    (param)->((BookType)stu).settId((int)param),
                    (param)->((BookType)stu).settName((String)param)
            };
        } else if(stu instanceof ChatInfo) {
            arrayFun = new Function[]{
                    (param)->((ChatInfo)stu).setuId((int)param),
                    (param)->((ChatInfo)stu).setfId((int)param),
                    (param)->((ChatInfo)stu).setcContent((String)param),
                    (param)->((ChatInfo)stu).setDate((Date)param)
            };
        } else if(stu instanceof FriendRelation) {
            arrayFun = new Function[]{
                    (param)->((FriendRelation)stu).setuId((int)param),
                    (param)->((FriendRelation)stu).setuId((int)param)
            };
        } else if(stu instanceof ManageEva) {
            arrayFun = new Function[]{
                    (param)->((ManageEva)stu).setBeId((int)param),
                    (param)->((ManageEva)stu).setSupId((int)param)
            };
        } else if(stu instanceof MemberInfo) {
            arrayFun = new Function[]{
                    (param)->((MemberInfo)stu).setMid((int)param),
                    (param)->((MemberInfo)stu).setmDate((Date)param),
                    (param)->((MemberInfo)stu).setmEDate((Date)param)
            };
        } else if(stu instanceof OrderDetailed) {
            arrayFun = new Function[]{
                    (param)->((OrderDetailed)stu).setOid((int)param),
                    (param)->((OrderDetailed)stu).setoRderNo((String)param),
                    (param)->((OrderDetailed)stu).setoCount((int)param),
                    (param)->((OrderDetailed)stu).setOid((int)param),
                    (param)->((OrderDetailed)stu).setoPrice((int)param),
                    (param)->((OrderDetailed)stu).setoBookName((String)param)
            };
        } else if(stu instanceof OrderMain) {
            arrayFun = new Function[]{
                    (param)->((OrderMain)stu).setUid((int)param),
                    (param)->((OrderMain)stu).setOid((int)param),
                    (param)->((OrderMain)stu).setoMoney((double)param),
                    (param)->((OrderMain)stu).setAid((int)param),
                    (param)->((OrderMain)stu).setoTime((Date)param),
                    (param)->((OrderMain)stu).setoDone((int)param)
            };
        } else if(stu instanceof Press) {
            arrayFun = new Function[]{
                    (param)->((Press)stu).setPrId((int)param),
                    (param)->((Press)stu).setPrName((String)param)
            };
        } else if(stu instanceof ShoppingCart) {
            arrayFun = new Function[]{
                    (param)->((ShoppingCart)stu).setShId((int)param),
                    (param)->((ShoppingCart)stu).setbId((int)param),
                    (param)->((ShoppingCart)stu).setShDate((Date)param),
                    (param)->((ShoppingCart)stu).setuId((int)param),
                    (param)->((ShoppingCart)stu).setShCount((int)param)
            };
        } else if(stu instanceof Store) {
            arrayFun = new Function[]{
                    (param)->((Store)stu).setsId((int)param),
                    (param)->((Store)stu).setbId((int)param),
                    (param)->((Store)stu).setsDate((Date)param),
                    (param)->((Store)stu).setuId((int)param)
            };
        } else if(stu instanceof UserInfo) {
            arrayFun = new Function[]{
                    (param)->((UserInfo)stu).setuId((int)param),
                    (param)->((UserInfo)stu).setuName((String)param),
                    (param)->((UserInfo)stu).setuSex((int)param),
                    (param)->((UserInfo)stu).setuEmail((String)param),
                    (param)->((UserInfo)stu).setuCard((String)param),
                    (param)->((UserInfo)stu).setuPhone((String)param),
                    (param)->((UserInfo)stu).setuPwd((String)param),
                    (param)->((UserInfo)stu).setuHeadImg((String)param),
                    (param)->((UserInfo)stu).setuLv((int)param),
                    (param)->((UserInfo)stu).setuMember((param == null) ? 0 : (int)param),
                    (param)->((UserInfo)stu).setuPost((int)param),
                    (param)->((UserInfo)stu).setuEmpirical((int)param)

            };
        } else{
            return null;
        }
        return arrayFun;
    }
}