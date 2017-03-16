<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='a/bootstrap.css' />
<script type="text/javascript" src='a/jquery.js'></script>
<script type="text/javascript" src='a/bootstrap.js'></script>
<script type="text/javascript" src='a/jquery.cookie.js'></script>
<script type="text/javascript" src='util.js'></script>
<link rel="stylesheet" href="a/daterangepicker.css" />
<link rel="stylesheet" href="a/select2.min.css" />
<script type="text/javascript" src="a/select2.min.js"></script>
<script type="text/javascript" src="a/moment.js"></script>
<script type="text/javascript" src="a/daterangepicker.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-2">
        <jsp:include page="main-nav.jsp"></jsp:include></div>
      <div class="col-md-10">
        <div class="center-block">
          <select class="form-control" id="userType">
            <option value="0">学生</option>
            <option value="1">老师</option>
            <option value="2">工人</option>
          </select>
          <jsp:include page="userlist.jsp"></jsp:include>
        </div>
      </div>
    </div>
    <!-- row end-->
  </div>
  <!-- container end -->
</body>

<script type="text/javascript">
	$("#main-nav #userListByUserType").addClass("active")
	$("#userType").select2().change(function() {
		load($(this).val())
	})
	function load(userType) {
		$("#userTable").children().eq(0).siblings().remove()
		$.getJSON("UserListByUserType", {
			userType : userType
		}, function(data) {
			addToUserList($("#userTable"), data)
		})
	}
	load(0)
</script>
</html>