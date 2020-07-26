$(function(){
	$(".readyInfo2 li:eq(0)").click(function(){
		$(".modBox").show();
		$(".modBox1").hide();
		$(".modBox2").hide();
	})
	$(".readyInfo2 li:eq(1)").click(function(){
		$(".modBox1").show();
		$(".modBox").hide();
		$(".modBox2").hide();
	})
	$(".readyInfo2 li:eq(2)").click(function(){
		$(".modBox2").show();
		$(".modBox").hide();
		$(".modBox1").hide();
	})
	
	$(".readyInfo li:eq(0)").click(function(){
		$(".modBoxmi").show();
		$(".modBoxmi1").hide();
		$(".modBoxmi2").hide();
	})
	$(".readyInfo li:eq(1)").click(function(){
		$(".modBoxmi1").show();
		$(".modBoxmi").hide();
		$(".modBoxmi2").hide();
	})
	$(".readyInfo li:eq(2)").click(function(){
		$(".modBoxmi2").show();
		$(".modBoxmi").hide();
		$(".modBoxmi1").hide();
	})
})
