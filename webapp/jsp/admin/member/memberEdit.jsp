<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>会员 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='memberAction.${actionExt}';    
}
</script>
<style type="text/css">
    body{ font-size:12px;}
    .l-table-edit {}
    .l-table-edit-td{ padding:4px;}
    .l-button-submit,.l-button-reset{width:80px; float:left; margin-left:10px; padding-bottom:2px;}
    .l-verify-tip{ left:230px; top:120px;}
</style>
</head>
<body>
<form name="memberForm" id="memberForm" method="post" action="memberAction!editSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <input type="hidden" id="member.id" name="member.id" value="${requestScope.member.id}"/>
    <tr>
        <td align="right" class="l-table-edit-td">编号：</td>
        <td align="left" class="l-table-edit-td"><input name="member.code" type="text" id="member.code" ltype="text" value="${requestScope.member.code}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">名称：</td>
        <td align="left" class="l-table-edit-td"><input name="member.name" type="text" id="member.name" ltype="text" value="${requestScope.member.name}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">手机：</td>
        <td align="left" class="l-table-edit-td"><input name="member.mobile" type="text" id="member.mobile" ltype="text" value="${requestScope.member.mobile}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">服务中心编号：</td>
        <td align="left" class="l-table-edit-td"><input name="member.servCode" type="text" id="member.servCode" ltype="text" value="${requestScope.member.servCode}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">推荐人编号：</td>
        <td align="left" class="l-table-edit-td"><input name="member.recoCode" type="text" id="member.recoCode" ltype="text" value="${requestScope.member.recoCode}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">管理人编号：</td>
        <td align="left" class="l-table-edit-td"><input name="member.managerCode" type="text" id="member.managerCode" ltype="text" value="${requestScope.member.managerCode}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">位置：</td>
        <td align="left" class="l-table-edit-td">
        <input name="member.area" type="radio" id="member.area" value="A" <c:if test="${requestScope.member.area=='A'}">checked="checked"</c:if>/>A区 
        <input name="member.area" type="radio" id="member.area" value="B" <c:if test="${requestScope.member.area=='B'}">checked="checked"</c:if>/>B区
        </td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">身份证号：</td>
        <td align="left" class="l-table-edit-td"><input name="member.inden" type="text" id="member.inden" ltype="text" value="${requestScope.member.inden}" style="width:300px;"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">银行：</td>
        <td align="left" class="l-table-edit-td">
        <select name="member.bank" id="member.bank">
        <option value="0">未选择</option>
        <option value="1" <c:if test="${requestScope.member.bank==1}">selected="selected"</c:if>>农行</option>
        <option value="2" <c:if test="${requestScope.member.bank==2}">selected="selected"</c:if>>工行</option>
        </select>
        </td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">开户地址：</td>
        <td align="left" class="l-table-edit-td"><input name="member.bankAddr" type="text" id="member.bankAddr" ltype="text" value="${requestScope.member.bankAddr}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">开户名：</td>
        <td align="left" class="l-table-edit-td"><input name="member.bankName" type="text" id="member.bankName" ltype="text" value="${requestScope.member.bankName}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">银行账号：</td>
        <td align="left" class="l-table-edit-td"><input name="member.bankAcco" type="text" id="member.bankAcco" ltype="text" value="${requestScope.member.bankAcco}" style="width:300px;"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">一级密码：</td>
        <td align="left" class="l-table-edit-td"><input name="member.passwd1" type="text" id="member.passwd1" ltype="text" value="${requestScope.member.passwd1}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">二级密码：</td>
        <td align="left" class="l-table-edit-td"><input name="member.passwd2" type="text" id="member.passwd2" ltype="text" value="${requestScope.member.passwd2}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">三级密码：</td>
        <td align="left" class="l-table-edit-td"><input name="member.passwd3" type="text" id="member.passwd3" ltype="text" value="${requestScope.member.passwd3}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">第二联系方式：</td>
        <td align="left" class="l-table-edit-td"><input name="member.mobile2" type="text" id="member.mobile2" ltype="text" value="${requestScope.member.mobile2}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">QQ：</td>
        <td align="left" class="l-table-edit-td"><input name="member.qq" type="text" id="member.qq" ltype="text" value="${requestScope.member.qq}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">邮编：</td>
        <td align="left" class="l-table-edit-td"><input name="member.postCode" type="text" id="member.postCode" ltype="text" value="${requestScope.member.postCode}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">地址：</td>
        <td align="left" class="l-table-edit-td"><input name="member.addr" type="text" id="member.addr" ltype="text" value="${requestScope.member.addr}" style="width:300px;"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">备注：</td>
        <td align="left" class="l-table-edit-td">
        <textarea name="member.remark" id="member.remark" rows="6" cols="10" style="width:80px;width:304px;">${requestScope.member.remark}</textarea>
        </td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">报单币：</td>
        <td align="left" class="l-table-edit-td"><input name="member.taxCoin" type="text" id="member.taxCoin" ltype="text" value="${requestScope.member.taxCoin}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">现金币：</td>
        <td align="left" class="l-table-edit-td"><input name="member.cashCoin" type="text" id="member.cashCoin" ltype="text" value="${requestScope.member.cashCoin}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">电商币：</td>
        <td align="left" class="l-table-edit-td"><input name="member.shopCoin" type="text" id="member.shopCoin" ltype="text" value="${requestScope.member.shopCoin}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">级别：</td>
        <td align="left" class="l-table-edit-td"><input name="member.level" type="text" id="member.level" ltype="text" value="${requestScope.member.level}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">状态：</td>
        <td align="left" class="l-table-edit-td">
        <input name="member.status" type="radio" id="member.status" value="0" <c:if test="${requestScope.member.status==0}">checked="checked"</c:if>/>未审 
        <input name="member.status" type="radio" id="member.status" value="1" <c:if test="${requestScope.member.status==1}">checked="checked"</c:if>/>已审
        </td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">注册人：</td>
        <td align="left" class="l-table-edit-td">${requestScope.member.creator}</td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">注册时间：</td>
        <td align="left" class="l-table-edit-td" ><fmt:formatDate value="${requestScope.member.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="left"></td>
    </tr>
    
    <tr>
    	<td align="center" colspan="3">
    	<input type="submit" value="保存" id="Button1" class="l-button l-button-submit" /> 
	<input type="button" value="取消" class="l-button l-button-reset" onclick="javascript:cancleClick();"/>
    	</td>
    </tr>
</table>
</form>
</body>
</html>