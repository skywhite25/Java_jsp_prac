<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <title>#OOTD</title>

    <!-- load CSS -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600"
    />
    <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="/css/magnific-popup.css" />
    <link rel="stylesheet" href="/css/tooplate-style.css" />
    <!-- Templatemo style -->
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Raleway:300'>
    <link rel="stylesheet" href="/css/style.css">
  </head>

  <body>
    <!-- Loader -->
      <div id="loader">
      <div class="loader-section section-left"></div>
      <div class="loader-section section-right"></div>
    </div>
    <div class="tm-main-container">
      <div class="tm-top-container">
        <!-- Menu -->
  <div id="page">
  <div id="toggle">
    <div class="bar"></div>
  </div>
  <section id="overlay">
    <nav>
      <ul>
     	<c:if test="${empty login }">
        <li><a href="${path }/notice/list.do">Notice</a></li>
		<li><a href="${path }/qna/list.do">QnA</a></li>
		<li><a href="${path }/image/list.do">Season</a></li>
		<li><a href="${path }/timeline/list.do">TimeLine</a></li>
		<li><a href="${path }/member/terms.do">Join</a></li>
		<li><a href="${path }/member/loginForm.do">Login</a></li>
		</c:if>
		<c:if test="${!empty login }">
        <li><a href="${path }/notice/list.do">Notice</a></li>
		<li><a href="${path }/qna/list.do">QnA</a></li>
		<li><a href="${path }/image/list.do">Season</a></li>
		<li><a href="${path }/timeline/list.do">TimeLine</a></li>
		<li><a href="${path }/member/view.do">MyPage</a></li>
		</c:if>
      </ul>
    </nav>
  </section>
</div>
        <!-- Menu -->

        <!-- Site header -->
        <header class="tm-site-header-box tm-bg-gray">
          <img src="/img/logo3.png" style="width: 300px;" />
                <h5 class="tm-section-title mb-3 font-weight-bold">
                  #OOTD
                </h5>
        </header>
      </div>
      <!-- tm-top-container -->

      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <!-- Site content -->
            <div class="tm-content">
              <!-- Section 0 Introduction -->
              <section class="tm-section tm-section-0">
                <div class="tm-textbox tm-bg-gray">
                  <p>
                    what
                  </p>
                </div>
               
              </section>

              <!-- Section 1 About Me -->
              <section class="tm-section tm-section-1">
                <div class="tm-textbox tm-textbox-2 tm-bg-dark">
                  <h2 class="tm-text-blue mb-4">About Me</h2>
                  <p class="mb-4">
                    You are allowed to modify and use this HTML template for
                    your personal or business websites.
                  </p>
                  <p class="mb-4">
                    You are NOT allowed to re-distribute this template file on
                    your site for any reason. Thank you.
                  </p>
                  <a
                    href="#"
                    id="tm_work_link"
                    data-linkid="2"
                    class="tm-link m-0"
                    >Next</a
                  >
                </div>
              </section>

            </div>
          </div>
        </div>
      </div>

      <div class="tm-bottom-container">
        <!-- Footer -->
        <footer>
          by.2Team
        </footer>
      </div>
    </div>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
	<script src="/js/index1.js"></script>
    <script src="/js/jquery-1.11.0.min.js"></script>
    <script src="/js/background.cycle.js"></script>
    <script src="/js/jquery.magnific-popup.min.js"></script>
    <script>
      let slickInitDone = false;
      let previousImageId = 0,
        currentImageId = 0;
      let pageAlign = "right";
      let bgCycle; 
      let links;
      let eachNavLink;

      window.onload = function() {
        $("body").addClass("loaded");
      };

      function navLinkClick(e) {
        if ($(e.target).hasClass("external")) {
          return;
        }

        e.preventDefault();

        if ($(e.target).data("align")) {
          pageAlign = $(e.target).data("align");
        }

        // Change bg image
        previousImageId = currentImageId;
        currentImageId = $(e.target).data("linkid");
        bgCycle.cycleToNextImage(previousImageId, currentImageId);

        // Change menu item highlight
        $(`.tm-nav-item:eq(${previousImageId})`).removeClass("active");
        $(`.tm-nav-item:eq(${currentImageId})`).addClass("active");

        // Change page content
        $(`.tm-section-${previousImageId}`).fadeOut(function(e) {
          $(`.tm-section-${currentImageId}`).fadeIn();
          // Gallery
          if (currentImageId === 2) {
            setupSlider();
          }
        });

        adjustFooter();
      }

      $(document).ready(function() {
        // Set first page
        $(".tm-section").fadeOut(0);
        $(".tm-section-0").fadeIn();

        // Set Background images


        eachNavLink = $(".tm-nav-link");
        links = $(".tm-nav-links");

        // "Menu" open/close
        if (links.hasClass("open")) {
          links.fadeIn(0);
        } else {
          links.fadeOut(0);
        }

        $("#tm_about_link").on("click", navLinkClick);
        $("#tm_work_link").on("click", navLinkClick);

        // Each menu item click
        eachNavLink.on("click", navLinkClick);

        $(".tm-navbar-menu").click(function(e) {
          if (links.hasClass("open")) {
            links.fadeOut();
          } else {
            links.fadeIn();
          }

          links.toggleClass("open");
        });

        // window resize
        $(window).resize(function() {
          // If current page is Gallery page, set it up
          if (currentImageId === 2) {
            setupSlider();
          }

          // Adjust footer
          adjustFooter();
        });

        adjustFooter();
      }); // DOM is ready

      function adjustFooter() {
        const windowHeight = $(window).height();
        const topHeight = $(".tm-top-container").height();
        const middleHeight = $(".tm-content").height();
        let contentHeight = topHeight + middleHeight;

        if (pageAlign === "left") {
          contentHeight += $(".tm-bottom-container").height();
        }

        if (contentHeight > windowHeight) {
          $(".tm-bottom-container").addClass("tm-static");
        } else {
          $(".tm-bottom-container").removeClass("tm-static");
        }
      }

      function setupSlider() {
        let slidesToShow = 4;
        let slidesToScroll = 2;
        let windowWidth = $(window).width();

        if (windowWidth < 480) {
          slidesToShow = 1;
          slidesToScroll = 1;
        } else if (windowWidth < 768) {
          slidesToShow = 2;
          slidesToScroll = 1;
        } else if (windowWidth < 992) {
          slidesToShow = 3;
          slidesToScroll = 2;
        }

        if (slickInitDone) {
          $("tm-gallery").slick("unslick");
        }

        slickInitDone = true;

        $("tm-gallery").slick({
          dots: true,
          customPaging: function(slider, i) {
            var thumb = $(slider.$slides[i]).data();
            return `<a>${i + 1}</a>`;
          },
          infinite: true,
          prevArrow: false,
          nextArrow: false,
          slidesToShow: slidesToShow,
          slidesToScroll: slidesToScroll
        });

        // Open big image when a gallery image is clicked.
        $("slick-list").magnificPopup({
          delegate: "a",
          type: "image",
          gallery: {
            enabled: true
          }
        });
      }
    </script>
  </body>
</html>
