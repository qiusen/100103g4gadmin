<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>提现 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='withdrawAction.${actionExt}';    
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
<form name="withdrawForm" id="withdrawForm" method="post" action="withdrawAction!editSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <input type="hidden" id="withdraw.id" name="withdraw.id" value="${requestScope.withdraw.id}"/>
    <tr>
        <td align="right" class="l-table-edit-td">编号：</td>
        <td align="left" class="l-table-edit-td"><input name="withdraw.code" type="text" id="withdraw.code" ltype="text" value="${requestScope.withdraw.code}" readonly="readonly"></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">金额：</td>
        <td align="left" class="l-table-edit-td"><input name="withdraw.haveCoin" type="text" id="withdraw.haveCoin" ltype="text" value="${requestScope.withdraw.haveCoin}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">转出金额：</td>
        <td align="left" class="l-table-edit-td"><input name="withdraw.coin" type="text" id="withdraw.coin" ltype="text" value="${requestScope.withdraw.coin}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">剩余金额：</td>
        <td align="left" class="l-table-edit-td"><input name="withdraw.leftCoin" type="text" id="withdraw.leftCoin" ltype="text" value="${requestScope.withdraw.leftCoin}" readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">备注：</td>
        <td align="left" class="l-table-edit-td"><input name="withdraw.remark" type="text" id="withdraw.remark" ltype="text" value="${requestScope.withdraw.remark}"  readonly="readonly"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">状态：</td>
        <td align="left" class="l-table-edit-td">
        <c:if test="${requestScope.withdraw.status==0}">未处理</c:if>
        <c:if test="${requestScope.withdraw.status==1}">已处理</c:if>
        </td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">申请时间：</td>
        <td align="left" class="l-table-edit-td"><fmt:formatDate value="${requestScope.withdraw.createtime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
        <td align="left"></td>
    </tr>
    <tr>
    	<td align="center" colspan="3">
    <c:if test="${requestScope.withdraw.status==0}">	<input type="submit" value="付款处理" id="Button1" class="l-button l-button-submit" /></c:if>
	<input type="button" value="取消" class="l-button l-button-reset" onclick="javascript:cancleClick();"/>
    	</td>
    </tr>
</table>
</form>
</body>
</html>