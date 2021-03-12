<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<br>
<br>
<br>
<br>

<!-- ##### Contact Area Start ##### -->
<section class="contact-area">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<div class="contact-content-area">
					<div class="row">

						<div class="col-12 col-lg-6">
							<div class="contact-content">
								<h4>Get In Touch</h4>

								<!-- Contact Form Area -->
								<div class="contact-form-area">
									<form action="mailSend" method="post">
										<div class="row">
											<div class="col-12 col-lg-6">
												<div class="form-group">
													<input class="form-control" name="userName" value="${sessionScope.userName }" placeholder="Name">
												</div>
											</div>
											<div class="col-12 col-lg-6">
												<div class="form-group">
													<input type="email" class="form-control" value="${sessionScope.userEmail }" name="userEmail" placeholder="Email">
												</div>
											</div>
											<div class="col-12">
												<div class="form-group">
													<textarea class="form-control" name="message" cols="30" rows="10" placeholder="Message"></textarea>
												</div>
											</div>
											<div class="col-12">
												<button type="submit" class="btn foode-btn">Send</button>
											</div>
										</div>
										<input type="hidden" name ="adminEmail" value="kw4365@gmail.com">
									</form>
								</div>
							</div>
						</div>

						<div class="col-12 col-lg-6">
							<div class="contact-content contact-information">
								<h4>Information</h4>

								<!-- Single Contact Info -->
								<div class="single-contact-info d-flex">
									<div class="icon">
										<i class="fa fa-map-marker" aria-hidden="true"></i>
									</div>
									<p>3919 New Cut Rd, Mary land, United State.</p>
								</div>

								<!-- Single Contact Info -->
								<div class="single-contact-info d-flex">
									<div class="icon">
										<i class="fa fa-phone" aria-hidden="true"></i>
									</div>
									<p>(12)-100-100-100</p>
								</div>

								<!-- Single Contact Info -->
								<div class="single-contact-info d-flex">
									<div class="icon">
										<i class="fa fa-print" aria-hidden="true"></i>
									</div>
									<p>(12)-112-123-123</p>
								</div>

								<!-- Single Contact Info -->
								<div class="single-contact-info d-flex">
									<div class="icon">
										<i class="fa fa-envelope" aria-hidden="true"></i>
									</div>
									<p>kw4365@gmail.com</p>
								</div>

								<!-- Contact Social Info -->
								<div class="contact-social-info mt-50">
									<a href="#" data-toggle="tooltip" data-placement="top" title="Facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a> <a href="#" data-toggle="tooltip" data-placement="top"
										title="Twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a> <a href="#" data-toggle="tooltip" data-placement="top" title="Instagram"><i class="fa fa-instagram"
										aria-hidden="true"></i></a> <a href="#" data-toggle="tooltip" data-placement="top" title="Google Plus"><i class="fa fa-google-plus" aria-hidden="true"></i></a> <a href="#" data-toggle="tooltip"
										data-placement="top" title="Pinterest"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ##### Contact Area End ##### -->

<%@include file="../include/footer.jsp"%>

</body>
</html>