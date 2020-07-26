$(function(){
	$(".security-ul li:eq(0)").click(function(){
		$(".security").show();
		$(".security1").hide();
		$(".security2").hide();
	})
	$(".security-ul li:eq(1)").click(function(){
		$(".security1").show();
		$(".security").hide();
		$(".security2").hide();
	})
	$(".security-ul li:eq(2)").click(function(){
		$(".security2").show();
		$(".security").hide();
		$(".security1").hide();
	})
	
//	$(".security-ul2 li:eq(0)").click(function(){
//		$(".modBoxmi").show();
//		$(".modBoxmi1").hide();
//		$(".modBoxmi2").hide();
//	})
//	$(".security-ul2 li:eq(1)").click(function(){
//		$(".modBoxmi1").show();
//		$(".modBoxmi").hide();
//		$(".modBoxmi2").hide();
//	})
//	$(".security-ul2 li:eq(2)").click(function(){
//		$(".modBoxmi2").show();
//		$(".modBoxmi").hide();
//		$(".modBoxmi1").hide();
//	})
})