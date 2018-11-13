var promotion = {
    $PRMTN: $(".promotion"),
    promotion_index: 0,
    ex: () => {

        promotion.$PRMTN.eq(promotion.promotion_index).css("transition", "transform 1s linear");
        promotion.$PRMTN.eq(promotion.promotion_index).css("transform", "translateX(-100%)");

        for (var j = 0; j < promotion.$PRMTN.length; j++) {
            if (j != promotion.promotion_index && j != (promotion.promotion_index + 1) && j != (promotion.promotion_index - 1)) {
                promotion.$PRMTN.eq(j).css("transition", "");
                promotion.$PRMTN.eq(j).css("transform", "translateX(100%)");
            }
        }

        if (promotion.promotion_index == promotion.$PRMTN.length - 1) {
            for (var j = 0; j < promotion.$PRMTN.length - 1; j++) {
                promotion.promotion_index = -1;
            }
        }

        promotion.$PRMTN.eq(promotion.promotion_index + 1).css("transition", "transform 1s linear");
        promotion.$PRMTN.eq(promotion.promotion_index + 1).css("transform", "translateX(0%)");

        promotion.promotion_index++;

    }
}

var categorys = {
    $category: $("#category"),
    $view: $(".cg"),
    
    
    pageNum: 0,
    over: function() {
        this.style.borderBottom = "3px solid green";
    },
    out: function(){
        this.style.borderBottom = "0px";
    },
    drawBorder: () => {
        categorys.$view.css({
            "borderBottom": "0px",
            "onmouseover": categorys.over,
            "onmouseout": categorys.out
        });

        categorys.$view.eq(categorys.pageNum).css('onmouseout', 'null');
        categorys.$view.eq(categorys.pageNum).css('borderBottom', '3px solid green');
    }
}

var mainList = {
    $add: $("#more"),
    $parent: $("#more").parent(),
    addNum: 0,
    
    res: null,
    appendAddBtn: () => {
        mainList.$parent.append(mainList.$add);
    },
    ajax: () => {

        $.ajax({
                url: "./category",
                data: "cn=" + categorys.pageNum,
                type: "GET",
                dataType: "json"
            })
            .done((res) => {
                var newcontent = '';
                var index = res.findIndex(i => i.productId != null);
                var resLength = res.length;

                for (var i = 0; i < mainList.addNum; i++) {
                    for (var j = index; j < resLength; j++) {
                        if (res[i].id == res[j].productId && res[j].type == 'ma') {

                            var $template = $("#template").html();

                            var filesource = 'img/' + res[j].productId + '_' + res[j].type + '_' + res[j].productImageId + '.png';

                            $template = $template.replace('filesource', filesource)
                                .replace('filedescription', res[i].description)
                                .replace('filecontent', res[i].content);

                            newcontent += $template;
                           
                        }
                    }
                }
                $("#message").html(index + "개");
                $(".elements").html(newcontent);
            })
            .fail(function (xhr, status, errorThrown) {
                console.log(xhr+"객체의"+"현재상태는"+status+"에러는"+errorThrown)
            })
            .always(function (xhr, status) {
                console.log("요청이 완료되었습니다!"+"객체의"+"현재 상태는"+status);
            });

    },
    doAll: () => {
        mainList.addNum = 4;
        categorys.pageNum = 0;
        mainList.appendAddBtn();
        categorys.drawBorder();
        mainList.ajax();

    }
}



$("window").ready(function () {
    promotion.$PRMTN.eq(0).css('transform', 'TranslateX(0%)');

    categorys.$category.on("click", function (evt) {
        if (evt.target.className == "cg view") {
            mainList.addNum = 4;
            categorys.pageNum = 1;
            mainList.appendAddBtn();
            categorys.drawBorder();
            mainList.ajax();
        } else if (evt.target.className == "cg musical") {
            mainList.addNum = 4;
            categorys.pageNum = 2;
            mainList.appendAddBtn();
            categorys.drawBorder();
            mainList.ajax();
        } else if (evt.target.className == "cg concert") {
            mainList.addNum = 4;
            categorys.pageNum = 3;
            mainList.appendAddBtn();
            categorys.drawBorder();
            mainList.ajax();
        } else if (evt.target.className == "cg classic") {
            mainList.addNum = 4;
            categorys.pageNum = 4;
            mainList.appendAddBtn();
            categorys.drawBorder();
            mainList.ajax();
        } else if (evt.target.className == "cg theater") {
            mainList.addNum = 4;
            categorys.pageNum = 5;
            mainList.appendAddBtn();
            categorys.drawBorder();
            mainList.ajax();
        } else if (evt.target.className == "cg all") {
            mainList.addNum = 4;
            categorys.pageNum = 0;
            mainList.appendAddBtn();
            categorys.drawBorder();
            mainList.ajax();
        }
    });

    mainList.$add.on("click", function () {
        $.ajax({
                url: "./category",
                data: "cn=" + categorys.pageNum,
                type: "GET",
                dataType: "json"
            })
            .done(function (res) {
                var newcontent = '';
                var index = res.findIndex(i => i.productId != null);
                var resLength = res.length;
                if (mainList.addNum + 4 < index) {
                    mainList.addNum = mainList.addNum + 4;
                } else if (mainList.addNum == 8) {
                    mainList.addNum = index;
                    mainList.$add.detach();
                }

                for (var i = 0; i < mainList.addNum; i++) {
                    for (var j = index; j < resLength; j++) {
                        if (res[i].id == res[j].productId && res[j].type == 'ma') {
                            var $template = $("#template").html();
                            var filesource = 'img/' + res[j].productId + '_' + res[j].type + '_' + res[j].productImageId + '.png';
                            $template = $template.replace('filesource', filesource)
                                .replace('filedescription', res[i].description)
                                .replace('filecontent', res[i].content);

                            newcontent += $template;

                        }
                    }
                }
                $("#message").html(index + "개");
                $(".elements").html(newcontent)
            })
            .fail(function (xhr, status, errorThrown) {})
            .always(function (xhr, status) {
                console.log("요청이 완료되었습니다!");
            });

    });

    setInterval(promotion.ex, 3000);
    mainList.doAll();
});
