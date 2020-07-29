package com.sfc.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Upload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String uploadFileName = ""; //上传的文件名
        String fieldName = "";  //表单字段元素的name属性值
        //请求信息中的内容是否是multipart类型
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        //上传文件的存储路径（服务器文件系统上的绝对文件路径）
        String path = "userImg";//上传图片目录名
        String uploadFilePath = "/ScienceFictionCity/image";
        //创建临时文件目录路径
        File tempPatchFile=new File("d:\\temp\\buffer\\");
        if(!tempPatchFile.exists())  //判断文件或目录是否存在
            tempPatchFile.mkdirs();   //创建指定的目录，包括所有必需但不存在的父目录
        if (isMultipart) {
            DiskFileItemFactory factory=new DiskFileItemFactory();
            //设置缓冲区大小4kb
            factory.setSizeThreshold(1024*4);
            //设置上传文件用到临时文件存放路径
            factory.setRepository(tempPatchFile);
            // ServletFileUpload类用于实现文件上传操作
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置单个文件的最大限制  500kb
            upload.setSizeMax(1024*500);
            List<FileItem> items = null;
            boolean flag = false;
            try {
                //解析form表单中所有文件
                items = upload.parseRequest(req);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {   //依次处理每个文件
                    FileItem item = (FileItem) iter.next();
                    if (!item.isFormField()){  //文件表单字段
                        String fileName = item.getName();
                        //通过Arrays类的asList()方法创建固定长度的集合
                        List<String> filType= Arrays.asList("gif","bmp","jpg");
                        String ext=fileName.substring(fileName.lastIndexOf(".")+1);
                        if(!filType.contains(ext))  //判断文件类型是否在允许范围内
                            out.print("上传失败，文件类型只能是gif、bmp、jpg");
                        else{
                            if (fileName != null && !fileName.equals("")) {
                                File fullFile = new File(item.getName());
                                File saveFile = new File(uploadFilePath, fullFile.getName());
                                item.write(saveFile);
                                uploadFileName = fullFile.getName();
                                //String strPath = uploadFilePath+"\\"+uploadFileName;
                                String strPath ="userImg/"+uploadFileName;//上传到数据库里的路径
                                out.print("上传成功后的文件名是："+uploadFileName+
                                        "，文件大小是："+item.getSize()+"bytes!"+"路径是："+strPath);
                                flag = true;
                            }
                        }
                    }else{
                        fieldName = item.getFieldName();//表单字段的name属性值
                        if (fieldName.equals("user")){
                            //将用户名存到实体类中
                            out.print(item.getString("UTF-8"));
                            //ui.setUserName(item.getString("UTF-8"));
                        }

                    }
                }
                if(flag) {

                }
            }catch(FileUploadBase.SizeLimitExceededException ex){
                out.print("上传失败，文件太大，单个文件的最大限制是："+upload.getSizeMax()+"bytes!");
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        out.close();
    }
}
