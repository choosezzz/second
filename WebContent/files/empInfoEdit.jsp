<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目管理系统 by www.eyingda.com</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />

<script src="js/jquery-1.9.1.min.js"></script>
<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="" method="post" action="empInfoEdit.do" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >员工基本信息录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="submit" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
				<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>员工信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="15%">员工唯一编号:</td>
					    <td width="35%"><input name='empId' type="text" class="text" style="width:154px" value="${emp.empId }" readonly="readonly" />
				        <span class="red">*</span></td>
					    <td width="16%" align="right" nowrap="nowrap">密码:</td>
					    <td width="34%"><input class="text" name='password' style="width:154px" value="${emp.password }"></td>
					  </tr>
					    
					    
					  <tr>
					    <td nowrap="nowrap" align="right">真实姓名:</td>
					    <td><input class="text" name='empName' style="width:154px" value="${emp.empName }"/></td>
					    <td align="right">性别:</td>
					    <script>						   
							if('${emp.sex}'=="男"){								
						    	$("#man").attr("selected",true);
						    }else{
						    	$("#woman").attr("selected",true);
						    }						
					    </script>
					    <td><select name="sex" >               
                            <option value="男" id="man">男</option>
                            <option value="女" id="woman">女</option>
                        </select></td>
					  </tr>
					  
					  
					  <tr>
					    <td align="right">出生日期:</td>
					    <td><input class="text" name='birth' style="width:154px" value="<fmt:formatDate value='${emp.birth }' pattern='yyyy-MM-dd'/>"/></td>
					    <td align="right">身份证号码:</td>
					    <td><input class="text" name='idCard' style="width:154px" value="${emp.idCard }"/></td>
					  </tr>
					  <tr>
					    <td align="right">电子邮箱:</td>
					    <td><input class="text" name='email' style="width:154px" value="${emp.email }"/></td>
					    <td align="right">电话号码:</td>
					    <td><input class="text" name='tel' style="width:154px" value="${emp.tel }"/></td>
					  </tr>
					  <tr>
					    <td align="right">居住地址:</td>
					    <td><input name="address" type="text" size="30" value="${emp.address }"/>                        </td>
					    <td align="right">职位:</td>
					    <td><select name="dutyId" >
                         <script>                      
                           	if('${emp.dutyId}'=="1"){
                           		$("#cxy").attr("selected",true);
                           	}else if('${emp.dutyId}'=="2"){
                           		$("#xmjl").attr("selected",true);
                           	}else{
                           		$("#zs").attr("selected",true);
                           	}
                           	
                           	</script>
                          <option value="1" id="cxy">程序员</option>
                          <option value="2" id="xmjl">项目经理</option>
                          <option value="3" id="jl">经理</option>
                        </select></td>
					  </tr>
					  <tr>
					    <td align="right">员工类型:</td>
					    <script>                         
                           	if('${emp.empType}'=="实习"){
                           		$("#sx").attr("selected",true);
                           	}else if('${emp.empType}'=="试用"){
                           		$("#sy").attr("selected",true);
                           	}else{
                           		alert("dddddddddddddd")
                           		$("#zs").prop("selected",true);
                           	}
                           	
                          </script>
					    <td><select name="empType" id="type_emp" >
                           	
                            <option value="实习" id="sx">实习</option>
                            <option value="试用" id="sy">试用</option>
                            <option value="正式员工" id="zs">正式员工</option>
                        </select></td>
					    <td align="right">银行名称:</td>
					    <td><input class="text" name='bankName' style="width:154px" value="${emp.bankName }"/></td>
					  </tr>
					  <tr>
					    <td align="right">银行账户:</td>
					    <td><input class="text" name='bankNo' style="width:154px" value="${emp.bankNo }"/></td>
					    <td align="right">基本工资:</td>
					    <td><input class="text" name='sal' style="width:154px" value="${emp.sal }"/></td>
					  </tr>
					  <tr>
					    <td align="right">奖金:</td>
					    <td><input class="text" name='comm' style="width:154px" value="${emp.comm }"/></td>
					    <td align="right">其它补助金:</td>
					    <td><input class="text" name='subsidy' style="width:154px" value="${emp.subsidy }"/></td>
					  </tr>
					  <tr>
					    <td align="right">入职时间:</td>
					    <td><input class="text" name='datehireDate' style="width:154px" value="${emp.hireDate }"/></td>
					    <td align="right">&nbsp;</td>
					    <td>&nbsp;</td>
					  </tr>
					 
					  <tr>
					    <td align="right">描述:</td>
					    <td colspan="3"><textarea name="descript" cols="100" rows="8">${emp.descript }</textarea></td>
					    </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		

		
		
		
		</TABLE>
	
	
	 </td>
  </tr>
  
  
		
		
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>

</div>
</form>
</body>
</html>
