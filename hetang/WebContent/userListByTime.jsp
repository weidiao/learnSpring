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
          <input type="text" class="form-control" name="daterange" value="01/01/2015 - 01/31/2015" style="margin-top: 50px;" />
          <jsp:include page="userlist.jsp"></jsp:include>
        </div>
      </div>
    </div>
    <!-- row end-->
  </div>
  <!-- container end -->
</body>

<script type="text/javascript">
	$("#main-nav #userListByTime").addClass("active")
	function load(start, end) {
		console.log(start+" "+end)
		$.getJSON("UserListByCreatedTime", {
			beg : start,
			end : end
		}, function(data) {
			console.log(JSON.stringify(data))
			addToUserList($("#userTable"), data)
		})
	}
	$('input[name="daterange"]')
			.daterangepicker(
					{
						"startDate" : "06/16/2016",
						"endDate" : "06/18/2016",
						ranges : {
							'今天' : [ moment(), moment() ],
							'昨天' : [ moment().subtract(1, 'days'),
									moment().subtract(1, 'days') ],
							'最近一周' : [ moment().subtract(6, 'days'), moment() ],
							'最近一月' : [ moment().subtract(29, 'days'), moment() ],
							'本月' : [ moment().startOf('month'),
									moment().endOf('month') ],
							'上月' : [
									moment().subtract(1, 'month').startOf(
											'month'),
									moment().subtract(1, 'month')
											.endOf('month') ]
						},
						autoUpdateInput : true,
						timePicker : true
					}, function(start, end, label) {
						load(start.valueOf(), end.valueOf())
					});
</script>
</html>