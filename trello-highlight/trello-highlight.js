$(document).ready(() => {
	var userName = $(".header-btn.header-avatar").find(".member-avatar")[0].title;
	$(".list-card-members").find('[alt*="' + userName + '"]').closest(".list-card-details").css("background-color", "yellow");
});