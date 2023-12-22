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
	
               
               <div class="card-header text-center">add Product Rau</div>
			<div class="card-body">
				
			<form action="<%= request.getContextPath() %>/themProductRServlet" method="post">
                   <p>Tên mặt hàng</p>
					<input type="text" name="nameR" class="form-control" placeholder="vd: ChÃ³ pull">
				
						
					<p>Thể loại</p>
					<input type="text" placeholder="vd: thÃº cÆ°ng" class="form-control" name="categoryR" required>
					
						
					<p>Giá sản phẩm</p>
					<input type="text" placeholder="vd: 100" class="form-control" name="priceR" required>
					<p>khuyến mãi</p>
					<input type="text" placeholder="vd: 100%" class="form-control" name="saleR" required>
					
					<p>Ảnh sản phẩm</p>
					<input type="text" placeholder="vd: cho.jpg" class="form-control" name="imageR" required>
					
					<p>chi tiết sản phẩm</p>
					<input type="text" placeholder="vd: hihi" class="form-control" name="chitietR" required>
					
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