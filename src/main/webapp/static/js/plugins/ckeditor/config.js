/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	config.toolbar = [
	                //源码、保存、新建、预览、打印、模板
	          		/*{ name: 'document', items: [ 'Source', '-', 'Save', 'NewPage', 'Preview', 'Print', '-', 'Templates' ] },*/
	          		//剪切、复制、粘贴、粘贴为无格式文本、从word中粘贴、撤销、重做
	          		{ name: 'clipboard', items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
	          		//查找、替换、全选、拼写检查
	          		{ name: 'editing', items: [ 'Find', 'Replace', '-', 'SelectAll'/*, '-', 'Scayt'*/ ] },
	          		//表单、多选框、单选框、单文本、多文本、下拉框、按钮、带图片的按钮、隐藏域
	          		/*{ name: 'forms', items: [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ] },*/
	          		'/',
	          		//加粗、倾斜、下划线、删除线、下标、上标、清除格式
	          		{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
	          		//编号列表、项目列表、减少缩进、增加缩进、块引用、生成div容器、左对齐、居中对齐、右对齐、两端对齐、文字方向从左到右、文字方向从右到左、设置语言
	          		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-',/* 'Outdent', 'Indent', '-',*/ 'Blockquote', 'CreateDiv', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', '-', 'BidiLtr', 'BidiRtl'/*, 'Language' */] },
	          		//插入/编辑超链接、取消超链接、设置锚点
	          		/*{ name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },*/
	          		//插入图片、flash、表格、水平线、表情、特殊符号、打印分页符、IFrame
	          		{ name: 'insert', items: [ 'Image', /*'Flash',*/ 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar'/*, 'PageBreak', 'Iframe'*/ ] },
	          		'/',
	          		//样式、格式、字体、字体大小
	          		{ name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
	          		//文本颜色、背景颜色
	          		{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
	          		//全屏、显示区块
	          		{ name: 'tools', items: [ 'Maximize', 'ShowBlocks' ] }
	          		//关于（就是介绍ckeditor的）
	          		/*,{ name: 'about', items: [ 'About' ] }*/
	          		
	          		//自定义
	          		,{ name: 'custome', items:['Image', 'About', 'Table']}
	          	];
	
	
	
	config.autoGrow_minHeight = 400;
	
	config.filebrowserUploadUrl="SamplesProject/webinfo/upload";

};
