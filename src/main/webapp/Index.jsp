<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="baoveCSDL.connection.DbCon"%>
<%@page import="baoveCSDL.model.*"%>
<%@page import="baoveCSDL.dao.ContactDao"%>

<%
   
    
ContactDao dl = new ContactDao(DbCon.getConnetion());
    List<Contact> quanly = dl.getAllCT();
    
%> 
   
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- basic -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- mobile metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="viewport" content="initial-scale=1, maximum-scale=1">
  <!-- site metas -->
  <title>shree</title>
  <meta name="keywords" content="">
  <meta name="description" content="">
  <meta name="author" content="">
  <!-- fevicon -->
  <link rel="icon" href="" type="image/gif" />
  <!-- bootstrap css -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!-- style css -->
  <link rel="stylesheet" href="css/style.css">
  <!-- Responsive-->
  <link rel="stylesheet" href="css/responsive.css">  
  <!-- Scrollbar Custom CSS -->
  <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
  <!-- Tweaks for older IEs-->
  <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<!-- body -->

<body class="main-layout">
  <!-- loader  -->
  <div class="loader_bg">
    <div class="loader"><img src="images/loading.gif" alt="#" /></div>
  </div>
  <!-- end loader -->
  <!-- header -->
  <header>
    <!-- header inner -->
    <div class="header-top">
      <div class="header">
        <div class="container-fluid">
          <div class="row">
            <div class="col-xl-2 col-lg-4 col-md-4 col-sm-3 col logo_section">
              <div class="full">
                <div class="center-desk">
                  <div class="logo">
                    <a href="Index.jsp"><img src="images/logotao.jpeg" alt="#" /></a>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-10 col-lg-8 col-md-8 col-sm-9">
         
               <div class="menu-area">
                <div class="limit-box">
                  <nav class="main-menu ">
                    <ul class="menu-area-main">
                      <li class="active"> <a href="index.jsp">Home</a> </li>
                      <li> <a href="product.jsp">Shop</a> </li>
                      <li> <a href="pages.jsp">Pages</a> </li>
                      <li> <a href="contact.jsp">Contact</a> </li>
                      <li> <a href="cart.jsp">Cart</a></li>
                      <li> <a href="login.jsp">logout</a> </li>
                     <li> <a href="Index.jsp"><img src="icon/icon_b.png" alt="#" /></a></li>
                     </ul>
                   </nav>
                 </div>
               </div> 
              </div>
           </div>
         </div>
       </div>
     </div>
     <!-- end header inner -->

     <!-- end header -->
     <section class="slider_section">
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">

            <div class="container-fluid padding_dd">
              <div class="carousel-caption">
                <div class="row">
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <div class="text-bg">
                     <span>Welcome To Apple</span>
                      <h1>Apple Shop</h1>
	                      <p>Anh nào chưa có người yêu
								Ăn miếng táo đỏ có nhiều em mê
								Chị nào chồng bỏ chồng chê
								Ăn miếng mít thái chồng mê đến giàu
								Bất luận là địch hay ta
								</p>
                      <form class="Vegetable">
                <input class="Vegetable_fom" placeholder="Vegetable" type="text" name=" Vegetable">
                <button class="Search_btn">Search</button>
              </form>
                      <a href="#">Contact Us</a> <a href="#">Vegetable</a>
                    </div>
                  </div>
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <div class="images_box">
                      <figure><img src="images/img2.png"></figure>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">

            <div class="container-fluid padding_dd">
              <div class="carousel-caption">

                <div class="row">
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <div class="text-bg">
                      <span>Welcome To Apple</span>
                      <h1>Xoài</h1>
                      <p>Đây cũng là loại trái cây quen thuộc với các bạn. Mùa hè là mùa xoài ngon nhất, trái Xoài của Việt Nam rất tươi, ngọt và thật sự rất ngon.
Xoài của mỗi vùng miền cũng có nét đặc trưng riêng, trái Xoài của miền Nam tương đối to còn miền Bắc thì nhỏ hơn.
 
Giá cả tùy thuộc vào từng loại, nhưng các bạn có thể ăn trái Xoài của Việt Nam với giá chỉ khoảng 30.000 đồng (140 yên) /1 kg và đó là một giá không tưởng ở Nhật Bản nhỉ!  </p>
                      <form class="Vegetable">
                <input class="Vegetable_fom" placeholder="Vegetable" type="text" name=" Vegetable">
                <button class="Search_btn">Search</button>
              </form>
                      <a href="#">Product</a> <a href="#">Vegetable</a>
                    </div>
                  </div>

                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <div class="images_box">
                      <figure><img src="images/xoai.png"></figure>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>


          <div class="carousel-item">

            <div class="container-fluid padding_dd">
              <div class="carousel-caption ">
                <div class="row">
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <div class="text-bg">
                      <span>Welcome To Apple</span>
                      <h1> Vải</h1>
                      <p>Ở Nhật Bản trái Vải thường được sử dụng trong đồ uống nhưng các bạn sẽ không thường thấy loại trái này thực tế trong các siêu thị.
 
						Việt Nam cũng là quốc gia đứng thứ 2 thế giới về xuất khẩu trái Vải.
						Mùa Vải ngon và nhiều nhất là từ tháng 5 đến tháng 7, hình dạng quả vải giống quả dâu tây và có kiểu mọc lông (gai) trên bề mặt vỏ.
						 
						Ở Việt Nam, các bạn có thể ăn Vải với giá khoảng 30.000 đồng (140 yên) đến 50.000 đồng (235 yên)/ 1kg.
						Đối với người Nhật đang sinh sống tại Việt Nam thì đây cũng là loại trái cây phổ biến.</p>
                       <form class="Vegetable">
                <input class="Vegetable_fom" placeholder="Vegetable" type="text" name=" Vegetable">
                <button class="Search_btn">Search</button>
              </form>
                      <a href="#">Contact Us</a> <a href="#">Vegetable</a>
                    </div>
                  </div>
                  <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                    <div class="images_box">
                      <figure><img src="images/vai.jpeg"></figure>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

</section>
</div>
</header>
</body>



<!-- about  -->
<div id="about" class="about">
  <div class="container-fluid">
    <div class="row">
      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
        <div class="about-box">
          <h2>Product</h2>
          <p>Ăn trái cây hay ăn hoa quả (thuật ngữ Latin: Frugivore) là bất kỳ loại động vật ăn cỏ hay ăn tạp nào xem trái cây là một loại thức ăn ưa thích trong chế độ ăn của mình. Khoảng 20% động vật ăn cỏ có vú là động vật ăn trái cây, việc này được coi là phổ biến ở động vật có vú. Những động vật ăn trái cây ăn một lượng lớn trái cây, chúng phụ thuộc rất nhiều vào sự phong phú và thành phần dinh dưỡng của trái cây. Nhóm động vật ăn trái cây hay nhóm ăn quả có thể kể đến là đười ươi, khỉ, voọc mũi hếch, vượn đen họ cáo có túi, chuột sóc, nhím. Thực tế không nhiều động vật thuần túy chỉ ăn trái cây vì nhiều loại trái cây đâm hoa kết trái theo mùa, lúc trái mùa không có quả thì chúng phải bổ sung lá 🥬, hoa🌻, cỏ 🌾trong thực đơn của mình.</p>
          <a href="product.jsp">Go</a>
        </div>
      </div>
      <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 padding_rl">
        <div class="about-box_img">
          <figure><img src="images/tao.jpeg" alt="product.jsp" /></figure>
        </div>
      </div>
    </div>

  </div>
</div>
<!-- end abouts -->



<!-- vegetable -->
<div id="vegetable" class="vegetable">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div  class="titlepage">
          <h2> Fresh <strong class="llow">vegetable</strong> </h2>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-xl-5 col-lg-5 col-md-5 col-sm-12 ">
        <div class="vegetable_shop">
          <h3>Best Vegetables Shop</h3>
          <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages andIt is a long established fact that a reader will be distracted.🍎  </p>
        </div>
      </div>
       <div class="col-xl-7 col-lg-7 col-md-7 col-sm-12 ">
        <div class="vegetable_img">
         <figure><img src="images/v1.jpg" alt="#"/></figure>
         <span>01</span>
        </div>
      </div>
       <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 ">
        <div class="vegetable_img margin_top">
         <figure><img src="images/v2.jpg" alt="#"/></figure>
         <span>02</span>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- end vegetable -->




   <!-- clients -->
    <div id="testimonial" class="clients">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="titlepage">
                        <h2>testimonial</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="clients_red">
        <div class="container">
            <div id="testimonial_slider" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ul class="carousel-indicators">
                    <li data-target="#testimonial_slider" data-slide-to="0" class=""></li>
                    <li data-target="#testimonial_slider" data-slide-to="1" class="active"></li>
                    <li data-target="#testimonial_slider" data-slide-to="2" class=""></li>
                </ul>
                <!-- The slideshow -->
                <div class="carousel-inner">
                    <div class="carousel-item">
                        <div class="testomonial_section">

                            <div class="full testimonial_cont">
                                <div class="row">
                                  
                                    <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 pa_right">
                                        <div class="testomonial_img">
                                            <figure><img src="images/nhon.jpg" alt="#"/></figure>
                                            <i><img src="images/test_con.png" alt="#"/></i>
                                        </div>
                                    </div>
                                    <div class="col-xl-9 col-lg-9 col-md-9 col-sm-12 pa_left">
                                        <div class="cross_inner">
                                     
                                            <h3>Mr. Nhơn<br><strong class="ornage_color">Manager </strong></h3>
                                            <p>
                                        – Giúp khách hàng thấy được sự chuyên nghiệp của bạn: Lời cảm ơn từ lâu vốn được coi là một nét văn hoá của người lịch sự. 
                                        Khi gửi lời cảm ơn tới khách hàng, bạn đã xây dựng một hình ảnh tinh tế và lịch sự trong mắt đối tác, 
                                        khách hàng. Điều này còn góp phần làm tăng cả sự uy tín, sự chuyên nghiệp trong việc chăm sóc khách hàng của doanh nghiệp. 
                                            </p>
										
                                        </div>
                                    </div>
                                  
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="carousel-item active">
						
                        <div class="testomonial_section">
                         
                            <div class="full center">
                            </div>
                            <div class="full testimonial_cont ">
                                <div class="row">
                                    <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 pa_right">
                                        <div class="testomonial_img">
                                            <figure><img src="images/ct.jpeg" alt="#"/></figure>
                                            <i><img src="images/test_con.png" alt="#"/></i>
                                        </div>
                                    </div>
                                    <div class="col-xl-9 col-lg-9 col-md-9 col-sm-12 pa_left">
                                        <div class="cross_inner">
                                         <%
									if(!quanly.isEmpty()) {
										for (Contact q : quanly) {		
										%>
                                            <h3><%=q.getName() %><br><strong class="ornage_color"><%=q.getMessage() %></strong></h3>
                                          
                                               <%}	
										}
										%>
										
										
                                        </div>
                                    </div>
                                </div>
                            </div>
                          
                        </div>

                    </div>



                </div>

            </div>
        </div>
    </div>
  
    <!-- end clients -->




<!-- contact -->
<div id="contact" class="contact">
  <div class="container">
   <div class="row">
     <div class="col-md-12">
                <div class="titlepage">
                  <h2>Contact <strong class="llow">us</strong></h2>
                </div>
   </div>

</div>
    <div class="white_color">
      <div class="row">
			
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
           <form class="contact_bg" action="addContac" method="post" >
            <div class="row">
              <div class="col-md-12">
              
                   <%
					        User loggedInUser = (User) session.getAttribute("loggedInUser");
					        if (loggedInUser != null) {
					    %>
                   <select name="name" class="contactus" required>
		                <option value="">-- Tên Của bạn --</option>
		                <option value="<%= loggedInUser.getName() %>"><%= loggedInUser.getName() %></option>
		                <option value="2">Khác</option>
		            </select>
                  
					    
                     
                       
                          <%
				    } else {
				        // Người dùng chưa đăng nhập, bạn có thể xử lý tại đây
				    }
					%>
                </div>
                <div class="col-md-12">
                  <input class="contactus" placeholder="Email" type="text" name="email">
                </div>
                <div class="col-md-12">
                  <input class="contactus" placeholder="Phone Number" type="text" name="phone">
                </div>
                <div class="col-md-12">
                  <textarea class="textarea" placeholder="Message" type="text" name="message"></textarea>
                </div>
                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                  <button class="send">Send</button>
                </div>
              </div>
            </form>
          </div>
            </div>
      
        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
<div id= "map"
>
          </div>
           </div>
          </div>
        </div>

      </div>
    </div>
</div>
</div>
    <!-- end contact -->

    <!--  footer -->
    <footr>
      <div class="footer ">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
             <a href="#" class="logo_footer"> <img src="images/logo2.png" alt="#"/></a>
            </div>
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 ">
              <div class="row">
                <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6 ">
                  <div class="address">
                    <h3>Address </h3>
                    <ul class="loca">
                      <li>
                        <a href="#"></a>It is a long established fact 
                        <br>that a reader will be  </li>
                        <li>
                          <a href="#"></a>(+71 1234567890) </li>
                          <li>
                            <a href="#"></a>demo@gmail.com</li>
                          </ul>
                        </div>
                      </div>
                      <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="address">
                          <h3>Social Link</h3>
                          <ul class="Menu_footer">
                            <li class="active"> <a href="#">Twitter</a> </li>
                            <li><a href="#">Facebook</a> </li>
                            <li><a href="#">Instagram</a> </li>
                            <li><a href="#">Linkdin</a> </li>
                          </ul>
                        </div>
                      </div>
                     

                      <div class="col-lg-4 col-md-6 col-sm-6 ">
                        <div class="address">
                          <h3>Newsletter</h3>
                           <form class="news">
                           <input class="newslatter" placeholder="Enter your email" type="text" name=" Enter your email">
                            <button class="submit">Subscribe</button>
                            </form>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>

              </div>
              <div class="copyright">
                <div class="container">
                  <p>Copyright Â© 2023 Cao Nhat Nhon <a href="https://html.design/">20CNTT3 </a></p>
                </div>
              </div>
            </div>
          </footr>
          <!-- end footer -->
          <!-- Javascript files-->
          <script src="js/jquery.min.js"></script>
          <script src="js/popper.min.js"></script>
          <script src="js/bootstrap.bundle.min.js"></script>
          <script src="js/jquery-3.0.0.min.js"></script>
          <script src="js/plugin.js"></script>
          <!-- sidebar -->
          <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
          <script src="js/custom.js"></script>
          <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>


          <script>
// This example adds a marker to indicate the position of Bondi Beach in Sydney,
// Australia.
function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 11,
    center: {
      lat: 40.645037,
      lng: -73.880224
    },
  });

  var image = 'images/maps-and-flags.png';
  var beachMarker = new google.maps.Marker({
    position: {
      lat: 40.645037,
      lng: -73.880224
    },
    map: map,
    icon: image
  });
}
</script>
<!-- google map js -->

<!-- end google map js -->



</body>

</html>