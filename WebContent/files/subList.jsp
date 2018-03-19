<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- 跳转指定页数 -->
                  	<script src="../js/jquery-1.9.1.min.js"></script>
                      <script>
                      		$(function(){
                      			$(".right-button06").click(function(){
                          			var value=$("#btn_page").val();
                          			
                          			//正则表达式匹配数字
                          			var p=/^[1-9][0-9]*$/;
                          			if(p.test(value)){
                          				if(value>0 && value<=${info.pageCount}){
                          					window.open("${uri}?currentPage="+value,"_self");
                          				}else{
                          					alert("页数不在合法范围");
                          					$("#btn_page").val("");
                          				}
                          			}else{
                          				alert("非法页数");
                          				$("#btn_page").val("");
                          			}
                          		});
                      		});
                      </script>
                    </tr>
          <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
              <td width="3%"></td>
                <td width="48%">第 <span class="right-text09">${info.currentPage}</span> 页|共 <span class="right-text09">${info.pageCount}</span> 页</td> 
                <td width="40%" align="right">[<a href="${uri}?currentPage=1" class="right-font08">首页</a> | 
                <!-- 判断当前页是否为首页，首页则没有前一页选项 -->
                <c:if test="${info.currentPage>1 }">
                	<a href="${uri}?currentPage=${info.currentPage-1}" class="right-font08">上一页</a>| 
                </c:if>
                 <!-- 判断当前页是否为末页，末页则没有下一页选项 -->
               	<c:if test="${info.currentPage<info.pageCount }">
               		<a href="${uri}?currentPage=${info.currentPage+1}" class="right-font08">下一页</a> |
               	</c:if>
                <a href="${uri}?currentPage=${info.pageCount}" class="right-font08">末页</a>] 转至：</td>
                <td width="8%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input id="btn_page" name="textfield3" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input  type="button" class="right-button06" value=" " />
                      </td>
                      <td width="12%"></td>
                </table></td>
              </tr>
          </table>