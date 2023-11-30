<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!--__________________________________________________________________________________________[↓ 부트스트랩 링크 ]-->
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/main.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
 integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
 crossorigin="anonymous"></script>
 
<!--__________________________________________________________________________________________[↓ 폰트어썸 링크 ]-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

<!--__________________________________________________________________________________________[↓ 폰트 링크 ]-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@600&family=Orbit&display=swap" rel="stylesheet">

<script type="text/javascript">
	var loopSearch=true;
	function keywordSearch(){
		if(loopSearch==false)
			return;
	 var value=document.frmSearch.searchWord.value;
		$.ajax({
			type : "get",
			async : true, //false인 경우 동기식으로 처리한다.
			url : "${contextPath}/goods/keywordSearch.do",
			data : {keyword:value},
			success : function(data, textStatus) {
			    var jsonInfo = JSON.parse(data);
				displayResult(jsonInfo);
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다."+data);
			},
			complete : function(data, textStatus) {
				//alert("작업을 완료했습니다");	
			}
		}); //end ajax	
	}
	
	function displayResult(jsonInfo){
		var count = jsonInfo.keyword.length;
		if(count > 0) {
		    var html = '';
		    for(var i in jsonInfo.keyword){
			   html += "<a href=\"javascript:select('"+jsonInfo.keyword[i]+"')\">"+jsonInfo.keyword[i]+"</a><br/>";
		    }
		    var listView = document.getElementById("suggestList");
		    listView.innerHTML = html;
		    show('suggest');
		}else{
		    hide('suggest');
		} 
	}
	
	function select(selectedKeyword) {
		 document.frmSearch.searchWord.value=selectedKeyword;
		 loopSearch = false;
		 hide('suggest');
	}
		
	function show(elementId) {
		 var element = document.getElementById(elementId);
		 if(element) {
		  element.style.display = 'block';
		 }
		}
	
	function hide(elementId){
	   var element = document.getElementById(elementId);
	   if(element){
		  element.style.display = 'none';
	   }
	}
</script>

<body>
<%-- 	<div id="logo">
		<a href="${contextPath}/main/main.do"> <img width="176"
			height="80" alt="booktopia"
			src="${contextPath}/resources/image/Booktopia_Logo.jpg">
		</a>
	</div> --%>
	
<!--__________________________________________________________________________________________[↓ 최상단 메뉴 ]-->
	<div id="head_link">
		<ul>
			<c:choose>
				<c:when test="${isLogOn==true and not empty memberInfo }">
					<li><a href="${contextPath}/member/logout.do">로그아웃</a></li>
					<li><a href="${contextPath}/mypage/myPageMain.do">마이페이지</a></li>
					<li><a href="${contextPath}/cart/myCartList.do">장바구니</a></li>
					<li><a href="#">주문배송</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${contextPath}/member/loginForm.do">로그인</a></li>
					<li><a href="${contextPath}/member/memberForm.do">회원가입</a></li>
				</c:otherwise>
				
			</c:choose>
<!-- 			<li><a href="#">고객센터</a></li> -->
			<c:if test="${isLogOn==true and memberInfo.member_id =='admin' }">
				<li class="no_line"><a
					href="${contextPath}/admin/goods/adminGoodsMain.do">관리자</a></li>
			</c:if>
		</ul>
	</div>

	<br>

<!--__________________________________________________________________________________________[↓ 검색창 메뉴 ]-->
				<!-- 스낵-snack 면류-noodle 유제품-dairy 음료-drink 도시락/샌드위치-sandwich 생활잡화-etc -->
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        
        <a class="navbar-brand" href="${contextPath}/main/main.do"><img src="${contextPath}/resources/image/logo.png"></a>
        
        <button class="navbar-toggler" type="button"
            data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="${contextPath}/main/main.do">　홈</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">　카 테 고 리　</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="${contextPath}/category/sandwich.do?category=도시락/샌드위치">도시락/샌드위치</a></li>
                        <li><a class="dropdown-item" href="${contextPath}/category/noodle.do?category=라면/면류">라면/면류</a></li>
                        <li><a class="dropdown-item" href="${contextPath}/category/dairy.do?category=유제품">유제품</a></li>
                        <li><a class="dropdown-item" href="${contextPath}/category/drink.do?category=음료">음료</a></li>
                        <li><a class="dropdown-item" href="${contextPath}/category/snack.do?category=스낵">스낵</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="${contextPath}/category/etc.do?category=생활잡화">생활잡화</a></li>
                    </ul>
                </li>
            </ul>
            
            <form class="d-flex" role="search" name="frmSearch" action="${contextPath}/goods/searchGoods.do">
                <div class="input-group">
                    <input class="form-control" name="searchWord" type="search" onKeyUp="keywordSearch()" placeholder="검색할 내용을 입력해주세요" aria-label="Search">
                    <button class="btn btn-outline-success" name="search" type="submit">Search</button>
                </div>
            </form>
       
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<c:choose>
					<c:when test="${header_menu=='admin_mode' }">
						<li class="nav-item"><a class="nav-link" href="${contextPath}/admin/goods/adminGoodsMain.do">상품관리</a></li>
       					<li class="nav-item"><a class="nav-link" href="${contextPath}/admin/order/adminOrderMain.do">주문관리</a></li>
						<li class="nav-item"><a class="nav-link" href="${contextPath}/admin/member/adminMemberMain.do">회원관리</a></li>
					</c:when>
					<c:when test="${header_menu=='my_page' }">
						<li class="nav-item"><a class="nav-link" href="${contextPath}/mypage/listMyOrderHistory.do">주문내역/배송조회</a></li>
						<li class="nav-item"><a class="nav-link" href="${contextPath}/mypage/myDetailInfo.do">회원정보관리</a></li>
					</c:when>
					
					
					<c:otherwise>
						<li>
						<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;국내외 도서</h3>
					<ul>
						<li><a href="${contextPath}/goods/goodsList.do">IT/인터넷</a></li>
						<li><a href="#">경제/경영</a></li>
						<li><a href="#">대학교재</a></li>
						<li><a href="#">자기계발</a></li>
						<li><a href="#">자연과학/공학</a></li>
						<li><a href="#">역사/인문학</a></li>
					</ul>
				</li>
				<li>
					<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;음반</h3>
					<ul>
						<li><a href="#">가요</a></li>
						<li><a href="#">록</a></li>
						<li><a href="#">클래식</a></li>
						<li><a href="#">뉴에이지</a></li>
						<li><a href="#">재즈</a></li>
						<li><a href="#">기타</a></li>
					</ul>
				</li>
			</c:otherwise>
		</c:choose>
					
					
       		</ul>
            
            
            
        </div>
    </div>
</nav>

<%-- 	<div id="search">
		<form name="frmSearch" action="${contextPath}/goods/searchGoods.do">
			<input name="searchWord" class="main_input" type="text" onKeyUp="keywordSearch()">
			<input type="submit" name="search" class="btn1" value="검 색">
		</form>
	</div> --%>
	
<!-- 	<div id="suggest">
		<div id="suggestList"></div>
	</div> -->
</body>