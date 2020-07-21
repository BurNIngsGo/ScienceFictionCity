$(document).ready(function(){
	$("#users").addClass("magictime puffIn");
    leftmove();
})

function leftmove(){
	var hoverTimer, outTimer;
	$("#marginbox").hover(function(){
        clearTimeout(outTimer);
        hoverTimer = window.setTimeout(function(){
            $("#userBox").slideDown(100);
        },200);
    },function(){
        clearTimeout(hoverTimer);
        outTimer = window.setTimeout(function(){
            $("#userBox").fadeOut();
        },100);
    });
}
