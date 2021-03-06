<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%>
<html>
<head>
<script type="text/javascript">
function checkno() {
	var telenum = document.getElementById("staffNo");
	var telenumText = telenum.value;
	var storeno=$("#storeinfo").find("option:selected").text();   
	if(!(/^\d{10}$/g.test(telenumText))){
		alert("员工编号必须为10位数字！");
	}
	
	else if(storeno=="--请选择--"){
		alert("必须选择门店！");
	}
	else{
		formSubmit('staffAction_insert','_self');
	}

}
</script>
</head>
<body>
<form action="icform" class="form-horizontal"  method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('staffAction_list','_self')"><img alt="add" src="${ctx }/img/back.png"></a></li>
	  <li><a href="#" onclick="checkno()"><img alt="modify" src="${ctx }/img/save.png"></a></li>
	</ul>
</div>

<div style="margin: 10px">
<div class="col-md-6">
  <div class="form-group">
    <label class="col-md-2 control-label">员工编号</label>
    <div class="col-md-10">
      <input type="text" class="form-control" id="staffNo" name="staffNo" placeholder="请输入员工编号(示例：0000000001，10位)" onkeyup="this.value=this.value.replace(/\D/g,'')" onkeydown="if(event.keyCode==32) return false">
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">姓名</label>
    <div class="col-md-10">
      <input type="text" class="form-control" name="staffName" placeholder="请输入姓名">
    </div>
  </div>
  <div class="form-group">
		<label class="col-md-2 control-label">所属门店</label>
		<div class="col-md-10">
			<s:select cssClass="form-control" id="storeinfo" name="storeInfo.storeNo" list="#storeInfo" headerKey="" headerValue="--请选择--" listKey="storeNo" listValue="storeName"></s:select>
		</div>
	</div>
  <div class="form-group">
    <label class="col-md-2 control-label">基本工资</label>
    <div class="col-md-10">
      <input type="text" class="form-control" name="basicSalary" placeholder="请输入基础工资">
    </div>
  </div>
  <div class="form-group">
    <label class="col-md-2 control-label">提成</label>
    <div class="col-md-10">
      <input type="text" class="form-control" name="commission" placeholder="请输入提成数额">
    </div>
  </div>
</div>
</div>
</form>
</body>
</html>