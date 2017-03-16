<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='a/bootstrap.css' />
<script type="text/javascript" src='a/jquery.js'></script>
<script type="text/javascript" src='a/bootstrap.js'></script>
<script type="text/javascript" src='a/jquery.cookie.js'></script>
<script type="text/javascript" src='util.js'></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-md-2">
        <jsp:include page="main-nav.jsp"></jsp:include></div>
      <div class="col-md-10">
        <div class="center-block">
          <input id="searchBox" type="text" class="form-control" placeholder="请输入用户名,按enter键搜索">
          <jsp:include page="userlist.jsp"></jsp:include>
        </div>
      </div>
    </div>
    <!-- row end-->
  </div>
  <!-- container end -->
</body>

<script type="text/javascript">
	$("#main-nav #userListByName").addClass("active")
	$("#searchBox").keydown(function(e) {
		if (e.which == 13) {
			$.getJSON("UserListByName", {
				key : $("#searchBox").val()
			}, function(data) {
				addToUserList($("#userTable"), data)
			})
		}
	})
</script>
</html>