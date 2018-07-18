~function (pageNumber) {
    console.log(pageNumber);
    loadPage(pageNumber);
}(1);

function loadPage(pageNumber) {
    //clean current page
    $('table tbody').empty();
    $('.pagination').empty();


    $.get(
        "/user/",
        {
            "pageNumber": pageNumber
        },
        function (data, status) {
            if (status === "success") {

                //fill the tree: create the table
                $(data.list).each(function (index, item) {
                    console.log(item);
                    let id = item.id;
                    let username = item.username;
                    let email = item.email;
                    let lastdate = item.lastdate;
                    let tr = $("<tr></tr>");
                    tr.append($("<td></td>").text(id));
                    tr.append($("<td></td>").text(username));
                    tr.append($("<td></td>").text(email));
                    tr.append($("<td></td>").text(lastdate));
                    let buttonGroup = $("<td></td>");
//                        buttonGroup.append($("<button></button>").attr({onclick : "updateRow(this)", type : "button",  class : "btn btn-success btn-sm"}).text("更新用户"));
                    buttonGroup.append($("<button></button>").attr({onclick : "deleteRow(this)", type : "button",  class : "btn btn-danger  btn-sm"}).text("删除用户"));
                    if(item.islock === 3){
                        buttonGroup.append($("<button></button>").attr({onclick : "unlockRow(this)", type : "button",  class : "btn btn-default btn-sm"}).text("解锁用户"));
                    } else {
                        buttonGroup.append($("<button></button>").attr({onclick : "lockRow(this)", type : "button",  class : "btn btn-primary btn-sm"}).text("冻结用户"));
                    }
                    tr.append(buttonGroup);
                    $('table tbody').append(tr);
                });


                //fill the pagination
                let preLi = $('<li></li>');
                preLi.append($('<a></a>').attr("href", "javascript:loadPage(" + ( (pageNumber - 1) > 0 ? pageNumber - 1 : 1) + ")").text('<<'));
                $('.pagination').append(preLi);
                for (let i = 1; i <= data.lastPage; ++i)
                {
                    let li = $('<li></li>');
                    li.append($('<a></a>').attr("href",  "javascript:loadPage("+ i +")").text(i));
                    $('.pagination').append(li);
                }
                let postLi = $('<li></li>');
                postLi.append($('<a></a>').attr("href",  "javascript:loadPage(" + ( (pageNumber + 1) < data.lastPage ? pageNumber + 1 : data.lastPage) + ")").text('>>'));
                $('.pagination').append(postLi);

            }
            else {
                alert("Request failed");
            }
        }
    );
}


function deleteRow(object) {
    // get the row value
    let tr = $(object).parent().parent();
    let id = tr.children('td').eq(0).text();
    $('#delId').text(id);
    $('#deleteModal').modal('show');
}

function lockRow(object){
    let tr = $(object).parent().parent();
    let id = tr.children('td').eq(0).text();
    $.get(
        "/lock/user",
        {
            "id" : id
        },
        function (data, status) {
            if (status === "success") {
                alert("冻结成功");
                window.location.reload();
            }
            else {
                alert("冻结失败");
            }
        }
    );


}



function unlockRow(object) {
    let tr = $(object).parent().parent();
    let id = tr.children('td').eq(0).text();
    $.get(
        "/unlock/user",
        {
            "id" : id
        },
        function (data, status) {
            if (status === "success") {
                alert("解锁成功");
                window.location.reload();
            }
            else {
                alert("删除失败");
            }
        }
    );

}


$('#deleteSure').click(function () {
    $.ajax({
        url: "/user/",
        type: "delete",
        data: JSON.stringify({id:$('#delId').text()}),
        contentType: "application/json;charset=utf-8",
        success: function (data, status) {
            console.log(data + " Status:" + status)
            if (data.msg === "success") {
                alert("删除成功");
                window.location.reload();
            }
            else {
                alert("修改失败");
            }
        }
    });

});



//    $.fn.serializeObject = function () {
//        let o = {};
//        let a = this.serializeArray();
//        $.each(a, function () {
//            if (o[this.name]) {
//                if (!o[this.name].push) {
//                    o[this.name] = [o[this.name]];
//                }
//                o[this.name].push(this.value || '');
//            } else {
//                o[this.name] = this.value || '';
//            }
//        });
//        return o;
//    };
//
//    $('#saveBtn').click(function () {
//
//        if ($(this).text() === "Add") {
//            let addForm = $('form').serialize();
//            addForm = addForm.substr(4);
//            $.post(
//                "/user",
//                addForm,
//                function (data, staus) {
//                    if (staus === "success") {
//                        if (data.code === 200) {
//                            alert(data.msg);
////                            window.location.reload();
//                        }
//                        else {
//                            alert("添加失败");
//                        }
//                    }
//
//                }
//            );
//        }
//        else if ($(this).text() === "Update") {
//            $.ajax({
//                    url: "/user/",
//                    type: "put",
//                    data: JSON.stringify($('form').serializeObject()),
//                    contentType: "application/json;charset=utf-8",
//                    success: function (data, status) {
//                        console.log(data + " Status:" + status)
//                        if (data.msg === "success") {
//                            alert("修改成功");
//                            window.location.reload();
//                        }
//                        else {
//                            alert("修改失败");
//                        }
//                    }
//
//
//                }
//            );
//
//
//        }
//
//
//    });
//
//
//    $('#addBtn').click(function () {
//        //clear the form
//        $('#userId').val("");
//        $('#userInfo').val("");
//        $('#userLocked').val("");
//
//        $('#saveBtn').text('Add');
//        $('#userModal').modal('show');
//    });



$('#logout').click(function () {
    $.get(
        "/logout",
        function (data, status) {
            if (data.code === 200){
                window.location.href = "/login.html";
            } else {
                alert("Logout failed");
            }
        }
    );
});
