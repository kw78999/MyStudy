<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- ##### Blog Content Area Start ##### -->
<div class="about-us-area section-padding-0-100">
	<div class="container">
		<div class="row justify-content-center">

			<!-- Blog Sidebar Area -->
			<div class="col-12 col-sm-9 col-md-6 col-lg-3">
				<div class="post-sidebar-area">
					<a href="lectureWriteForm?ctNum=${lecture.ctNum}" class="foode-btn">토픽을 등록해보자</a>
					<a href="lectureDelete?lcNum=${lecture.lcNum}&ctNum=${lecture.ctNum}" class="foode-btn">토픽을 삭제해보자</a>
					<!-- ##### Single Widget Area ##### -->
					<div class="single-widget-area mt-0">
						<ol class="foode-catagories">
							<li><a href="#"></a></li>
							<c:forEach var="item" items="${lectureTitle}">
								<li><a href="lectureView?ctNum=${item.ctNum}&lcNum=${item.lcNum}"><span><i class="fa fa-stop" aria-hidden="true"></i> ${item.lcTitle}</span> <span></span></a></li>
							</c:forEach>
						</ol>
					</div>
				</div>
			</div>
			<!-- ##### Blog Sidebar Area End ##### -->

			<div class="col-12 col-lg-9">
				<div class="about-content">
					${lecture.lcContent}
				</div>
			</div>
			
		</div>

	</div>
</div>
<!-- ##### Blog Content Area End ##### -->

<%@include file="../include/footer.jsp"%>

</body>
</html>