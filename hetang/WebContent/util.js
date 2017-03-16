function toggleLock() {
	var userItem = $(this).parents("#userItem")
	var data = $(userItem).data("data")
	if (data.state == 0) {
		$.post("LockUser", {
			id : data.id
		})
	} else {
		$.post("UnlockUser", {
			id : data.id
		})
	}
}
function gotoUpdateUser() {
	var userItem = $(this).parents("#userItem")
	var data = $(userItem).data("data")
	location = "updateUser.jsp?userId=" + data.id
}
function deleteUser() {
	var userItem = $(this).parents("#userItem")
	var data = $(userItem).data("data")
	$.post("DeleteUser", {
		id : data.id
	}, function() {
		$(userItem).slideUp(1000, function() {
			$(userItem).remove()
		})
	})
}
function addToUserList(view, data) {
	for ( var index in data) {
		var i = data[index]
		var it = $(view).children().eq(0).clone()
		$(it).find("#num").text(i.num)
		$(it).find("#name").text(i.name)
		$(it).find("#remark").text(i.remark)
		$(it).find("#registerTime").text(convertTime(i.createdTime))
		$(it).find("#lastAccessTime").text(convertTime(i.lastAccessTime))
		$(it).find("#userType").text(i.userType)
		$(it).find("#state input").attr("checked", i.state != 0).click(
				toggleLock)
		$(it).find("#updateUser").click(gotoUpdateUser)
		$(it).find("#deleteUser").click(deleteUser)
		$(it).data("data", i).appendTo($(view)).removeClass("hidden")
	}
}
function format(n) {
	if (n < 10)
		return "0" + n;
	else
		return n;
}
function convertTime(t) {
	var date = new Date(t)
	var now = new Date()
	var nowtime = now.getTime()
	if (nowtime - t < 3 * 60 * 1000) {
		return "刚刚"
	}
	if (nowtime - t < 3600 * 1000) {
		return Math.round((nowtime - t) / 60000) + "分钟前"
	}
	var day = " 昨天 前天 大前天".split(" ");
	for (var i = 0; i < day.length; i++) {
		var s = day[i]
		if (nowtime - t < 1000 * 3600 * 24 * (i + 1)
				&& date.getDate() + i >= now.getDate()) {
			if (date.getHours() < 12) {
				return s + "上午" + format(date.getHours()) + ":"
						+ format(date.getMinutes())
			} else if (date.getHours() == 12) {
				return s + "中午12:" + format(date.getMinutes())
			} else {
				return s + "下午" + format(date.getHours() - 12) + ":"
						+ format(date.getMinutes())
			}
		}
	}
	if (date.getFullYear() == now.getFullYear()) {
		return date.getMonth() + "月" + date.getDay() + "日"
	}
	return date.toLocaleDateString()
}
function getParameter(arg, href) {
	var s = typeof (href) == "undefined" ? location.href : href
	if (s.indexOf('?') == -1)
		return null;
	else {
		s = s.substr(s.indexOf("?") + 1).split("&")
		for ( var i in s) {
			var eq = s[i].indexOf('=')
			var k = s[i].substring(0, eq), v = s[i].substring(eq + 1)
			if (k == arg)
				return v;
		}
		return null;
	}
}
