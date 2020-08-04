<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<script language="javascript" src="${ctx}/js/calendar.js"></script>
	<script language="javascript" src="${ctx}/js/WdatePicker.js"></script>
<script type="text/javascript">
	 var count;
     function isOnlyChecked(){
    	 var checkBoxArray = document.getElementsByName('id');
			count=0;
			for(var index=0; index<checkBoxArray.length; index++) {
				if (checkBoxArray[index].checked) {
					count++;
				}	
			}
		//jquery
		//var count = $("[input name='id']:checked").size();
		if(count==1)
			return true;
		else
			return false;
     }
     function deleteById(){
     	 isOnlyChecked();
    	 if(count > 0){
    	 	 alert("确认删除？");
    		 formSubmit('saleAction_delete','_self');
    	 }else{
    		 alert("请先选择一项以上，再进行操作！");
    	 }
     }
     function jisuan(){
    	 var text1=document.getElementById("text1").value;
    	 var text2=document.getElementById("text2").value;
    	 document.getElementById("text3").value=parseFloat(text1)*parseFloat(text2);
    }
     function jisuan1(){
    	 var text3=document.getElementById("text3").value;
    	 var discount=document.getElementById("discount").value;
    	 document.getElementById("payamount").value=parseFloat(text3)*parseFloat(discount);
    }
     function order(){    	 
     	// var storeno=$("#storeno").find("option:selected").text(); 
     	 var checkValue=$("#storeno").val();
     	 var saledate= document.getElementById("saledate").value;   
     	 var arr1 = saledate.split(" ");
     	 var sdate = arr1[0].split('-');
     	 var ttime = arr1[1].split(':');
     	 var date = sdate[0][2]+''+sdate[0][3]+''+sdate[1]+''+sdate[2];
     	 var time = ttime[0]+''+ttime[1]+''+ttime[2];
     	 document.getElementById("orderno").value=checkValue+''+date+''+time;
      }
      
      function $(obj){return document.getElementById(obj);}
      function show(objid) {$(objid).style.display='inline';}
      function hidden(objid) {$(objid).style.display='none';}
      function doit(){
      var sel_val=$('sel').value;
      if (sel_val=='') {hidden('a1');}
      if (sel_val=="否") {hidden('a1');}
      if (sel_val=="是") {show('a1');}
      }

</script>
</head>
<body>
<form action="icform" class="form-horizontal"  method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('saleAction_list','_self')"><img alt="add" src="${ctx }/img/back.png"></a></li>
	  <li><a href="#" onclick="formSubmit('saleAction_insert','_self')"><img alt="modify" src="${ctx }/img/save.png"></a></li>
	</ul>
</div>

<div style="margin: 10px">
<div class="col-md-6">
	<div class="form-group">
    <label class="col-md-2 control-label">订单编号</label>
    <div class="col-md-10">
      <input type="text" class="form-control" id="orderno" name="orderNo" placeholder="请输入订单单号，示例：1CHN300000001190522172815" >
    </div>
  </div>
  <div class="form-group">
		<label class="col-md-2 control-label">门店编号</label>
		<div class="col-md-10">
			<s:select cssClass="form-control" id="storeno" name="storeInfo.storeNo" list="#storeInfo" headerKey="" headerValue="--请选择--" listKey="storeNo" listValue="storeName" ></s:select>
		</div>
  </div>
  <div class="form-group">
		<label class="col-md-2 control-label">会员号</label>
		<div class="col-md-10">
			<s:select cssClass="form-control" id="vipno" name="vip.vipNo" list="#vip" headerKey="" headerValue="--请选择--" listKey="vipNo" listValue="vipNo"></s:select>
		</div>
  </div>
  <div class="form-group">
		<label class="col-md-2 control-label">导购编号</label>
		<div class="col-md-10">
			<s:select cssClass="form-control" id="staffno" name="staffInfo.staffNo" list="#staffInfo" headerKey="" headerValue="--请选择--" listKey="staffNo" listValue="staffName"></s:select>
		</div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">销售日期</label>
    <div class="col-md-10">
      <input type="text" name="saleDate" id="saledate" class="form-control" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="请选择销售时间">
    </div>
  </div>
  <div class="form-group">
		<label class="col-md-2 control-label">商品名称</label>
		<div class="col-md-10">
			<s:select cssClass="form-control" id="itemno" name="itemNo" list="#itemInfo" headerKey="" headerValue="--请选择--" listKey="itemNo" listValue="itemName"></s:select>
		</div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">购买数量</label>
    <div class="col-md-10">
      <input type="text" class="form-control" id="text1" name="itemQty" placeholder="请输入购买数量" onkeyup="jisuan();">
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">商品单价</label>
    <div class="col-md-10">
      <input type="text" class="form-control" id="text2" name="itemPrice" placeholder="请输入商品单价" onkeyup="jisuan();">
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">总金额</label>
    <div class="col-md-10">
      <input type="text" class="form-control" id="text3" name="totalAmount" placeholder="请输入总数额" readonly onkeyup="jisuan1();">
    </div>
  </div>
  <div class="form-group">
		<label class="col-md-2 control-label">折扣</label>
		<div class="col-md-10">
			<input type="text" class="form-control" id="discount" name="discount" placeholder="请输入折扣" onkeyup="jisuan1();">
		</div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">实付金额</label>
    <div class="col-md-10">
      <input type="text" class="form-control" id="payamount" name="payAmount" placeholder="请输入实付数额" readonly>
    </div>
  </div>

  <div class="form-group">
    <label class="col-md-2 control-label">支付方式</label>
    <div class="col-md-10">
      <s:select cssClass="form-control" id="payment" name="payment" list="#{'现金':'现金','支付宝':'支付宝','微信':'微信','银联卡':'银联卡','visa':'visa'}" headerKey="" headerValue="--请选择--"></s:select>
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">是否快递</label>
    <div class="col-md-10">
      <!-- <input type="number" class="form-control" name="isRemainder" placeholder="请确定其是否快递">  -->
      <select cssClass="form-control" id="sel" name="isDelivery"  value="${isDelivery}" onchange="doit();">     
  		<option value="0">-请选择-</option>     
  		<option value="是" <c:if test="${'是' eq isRemainder}">selected</c:if> >是</option>     
  		<option value="否" <c:if test="${'否' eq isRemainder}">selected</c:if> >否</option>  
 	</select>  
 	<input placeholder="请输入快递单号" type="text" name="deliveryNo" id="a1" style="display:none;" />
    </div>
  </div>
</div>
</div>
</form>
</body>
</html>