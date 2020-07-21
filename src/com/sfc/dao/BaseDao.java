package com.sfc.dao;

import com.sfc.connpool.BaseDaoUtil;

import com.sfc.impl.ExpandToolDaoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

public class BaseDao {
    public Connection conn;

    public PreparedStatement pstmt;

    public ResultSet rs = null;

    public BaseDao(Connection conn) {
        this.conn = conn;
    }

    public int executeUpdate(String strSql, Object[] param) throws SQLException {
        int resultLine = 0;
        try {
            pstmt = conn.prepareStatement(strSql);
            if(param != null) {
                for(int i = 0; i < (param == null ? 0 : param.length); i++) {
                    pstmt.setObject(i+1, param[i]);
                }
                resultLine = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            BaseDaoUtil.closeAll(null, pstmt, null);
        }
        return resultLine;
    }

    public List<Object> executeQuery(String strSql, Object[] param) throws SQLException {
        List<Object> pList = new ArrayList<Object>();

        try {
            pstmt = conn.prepareStatement(strSql);
            if(pstmt != null) {
                for(int i = 0; i < (param == null ? 0 : param.length); i++) {
                    pstmt.setObject(i+1, param[i]);
                }
                rs = pstmt.executeQuery();
                while(rs.next()) {
                    for(int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        pList.add(rs.getObject(i+1));
                    }
                }
                pList.add(rs.getMetaData().getColumnCount());                      //表列数
                return pList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            BaseDaoUtil.closeAll(this.rs, this.pstmt, null);
        }
        return null;
    }

    /**
     * 封装对实体类的设值以及获取得到数据库数据的数据映射到实体类的操作
     * 返回泛型类型为实体类的的集合
     * 该封装纯属个人尝试，对比较常见的数据库查询起到明显的解耦作用
     * 目前尚未发现bug，可能在性能上要低于其他框架类似操作
     * @author BurNIng
     * @param ec 实体类
     * @param sql sql语句
     * @return 实体类集合
     * @throws SQLException
     */
    public <T>List<T> getEntity(EntityClass<T> ec, Object[] param, String sql) throws SQLException {
        //数据库设置到实体类的映射操作对象（et）
        ExpandToolDao et = new ExpandToolDaoImpl();
        //用来存储返回的实体类集合
        List<T> listInfo = new ArrayList<T>();
        //执行sql查询语句的关键代码
        List<Object> objList = this.executeQuery(sql, param);
        //k用来提取查询数据库得到的实体类集合中的数据集合
        int k = 0;
        //外层循环次数为数据库记录的总行数，从数据库得到的实体类集合的尾端存储数据表的列数
        for(int i = 0; i < objList.size()/(int)objList.get(objList.size()-1); i++) {
            //利用多态的特性获取指定的实体类对象,EntityClass的泛型可指定获取何种类型的对象
            Object obj = ec.getNew();
            //通过newArrayFunc方法获得实体类来对实体类的字段一一映射，对应到数据库的每个匹配的字段
            //从而返回已经通过lambda一一对应的，对Function接口唯一func抽象方法的多次重写的数组序列
            Function[] arrayFun = et.newArrayFunc((T)obj);
            //计算func抽象方法的的重写次数，来为实体类对象的各个字段设值。此循环为数据库的一条记录，也就是对应一个实体类
            for(int j = 0; j < arrayFun.length; j++) {
                //将objList从数据库取出的数据通过被重写的func方法设置到实体类中
                arrayFun[j].func(objList.get(k));
                //k为下一个下标做准备
                k++;
            }
            //将已填充的实体类对象存储到集合之中
            listInfo.add((T)obj);
        }
        //返回集合对象
        return listInfo;
    }
}
