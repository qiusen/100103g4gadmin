<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>充值 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='depositAction.${actionExt}';    
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
<form name="depositForm" id="depositForm" method="post" action="depositAction!editSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <input type="hidden" id="deposit.id" name="deposit.id" value="${requestScope.deposit.id}"/>
    <tr>
        <td align="right" class="l-table-edit-td">编号：</td>
        <td align="left" class="l-table-edit-td"><input name="deposit.code" type="text" id="deposit.code" ltype="text" value="${requestScope.deposit.code}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">报单币：</td>
        <td align="left" class="l-table-edit-td"><input name="deposit.taxCoin" type="text" id="deposit.taxCoin" ltype="text" value="${requestScope.deposit.taxCoin}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">说明：</td>
        <td align="left" class="l-table-edit-td"><input name="deposit.des" type="text" id="deposit.des" ltype="text" value="${requestScope.deposit.des}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">处理人：</td>
        <td align="left" class="l-table-edit-td"><input name="deposit.dealor" type="text" id="deposit.dealor" ltype="text" value="${requestScope.deposit.dealor}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">处理时间：</td>
        <td align="left" class="l-table-edit-td"><input name="deposit.dealtime" type="text" id="deposit.dealtime" ltype="text" value="${requestScope.deposit.dealtime}"/></td>
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