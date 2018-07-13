~function (pageNumber, state) {
    console.log(pageNumber + state);
    loadPage(pageNumber, state);
}(1, 3);

function loadPage(pageNumber, state) {
    //clean current page
    $('#listBody').empty();
    $('.pagination').empty();


    $.get(
        "/order",
        {
            "pageNumber": pageNumber,
            "state": state
        },
        function (data, status) {
            if (status === "success") {

                //fill the tree: create the table
                $(data.list).each(function (index, item) {
                    console.log(item);
                    let id = item.id;
                    let ordernum = item.ordernum;
                    let buyerId = item.buyerId;
                    let createDate = item.createdate;
                    let state = item.state === 0 ? "未发货" : (item.state === 1 ? "已发货" : "已完成");
                    let totalPrice = item.totalprice;
                    let tr = $("<tr></tr>");
                    tr.append($("<td></td>").append($("<a></a>").attr({"href": "javascript:showInfo(" + ordernum + ")"}).text(id)));
                    tr.append($("<td></td>").text(ordernum));
                    tr.append($("<td></td>").text(buyerId));
                    tr.append($("<td></td>").text(createDate));
                    tr.append($("<td></td>").text(state));
                    tr.append($("<td></td>").text(totalPrice));
                    let buttonGroup = $("<td></td>");
                    if (item.state === 0) {
                        buttonGroup.append($("<button></button>").attr({
                            onclick: "javascript:delivery(this)",
                            type: "button",
                            class: "btn btn-default btn-sm"
                        }).text("执行发货"));
                    }
                    tr.append(buttonGroup);
                    $('#listBody').append(tr);
                });


                //fill the pagination
                let preLi = $('<li></li>');
                preLi.append($('<a></a>').attr("href", "javascript:loadPage(" + ((pageNumber - 1) > 0 ? pageNumber - 1 : 1) + ", " + state + ")").text('<<'));
                $('.pagination').append(preLi);
                for (let i = 1; i <= data.lastPage; ++i) {
                    let li = $('<li></li>');
                    li.append($('<a></a>').attr("href", "javascript:loadPage(" + i + ", " + state + ")").text(i));
                    $('.pagination').append(li);
                }
                let postLi = $('<li></li>');
                postLi.append($('<a></a>').attr("href", "javascript:loadPage(" + ((pageNumber + 1) < data.lastPage ? pageNumber + 1 : data.lastPage) + ", " + state + ")").text('>>'));
                $('.pagination').append(postLi);

            }
            else {
                alert("Request failed");
            }
        }
    );
}

function delivery(object) {
    let tr = $(object).parent().parent();
    let id = tr.children('td').eq(0).text();
    let state = tr.children('td').eq(4).text();
    $.ajax({
        url: "/order/",
        type: "put",
        data: JSON.stringify({id: id}),
        contentType: "application/json;charset=utf-8",
        success: function (data, status) {
            console.log(data + " Status:" + status)
            if (data.msg === "success") {
                alert("发货成功");
                window.location.reload();
            }
            else {
                alert("发货失败");
            }
        }
    });
}


function showInfo(ordernum) {
    // get the row value
    $('#infoBody').empty();
    $.get(
        "/order/info/",
        {
            "ordernum": ordernum
        },
        function (data, status) {
            let list = data.msg;

            $.each(list, function (index, item) {
                let tr = $("<tr></tr>");
                let id = item.book.id;
                let name = item.book.bookname;
                let price = item.book.price;
                let img = item.book.img;
                let count = item.num;


                tr.append($("<td></td>").text(id));
                tr.append($("<td></td>").text(name));
                tr.append($("<td></td>").text(price));
                tr.append($("<td></td>").append($("<img></img>").attr({
                    "src": img,
                    "height": 92,
                    "width": 92
                })));
                tr.append($("<td></td>").text(count));


                $('#infoBody').append(tr);
            });


        }
    );
    $('#infoModal').modal('show');
}

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