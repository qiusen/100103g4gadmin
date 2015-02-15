<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>奖金 添加</title>
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
<form name="bonusForm" id="bonusForm" method="post" action="bonusAction!addSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
    	<td align="right" class="l-table-edit-td">编号：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.code" type="text" id="bonus.code" ltype="text" value="${requestScope.code }" readonly="readonly"/></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">期数：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.cycle" type="text" id="bonus.cycle" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">服务补贴：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.servSubsidy" type="text" id="bonus.servSubsidy" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">媒体宣传费：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.mediaPub" type="text" id="bonus.mediaPub" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">教育培训奖：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.eduTrain" type="text" id="bonus.eduTrain" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">广告服务奖：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.adServ" type="text" id="bonus.adServ" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">组织领导奖：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.orgaLead" type="text" id="bonus.orgaLead" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">津贴分红：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.allowance" type="text" id="bonus.allowance" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">维护费：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.maintain" type="text" id="bonus.maintain" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">互助基金：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.helpEach" type="text" id="bonus.helpEach" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">爱心基金：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.loveHeart" type="text" id="bonus.loveHeart" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">税金：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.tax" type="text" id="bonus.tax" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">实发金额：</td>
    	<td align="left" class="l-table-edit-td"><input name="bonus.realGive" type="text" id="bonus.realGive" ltype="text" /></td>
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