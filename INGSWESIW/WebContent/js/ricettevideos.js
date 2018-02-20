function tplawesome(e,t){res=e;for(var n=0;n<t.length;n++){res=res.replace(/\{\{(.*?)\}\}/g,function(e,r){return t[n][r]})}return res}

$(document).ready(function(){
	$.get(
			    "https://www.googleapis.com/youtube/v3/channels",{
				part:"contentDetails",
				id:"UC76vuUkGWnPUDFWcgM2_yMg",
				key:"AIzaSyBY6U753kczJuKO9d0urFsYtr-_sV_YeRM"},
			function(data){
				$.each(data.items,function(i, item){
					console.log(item);
					playlistid=item.contentDetails.relatedPlaylists.uploads;
					getvideos(playlistid);
				})
			}
	);
	
	function getvideos(playlistid){
		$.get(
				"https://www.googleapis.com/youtube/v3/playlistItems",{
					part:'snippet',
					maxResults:5,
					playlistId:playlistid,
					key:'AIzaSyBY6U753kczJuKO9d0urFsYtr-_sV_YeRM'
				},
				function(data){
					var output;
					$.each(data.items,function(i, item){
					            $.get("item.html", function(data) {
					                $("#results").append(tplawesome(data, [{"title":item.snippet.title, "videoid":item.snippet.resourceId.videoId}]));
					           
					          });
					})
				}
		);
	}
});
