package com.virtual.lab.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.virtual.lab.common.pojo.EasyUIDataGridResult;
import com.virtual.lab.controller.utils.UploadUtil;
import com.virtual.lab.pojo.TbUser;
import com.virtual.lab.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 上传头像
	 * @param userid
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "{userid}/upload")
	public String upload(@PathVariable("userid") String userid, MultipartFile file,
			HttpServletRequest request, UploadUtil uploadUtil,RedirectAttributes attributes){
		String fileurl = uploadUtil.upload(request, "upload", userid);
		TbUser user = userService.selectUserByUsername(userid);
		user.setProfilehead(fileurl);
		boolean flag = userService.update(user);
		if(flag){
			attributes.addFlashAttribute("message", "["+userid+"]头像更新成功!");
		}else{
			attributes.addFlashAttribute("error", "["+userid+"]头像更新失败!");
		}
		return "redirect:/upload-head";
	}
	
	/**
	 * 获取头像
	 */
	@RequestMapping(value = "{userid}/head")
	public void head(@PathVariable("userid") String userid, HttpServletRequest request, HttpServletResponse response){
        try {
        	TbUser user = userService.selectUserByUsername(userid);
    		String path = user.getProfilehead();
    		String rootPath = request.getSession().getServletContext().getRealPath("/");
            String picturePath = rootPath + path;
            response.setContentType("image/jpeg; charset=UTF-8");
			ServletOutputStream outputStream = response.getOutputStream();
			FileInputStream inputStream = new FileInputStream(picturePath);
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, i);
            }
			outputStream.flush();
            outputStream.close();
            inputStream.close();
            outputStream = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 分页查询用户信息
	 */
	@RequestMapping("/userController_pageQuery")
	@ResponseBody
	public EasyUIDataGridResult pageQuery(int page, int rows){
		EasyUIDataGridResult result = userService.getUserList(page, rows);
		return result;
	}
	
	/**
	 * 添加一个用户对应的角色信息
	 */
	@RequestMapping("/userController_add")
	public String editUser(TbUser user, String roleIds){
		
		userService.saveUserAndRole(user, roleIds);
		
		//修改完，跳到列表页面
		return "/userlist";
	}
}
