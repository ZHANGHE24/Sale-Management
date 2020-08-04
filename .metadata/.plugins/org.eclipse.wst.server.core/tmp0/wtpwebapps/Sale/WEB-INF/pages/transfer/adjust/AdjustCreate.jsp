<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<script language="javascript" src="${ctx}/js/calendar.js"></script>
	<script language="javascript" src="${ctx}/js/WdatePicker.js"></script>
</head>
<body>
<form action="icform" class="form-horizontal"  method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('transferAction_list','_self')"><img alt="add" src="${ctx }/img/back.png"></a></li>
	  <li><a href="#" onclick="formSubmit('transferAction_insert','_self')"><img alt="modify" src="${ctx }/img/save.png"></a></li>
	</ul>
</div>

<div style="margin: 10px">
<div class="col-md-6">
  <div class="form-group">
		<label class="col-md-2 control-label">出库门店</label>
		<div class="col-md-10">
			<s:select cssClass="form-control" name="id.outStoreNo" list="#storeInfo" headerKey="" headerValue="--请选择--" listKey="storeNo" listValue="storeName"></s:select>
		</div>
  </div>
  <div class="form-group">
		<label class="col-md-2 control-label">入库门店</label>
		<div class="col-md-10">
			<s:select cssClass="form-control" name="id.inStoreNo" list="#storeInfo" headerKey="" headerValue="--请选择--" listKey="storeNo" listValue="storeName"></s:select>
		</div>
  </div>
  <div class="form-group">
		<label class="col-md-2 control-label">调货商品名称</label>
		<div class="col-md-10">
			<s:select cssClass="form-control" name="id.itemNo" list="#storeStockInfo" headerKey="" headerValue="--请选择--" listKey="itemInfo.itemNo" listValue="itemInfo.itemNo"></s:select>
		</div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">调货日期</label>
    <div class="col-md-10">
      <input type="text" name="transferDate"  class="form-control" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="请选择调货时间">
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">调货数量</label>
    <div class="col-md-10">
      <input type="text" class="form-control" name="transferQty" placeholder="请输入调货数量">
    </div>
  </div>
</div>
</div>
</form>
</body>
</html>