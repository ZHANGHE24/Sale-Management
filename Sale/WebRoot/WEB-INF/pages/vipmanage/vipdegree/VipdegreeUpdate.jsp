<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../../base.jsp"%>
<html>
<head>

</head>
<body>
<form action="vipdegree/vipdegreeAction_update" class="form-horizontal" role="form" method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('vipdegreeAction_list','_self')"><img alt="add" src="${ctx }/img/back.png"></a></li>
	  <li><a href="#" onclick="formSubmit('vipdegreeAction_update','_self')"><img alt="modify" src="${ctx }/img/save.png"></a></li>
	</ul>
</div>

<!-- 隐藏域 userid -->
<input type="hidden" name="degree" value="${degree }">

<div style="margin: 10px">
<div class="col-md-6">
  <div class="form-group">
		<label for="firstname" class="col-md-2 control-label">可享受折扣</label>
		<div class="col-md-10">
			<input type="text" class="form-control" id="firstname" 
				   name="discount" placeholder="请修改可享受折扣" value="${discount }">
		</div>
  </div>
</div>
</div>
</form>
</body>
</html>