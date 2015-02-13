<%@ page contentType="text/html;charset=UTF-8"%><%@ include file="/jsp/common/taglibs.jsp"%><!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>在线订单 列表</title>
<%@ include file="/jsp/common/meta.jsp"%>
<script language="javascript">
var resultListData = {${requestScope.json}} ;

var manager, g;


var pageSize = ${requestScope.pageInfo.pageSize};
var totalPage=${requestScope.pageInfo.totalPage};
var itemCount = resultListData.Total;
var pageNo =${requestScope.pageInfo.page};


$(f_initGrid);
function f_initGrid(){
    g = manager = $("#maingrid").ligerGrid({
    	title:'在线订单列表',
        columns: [
        //{ display: '主键', name: 'id', width: 50, type: 'int', frozen: true },
		
		{ display: '订单人编号', name: 'code',type: 'text' , width: '15%'},
		{ display: '收货人姓名', name: 'name',type: 'text' , width: '15%'},
		{ display: '状态', name: 'status',type: 'text' , width: '15%',render: function (rowdata, rowindex, value)
        {
        	var h = "<font color='red'>未处理</font>";
            if(rowdata.status==1){
                h = "<font color='green'>已处理</font>";
            }
            return h;
        } },
		{ display: '收货人手机', name: 'mobile',type: 'text' , width: '15%'},
		{ display: '收货人地址', name: 'addr',type: 'text' , width: '15%'},
		{ display: '手机型号', name: 'mobileModel',type: 'text' , width: '15%'},
		{ display: '手机颜色', name: 'mobileColor',type: 'text' , width: '15%'},
		{ display: '手机号码1', name: 'mobileNumber1',type: 'text' , width: '15%'},
		{ display: '手机号码2', name: 'mobileNumber2',type: 'text' , width: '15%'},
		{ display: '手机号码3', name: 'mobileNumber3',type: 'text' , width: '15%'},
		{ display: '手机号码4', name: 'mobileNumber4',type: 'text' , width: '15%'},
		{ display: '手机号码5', name: 'mobileNumber5',type: 'text' , width: '15%'},
		{ display: '手机号码6', name: 'mobileNumber6',type: 'text' , width: '15%'},
		{ display: '电脑、上网卡', name: 'pc',type: 'text' , width: '15%'},
		//{ display: '备注', name: 'remark',type: 'text' , width: '15%'},
		
		{ display: '提交时间', name: 'createtime',type: 'text' , width: '15%'},
		{ display: '处理人', name: 'dealor',type: 'text' , width: '15%'},
		{ display: '处理时间', name: 'dealtime',type: 'text' , width: '15%'}
        ],
        onSelectRow: function (rowdata, rowindex)
        {
            $("#txtrowindex").val(rowindex);
        },
        enabledEdit: true,clickToEdit:false, isScroll: true,
        rownumbers:true,
        data: resultListData,
        record: resultListData.Total,
        //usePager :false,
        width: '90%',height: '90%',
        pageSize:pageSize,
        pageSizeOptions:[5,10,15,20],
        onReload: function() {
        	search();
        },
        onToFirst: function() {
			if(pageNo != 1) {
				document.getElementById("pageNo").value = 1;
				search();
			}
			return false;
        },
        onToPrev: function() {
        	if(pageNo > 1) {
        		document.getElementById("pageNo").value = pageNo - 1;
        		search();
        	}
			return false;
        },
        onToNext: function() {
        	if(pageNo < totalPage) {
        		document.getElementById("pageNo").value = pageNo +1;
        		search();
        	}
			return false;
        },
        onToLast: function() {
        	if(pageNo != totalPage) {
				document.getElementById("pageNo").value = totalPage;
        		search();
        	}
			return false;
        } ,
        //isScroll: false, 
        
        toolbar: { items: [//{ text: '增加', value:'add', click: itemclick, icon: 'add', img: '${base}/ligerUI/skins/icons/add.gif' },
                           { text: '处理', value:'edit', click: itemclick, icon: 'edit', img: '${base}/ligerUI/skins/icons/edit.gif' }//,
                           //{ text: '删除', value:'delete', click: itemclick, icon: 'delete', img: '${base}/ligerUI/skins/icons/delete.gif' }
                            ] }

        
                                 
    });

    $(".pcontrol input").val(pageNo);
   	$(".pcontrol input").css("width", ((totalPage + "").length * 7) + "px");
   	$(".pcontrol input").attr("maxlength", (totalPage + "").length);
	$(".pcontrol input").attr("readonly", "readonly");
       $(".pcontrol span").html(totalPage);
       var start = 0;
	var end = 0;
	if(pageNo>0){
		start = (pageSize * (pageNo - 1) + 1);
		end = start + resultListData.Rows.length - 1;
	}
       $(".l-bar-text").html("显示记录从" + start + "到" + end + "，总数 " + itemCount + " 条");
       if (!itemCount)
       {
           $(".l-bar-btnfirst span,.l-bar-btnprev span,.l-bar-btnnext span,.l-bar-btnlast span").addClass("l-disabled");
       }
       if (pageNo == 1)
       {
           $(".l-bar-btnfirst span").addClass("l-disabled");
           $(".l-bar-btnprev span").addClass("l-disabled");
       }
       else if (pageNo > 1 && totalPage > 0)
       {
           $(".l-bar-btnfirst span").removeClass("l-disabled");
           $(".l-bar-btnprev span").removeClass("l-disabled");
       }
       if (pageNo == totalPage)
       {
           $(".l-bar-btnlast span").addClass("l-disabled");
           $(".l-bar-btnnext span").addClass("l-disabled");
       }
       else if (pageNo < totalPage && totalPage > 0)
       {
           $(".l-bar-btnlast span").removeClass("l-disabled");
           $(".l-bar-btnnext span").removeClass("l-disabled");
       }
    
    $(".l-bar-selectpagesize select").change(function() {
   		document.getElementById("pageSize").value = $(".l-bar-selectpagesize select").val();
   		document.getElementById("pageNo").value = 1;
   		search();
       }); 
}
function search(){
	document.forms[0].submit();
}
function deleteData(id){
    if (confirm('确定删除?')){
    	window.location="${base}/admin/onlineOrder/onlineOrderAction!delete.${actionExt}?id=" + id;
    }
}
function showData(id){
	var dialog=$.ligerDialog.open({ title:'查看', url: '${base}/admin//onlineOrder/onlineOrderAction!show.${actionExt}?id=' + id, height: 300, width: null, buttons: [
              { text: '关闭', onclick: function (item, dialog) { dialog.close(); } }
           ], isResize: true
          });                                                                 	
}

function itemclick(item){
	if(item.value=='add'){
		window.location="${base}/admin/onlineOrder/onlineOrderAction!add.${actionExt}";
	}
	if(item.value=='edit'){
        var row = manager.getSelectedRow();
        if (!row) { $.ligerDialog.warn('请选择行'); return; }
            //alert(row.id);
		window.location="${base}/admin/onlineOrder/onlineOrderAction!edit.${actionExt}?id=" + row.id;
	}
	if(item.value=='delete'){
		var row = manager.getSelectedRow();
        if (!row) {$.ligerDialog.warn('请选择行'); return; }
		$.ligerDialog.confirm('确认删除模块 ' + row.code + ' 的信息？', function (yes) {
            if(yes==true){
            	window.location="${base}/admin/onlineOrder/onlineOrderAction!delete.${actionExt}?id=" + row.id;
            }
        });
	}
    
}

</script>
<style type="text/css">
.l-case-title{font-weight:bold; margin-top:20px;margin-bottom:20px;}
</style>
</head>
<body style="padding:6px; overflow:hidden;">
<form name="onlineOrderForm" id="onlineOrderForm" method="post" action="onlineOrderAction.${actionExt}" >
<input type="hidden" name="pageNo" id="pageNo" value="${requestScope.pageInfo.page}" />
<input type="hidden" name="pageSize" id="pageSize" value="${requestScope.pageInfo.pageSize}" />
<div id="searchbar">
订单人编号：<input id="onlineOrder.code" type="text" name="onlineOrder.code" value="${onlineOrder.code }"/>
    <input id="btnOK" type="submit" value="查询"/>
</div>
    <div id="maingrid" style="margin:0; padding:0"></div>
   

  <div style="display:none;">
</div>
 
</form>
</body>
</html>