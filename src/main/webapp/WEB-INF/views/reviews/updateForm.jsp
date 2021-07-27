<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html> 
<head>
  <title>상품 후기 등록</title>
  <meta charset="utf-8">
  <script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js">     </script>
  <script type="text/JavaScript">
 $(function() {
	 CKEDITOR.replace('revcontent'); // <TEXTAREA>태그 id 값
	 });
 
 $(function() {
     $.ajax({
         url : "/reviews/getOption",
         type : "GET",
         //data: JSON.stringify(),
         //contentType: "application/json; charset=utf-8;",
         dataType : "json",
         success : function(data) {
             // alert("success:"+data.length);
             // alert(data[0].CATENO);
             // alert(data[0].CATENAME)
             for (var i = 0; i < data.length; i++) {
                 $('#pname').append(
                		 "<option value='"+ data[i].pname +"'>" + data[i].pname + "</option>");
             }

         },
         error : function(request, status, error) {
             alert("code = " + request.status + " message = "
                     + request.responseText + " error = " + error); // 실패 시 처리
         }
     });//ajax end
 });//페이지로딩

 function checkIn(f){
     if (f.revtitle.value == ""){
             alert("제목을 입력하세요");
             f.revtitle.focus()
             return false;
     }

     if (CKEDITOR.instances['revcontent'].getData() == '') {
         window.alert('내용을 입력해 주세요.');
         CKEDITOR.instances['revcontent'].focus();
         return false;
     }
}
 </script>
</head>
<body> 

<div class="container">
<h1 class="col-sm-offset-2 col-sm-10">상품 후기 등록</h1>
<form class="form-horizontal" 
      action="/reviews/create"
      method="post"
      enctype="multipart/form-data"
      onsubmit="return checkIn(this)">


  <div class="form-group">
    <label class="control-label col-sm-2" for="pname">상품명</label>
    <div class="col-sm-8">
      <select class="form-control" name="pname" id="pname" value="${dto.pname}">
        
      </select>
      
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="revtitle">제목</label>
    <div class="col-sm-8">
      <input type="text" name="revtitle" id="revtitle" class="form-control" value="${dto.revtitle}">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="revwriter">작성자</label>
    <div class="col-sm-8">
      <input type="text" name="revwriter" id="revwriter" class="form-control" value="${dto.revwriter}">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="revpass">비밀번호</label>
    <div class="col-sm-8">
      <input type="password" name="revpass" id="revpass" class="form-control">
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-2" for="revcontent">내용</label>
    <div class="col-sm-8">
    <textarea rows="12" cols="7" id="revcontent" name="revcontent" class="form-control">${dto.revcontent}</textarea>
    </div>
  </div>
  
   <div class="form-group">
   <div class="col-sm-offset-2 col-sm-5">
    <button class="btn">수정</button>
    <button type="reset" class="btn">취소</button>
   </div>
 </div>
</form>
</div>
</body> 
</html> 