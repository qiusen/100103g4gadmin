<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>产品 添加</title>
<%@ include file="/jsp/common/meta.jsp"%>
<link rel="stylesheet" href="${base }/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="${base }/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="${base }/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${base }/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="${base }/kindeditor/plugins/code/prettify.js"></script>
<script charset="utf-8" src="${base}/js/jquery.upload.js" type="text/javascript" ></script>

<script language="javascript">
function checkForm(){
	return true;
}
function cancleClick(){
	self.location='productAction.${actionExt}';    
}
var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="product.content"]', {
		cssPath : '${base }/kindeditor/plugins/code/prettify.css',
		uploadJson : '${base }/uploadJson',
		fileManagerJson : '${base }/fileManagerJson',
		//fileManagerJson : '../jsp/file_manager_json.jsp',
		allowFileManager : true,
		afterCreate : function() {
			var self = this;
			K.ctrl(document, 13, function() {
				self.sync();
				document.forms['productForm'].submit();
			});
			K.ctrl(self.edit.doc, 13, function() {
				self.sync();
				document.forms['productForm'].submit();
			});
		}
	});
	prettyPrint();
});
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
<form name="productForm" id="productForm" method="post" action="productAction!addSave.${actionExt}" onsubmit="return checkForm();">
<table cellpadding="0" cellspacing="0" class="l-table-edit" style="margin-top:50px;margin-left:50px;">
    <tr>
    	<td align="right" class="l-table-edit-td">名称：</td>
    	<td align="left" class="l-table-edit-td"><input name="product.name" type="text" id="product.name" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">短名称：</td>
    	<td align="left" class="l-table-edit-td"><input name="product.shortName" type="text" id="product.shortName" ltype="text" /></td>
    	<td align="left"></td>
    </tr>
    <tr>
    	<td align="right" class="l-table-edit-td">内容：</td>
    	<td align="left" class="l-table-edit-td">
    	<textarea name="product.content" id="product.content" cols="80" rows="8" 
    			style="width:680px;height:350px;visibility:hidden;"></textarea>
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