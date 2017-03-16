<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="table table-striped table-hover">
  <thead>
    <tr>
      <th>编码</th>
      <th>名称</th>
      <th>封存</th>
      <th>注册时间</th>
      <th>上次登录时间</th>
      <th>用户类型</th>
      <th>备注</th>
      <th>操作</th>
    </tr>
  </thead>
  <tbody id='userTable'>
    <tr id='userItem' class="hidden">
      <td id='num'>one</td>
      <td id='name'>two</td>
      <td id='state'>
        <div class="checkbox">
          <input type="checkbox" checked>
        </div>
      </td>
      <td id='registerTime'>three</td>
      <td id='lastAccessTime'>three</td>
      <td id='userType'>three</td>
      <td id='remark'>three</td>
      <td><div class="dropdown">
          <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
            操作
            <span class="caret"></span>
          </button>
          <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
            <li role="presentation"><a role="menuitem" href="#" id='updateUser'><span class='glyphicon glyphicon-edit'>更改用户</span></a></li>
            <li role="presentation"><a role="menuitem" href="#" id='deleteUser'><span class='glyphicon glyphicon-remove'>删除用户</span></a></li>
          </ul>
        </div></td>
    </tr>
  </tbody>

</table>