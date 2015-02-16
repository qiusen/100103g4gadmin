<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>提现 添加</title>
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
<form name="withdrawForm" id="withdrawForm" method="post" action="withdrawAction!addSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
    	<td align="right" class="l-table-edit-td">编号：</td>
    	<td align="left" class="l-table-edit-td"><input name="withdraw.code" type="text" id="withdraw.code" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">金额：</td>
    	<td align="left" class="l-table-edit-td"><input name="withdraw.haveCoin" type="text" id="withdraw.haveCoin" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">转出金额：</td>
    	<td align="left" class="l-table-edit-td"><input name="withdraw.coin" type="text" id="withdraw.coin" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">剩余金额：</td>
    	<td align="left" class="l-table-edit-td"><input name="withdraw.leftCoin" type="text" id="withdraw.leftCoin" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">备注：</td>
    	<td align="left" class="l-table-edit-td"><input name="withdraw.remark" type="text" id="withdraw.remark" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">状态：0、未处理；1、已处理：</td>
    	<td align="left" class="l-table-edit-td"><input name="withdraw.status" type="text" id="withdraw.status" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">申请时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="withdraw.createtime" type="text" id="withdraw.createtime" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">结算人：</td>
    	<td align="left" class="l-table-edit-td"><input name="withdraw.dealor" type="text" id="withdraw.dealor" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">结算时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="withdraw.dealtime" type="text" id="withdraw.dealtime" ltype="text" /></td>
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