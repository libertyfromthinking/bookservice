



document.addEventListener("DOMContentLoaded", function () {
    var category = document.getElementById("category");
    var view = document.getElementsByClassName("cg");
    var add = document.getElementById("more");
    var addNum = 0;
    var pageNum = 0;
    var parent = add.parentNode;
    
    function doAll(){
    	addNum = 4;
        pageNum = 0;
        parent.appendChild(add);
        for (var i = 0; i < view.length; i++) {
            view[i].style.borderBottom = "0px";
            view[i].onmouseover = over;
            view[i].onmouseout = out;
        }
        view[0].onmouseout = null;
        view[0].style.borderBottom = "3px solid green"
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.status == 200 && xhr.readyState == 4) {

                var res = JSON.parse(xhr.responseText);
                var newcontent = '';
                var getIndex = function () {
                    for (var i = 0; i < res.length; i++) {
                        if (res[i].productId != null) {
                            index = i;
                            return index;
                        }
                    }

                }
                var index = getIndex();
                for (var i = 0; i < addNum; i++) {
                    for (var j = index; j < res.length; j++) {
                        if (res[i].id == res[j].productId && res[j].type == 'ma') {
                            var template = document.getElementById("template").innerHTML;
                            var filesource = 'img/' + res[j].productId + '_' + res[j].type + '_' + res[j].productImageId + '.png';
                            template = template.replace('filesource', filesource)
                                .replace('filedescription', res[i].description)
                                .replace('filecontent', res[i].content);

                            newcontent += template;

                        }
                    }
                }
                document.getElementById("ro").innerHTML = index + "개";
                document.getElementsByClassName("elements")[0].innerHTML = newcontent;
            }
        }
        xhr.open("GET", "./category?cn=0");
        xhr.send();


    }
    var over = function () {
        this.style.borderBottom = "3px solid green";
    }
    var out = function () {
        this.style.borderBottom = "0px";
    }

    category.addEventListener("click", function (evt) {
        if (evt.target.className == "cg view") {
            addNum = 4;
            pageNum = 1;
            parent.appendChild(add);
            for (var i = 0; i < view.length; i++) {
                view[i].style.borderBottom = "0px";
                view[i].onmouseover = over;
                view[i].onmouseout = out;
            }
            view[1].onmouseout = null;
            view[1].style.borderBottom = "3px solid green"
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.status == 200 && xhr.readyState == 4) {
                    
                    var res = JSON.parse(xhr.responseText);
                    var newcontent = '';
                    var getIndex = function () {
                        for (var i = 0; i < res.length; i++) {
                            if (res[i].productId != null) {
                                index = i;
                                return index;
                            }
                        }

                    }
                    var index = getIndex();
                    for (var i = 0; i < addNum; i++) {
                        for (var j = index; j < res.length; j++) {
                            if (res[i].id == res[j].productId && res[j].type == 'ma') {
                                var template = document.getElementById("template").innerHTML;
                                var filesource = 'img/' + res[j].productId + '_' + res[j].type + '_' + res[j].productImageId + '.png';
                                template = template.replace('filesource', filesource)
                                    .replace('filedescription', res[i].description)
                                    .replace('filecontent', res[i].content);

                                newcontent += template;

                            }
                        }
                    }
                    document.getElementById("ro").innerHTML = index + "개";
                    document.getElementsByClassName("elements")[0].innerHTML = newcontent;
                }
            }
            xhr.open("GET", "./category?cn=1");
            xhr.send();

        } else if (evt.target.className == "cg musical") {
        	addNum = 4;
            pageNum = 2;
            parent.appendChild(add);
            for (var i = 0; i < view.length; i++) {
                view[i].style.borderBottom = "0px";
                view[i].onmouseover = over;
                view[i].onmouseout = out;
            }
            view[2].onmouseout = null;
            view[2].style.borderBottom = "3px solid green"


            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.status == 200 && xhr.readyState == 4) {

                    var res = JSON.parse(xhr.responseText);
                    var newcontent = '';
                    var getIndex = function () {
                        for (var i = 0; i < res.length; i++) {
                            if (res[i].productId != null) {
                                index = i;
                                return index;
                            }
                        }

                    }
                    var index = getIndex();
                    for (var i = 0; i < addNum; i++) {
                        for (var j = index; j < res.length; j++) {
                            if (res[i].id == res[j].productId && res[j].type == 'ma') {
                                var template = document.getElementById("template").innerHTML;
                                var filesource = 'img/' + res[j].productId + '_' + res[j].type + '_' + res[j].productImageId + '.png';
                                template = template.replace('filesource', filesource)
                                    .replace('filedescription', res[i].description)
                                    .replace('filecontent', res[i].content);

                                newcontent += template;

                            }
                        }
                    }
                    document.getElementById("ro").innerHTML = index + "개";
                    document.getElementsByClassName("elements")[0].innerHTML = newcontent;
                }
            }
            xhr.open("GET", "./category?cn=2");
            xhr.send();

        } else if (evt.target.className == "cg concert") {
        	addNum = 4;
            pageNum = 3;
            parent.appendChild(add);
            for (var i = 0; i < view.length; i++) {
                view[i].style.borderBottom = "0px";
                view[i].onmouseover = over;
                view[i].onmouseout = out;

            }
            view[3].onmouseout = null;
            view[3].style.borderBottom = "3px solid green"
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.status == 200 && xhr.readyState == 4) {

                    var res = JSON.parse(xhr.responseText);
                    var newcontent = '';
                    var getIndex = function () {
                        for (var i = 0; i < res.length; i++) {
                            if (res[i].productId != null) {
                                index = i;
                                return index;
                            }
                        }

                    }
                    var index = getIndex();
                    for (var i = 0; i < addNum; i++) {
                        for (var j = index; j < res.length; j++) {
                            if (res[i].id == res[j].productId && res[j].type == 'ma') {
                                var template = document.getElementById("template").innerHTML;
                                var filesource = 'img/' + res[j].productId + '_' + res[j].type + '_' + res[j].productImageId + '.png';
                                template = template.replace('filesource', filesource)
                                    .replace('filedescription', res[i].description)
                                    .replace('filecontent', res[i].content);

                                newcontent += template;

                            }
                        }
                    }
                    document.getElementById("ro").innerHTML = index + "개";
                    document.getElementsByClassName("elements")[0].innerHTML = newcontent;
                }
            }
            xhr.open("GET", "./category?cn=3");
            xhr.send();

        } else if (evt.target.className == "cg classic") {
        	addNum = 4;
            pageNum = 4;
            parent.appendChild(add);
            for (var i = 0; i < view.length; i++) {
                view[i].style.borderBottom = "0px";
                view[i].onmouseover = over;
                view[i].onmouseout = out;
            }
            view[4].onmouseout = null;
            view[4].style.borderBottom = "3px solid green"
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.status == 200 && xhr.readyState == 4) {

                    var res = JSON.parse(xhr.responseText);
                    var newcontent = '';
                    var getIndex = function () {
                        for (var i = 0; i < res.length; i++) {
                            if (res[i].productId != null) {
                                index = i;
                                return index;
                            }
                        }

                    }
                    var index = getIndex();
                    for (var i = 0; i < addNum; i++) {
                        for (var j = index; j < res.length; j++) {
                            if (res[i].id == res[j].productId && res[j].type == 'ma') {
                                var template = document.getElementById("template").innerHTML;
                                var filesource = 'img/' + res[j].productId + '_' + res[j].type + '_' + res[j].productImageId + '.png';
                                template = template.replace('filesource', filesource)
                                    .replace('filedescription', res[i].description)
                                    .replace('filecontent', res[i].content);

                                newcontent += template;

                            }
                        }
                    }
                    document.getElementById("ro").innerHTML = index + "개";
                    document.getElementsByClassName("elements")[0].innerHTML = newcontent;
                }
            }
            xhr.open("GET", "./category?cn=4");
            xhr.send();

        } else if (evt.target.className == "cg theater") {
        	addNum = 4;
            pageNum = 5;
            parent.appendChild(add);
            for (var i = 0; i < view.length; i++) {
                view[i].style.borderBottom = "0px";
                view[i].onmouseover = over;
                view[i].onmouseout = out;
            }
            view[5].onmouseout = null;
            view[5].style.borderBottom = "3px solid green"
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (xhr.status == 200 && xhr.readyState == 4) {

                    var res = JSON.parse(xhr.responseText);
                    var newcontent = '';
                    var getIndex = function () {
                        for (var i = 0; i < res.length; i++) {
                            if (res[i].productId != null) {
                                index = i;
                                return index;
                            }
                        }

                    }
                    var index = getIndex();
                    for (var i = 0; i < addNum; i++) {
                        for (var j = index; j < res.length; j++) {
                            if (res[i].id == res[j].productId && res[j].type == 'ma') {
                                var template = document.getElementById("template").innerHTML;
                                var filesource = 'img/' + res[j].productId + '_' + res[j].type + '_' + res[j].productImageId + '.png';
                                template = template.replace('filesource', filesource)
                                    .replace('filedescription', res[i].description)
                                    .replace('filecontent', res[i].content);

                                newcontent += template;

                            }
                        }
                    }
                    document.getElementById("ro").innerHTML = index + "개";
                    document.getElementsByClassName("elements")[0].innerHTML = newcontent;
                }
            }
            xhr.open("GET", "./category?cn=5");
            xhr.send();

        } else if (evt.target.className == "cg all") {
        	doAll();
        	        }
    });

    add.addEventListener("click", function (evt) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.status == 200 && xhr.readyState == 4) {

                var res = JSON.parse(xhr.responseText);
                var newcontent = '';

                var getIndex = function () {
                    for (var i = 0; i < res.length; i++) {
                        if (res[i].productId != null) {
                            index = i;
                            return index;
                        }
                    }

                }
                var index = getIndex();
                if (addNum + 4 < index) {
                    addNum = addNum + 4;
                }
                else {
                    addNum = index;
                    parent.removeChild(add);
                }
                for (var i = 0; i < addNum; i++) {
                    for (var j = index; j < res.length; j++) {
                        if (res[i].id == res[j].productId && res[j].type == 'ma') {
                            var template = document.getElementById("template").innerHTML;
                            var filesource = 'img/' + res[j].productId + '_' + res[j].type + '_' + res[j].productImageId + '.png';
                            template = template.replace('filesource', filesource)
                                .replace('filedescription', res[i].description)
                                .replace('filecontent', res[i].content);

                            newcontent += template;

                        }
                    }
                }
                document.getElementById("ro").innerHTML = index + "개";
                document.getElementsByClassName("elements")[0].innerHTML = newcontent;
            }
        }
        if (pageNum == 1) {
            xhr.open("GET", "./category?cn=1");
            xhr.send();
        }else if(pageNum == 2){
        	xhr.open("GET", "./category?cn=2");
        	xhr.send();
        }else if(pageNum == 3) {
            xhr.open("GET", "./category?cn=3");
            xhr.send();
        }else if(pageNum == 4) {
            xhr.open("GET", "./category?cn=4");
            xhr.send();
        }else if(pageNum == 5) {
            xhr.open("GET", "./category?cn=5");
            xhr.send();
        }else if(pageNum == 0){
        	xhr.open("GET", "./category?cn=0");
        	xhr.send();
        }
    });

    doAll();
});
