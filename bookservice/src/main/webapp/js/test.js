$("window").ready(function () {
    var $thumb = $(".thumbnail")
    $thumb.eq(0).css('transform', 'TranslateX(0%)');
    var f = 0;

    var $category = $("#category")  
    var $view = $(".cg")
    var $add = $("#more");
    var addNum = 0;
    var pageNum = 0;
    var $parent = $add.parent();
    var res = null;

    function over() {
        this.style.borderBottom = "3px solid green";
    }

    function out() {
        this.style.borderBottom = "0px";
    }

    function drawBorder() {
        $parent.append($add);
        $view.css({
            "borderBottom": "0px",
            "onmouseover": over,
            "onmouseout": out
        });

        $view.eq(pageNum).css('onmouseout', 'null');
        $view.eq(pageNum).css('borderBottom', '3px solid green');
    }


    function ajax() {
        
        $.ajax({
            url : "./category",
            data : "cn="+pageNum,
            type : "GET",
            dataType : "json"
        })
        .done(function(res){
            var newcontent = '';
            var index = res.findIndex(i=>i.productId!=null);
            var resLength = res.length;
            // var template = document.getElementById("template").innerHTML;
            // var $template = $("#template").html();
            //             console.log($template)
            //             console.log(template)
            for (var i = 0; i < addNum; i++) {
                for (var j = index; j < resLength; j++) {
                    if (res[i].id == res[j].productId && res[j].type == 'ma') {
                        
                        var $template = $("#template").html();
                        
                        var filesource = 'img/' + res[j].productId + '_' + res[j].type + '_' + res[j].productImageId + '.png';
                        
                        $template = $template.replace('filesource', filesource)
                            .replace('filedescription', res[i].description)
                            .replace('filecontent', res[i].content);

                        newcontent += $template;
                        console.log(newcontent)
                    }
                }
            }
            $("#ro").html(index + "개");
            $(".elements").html(newcontent);
        })
        .fail(function(xhr, status, errorThrown){})
        .always(function(xhr, status) {
            console.log("요청이 완료되었습니다!");
        });
        
    }

    function doAll() {
        addNum = 4;
        pageNum = 0;
        drawBorder();
        ajax();

    }

    function ex() {

        $thumb.eq(f).css("transition","transform 1s linear");
        $thumb.eq(f).css("transform","translateX(-100%)");

        for (var j = 0; j < $thumb.length; j++) {
            if (j != f && j != (f + 1) && j != (f - 1)) {
                $thumb.eq(j).css("transition","");
                $thumb.eq(j).css("transform","translateX(100%)");
            }
        }

        if (f == $thumb.length - 1) {
            for (var j = 0; j < $thumb.length - 1; j++) {
                f = -1;
            }
        }

        $thumb.eq(f+1).css("transition","transform 1s linear");
        $thumb.eq(f+1).css("transform","translateX(0%)");

        f++;

    }



    $category.on("click", function (evt) {
        if (evt.target.className == "cg view") {
            addNum = 4;
            pageNum = 1;
            drawBorder();
            ajax();
        } else if (evt.target.className == "cg musical") {
            addNum = 4;
            pageNum = 2;
            drawBorder();
            ajax();
        } else if (evt.target.className == "cg concert") {
            addNum = 4;
            pageNum = 3;
            drawBorder();
            ajax();
        } else if (evt.target.className == "cg classic") {
            addNum = 4;
            pageNum = 4;
            drawBorder();
            ajax();
        } else if (evt.target.className == "cg theater") {
            addNum = 4;
            pageNum = 5;
            drawBorder();
            ajax();
        } else if (evt.target.className == "cg all") {
            addNum = 4;
            pageNum = 0;
            drawBorder();
            doAll();
        }
    });

    $add.on("click", function (evt) {
        $.ajax({
            url : "./category",
            data : "cn="+pageNum,
            type : "GET",
            dataType : "json"
        })
        .done(function(res){
            var newcontent = '';
            var index = res.findIndex(i=>i.productId!=null);
            var resLength = res.length;
            if (addNum + 4 < index) {
                addNum = addNum + 4;
            } else if(addNum==8){
                addNum = index;
                $add.detach();
            }
            
            for (var i = 0; i < addNum; i++) {
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
            $("#ro").html(index + "개");
            $(".elements").html(newcontent)
        })
        .fail(function(xhr, status, errorThrown){})
        .always(function(xhr, status) {
            console.log("요청이 완료되었습니다!");
        });

    });
    
    setInterval(ex, 3000);
    doAll();
});
