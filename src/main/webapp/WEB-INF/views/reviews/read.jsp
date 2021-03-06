<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="util" uri="/ELFunctions" %>

<!DOCTYPE html> 
<html> 
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">

  <script type="text/javascript">
    function updateM(){
      var url = "update";
      url += "?reviewno=${dto.reviewno}";
      
      location.href=url;
    }
    function deleteM(){
      var url = "delete";
      url += "?reviewno=${dto.reviewno}";
      url += "&oldfile=${dto.filename}";
      
      location.href=url;
    }
    function replyM(){
        var url = "reply";
        url += "?reviewno=${dto.reviewno}";
        
        location.href=url;
      }
    
    function listM(){
        var url = "list";
        url += "?nowPage=${param.nowPage}";
        url += "&col=${param.col}";
        url += "&word=${param.word}";
        location.href=url;
      }
    
    function delete_Ajax(){
        var url = "delete_Ajax";
        url += "?reviewno=${dto.reviewno}";
        url += "&oldfile=${dto.filename}";
        //alert(url);    
        location.href=url;
      }
  </script>

</head>
<body>  
<div class="container">

<h2>조회</h2>


<div class="panel panel-default">

<div class="panel-heading">조회수</div>
<div class="panel-body">${dto.viewcnt}</div>

<div class="panel-heading">등록일</div>
<div class="panel-body">${dto.revdate}</div>
<div class="panel-heading">작성자</div>
<div class="panel-body">${dto.revwriter}</div>

<div class="panel-heading">제목</div>
<div class="panel-body">${dto.revtitle}</div>

<div class="panel-heading">내용</div>
<div class="panel-body">${dto.revcontent}</div>

<div class="panel-heading">등록일</div>
<div class="panel-body">${dto.revdate}</div>

</div>

<div>
<button type="button" class="btn" onclick="listM()">목록</button>
</div>
<br>
<div class='row'>
 
<div class="col-lg-12">
 
<!-- panel start-->
<div class="panel panel-default">
 
<div class="panel-heading">
        <i class="fa fa-comments fa-fw"></i> 댓글
        <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New
                Reply</button>
</div>
 
 
<div class="panel-body">
 
        <ul class="chat list-group">
                <li class="left clearfix" data-rno="12">
                        <div>
                                <div class="header">
                                        <strong class="primary-font">user1</strong> <small
                                                class="pull-right text-muted">2019-05-12</small>
                                </div>
                                <p>Good job!</p>
 
                        </div>
                </li>
        </ul>
        <!-- ul end  -->
</div>
 
<div class="panel-footer"></div>
 
</div>
<!-- panel end-->
</div>
<!--  col-lg-12 end -->
</div>
<!-- row end -->

</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal"
        aria-hidden="true">&times;</button>
      <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
    </div>
    <div class="modal-body">
      <div class="form-group">
        <label>내용</label> 
        <textarea cols="10" rows="3" class="form-control" name='content'>New Reply!!!!</textarea> 
      </div>      
    </div>
<div class="modal-footer">
<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
<button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
<button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
</div>          </div>
  <!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- 댓글처리 관련 Javascript 파일 추가-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/breply.js"></script>

 <!-- 페이지 로딩시 댓글 목록 처리-->
 <!-- jstl내부 javascript에서 사용가능 -->
 <script type="text/javascript">
 var id = "${sessionScope.id}";
  var reviewno = "${dto.reviewno}"; 
  var sno = "${sno}";
  var eno = "${eno}";
 <!-- 댓글용 paging, 게시판 검색 -->
  var nPage = "${nPage}";
  var nowPage = "${param.nowPage}";
  var colx = "${param.col}";
  var wordx = "${param.word}";
  </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/replyprocess.js"></script>

</body> 
</html> 