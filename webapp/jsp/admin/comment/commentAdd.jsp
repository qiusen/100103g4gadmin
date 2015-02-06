<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>留言 添加</title>
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
<form name="commentForm" id="commentForm" method="post" action="commentAction!addSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
    	<td align="right" class="l-table-edit-td">类型：1、财务咨询；2、产品咨询；3、公司建议；4、其他咨询：</td>
    	<td align="left" class="l-table-edit-td"><input name="comment.type" type="text" id="comment.type" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">内容：</td>
    	<td align="left" class="l-table-edit-td"><input name="comment.content" type="text" id="comment.content" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">回复：</td>
    	<td align="left" class="l-table-edit-td"><input name="comment.revet" type="text" id="comment.revet" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">创建人：</td>
    	<td align="left" class="l-table-edit-td"><input name="comment.creator" type="text" id="comment.creator" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">创建时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="comment.createtime" type="text" id="comment.createtime" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">回复人：</td>
    	<td align="left" class="l-table-edit-td"><input name="comment.revetor" type="text" id="comment.revetor" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">回复时间：</td>
    	<td align="left" class="l-table-edit-td"><input name="comment.revettime" type="text" id="comment.revettime" ltype="text" /></td>
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