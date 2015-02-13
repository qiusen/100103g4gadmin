<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>在线订单 添加</title>
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
<form name="onlineOrderForm" id="onlineOrderForm" method="post" action="onlineOrderAction!addSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
    	<td align="right" class="l-table-edit-td">订单人编号：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.code" type="text" id="onlineOrder.code" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">收货人姓名：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.name" type="text" id="onlineOrder.name" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">收货人手机：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.mobile" type="text" id="onlineOrder.mobile" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">收货人地址：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.addr" type="text" id="onlineOrder.addr" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">手机型号：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileModel" type="text" id="onlineOrder.mobileModel" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">手机颜色：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileColor" type="text" id="onlineOrder.mobileColor" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">手机号码1：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber1" type="text" id="onlineOrder.mobileNumber1" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">手机号码2：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber2" type="text" id="onlineOrder.mobileNumber2" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">手机号码3：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber3" type="text" id="onlineOrder.mobileNumber3" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">手机号码4：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber4" type="text" id="onlineOrder.mobileNumber4" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">手机号码5：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber5" type="text" id="onlineOrder.mobileNumber5" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">手机号码6：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.mobileNumber6" type="text" id="onlineOrder.mobileNumber6" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">电脑、上网卡：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.pc" type="text" id="onlineOrder.pc" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">备注：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.remark" type="text" id="onlineOrder.remark" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">状态：0、未处理；1、已处理：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.status" type="text" id="onlineOrder.status" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">创建时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.createtime" type="text" id="onlineOrder.createtime" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">处理人：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.dealor" type="text" id="onlineOrder.dealor" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">处理时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="onlineOrder.dealtime" type="text" id="onlineOrder.dealtime" ltype="text" /></td>
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