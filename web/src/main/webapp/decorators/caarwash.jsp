<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<html lang="en">
<head>
    <title> <fmt:message key="webapp.name"/> | <fmt:message key="webapp.tagline"/></title>
    <jsp:include page="/common/meta.jsp"/>
    <jsp:include page="/common/tracking/ga.jsp"/>
    <jsp:include page="/common/tracking/gtm.jsp"/>
    <link rel="icon" href="<c:url value="/images/favicon.ico"/>"/>
    <title><decorator:title/> | <fmt:message key="webapp.name"/></title>
    <t:assets type="js"/>
    <%--<script src="/scripts/intlTelInput.min.js"></script>--%>
    <%--<script src="/scripts/main.js"></script>--%>
    <%--<script src="/scripts/spin.min.js"></script>--%>
    <%--<script src="/scripts/contactForm.js"></script>--%>
    <link rel="shortcut icon" type="image/png" href="http://www.grofers.com/ico/favicon.ico">

    <t:assets type="css"/>
    <decorator:head/>
</head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>
<c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>

<header>
    <div id="one"></div>
    <a class="navbar-brand" href="./Grofers - Your instant delivery app_files/Grofers - Your instant delivery app.html">
        <img src=""></a>
    <nav id="cd-top-nav">
        <ul>
            <li><a href="http://www.grofers.com/mobile">MOBILE APP</a></li>
            <li><a href="javscript:void(0)">BLOG</a></li>
            <li><a class="modal-title" id="contactButton" style="cursor:pointer">CONTACT</a></li>
            <li class="menu-text"><a id="cd-menu-text-trigger" href="http://www.grofers.com/#0"><span class="cd-menu-text">MENU</span></a></li>
        </ul>
    </nav>
    <a id="cd-menu-trigger" href="javascript:void(0);"><span class="cd-menu-icon"></span></a>
</header>

<nav id="cd-lateral-nav">
    <ul class="cd-navigation links">
        <li class="top-link"><a href="http://www.grofers.com/aboutus">ABOUT US</a></li>
        <li class="hidden-md"><a href="http://www.grofers.com/mobile">MOBILE APP</a></li>
        <li class="hidden-md"><a target="_blank" href="http://www.grofers.com/careers" class="hiring-bold">WE'RE HIRING</a></li>
        <li class="hidden-md"><a href="http://www.grofers.com/blog">BLOG</a></li>
        <li class="hidden-md"><a class="modal-title" id="contactButton" style="cursor:pointer">CONTACT</a></li>
        <li><a href="http://www.grofers.com/api">DEVELOPERS</a></li>
    </ul>
    <ul class="cd-navigation links">
        <!-- <li><a href="#0">Media Kit</a></li> -->
        <li><a href="http://www.grofers.com/terms">TERMS &amp; CONDITIONS</a></li>
        <li><a href="http://www.grofers.com/privacy">PRIVACY POLICY</a></li>
        <li><a href="http://www.grofers.com/login.php">LOGIN</a></li>
    </ul>

    <ul class="cd-navigation social-media">
        <li class="social">
            <a class="first-icon twitter" href="https://twitter.com/grofers" target="_blank">
                <i title="Follow us on Twitter" class="grofers-social-icon fa fa-twitter fa-lg"></i>
            </a>
            <a class="facebook" href="https://www.facebook.com/Grofers" target="_blank">
                <i title="Like us ? Share on Facebook!" class="grofers-social-icon fa fa-facebook fa-lg"></i>
            </a>
            <a class="google" target="_blank" href="https://plus.google.com/b/107649970555039572894/dashboard/overview/getstarted?hl=en&service=plus">
                <i title="Google plus" class="grofers-social-icon fa fa-google-plus fa-lg
                    "></i>
            </a>
            <a class="linkedin" target="_blank" href="https://www.linkedin.com/company/3561164?trk=tyah&trkInfo=tarId%3A1411112717095%2Ctas%3Agrofers%2Cidx%3A1-1-1">
                <i title="Linkedin" class="grofers-social-icon fa fa-linkedin fa-lg"></i>
            </a>
            <a class="github" target="_blank" href="http://github.com/grofers">
                <i title="We code" class="grofers-social-icon fa fa-github fa-lg"></i>
            </a>
        </li>
    </ul>
    <footer class="footer mobile-footer">
        <ul class="cd-navigation footer-border">
            <li><i class="fa fa-copyright copyright fa-lg"></i>
                </li>
        </ul>
    </footer>
</nav>

<div id="contactModalContainer">
    <div class="modal fade" id="contactModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel" style="color:#E96125">Contact</h4>
                </div>
                <div id="contactResponse" class="modal-body">
                    <form id="cPass" class="form-horizontal" data-async="" data-target="#contact-modal" action="http://www.grofers.com/mail/contact_me.php" method="POST">
                        <p>
                            <input id="name" name="name" placeholder="Name" class="form-control" type="text" required="" autofocus="">
                        </p>
                        <p>
                            <input id="email" name="email" placeholder="Email Address" class="form-control" type="email" required="">
                        </p>
                        <p>
                            <input id="phone" name="phone" placeholder="Phone Number" class="form-control" type="phone" required="">
                        </p>
                        <p>
                            <input id="date" name="date" placeholder="Date" class="form-control" type="text" required="">
                        </p>
                        <p>
                            <input id="time" name="time" placeholder="Time" class="form-control" type="text" required="">
                        </p>
                        <p>
                            <label></label>
                            <textarea rows="5" name="message" class="form-control" placeholder="Message" id="message" required="" data-validation-required-message="Please enter a message."></textarea>
                        </p>
                        <p>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button class="btn btn-primary" id="contact-form-send-button" type="submit" style="background-color:#E0471D;
                    												     border-color:#E0471D">Send</button>
                        </p>
                    </form>
                </div>
            </div>
        </div> <!-- modal content closes-->
    </div> <!-- modal -->
</div> <!-- modal-->

<main class="cd-main-content">
    <div id="two"></div>
    <div class="container">
        <div class="row top-buffer"></div>
        <div class="row top-buffer"></div>
        <div class="row top-buffer"></div>
        <div class="row">
            <!-- <div class="col-lg-12 text-center">
                <div class="center-heading">Your <span style="font-weight:900">Instant Delivery</span> App</div>
                <div class="top-buffer-20"></div>
            </div> -->
            <div class="col-lg-12 use-case-text text-center">
                <!-- <div class="center-subheading lead"> -->

                <!-- <span>Get </span> -->

                <div class="grofers-anything display-first" style="display: none; opacity: 1;">Any Car</div>
                <div class="grofers-anything" style="display: none; opacity: 1;">Sedan</div>
                <div class="grofers-anything" style="display: none; opacity: 1;">Hatch</div>
                <div class="grofers-anything" style="display: none; opacity: 1;">SUV</div>

                <span class="90-min-delivery">get washed in less than 60 minutes</span>
                <!-- </div> -->
            </div>
            <div class="col-lg-4">
            </div>


        </div>
        <div class="row top-buffer"></div>
        <div class="row top-buffer"></div>
        <div id="append-data" class="row">
            <div class="center-block text-center" id="phone-number-container">
                <i title="Enter your mobile number" class="grofers-social-icon fa fa-mobile fa-lg"></i><div class="intl-tel-input">

                <input type="tel" id="user-phone-value" placeholder="+91">

                <div class="flag-dropdown">
                    <div class="selected-flag" title="India (भारत): +91">
                        <div class="flag in">
                            <div class="arrow"></div>
                        </div>
                    </div>
                </div>
            </div>

                <button title="and chill" id="get-app-button" type="button" class="grofers-get-app btn" data-toggle="modal" data-target="#contactModal">Book Now</button>
            </div>
            <div class="row top-buffer text-center or-class">
                or
            </div>
            <div class="row top-buffer-20 text-center call-grofers">
                Call us on&nbsp;&nbsp;&nbsp;<a class="grofers-phone" href="tel:+9198846 63623">98846 63623</a>
            </div>
        </div>

        <!-- /.row -->

    </div>
    <!-- /.container -->
</main>

<div id="footer" class="container navbar-fixed-bottom">
        <span class="col-sm-6 text-left"><fmt:message key="webapp.version"/>
            <c:if test="${pageContext.request.remoteUser != null}">
                | <fmt:message key="user.status"/> ${pageContext.request.remoteUser}
            </c:if>
        </span>
        <span class="col-sm-6 text-right">
            &copy; <fmt:message key="copyright.year"/> <a href="<fmt:message key="company.url"/>"><fmt:message key="company.name"/></a>
        </span>
</div>
<%= (request.getAttribute("scripts") != null) ?  request.getAttribute("scripts") : "" %>
</body>
</html>
