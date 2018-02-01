$(document).ready(function(){
	$('#commbtn').click(function(){
		var comment=$('#comment').val();	 
		$ajax({
			type : 'post',
			data :{comment:comment},
			url :'Comment',
			success:function(result){
				$('#').html(result);
			}
		});
	});
});



$(window).on('load', function() { 	
	$("#rating").change(function () {		
		var selected = $("#rating radio:selected").attr("value");
		$.ajax({
			type: "post",		
			url: "vote",			
			data: {valueVote: selected},
			success: function(){
				$("#voti").html('thank you for rating');
			}	
		});
	});
		
	});


/*

$(window).on('load', function() { 	
$("#dip").change(function () {		
	var selected = $("#dip option:selected").attr("value");
	$.ajax({
		type: "GET",		
		url: "getCorsiDiLaurea",			
		data: {valueDip: selected},
		success: function(data){
			$("#corso_laurea").html(data);
		}	
	});
});
	
});
*/