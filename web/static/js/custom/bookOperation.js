~function (pageNumber) {
    console.log(pageNumber);
    loadPage(pageNumber);
}(1);

function loadPage(pageNumber) {
    //clean current page
    $('#listBody').empty();
    $('.pagination').empty();

    $.get(
        "/book",
        {
            "pageNumber": pageNumber
        },
        function (data, status) {
            if (status === "success") {
//                    data  = response.msg;
                //fill the tree: create the table
                $(data.list).each(function (index, item) {
                    console.log(item);
                    let id = item.id;
                    let name = item.bookname;
                    let price = item.price;
                    let stock = item.stock;
                    let img = item.img;
                    let tr = $("<tr></tr>");
                    tr.append($("<td></td>").text(id));
                    tr.append($("<td></td>").text(name));
                    tr.append($("<td></td>").text(price));
                    tr.append($("<td></td>").append($("<img></img>").attr(
                        {
                            "src": img, "height": 92, "width": 92
                        })));
                    tr.append($("<td></td>").text(stock));
                    let buttonGroup = $("<td></td>");
                    buttonGroup.append($("<button></button>").attr({
                        onclick: "javascript:deleteThis(this)",
                        type: "button",
                        class: "btn btn-danger btn-sm"
                    }).text("删除图书"));
                    buttonGroup.append($("<button></button>").attr({
                        onclick: "javascript:update(this)",
                        type: "button",
                        class: "btn btn-primary btn-sm"
                    }).text("修改图书"));
                    tr.append(buttonGroup);
                    $('#listBody').append(tr);
                });


                //fill the pagination
                let preLi = $('<li></li>');
                preLi.append($('<a></a>').attr("href", "javascript:loadPage(" + ((pageNumber - 1) > 0 ? pageNumber - 1 : 1) + ")").text('<<'));
                $('.pagination').append(preLi);
                for (let i = 1; i <= data.lastPage; ++i) {
                    let li = $('<li></li>');
                    li.append($('<a></a>').attr("href", "javascript:loadPage(" + i + ")").text(i));
                    $('.pagination').append(li);
                }
                let postLi = $('<li></li>');
                postLi.append($('<a></a>').attr("href", "javascript:loadPage(" + ((pageNumber + 1) < data.lastPage ? pageNumber + 1 : data.lastPage) + ")").text('>>'));
                $('.pagination').append(postLi);

            }
            else {
                alert("Request failed");
            }
        }
    );
};

function deleteThis(object) {
    let tr = $(object).parent().parent();
    let id = tr.children('td').eq(0).text();
    $('#delId').text(id);
    $('#deleteModal').modal('show');
};


$('#saveBtn').click(function () {
    let aou = $("#saveBtn").text();
    addOrUpdate(aou);
});

function addOrUpdate(aou) {
    let formData = new FormData($("#bookForm")[0]);
    let imgFile = $("#bookImg").prop("files")[0];
    formData.append("file", imgFile);
    if (aou === "add") {
        formData.delete("id");
    }
    $.ajax({
        async: true,
        cache: false,
        type: "post",
        data: formData,
        url: '/book/' + aou,
        dataType: 'json',
        contentType: false, //必须
        processData: false, //必须
        success: function (data, status) {
            console.log(data);
            if (data.code === 200) {
                window.location.href = "bookOperation.html"
            }

        },
        error: function (arg1, arg2, arg3) {
            console.log(arg1 + "--" + arg2 + "--" + arg3);
        }
    });


};


$('#deleteSure').click(function () {
    $.get(
        "/book/delete",
        {
            "id": $('#delId').text()
        },
        function (data, status) {
            if (status === "success" && data.msg === "success") {
                alert("删除成功");
                window.location.href = "bookOperation.html";
            }
            else {
                alert("删除失败");
            }
        }
    );
});

$('#addBtn').click(function () {
    //clear the form
    $('#bookId').remove();
    $('#bookName').val("");
    $('#bookStock').val("");
    $('#bookPrice').val("");
    $('#bookImg').val("");
    $('#saveBtn').text('add');
    $('#aouModal').modal('show');
});

function update(object) {
    let tr = $(object).parent().parent();
    let bookId = tr.children('td').eq(0).text();
    let bookName = tr.children('td').eq(1).text();
    let bookPrice = tr.children('td').eq(2).text();
    let bookImg = tr.children('td').eq(3).text();
    let bookStock = tr.children('td').eq(4).text();
    console.log(bookName);
    console.log(bookImg);
    console.log(bookId);
    // assign the row to the modal
    $('#bookId').val(bookId);
    $('#bookName').val(bookName);
    $('#bookStock').val(bookStock);
    $('#bookPrice').val(bookPrice);
    $('#bookImg').val(bookImg);
    $('#saveBtn').text('update');
    $('#aouModal').modal('show');
};

$('#logout').click(function () {
    $.get(
        "/logout",
        function (data, status) {
            if (data.code === 200) {
                window.location.href = "/login.html";
            } else {
                alert("Logout failed");
            }
        }
    );
});

$("#bookImg").change(function () {
    let url = window.URL.createObjectURL(this.files[0]);
    $("#preview").attr({"src" : url});
});