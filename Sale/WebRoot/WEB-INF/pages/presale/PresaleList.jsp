<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../base.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<script>
	 var count;
     function isOnlyChecked(){
    	 var checkBoxArray = document.getElementsByName('presale');
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
    		 formSubmit('presaleAction_delete','_self');
    	 }else{
    		 alert("请先选择一项以上，再进行操作！");
    	 }
     }
     //实现更新
     function toUpdate(){
    	 if(isOnlyChecked()){
    		 formSubmit('presaleAction_toupdate','_self')
    	 }else{
    		 alert("请先选择一项并且只能选择一项，再进行操作！");
    	 }
     }
</script>
</head>
<body>
<form name="icform" method="post">
<div>
	<ul class="nav nav-pills">
	  <li><a href="#" onclick="formSubmit('presaleAction_tocreate','_self')"><img alt="add" src="${ctx }/img/add.png"></a></li>
	  <li><a href="#" onclick="javascript:toUpdate()"><img alt="modify" src="${ctx }/img/modify.png"></a></li>
	  <!--<li><a href="#" onclick="javascript:deleteById()"><img alt="delete" src="${ctx }/img/delete.png"></a></li>
	  -->
	</ul>
</div>

<div>
	<h4>预售信息:</h4>
	<table class="table table-hover">
	  <thead>
	    <tr>
	      <th>
	      	<input type="checkbox" name="selid" onclick="checkAll('presale',this)">
	      </th>
	      <th>序号</th>
	      <th>预订单号</th>
	      <th>会员编号</th>
	      <th>门店编号</th>
	      <th>商品编号</th>
	      <th>定金</th>
	      <th>预售日期</th>
	      <th>是否支付尾款</th>
	    </tr>
	  </thead>
	 
	  <tbody>
	   	<c:forEach items="${results}" var="o" varStatus="status">
	    <tr>
	      <td style="width: 60px"><input type="checkbox" name="presale" value="${o.presale}"/></td>
	      <td>${status.index+1}</td>
	      <td>${o.presale}</td>
	      <td>${o.vip.vipNo}</td>
	      <td>${o.storeInfo.storeName}</td>
	      <td>${o.itemInfo.itemName}</td>
	      <td>${o.subscription}</td>
	      <td><fmt:formatDate value="${o.reserveDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	      <td>${o.isRemainder}</td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
</div>
<div style="text-align:center; height: 40px">${links }</div> 
</form>
</body>
</html>