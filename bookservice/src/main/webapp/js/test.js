var x = 480;
var slider = document.getElementById("ad");
var slideArray = slider.getElementsByClassName("thumbnail");
var slideMax = slideArray.length - 1;
var curSlideNo = 0;

for (i = 0; i <= slideMax; i++) {
    if (i == curSlideNo) slideArray[i].style.left = 0;
    else slideArray[i].style.left = -x + "px";
}

var aniStart = false;
var next = 1;
var changeSlide = function () {
    if (aniStart === true) return;
    next = curSlideNo + 1;
    if (next > slideMax) next = 0;
    aniStart = true;
    sliding();
}

function sliding() {
    var curX = parseInt(slideArray[curSlideNo].style.left, 10);
    var nextX = parseInt(slideArray[next].style.left, 10);
    var newCurX = curX + 30;
    var newNextX = nextX + 30;
    if (newCurX >= x) {
        slideArray[curSlideNo].style.left = -x + "px";
        slideArray[next].style.left = 0;
        curSlideNo = curSlideNo + 1;
        if (curSlideNo > slideMax) curSlideNo = 0;
        aniStart = false;
        
        return;
    }
    slideArray[curSlideNo].style.left = newCurX + "px";
    slideArray[next].style.left = newNextX + "px";
    requestAnimationFrame(sliding);
    
}
setInterval(changeSlide, 5000);