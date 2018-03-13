package com.virtual.lab.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.shiro.web.session.HttpServletSession;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.common.utils.E3Result;
import com.virtual.lab.common.utils.FtpUtil;
import com.virtual.lab.common.utils.IDUtils;
import com.virtual.lab.common.utils.JsonUtils;
import com.virtual.lab.pojo.TbItem;
import com.virtual.lab.pojo.TbResport;
import com.virtual.lab.service.ResportService;


/**
 * 实验报告
 * @author xiaoqiang
 *
 */
@Controller
public class ResportController {
	
	private String FTP_ADDRESS = "120.79.52.130";
	
	private Integer FTP_PORT = 21;
	
	private String FTP_USERNAME = "ftpuser";
	
	private String FTP_PASSWORD = "ftpuser";
	
	private String FTP_BASE_PATH = "/home/ftpuser/www/images";

	private String IMAGE_BASE_URL = "http://120.79.52.130:81/images";
	
	//实验报告表
	@Autowired
	private ResportService resportService;
	
	/**
	 * 图片上传
	 * @param uploadFile
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/pic/upload", produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String fileUpload(MultipartFile uploadFile){
		Map resultMap = new HashMap<>();
		try {
			//生成一个新的文件名
			//取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			//生成新文件名
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			
			//图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
			//返回结果
			if(!result){//上传失败
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
				return JsonUtils.objectToJson(resultMap);
			}
			resultMap.put("error", 0);
			resultMap.put("url", IMAGE_BASE_URL + imagePath + "/" + newName);
			return JsonUtils.objectToJson(resultMap);
		} catch (IOException e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
			return JsonUtils.objectToJson(resultMap);
		}
	}
	
	/**
	 * 添加实验报告
	 */
	@RequestMapping("/resport/save")
	@ResponseBody
	public E3Result saveResport(TbResport resport, String desc){
		//直接调用service层的服务
		E3Result result = resportService.addResport(resport, desc);
		return result;
	}
	
	/**
	 * 老师查询所有的实验报告列表，可以看到所有学生的列表，要进行分页处理
	 */
	@RequestMapping("/resport/list")
	@ResponseBody
	public EasyUIDataGridResult getResportList(int page, int rows){
		EasyUIDataGridResult resportList = resportService.getResportList(page, rows);
		return resportList;
	}
	
	/**
	 * 老师评阅实验报告,更新实验报告
	 * @param item
	 * @param desc
	 * @return
	 */
	@RequestMapping("/rest/resport/update")
	@ResponseBody
	public E3Result teacherEditResport(TbResport resport, String desc){
		//直接调用service层方法
		E3Result result = resportService.editResport(resport, desc);
		return result;
	}
	
	/**
	 * 学生查询自己的实验报告列表，要求只能看到自己提交的文档，看不到别人的
	 */
	@RequestMapping("/resport/yourself/list")
	@ResponseBody
	public EasyUIDataGridResult getStudentResportList(int page, int rows, HttpSession session){
		String username = (String) session.getAttribute("userid");
		EasyUIDataGridResult resporStudenttList = resportService.getStudentResportList(page, rows, username);
		return resporStudenttList;
	}
	
	/**
	 * 学生修改实验报告，只能修改学生提交的部分，无法修改老师的指导评阅
	 */
	@RequestMapping("/student/resport/update")
	@ResponseBody
	public E3Result studentEditResport(TbResport resport, String desc){
		//直接调用service层方法
		E3Result result = resportService.studentEditResport(resport, desc);
		return result;
	}
}
