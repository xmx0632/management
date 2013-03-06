<%@ page language="java" pageEncoding="UTF-8" %>
<div class="span2 main-menu-span">
	<div class="well nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu">
			<li class="nav-header hidden-tablet">Main</li>
			<li><a class="ajax-link" href="${ctx}/admin/userAccount"><i class="icon-home"></i><span class="hidden-tablet"> 用户账号</span></a></li>
			<li class="nav-header hidden-tablet">Message Sample</li>
			<li><a class="ajax-link" href="${ctx}/account/user"><i class="icon-edit"></i><span class="hidden-tablet"> 演示1</span></a></li>
			<li><a class="ajax-link" href="${ctx }/task/task"><i class="icon-list-alt"></i><span class="hidden-tablet"> 演示2</span></a></li>
			<li><a class="ajax-link" href="${ctx }/api/v1/task/1"><i class="icon-picture"></i><span class="hidden-tablet"> Task</span></a></li>
			<li><a class="ajax-link" href="${ctx }/api/v2/user/1"><i class="icon-align-justify"></i><span class="hidden-tablet"> User</span></a></li>
			<li><a class="ajax-link" href="${ctx }/api/v1/admin/1"><i class="icon-calendar"></i><span class="hidden-tablet"> admin3</span></a></li>
			<li><a class="ajax-link" href="${ctx }/api/v1/admin/1.xml"><i class="icon-th"></i><span class="hidden-tablet"> admin2</span></a></li>
			<li><a class="ajax-link" href="${ctx }/api/v1/admin/1.json"><i class="icon-folder-open"></i><span class="hidden-tablet"> admin1</span></a></li>
			<li><a class="ajax-link" href="${ctx}/admin/testUser"><i class="icon-star"></i><span class="hidden-tablet"> 生成代码测试</span></a></li>
		</ul>
		<label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
	</div><!--/.well -->
</div><!--/span-->