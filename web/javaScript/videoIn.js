$(document).ready(function() {
	$(".bookVideo").click(function() {
		$("#mengban").show(400);
		$('#menban video').trigger('play');
	});
	$("#mengban a").click(function() {
		$("#mengban").hide(400);
		$('#mengban video').trigger('pause');
	})
});