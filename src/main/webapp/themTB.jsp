<%@page import="baoveCSDL.connection.DbCon"%>
<%@page import="baoveCSDL.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/admintest.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
 <!----======== CSS ======== -->
    <link rel="stylesheet" href="css/index.css" type="text/css" media="all" /> <!-- Style-CSS --> 
    
    <!----===== Boxicons CSS ===== -->
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

     <!-- ===== Link Swiper's CSS ===== -->
     <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>

     <!-- ===== Fontawesome CDN Link ===== -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
</head>
<body>
  <div class="container">
	
               
               <div class="card-header text-center">Thêm danh mục thông báo</div>
			<div class="card-body">
				
			<form action="<%= request.getContextPath() %>/themPages" method="post">
                
				 
                   
						
							<p>Tên nhân viên:</p>
		            <select name="tenNV" class="form-control" required>
		           
		                <option value="">-- Chọn tên của mình --</option>
		                 <%
				    Admin loggedInUser = (Admin) session.getAttribute("loggedInUser");
				    if (loggedInUser != null) {
					%>
		                <option value="<%= loggedInUser.getName() %>"><%= loggedInUser.getName() %></option>
		                <option value="2">Khác</option>
		             <%
				    } else {
				        // Người dùng chưa đăng nhập, bạn có thể xử lý tại đây
				    }
					%>
		            </select>
					   <p>Tiêu đề</p>
					<input type="text" name="tieude" class="form-control" placeholder="">
					<p>Giới thiệu</p>
					<input type="text" placeholder="vd: 100" class="form-control" name="gioithieu" required>
					
					<p>nội dung</p>
					<input type="text" placeholder="vd: 100" class="form-control" name="noidung" required>
					
					<p>số cmt</p>
					<input type="text" placeholder="vd: 100" class="form-control" name="socmt" required>
					
					<p>Ngày đăng</p>
					<input type="date" placeholder="vd: 100" class="form-control" name="noidung" required>
					
					<p>Ảnh</p>
					<input type="file" class="form-control" name="image" required>
					
					
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
						<a href="QLProduct.jsp" class="btn">Exit</a>
					</div>
					</form>
      </div>
   
   
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $("#action").click(function(){
            $(".log_form, .reg_form").toggle(1200);
        });
    </script>
</body>
</html>