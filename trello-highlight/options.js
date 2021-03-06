function saveOptions(e) {
    e.preventDefault();
    if (!!chrome && chrome.storage) {
        chrome.storage.sync.set({
            color: document.querySelector("#color").value
        })

    } else {
        browser.storage.sync.set({
            color: document.querySelector("#color").value
        });
    }
}

function restoreOptions() {
    function setCurrentChoice(result) {
        document.querySelector("#color").value = result.color || "yellow";
    }

    function onError(error) {
        console.log(`Error: ${error}`);
    }

    var getting = browser.storage.sync.get("color");
    getting.then(setCurrentChoice, onError);
}

document.addEventListener("DOMContentLoaded", restoreOptions);
document.querySelector("form").addEventListener("submit", saveOptions);