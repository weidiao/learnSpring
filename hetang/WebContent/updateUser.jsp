<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='a/bootstrap.css' />
<script type="text/javascript" src='a/jquery.js'></script>
<script type="text/javascript" src='a/bootstrap.js'></script>
<script type="text/javascript" src='a/jquery.cookie.js'></script>
<script type="text/javascript" src='util.js'></script>
<link rel="stylesheet" href="a/select2.min.css" />
<script type="text/javascript" src="a/select2.min.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-2">
        <jsp:include page="main-nav.jsp"></jsp:include></div>
      <div class="col-md-8">
        <div class="center-block" style="width: 700px">
          <form role="form" method="POST" action="UpdateUser" style="padding-top: 20px; font-size: 20px;">
            <input name="id" class="hidden">
            <div class="form-group">
              <input name='num' type="text" class="form-control" placeholder="用户编码">
            </div>
            <div class="form-group">
              <input name='name' type="text" class="form-control" placeholder="用户姓名">
            </div>
            <div class="form-group">
              <label>用户状态</label> <label class="checkbox-inline"> <input type="radio" name="state" value="0" class="input-lg"> 封锁
              </label> <label class="checkbox-inline"> <input type="radio" name="state" value="1" class="input-lg"> 解封
              </label>
            </div>
            <div class="form-group">
              <label>用户类型</label> <select class="form-control" id="userType" name="userType">
                <option value="0">学生</option>
                <option value="1">老师</option>
                <option value="2">工人</option>
              </select>
            </div>
            <div class="form-group">
              <textarea class="form-control" rows="13" placeholder="备注" name="remark" cols="13"></textarea>
            </div>
            <div>
              <button type="submit" class="btn btn-lg btn-block btn-primary">提交</button>
            </div>
          </form>
        </div>
      </div>
      <!-- col-md-8  end-->
      <div class="col-md-2">haha weidiao</div>
    </div>
    <!-- row end-->
  </div>
  <!-- container end -->
</body>
<script type="text/javascript">
	var userId = getParameter("userId")
	$("#main-nav #updateUser").addClass("active").removeClass("hidden")
	$("#userType").select2()
	console.log(userId)
	$.getJSON("UserById", {
		id : userId
	}, function(data) {
		$("[name=id]").val(userId)
		$("[name=num]").val(data.num)
		$("[name=name]").val(data.name)
		$("[name=remark]").val(data.remark)
		$("[name=userType]").val(data.userType)
		if (data.state == 0)
			$("[name=state]").eq(0).attr("checked", true)
		else
			$("[name=state]").eq(1).attr("checked", true)
	})
</script>
</html>