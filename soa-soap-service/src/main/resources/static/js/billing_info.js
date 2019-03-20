layui.use(['form', 'laypage', 'table', 'laydate', 'layer'], function() {
	var table = layui.table;
	var laydate = layui.laydate;
	var layer = layui.layer;
	var form = layui.form;
	var $ = layui.jquery;
	laydate.render({
				elem : '#begin_date'
			});
	laydate.render({
				elem : '#end_date'
			});

	// 渲染销售发票主表
	table.render({
		elem : '#main_billing_table',
		url : '../billing/getMainBillingInfo',
		toolbar : '#main_toolbar',
		height : 315,
		title : '销售发票主表',
		cols : [[{
					type : 'checkbox'
				}, {
					field : 'billNumber',
					title : '单号',
					sort : true
				}, {
					field : 'billDate',
					title : '单据日期'
				}, {
					field : 'buyerName',
					title : '购方名称',
					sort : true
				}, {
					field : 'buyerDutyParagraph',
					title : '购方税号'
				}, {
					field : 'state',
					templet : function(d) {
						// console.log(d);
						if (d.state == 'FALSE') {
							return '<span class="layui-badge layui-bg-gray">未发送</span>';
						} else if (d.state == 'TRUE') {
							return '<span class="layui-badge layui-bg-green">已发送</span>';
						} else {
							return '<span class="layui-badge layui-bg-red">未知状态</span>';
						}
					},
					title : '状态'
				}, {
					field : 'buyerAddrPhone',
					title : '购方地址、电话'
				}, {
					field : 'buyerBankAccount',
					title : '购方开户行及账号',
					sort : true
				}, {
					field : 'totalAmount',
					title : '金额合计',
					sort : true
				}, {
					field : 'remarks',
					title : '备注'
				}, {
					field : 'reBillNumber',
					title : '发票号码(回写)',
					sort : true
				}, {
					field : 'printRemark',
					title : '打印标记(回写）',
					sort : true
				}, {
					field : 'distinction',
					title : '普票，专用发票区别',
					sort : true
				}]],
		page : true,
		// count : 20,
		curr : 0,
		limit : 5,
		limits : [5, 10, 15, 20, 25, 30],
		layout : ['prev', 'page', 'next', 'skip', 'count', 'limit']
	});

	// 头工具栏事件
	table.on('toolbar(main_billing_table)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
					case 'send_receipt' :

						var select_data = checkStatus.data;// 销售发票主表选中数据

						/*
						 * var message = '<Request>';
						 * 
						 * $.each(select_data, function(index, item) { if
						 * (item.state == 'false') { // 拼装发送回执报文 message += '<Table>';
						 * message += '<reBillNumber>' + item.reBillNumber + '</reBillNumber>';
						 * message += '<printRemark>' + item.printRemark + '</printRemark>';
						 * message += '</Table>'; }
						 * 
						 * });
						 * 
						 * message += '</Request>';
						 */

						$.ajax({
									url : '../billing/sendBillReceipt',
									type : 'post',
									contentType : 'application/json;charset=utf-8',
									data : JSON.stringify(select_data),
									dataType : 'json',
									success : function(res) {
										layer.msg('发送数据成功');
										console.log(res);
									},
									error : function(textStatus) {
										layer.msg('发送数据失败');
										console.log(textStatus);
									}

								});

				};
			});
	// 监听发票主表行单击事件
	table.on('row(main_billing_table)', function(obj) {
				// 重载开票主表表格数据
				table.reload('detail_billing_table', {
							url : '../billing/getDetailBillingInfo',
							where : {
								billNumber : obj.data.billNumber
							}
						});

			});

	// 渲染销售发票副表
	table.render({
				elem : '#detail_billing_table',
				url : '../billing/getDetailBillingInfo',
				height : 315,
				title : '销售发票主表',
				toolbar : '#detail_toolbar',
				cols : [[/*
							 * { type : 'checkbox' },
							 */{
									field : 'serialNumber',
									title : '序号',
									sort : true,
									rowspan : 2
								}, {
									field : 'tradeName',
									title : '商品名称',
									sort : true,
									rowspan : 2
								}, {
									field : 'specificationsAndModel',
									title : '规格型号',
									rowspan : 2
								}, {
									field : 'unit',
									title : '计量单位',
									sort : true,
									rowspan : 2
								}, {
									field : 'quantity',
									title : '数量',
									rowspan : 2
								}, {
									field : '',
									title : '单价',
									colspan : 2
								}, {
									field : '',
									title : '金额',
									sort : true,
									colspan : 2
								}, {
									field : 'taxRate',
									title : '税率',
									sort : true,
									rowspan : 2
								}, {
									field : 'discount',
									title : '折扣',
									sort : true,
									rowspan : 2
								}, {
									field : 'tax',
									title : '税额',
									sort : true,
									rowspan : 2
								}, {
									field : 'taxClassCode',
									title : '税收分类编码',
									sort : true,
									rowspan : 2
								}], [{
									field : 'priceIncludingTax',
									title : '含税',
									sort : true
								}, {
									field : 'priceExcludingTax',
									title : '不含税',
									sort : true
								}, {
									field : 'sumIncludingTax',
									title : '含税',
									sort : true
								}, {
									field : 'sumExcludingTax',
									title : '不含税'
								}]],
				page : true,
				curr : 0,
				limit : 5,
				limits : [5, 10, 15, 20, 25, 30],
				layout : ['prev', 'page', 'next', 'skip', 'count', 'limit'],
				done : function(res, curr, count) {

				}
			});

	// 搜索栏查询按钮事件监听
	form.on('submit(search)', function(data) {
				var begin_date = data.field.begin_date;// 开始时间
				var end_date = data.field.end_date;// 结束时间
				var bill_numer = data.field.bill_numer;// 单号
				var buyer_name = data.field.buyer_name;// 购方名称
				var buyer_duty_paragraph = data.field.buyer_duty_paragraph;// 购方税号

				var query_data = {
					beginDate : begin_date,
					endDate : end_date,
					billNumber : bill_numer,
					buyerName : buyer_name,
					buyerDutyParagraph : buyer_duty_paragraph

				}

				// 重载开票主表表格数据
				table.reload('main_billing_table', {
							url : '../billing/getMainBillingInfo',
							where : query_data
						});
				return false;
			});

});