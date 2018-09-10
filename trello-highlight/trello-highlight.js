function changeCardsColor(color) {
    var userName = $(".header-btn.header-avatar").find(".member-avatar")[0].title;
    $(".list-card-members").find('[alt*="' + userName + '"]').closest(".list-card-details").css("background-color", color);
}

$(document).ready(() => {
    // TODO: handle correctly in Chrome and Firefox
    //onGot({});
});

function onError(error) {
    console.log(`Error: ${error}`);
}

function onGot(item) {
    var color = "yellow";
    if (item) {
        if (typeof item === "string") {
            color = item;
        }
        if (item.color) {
            color = item.color;
        }
    }
    changeCardsColor(color);
}


if (!!chrome) {
    chrome.storage.sync.get(["color"], (item) => {
        onGot(item);
    });
}
else {
    var getting = browser.storage.sync.get("color");
    getting.then(onGot, onError);
}


