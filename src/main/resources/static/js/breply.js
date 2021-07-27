console.log("*****Reply Module........");

var replyService = (function() {

    function update(reply, callback, error) {
        console.log("rnum: " + reply.rnum);
        $.ajax({
            type: 'put',
            url: './reply/' + reply.rnum,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error: function(xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }
    function remove(rnum, callback, error) {
        $.ajax({
            type: 'delete',
            url: './reply/' + rnum,
            success: function(deleteResult, status, xhr) {
                if (callback) {
                    callback(deleteResult);
                }
            },
            error: function(xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }

    function add(reply, callback, error) {
        console.log("add reply...............");

        $.ajax({
            type: 'post',
            url: './reply/create',
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error: function(xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }

    function get(rnum, callback, error) {

        $.get("./reply/" + rnum + "", function(result) {

            if (callback) {
                callback(result);
            }

        }).fail(function(xhr, status, err) {
            if (error) {
                error();
            }
        });
    }
    function getList(param, callback, error) {
        var reviewno = param.reviewno;
        var sno = param.sno;
        var eno = param.eno;
        //alert(param.bbsno);
        $.getJSON("/reviews/reply/list/" + reviewno + "/" + sno + "/" + eno + "",
            function(data) {           
                //alert(data);
                if (callback) {
                    callback(data); // 댓글 목록만 가져오는 경우 
                    //callback(data.replyCnt, data.list); //댓글 숫자와 목록을 가져오는 경우 
                }
            });
    }

    function getPage(param, callback, error) {
        $.ajax({
            type: 'get',
            url: "./reply/page",
            data: param,
            contentType: "application/text; charset=utf-8",
            success: function(result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error: function(xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }

    ;

    return {
        remove : remove,
        update : update,
        add: add,
        get: get,
        getList: getList,
        getPage: getPage
    };

})();//function()실행
