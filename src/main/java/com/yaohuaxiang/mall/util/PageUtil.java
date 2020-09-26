package com.yaohuaxiang.mall.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaohuaxiang.mall.bean.User;

public class PageUtil<T> {
	
	/*
		首页 上一页 1 2 3 4 5 下一页 末页
		PageHelper.startPage(pageNum,num);pageNum表示从那一页开始，num表示一页的数据条数
		PageInfo<User> pageInfo = new PageInfo<User>(users,usernum);usernum表示显示的页码数有几个
		String info = pageUtil.getPageInfo(pageInfo, request,"users");
		model.addAttribute("users",users);
		model.addAttribute("pageInfo",info);
		return "userlist";

	example：
		 @RequestMapping("manage/{pageNum}")
    public String manage(Model model , HttpServletRequest httpServletRequest,@PathVariable("pageNum") Integer pageNum){
        PageUtil<User> pageUtil = new PageUtil<>();
        PageHelper.startPage(pageNum,2);
        List<User> userList = manageService.getAllUser();

        PageInfo<User> pageInfo = new PageInfo<>(userList,2);
        String info = pageUtil.getPageInfo(pageInfo, httpServletRequest, "manage");projectName与@RequestMapping("manage/{pageNum}")中一样
        model.addAttribute("userlist",userList);
        model.addAttribute("pageInfo",info);
        return "manage_index";
    }
	 */
	public String getPageInfo(PageInfo<T> pageInfo,HttpServletRequest request,String projectName) {
		StringBuilder result= new StringBuilder();
		String path = request.getContextPath()+"/";
		//拼接首页
		result.append("<a href=' "+path+projectName+"/1'>首页</a>");
		//拼接上一页
		if(pageInfo.isHasPreviousPage()) {
			result.append("<a href=' "+path+projectName+"/"+pageInfo.getPrePage()+"'>上一页</a>");
		}else {
			result.append("上一页");
		}
		//拼接页码
		int[] nums = pageInfo.getNavigatepageNums();
		for (int i : nums) {
			if(i==pageInfo.getPageNum()) {
				result.append("<a href=' "+path+projectName+"/"+i+"'>"+"<font color='red'>"+i+"</font></a>");
			}else {
				result.append("<a href=' "+path+projectName+"/"+i+"'>"+i+"</a>");
			}
		}
		//拼接下一页
		if(pageInfo.isHasNextPage()) {
			result.append("<a href=' "+path+projectName+"/"+pageInfo.getNextPage()+"'>下一页</a>");
		}else {
			result.append("下一页");
		}
		//拼接尾页
		result.append("<a href=' "+path+projectName+"/"+pageInfo.getPages()+"'>尾页</a>");
		return result.toString();
	}
	
	
	
}
