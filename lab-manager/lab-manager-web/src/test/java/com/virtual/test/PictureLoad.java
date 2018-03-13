package com.virtual.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import com.virtual.lab.common.utils.FtpUtil;

public class PictureLoad{
	
	public static void main(String[] args) throws Exception{
		String str = "D:\\upload\\xiao.jpg";
		String path = str.replaceAll("\\\\", "/");
		FileInputStream fis = new FileInputStream(new File(path));
		FtpUtil.uploadFile("120.79.52.130", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images", "/2017/08/06", "hello.jpg", fis);
		System.out.println("上传成功");
	}
}
