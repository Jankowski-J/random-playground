function changeCardsColor(color) {
	console.log("changing color!", color);
	var userName = $(".header-btn.header-avatar").find(".member-avatar")[0].title;
	$(".list-card-members").find('[alt*="' + userName + '"]').closest(".list-card-details").css("background-color", color);
}

$(document).ready(() => {
	onGot();
});

function onError(error) {
  console.log(`Error: ${error}`);
}

function onGot(item) {
  var color = "blue";
  if (item.color) {
    color = item.color;
  }
  changeCardsColor(color);
}

var getting = browser.storage.sync.get("color");
getting.then(onGot, onError);