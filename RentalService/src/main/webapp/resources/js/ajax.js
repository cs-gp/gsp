
$(function() {
	
	
	$( "#pickupdate" ).click(function() {
		  		  $("#pickupdate").datepicker({
				
				format : 'yyyy-mm-dd'
			});
		});
	
	
	
	$( "#dropoffdate" ).click(function() {
		  $("#dropoffdate").datepicker({
		
		format : 'yyyy-mm-dd'
	});
});
	
});