<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>留言 修改</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='commentAction.${actionExt}';    
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
<form name="commentForm" id="commentForm" method="post" action="commentAction!editSave.${actionExt}" onsubmit="return checkForm();">
<input type="hidden" id="comment.id" name="comment.id" value="${requestScope.comment.id}"/>
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
        <td align="right" class="l-table-edit-td">类型：</td>
        <td align="left" class="l-table-edit-td">
        <c:if test="${requestScope.comment.type==1}">财务咨询</c:if>
        <c:if test="${requestScope.comment.type==2}">产品咨询</c:if>
        <c:if test="${requestScope.comment.type==3}">公司建议</c:if>
        <c:if test="${requestScope.comment.type==4}">其他咨询</c:if>
        </td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">留言人：</td>
        <td align="left" class="l-table-edit-td">${requestScope.comment.creator}</td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">留言时间：</td>
        <td align="left" class="l-table-edit-td"><fmt:formatDate value="${requestScope.comment.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">内容：</td>
        <td align="left" class="l-table-edit-td">
        <textarea rows="6" cols="10" style="width:330px;height:80px;" readonly="readonly">${requestScope.comment.content}</textarea>
        </td>
        <td align="left"></td>
    </tr>
    <tr>
        <td align="right" class="l-table-edit-td">回复：</td>
        <td align="left" class="l-table-edit-td">
        <textarea name="comment.revet" id="comment.revet" rows="6" cols="10" style="width:330px;height:80px;"></textarea>
        </td>
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