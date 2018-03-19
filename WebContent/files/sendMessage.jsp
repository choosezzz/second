<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目管理系统 by www.eyingda.com</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />

<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>

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
  <form action="sendMessage.do" method="post">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >新建信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="发送" class="button" onclick="alert('发送成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>新建信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					    
					    
					  <tr>
					    <td nowrap align="right" width="11%">消息标题:</td>
					    <td width="27%"><input name='messageTitle' type="text" class="text" style="width:154px" value="" /></td>
				        	
					    <td align="right" width="25%">&nbsp;</td>
					    <td width="37%">&nbsp;</td>
					    </tr>
					    
					    
					    
					  <tr>
					    <td width="11%" align="right" nowrap>接收者:</td>
					    <td colspan="3"><input id="addressee" type="text" class="text" style="width:450px;" size="20" value="" readonly="readonly"/>
					   	<div id="addr_tips" style="text-align:center;position:absolute;width:360px;height:210px;background-color:#cacca1;opacity:0.8; display:none">
					   		<div style="float:right;width:20%">
					   			<input type="button" value="关闭" id="btn_close"/>
					   		</div>
					   		<table width="100%" border="1" id="tab_emp">
					   			<th colspan="2" style="text-align:center">请选择</th>
					   		</table>
					   	</div>
					   	
					   	<script type="text/javascript">
							$(function(){	
								
								$.getJSON("getAddr.do",function(data){
									
									var tab=$("#tab_emp");
									var tr=null;
									for(var i=0;i<data.length;i++){
										if(i%2==0){
											tr=$("<tr width='50%'>");
											tab.append(tr);
										}
										
										var td=$("<td>");
										var check=$("<input type='checkbox' name='rec_empIds'>").val(data[i].empId);
										var spa=$("<span>").html(data[i].empName);	
										tr.append(td);
										td.append(check);
										td.append(spa);
									}
									
									$(":checkbox").click(function(){
										var name=[];
										$("input:checked").each(function(){
											name.push($(this).next().html());
										});
										$("#addressee").val(name.join(","));
									});
								});
								$("#addressee").click(function(){
									$("#addr_tips").slideDown();
								});
								
								$("#btn_close").click(function(){
									$("#addr_tips").slideUp();
								});	
							});										
						</script>
					      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="priority">
							<option selected="selected">==选择==</option>
							<option value="1">低级</option>
							<option value="2">中级</option>
							<option value="3">高级</option>
						</select></td>
					    </tr>
					  
					  <tr>
					    <td  width="11%" nowrap align="right">信息内容:</td>
					    <td colspan="3"><textarea name="messageContent" cols="100" rows="20"></textarea></td>
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
			<input type="submit" name="Submit" value="发送" class="button" onclick="alert('发送成功！');"/>　
			
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