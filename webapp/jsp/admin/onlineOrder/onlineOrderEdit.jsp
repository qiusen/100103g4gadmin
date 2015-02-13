<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>在线订单 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='onlineOrderAction.${actionExt}';    
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
<form name="onlineOrderForm" id="onlineOrderForm" method="post" action="onlineOrderAction!editSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <input type="hidden" id="onlineOrder.id" name="onlineOrder.id" value="${requestScope.onlineOrder.id}"/>
    <tr>
        <td align="right" class="l-table-edit-td">订单人编号：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.code" type="text" id="onlineOrder.code" ltype="text" value="${requestScope.onlineOrder.code}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">收货人姓名：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.name" type="text" id="onlineOrder.name" ltype="text" value="${requestScope.onlineOrder.name}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">收货人手机：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.mobile" type="text" id="onlineOrder.mobile" ltype="text" value="${requestScope.onlineOrder.mobile}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">收货人地址：</td>
        <td align="left" class="l-table-edit-td">
        <textarea name="onlineOrder.addr" id="onlineOrder.addr" rows="3" cols="10" style="width:300px;height:80px;" readonly="readonly">${requestScope.onlineOrder.addr}</textarea>
        </td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">手机型号：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileModel" type="text" id="onlineOrder.mobileModel" ltype="text" value="${requestScope.onlineOrder.mobileModel}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">手机颜色：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileColor" type="text" id="onlineOrder.mobileColor" ltype="text" value="${requestScope.onlineOrder.mobileColor}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">手机号码1：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber1" type="text" id="onlineOrder.mobileNumber1" ltype="text" value="${requestScope.onlineOrder.mobileNumber1}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">手机号码2：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber2" type="text" id="onlineOrder.mobileNumber2" ltype="text" value="${requestScope.onlineOrder.mobileNumber2}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">手机号码3：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber3" type="text" id="onlineOrder.mobileNumber3" ltype="text" value="${requestScope.onlineOrder.mobileNumber3}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">手机号码4：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber4" type="text" id="onlineOrder.mobileNumber4" ltype="text" value="${requestScope.onlineOrder.mobileNumber4}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">手机号码5：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber5" type="text" id="onlineOrder.mobileNumber5" ltype="text" value="${requestScope.onlineOrder.mobileNumber5}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">手机号码6：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber6" type="text" id="onlineOrder.mobileNumber6" ltype="text" value="${requestScope.onlineOrder.mobileNumber6}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">电脑、上网卡：</td>
        <td align="left" class="l-table-edit-td"><input name="onlineOrder.pc" type="text" id="onlineOrder.pc" ltype="text" value="${requestScope.onlineOrder.pc}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">备注：</td>
        <td align="left" class="l-table-edit-td">
        <textarea name="onlineOrder.remark" id="onlineOrder.remark" rows="3" cols="10" style="width:300px;height:80px;" readonly="readonly">${requestScope.onlineOrder.remark}</textarea>
        </td>
        <td align="left"></td>
    </tr>
    
    <tr>
        <td align="right" class="l-table-edit-td">提交时间：</td>
        <td align="left" class="l-table-edit-td"><fmt:formatDate value="${requestScope.onlineOrder.createtime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
        <td align="left"></td>
    </tr>
    <tr>
    	<td align="center" colspan="3">
    	<c:if test="${requestScope.onlineOrder.status==0}">
    	<input type="submit" value="保存" id="Button1" class="l-button l-button-submit" /> </c:if>
	<input type="button" value="返回" class="l-button l-button-reset" onclick="javascript:cancleClick();"/>
    	</td>
    </tr>
</table>
</form>
</body>
</html>