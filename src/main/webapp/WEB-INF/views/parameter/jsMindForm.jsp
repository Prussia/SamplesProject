<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<link type="text/css" rel="stylesheet" href="${ctx }/static/js/plugins/jsMind//style/jsmind.css" />
<style type="text/css">
img {
	cursor: pointer;
}
 #jsmind_container{
    width:800px;
    height:500px;
    border:solid 1px #ccc;
    background:#f4f4f4;
}
</style>
<div>
	<div >
		<select id="selectLevel" >
			<option value="1" selected>显示1级</option>
			<option value="2">显示2级</option>
			<option value="3">显示3级</option>
			<option value="4">显示4级</option>
		</select>
		<select id="selectTheme" >
		   <option value="primary" >primary</option>
		   <option value="warning" >warning</option>
		   <option value="danger" >danger</option>
		   <option value="success" >success</option>
		   <option value="info" >info</option>
		   <option value="greensea" >greensea</option>
		   <option value="nephrite" >nephrite</option>
		   <option value="belizehole" >belizehole</option>
		   <option value="wisteria" >wisteria</option>
		   <option value="asphalt" >asphalt</option>
		   <option value="orange" >orange</option>
		   <option value="pumpkin" >pumpkin</option>
		   <option value="pomegranate" >pomegranate</option>
		   <option value="clouds" >clouds</option>
		   <option value="asbestos" >asbestos</option>
		</select>
		<button onclick="load_jsMind();">刷新</button>
	</div>
	<div id="jsmind_container"></div>
	
</div>
<script type="text/javascript" src="${ctx }/static/js/json2.js"></script>
<script type="text/javascript" src="${ctx }/static/js/plugins/jsMind/js/jsmind.js"></script>
<script type="text/javascript" src="${ctx }/static/js/plugins/jsMind/js/jsmind.draggable.js"></script>
<script type="text/javascript">
	var data1;
	var load_data_url = "${ctx}/parameter/findMindData?search_EQ_parentId=0";
	
	var jm ;
	
	
	
	function load_jsMind(){
        var level = $("#selectLevel").val();
        var theme = $("#selectTheme").val();
        console.info(theme);
		$.ajax({
			type : 'post',
			url : load_data_url,
			data: {rootId: 1,level:level},
			dataType : 'json',
			success : function(data){
				$("#jsmind_container").children().remove();
				 var mind = {
				            "meta":{
				                "name":"demo",
				                "author":"hizzgdev@163.com",
				                "version":"0.2",
				            },
				            "format":"node_array",	//node_tree,freemind,node_array
				            "editable": false,
				            "data":data
				        };
				        var options = {
				            container:'jsmind_container',
				            theme:theme
				        }
				        jm = jsMind.show(options,mind);
			}
		});
		
		
		
	}

	$.parser.onComplete = function() {
		parent.$.messager.progress('close');
		load_jsMind();
		
	};
</script>


