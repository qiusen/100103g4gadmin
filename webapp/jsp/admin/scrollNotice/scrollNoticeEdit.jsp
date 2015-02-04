<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>滚动公告 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='scrollNoticeAction.${actionExt}';    
}
<c:if test="${requestScope.edit==1}">
$(function() {
	$.ligerDialog.success('修改成功！');
});
</c:if>
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
<form name="scrollNoticeForm" id="scrollNoticeForm" method="post" action="scrollNoticeAction!editSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
       	<td align="center" colspan="3">
       	<font color="red">滚动公告</font>
	    	</td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">内容：</td>
        <td align="left" class="l-table-edit-td">
        <textarea name="scrollNotice.content" id="scrollNotice.content" rows="10" cols="6" style="width:600px;height:80px;margin:20px;">${requestScope.scrollNotice.content}</textarea>
        </td>
        <td align="left"></td>
    </tr>
    <tr>
    	<td align="right" colspan="3">
    	<input type="submit" value="保存" id="Button1" class="l-button l-button-submit" style="margin-left:300px;"/> 
    	</td>
    </tr>
</table>
</form>
</body>
</html>