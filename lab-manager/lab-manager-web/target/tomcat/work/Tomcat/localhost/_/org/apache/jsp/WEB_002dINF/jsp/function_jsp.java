/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-09 03:17:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class function_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>权限列表展示页面</title>\r\n");
      out.write("<!-- 导入jquery核心类库 -->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.8.3.js\"></script>\r\n");
      out.write("<!-- 导入easyui类库 -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/portal.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/default.css\">\t\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/jquery.portal.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/jquery.cookie.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/locale/easyui-lang-zh_CN.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"#grid\").datagrid({\r\n");
      out.write("\t\t\ttoolbar : [\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tid : 'add',\r\n");
      out.write("\t\t\t\t\ttext : '添加权限',\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-add',\r\n");
      out.write("\t\t\t\t\thandler : function(){\r\n");
      out.write("\t\t\t\t\t\tlocation.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/function_add';\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},{\r\n");
      out.write("\t\t\t\t\tid : 'delete',\r\n");
      out.write("\t\t\t\t\ttext : '删除权限',\r\n");
      out.write("\t\t\t\t\ticonCls : 'icon-cancel',\r\n");
      out.write("\t\t\t\t\thandler : doDelete\r\n");
      out.write("\t\t\t\t}         \r\n");
      out.write("\t\t\t],\r\n");
      out.write("\t\t\turl : '/functionController_pageQuery',\r\n");
      out.write("\t\t\tpagination : true,//分页条\r\n");
      out.write("\t\t\tfit : true,//撑满\r\n");
      out.write("\t\t\t//为数据表达绑定双击事件\r\n");
      out.write("\t\t\tonDblClickRow : doDblClickRow,\r\n");
      out.write("\t\t\tcolumns : [[\r\n");
      out.write("\t\t\t  {\r\n");
      out.write("\t\t\t\t  field : 'id',\r\n");
      out.write("\t\t\t\t  title : '编号',\r\n");
      out.write("\t\t\t\t  width : 200,\r\n");
      out.write("\t\t\t\t  checkbox:true\r\n");
      out.write("\t\t\t  },\r\n");
      out.write("\t\t\t  {\r\n");
      out.write("\t\t\t\t  field : 'name',\r\n");
      out.write("\t\t\t\t  title : '名称',\r\n");
      out.write("\t\t\t\t  width : 200\r\n");
      out.write("\t\t\t  },  \r\n");
      out.write("\t\t\t  {\r\n");
      out.write("\t\t\t\t  field : 'description',\r\n");
      out.write("\t\t\t\t  title : '描述',\r\n");
      out.write("\t\t\t\t  width : 500\r\n");
      out.write("\t\t\t  },  \r\n");
      out.write("\t\t\t  {\r\n");
      out.write("\t\t\t\t  field : 'generatemenu',\r\n");
      out.write("\t\t\t\t  title : '是否生成菜单',\r\n");
      out.write("\t\t\t\t  width : 50,\r\n");
      out.write("\t\t\t\t  formatter : function(data, row, index){\r\n");
      out.write("\t\t\t\t\t  if(data == \"1\"){\r\n");
      out.write("\t\t\t\t\t\t  return \"是\";\r\n");
      out.write("\t\t\t\t\t  }else{\r\n");
      out.write("\t\t\t\t\t\t  return \"否\";\r\n");
      out.write("\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t  },  \r\n");
      out.write("\t\t\t  {\r\n");
      out.write("\t\t\t\t  field : 'zindex',\r\n");
      out.write("\t\t\t\t  title : '优先级',\r\n");
      out.write("\t\t\t\t  width : 50\r\n");
      out.write("\t\t\t  },  \r\n");
      out.write("\t\t\t  {\r\n");
      out.write("\t\t\t\t  field : 'page',\r\n");
      out.write("\t\t\t\t  title : '路径',\r\n");
      out.write("\t\t\t\t  width : 200\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t\t]]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 修改取派员窗口\r\n");
      out.write("\t\t$('#editFunctionWindow').window({\r\n");
      out.write("\t        title: '修改权限数据',\r\n");
      out.write("\t        width: 800,\r\n");
      out.write("\t        modal: true,//遮罩效果\r\n");
      out.write("\t        shadow: true,//阴影效果\r\n");
      out.write("\t        closed: true,//默认关闭\r\n");
      out.write("\t        height: 600,\r\n");
      out.write("\t        resizable:false\r\n");
      out.write("\t    });\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//数据表格绑定的双击事件对应的函数\r\n");
      out.write("\tfunction doDblClickRow(rowIndex, rowData){\r\n");
      out.write("\t\t//alert(\"双击数据表格\");\r\n");
      out.write("\t\t//打开修改权限的窗口\r\n");
      out.write("\t\t$('#editFunctionWindow').window(\"open\");\r\n");
      out.write("\t\t//使用form表单对象的load方法回显数据\r\n");
      out.write("\t\t$('#editFunctionForm').form(\"load\",rowData);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//删除操作的js代码\r\n");
      out.write("\tfunction doDelete(){\r\n");
      out.write("\t\tvar items = $('#grid').datagrid('getSelections');\r\n");
      out.write("\t\tif(items.length > 0){\r\n");
      out.write("\t\t\t$.messager.confirm(\"提示窗口\", \"是否确认删除\", function(r){\r\n");
      out.write("\t\t\t\tif(r){\r\n");
      out.write("\t\t\t\t\tvar arr = new Array();\r\n");
      out.write("\t\t\t\t\tfor(var i=0; i<items.length; i++){\r\n");
      out.write("\t\t\t\t\t\tarr.push(items[i].id);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar ids=arr.join(\",\");\r\n");
      out.write("                    $.post(\"/functionController_delete\",{ids:ids},function(data){\r\n");
      out.write("                        $('#grid').datagrid('reload');\r\n");
      out.write("                    });\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$.messager.alert(\"提示信息\", \"请选择数据\", \"warning\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\t\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\">\r\n");
      out.write("\t<div data-options=\"region:'center'\">\r\n");
      out.write("\t\t<table id=\"grid\"></table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 修改权限管理窗口 -->\r\n");
      out.write("\t<div class=\"easyui-window\" title=\"对权限进行修改\" id=\"editFunctionWindow\" collapsible=\"false\" \r\n");
      out.write("\t\tminimizable=\"false\" maximizable=\"false\" style=\"top:20px;left:200px\">\r\n");
      out.write("\t\t<div region=\"north\" style=\"height:31px;overflow:hidden;\" split=\"false\" border=\"false\" >\r\n");
      out.write("\t\t\t<div class=\"datagrid-toolbar\">\r\n");
      out.write("\t\t\t\t<a id=\"edit\" icon=\"icon-edit\" href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" >修改保存</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div region=\"center\" style=\"overflow:auto;padding:5px;\" border=\"false\">\r\n");
      out.write("\t\t\t<form id=\"editFunctionForm\" action=\"/userController_edit\" method=\"post\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"id\">\r\n");
      out.write("\t\t\t\t<table class=\"table-edit\" width=\"80%\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<tr class=\"title\">\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">功能权限信息</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"200\">关键字</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"code\" class=\"easyui-validatebox\" data-options=\"required:true\" />\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>名称</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"name\" class=\"easyui-validatebox\" data-options=\"required:true\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>访问路径</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"page\"  /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>是否生成菜单</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"generatemenu\" class=\"easyui-combobox\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"0\">不生成</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"1\">生成</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>优先级</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"zindex\" class=\"easyui-numberbox\" data-options=\"required:true\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>父功能点</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"pid\" class=\"easyui-combobox\" data-options=\"valueField:'id',textField:'name',url:'/functionController_listajax'\"/>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>描述</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<textarea name=\"description\" rows=\"4\" cols=\"60\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t//为保存按钮绑定事件\r\n");
      out.write("\t\t\t$(\"#edit\").click(function(){\r\n");
      out.write("\t\t\t\t//表单校验，如果通过，提交表单\r\n");
      out.write(" \t\t\t\tvar v = $(\"#editFunctionForm\").form(\"validate\");\r\n");
      out.write("\t\t\t\tif(v){\r\n");
      out.write("\t\t\t\t\t$(\"#editFunctionForm\").submit();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}