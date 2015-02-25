<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>电商币结算 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='shopCoinAction.${actionExt}';    
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
<form name="shopCoinForm" id="shopCoinForm" method="post" action="shopCoinAction!editSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <input type="hidden" id="shopCoin.id" name="shopCoin.id" value="${requestScope.shopCoin.id}"/>
    <tr>
        <td align="right" class="l-table-edit-td">编号：</td>
        <td align="left" class="l-table-edit-td"><input name="shopCoin.code" type="text" id="shopCoin.code" ltype="text" value="${requestScope.shopCoin.code}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">姓名：</td>
        <td align="left" class="l-table-edit-td"><input name="shopCoin.name" type="text" id="shopCoin.name" ltype="text" value="${requestScope.shopCoin.name}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">电商币：</td>
        <td align="left" class="l-table-edit-td"><input name="shopCoin.coin" type="text" id="shopCoin.coin" ltype="text" value="${requestScope.shopCoin.coin}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">处理人：</td>
        <td align="left" class="l-table-edit-td"><input name="shopCoin.dealor" type="text" id="shopCoin.dealor" ltype="text" value="${requestScope.shopCoin.dealor}"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">处理时间：</td>
        <td align="left" class="l-table-edit-td"><input name="shopCoin.dealtime" type="text" id="shopCoin.dealtime" ltype="text" value="${requestScope.shopCoin.dealtime}"/></td>
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