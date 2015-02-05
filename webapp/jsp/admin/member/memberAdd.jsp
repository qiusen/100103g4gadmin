<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>会员 添加</title>
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
<form name="memberForm" id="memberForm" method="post" action="memberAction!addSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
    	<td align="right" class="l-table-edit-td">编号：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.code" type="text" id="member.code" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">名称：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.name" type="text" id="member.name" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">手机：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.mobile" type="text" id="member.mobile" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">服务中心编号：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.servCode" type="text" id="member.servCode" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">推荐人编号：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.recoCode" type="text" id="member.recoCode" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">管理人编号：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.managerCode" type="text" id="member.managerCode" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">位置：A、A区；B、B区：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.area" type="text" id="member.area" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">身份证号：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.inden" type="text" id="member.inden" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">银行：1、农行；2、工行：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.bank" type="text" id="member.bank" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">一级密码：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.passwd1" type="text" id="member.passwd1" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">二级密码：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.passwd2" type="text" id="member.passwd2" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">三级密码：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.passwd3" type="text" id="member.passwd3" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">第二联系方式：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.mobile2" type="text" id="member.mobile2" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">QQ：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.qq" type="text" id="member.qq" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">邮编：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.postCode" type="text" id="member.postCode" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">地址：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.addr" type="text" id="member.addr" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">备注：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.remark" type="text" id="member.remark" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">报单币：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.taxCoin" type="text" id="member.taxCoin" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">现金币：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.cashCoin" type="text" id="member.cashCoin" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">电商币：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.shopCoin" type="text" id="member.shopCoin" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">级别：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.level" type="text" id="member.level" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">状态：0、未审；1、已审：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.status" type="text" id="member.status" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">创建人：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.creator" type="text" id="member.creator" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">创建时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.createtime" type="text" id="member.createtime" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">修改人：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.updator" type="text" id="member.updator" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">修改时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.updatetime" type="text" id="member.updatetime" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">审核人：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.exator" type="text" id="member.exator" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">审核时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="member.exatetime" type="text" id="member.exatetime" ltype="text" /></td>
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