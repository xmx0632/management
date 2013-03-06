<c:if test="${not empty message}">
	<div id="message" class="alert alert-success">
		<button data-dismiss="alert" class="close">×</button>
		${message}
	</div>
</c:if>
<c:if test="${not empty error}">
	<div id="error" class="alert alert-danger">
		<button data-dismiss="alert" class="close">×</button>
		${error}
	</div>
</c:if>