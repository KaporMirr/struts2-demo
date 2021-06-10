const upDowButtonMap = {
    "#leftDown": createDownOuter,
    "#leftUp": createUpOuter,
    "#rightDown": createDownOuter,
    "#rightUp": createUpOuter
}
const leftRightMarker = "==";
function tweakOtsButtons() {
    let inputElements = document.getElementsByTagName("input");
    let buttons = [];
    for (let inputElement of inputElements) {
        if (inputElement.getAttribute("type") === "button") {
            buttons.push(inputElement);
        }
    }
    for (let inputElement of buttons) {
        let valueText = inputElement.getAttribute("value");
        if (valueText.startsWith(leftRightMarker)) {
            inputElement.classList.add("leftRightButton");
            inputElement.setAttribute("value", valueText.substr(leftRightMarker.length));
        } else {
            let outerFn = upDowButtonMap[valueText];
            if (outerFn) {
                let parent = inputElement.parentElement;
                parent.removeChild(inputElement);
                let outerDiv = outerFn.call(window, modifyButton(inputElement));
                parent.appendChild(outerDiv);
            }
        }
    }
}
function modifyButton(button) {
    button.classList.add("upDownButtonSize");
    button.removeAttribute("value");
    return button;
}
function createUpOuter(button) {
    let newDiv = createUpDownOuter();
    newDiv.classList.add("upLeftMargin");
    newDiv.appendChild(createUpInner(button));
    return newDiv;
}
function createDownOuter(button) {
    let newDiv = createUpDownOuter();
    newDiv.appendChild(createDownInner(button));
    return newDiv;
}
function createUpDownOuter() {
    let newDiv = document.createElement("div");
    newDiv.classList.add("upDownOuter");
    return newDiv;
}
function createUpInner(button) {
    return createUpDownInner(button, "upInner");
}
function createDownInner(button) {
    return createUpDownInner(button, "downInner");
}
function createUpDownInner(button, additionalClass) {
    let newDiv = document.createElement("div");
    newDiv.classList.add("upDownInner");
    newDiv.classList.add(additionalClass);
    newDiv.appendChild(button);
    return newDiv;
}
window.onload = function () {
    tweakOtsButtons();
}
// tweak the list selection with CSS, so that
// the automatic selection on pressing "Save" is not visible to the user
function soften(id) {
    document.getElementById(id).classList.add('soften')
}
